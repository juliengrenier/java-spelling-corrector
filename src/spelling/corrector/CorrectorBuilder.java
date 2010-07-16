package spelling.corrector;


public class CorrectorBuilder {
	private static SpellingCorrectorHelper buildHelper(boolean isVerbose){
		SpellingCorrectorHelper helper = new DefaultSpellingCorrectorHelper();
		if(isVerbose){
			return new StatSpellingCorrectorHelper(helper);
		}else{
			return helper;
		}
	}
	
	public static SpellingCorrector buildCorrector(boolean isVerbose){
		SpellingCorrector corrector = new DefaultSpellingCorrector(buildHelper(isVerbose));
		if(isVerbose){
			return new StatSpellingCorrector(corrector);
		}else{
			return corrector;
		}
		
	}
}
