package spelling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import spelling.corrector.CorrectorBuilder;
import spelling.corrector.SpellingCorrector;
import spelling.dictionary.Dictionary;

public class CorrectorLauncher {

	public static void main(String[] args) throws IOException {
		try {
			SpellingCorrector sc = handleCommandLine(args);
			Scanner inputScanner = new Scanner(System.in);
			System.out.print("Please enter a word (anything else will quit the application):");
			while(inputScanner.hasNext("[a-zA-Z]+")){
				String toCorrect = inputScanner.next("[a-zA-Z]+");
				String correction = sc.correct(toCorrect.toLowerCase());
				System.out.println(toCorrect+ ":\t did you mean "+ correction);
				System.out.print("\nPlease enter a word:");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	private static SpellingCorrector handleCommandLine(String[] args) throws IOException {
		boolean hasCommandFlag = args.length > 0;
		String filename = "holmes.txt";
		boolean isVerbose = false;
		if(hasCommandFlag){
			for(int index=0;index<args.length;index++){
				if("-h".equalsIgnoreCase(args[index])){
					showHelp();
				}else if("-f".equalsIgnoreCase(args[index])){
					if(index+1 > args.length){
						showHelp();
					}else{
						if(args[index+1].startsWith("-")){
							showHelp();
						}else{
							filename = args[index+1];
							index++;
						}
					}
				}else if("-v".equalsIgnoreCase(args[index])){
					if(index+1 > args.length){
						//do nothing
					}else{
						isVerbose = true;
					}
				}
				
			}
		}
		Dictionary.load(Locale.ENGLISH, new File(filename));
		
		SpellingCorrector corrector = CorrectorBuilder.buildCorrector(isVerbose);
		return corrector;
	}
	
	private static void showHelp() {
		System.out.println("Usage SpellingCorrector [-h -f filename -v] \n\t-h : Show this help\n\t-f filename : Use this file to train the corrector\n\t-v [all] : Print statistic for methods if \"all\" then print statistic for every methods");
		System.exit(0);
	}
}
