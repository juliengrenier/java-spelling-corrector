package spelling.corrector;

import java.util.Collection;

public class StatSpellingCorrector implements SpellingCorrector {
	final private SpellingCorrector corrector;
	protected StatSpellingCorrector(SpellingCorrector corrector){
		this.corrector = corrector;
	}
	protected StatSpellingCorrector(){
		this(new DefaultSpellingCorrector(new StatSpellingCorrectorHelper()));
	}
	public String correct(String word) {
		System.out.println("StatSpellingCorrector.correct()");
		long begin = System.nanoTime();
		String correction = this.corrector.correct(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : "+ (end-begin) + " nanoseconds");
		return correction;
	}
	
	public Collection<String> getCandidates(String word) {
		System.out.println("StatSpellingCorrector.getCandidates()");
		long begin = System.nanoTime();
		Collection<String> result = this.corrector.getCandidates(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : "+ (end-begin) + " nanoseconds");
		return result;
	}

}
