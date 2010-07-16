package spelling.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Dictionary {
	private final static Map<Locale,Dictionary> dictionaries = new HashMap<Locale,Dictionary>();
	private final Map<String, Integer> dictionnary = new HashMap<String, Integer>(5000);
	private Dictionary(){}
	public static Dictionary load(final Locale locale,final File text) throws IOException{
		Dictionary dict = new Dictionary();
		Scanner textScanner = new Scanner(text);
		Pattern wordPattern = Pattern.compile("[a-z]+");
		Map<String, Integer> map = dict.dictionnary;
		while(textScanner.hasNext()){
			String foundWord = textScanner.next();
			foundWord = foundWord.toLowerCase();
			if(wordPattern.matcher(foundWord).matches()){
				if(map.containsKey(foundWord)){
					Integer occurence = map.get(foundWord);
					map.put(foundWord, occurence+1);
				}else{
					map.put(foundWord, 1);
				}
			}
			if(textScanner.ioException() != null){
				throw textScanner.ioException();
			}
		}
		
		if(textScanner.ioException() != null){
			throw textScanner.ioException();
		}
		dictionaries.put(locale, dict);
		return dict;
	}
	public static Dictionary getDictionnary(final Locale locale){
		return dictionaries.get(locale);
	}
	public Integer getOccurences(final String word){
		if(dictionnary.containsKey(word)){
			return dictionnary.get(word);
		}else{
			return Integer.valueOf(1);
		}
	}
	
	public boolean contains(final String word){
		return this.dictionnary.containsKey(word);
	}
	
	public Collection<String> known(final Collection<String> words){
		Collection<String> knownWords = new TreeSet<String>();
		for(String word :words){
			if(this.contains(word)){
				knownWords.add(word);
			}
		}
		return Collections.unmodifiableCollection(knownWords);
	}
}
