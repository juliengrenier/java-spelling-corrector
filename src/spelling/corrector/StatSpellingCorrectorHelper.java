package spelling.corrector;

import java.util.Collection;
import java.util.List;

public class StatSpellingCorrectorHelper implements SpellingCorrectorHelper {
	final private SpellingCorrectorHelper helper;

	protected StatSpellingCorrectorHelper(SpellingCorrectorHelper helper) {
		this.helper = helper;
	}

	protected StatSpellingCorrectorHelper() {
		this(new DefaultSpellingCorrectorHelper());
	}

	public List<String> getAlterations(String word) {
		System.out.println("StatSpellingCorrectorHelper.getAlterations()");
		long begin = System.nanoTime();
		List<String> result = this.helper.getAlterations(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

	public List<String> getDeletion(String word) {
		System.out.println("StatSpellingCorrectorHelper.getDeletion()");
		long begin = System.nanoTime();
		List<String> result = this.helper.getDeletion(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

	public List<String> getInsertions(String word) {
		System.out.println("StatSpellingCorrectorHelper.getInsertions()");
		long begin = System.nanoTime();
		List<String> result = this.helper.getInsertions(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

	public List<String> getTransposition(String word) {
		System.out.println("StatSpellingCorrectorHelper.getTransposition()");
		long begin = System.nanoTime();
		List<String> result = this.helper.getTransposition(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

	public Collection<String> getFirstDegreeAlternatives(String word) {
		System.out.println("StatSpellingCorrectorHelper.getAlternatives()");
		long begin = System.nanoTime();
		Collection<String> result = this.helper
				.getFirstDegreeAlternatives(word);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

	public Collection<String> getSecondDegreeAlternatives(
			Collection<String> words) {
		System.out
				.println("StatSpellingCorrectorHelper.getKnown_Alternatives()");
		long begin = System.nanoTime();
		Collection<String> result = this.helper
				.getSecondDegreeAlternatives(words);
		long end = System.nanoTime();
		System.out.println("Elapsed time : " + (end - begin) + " nanoseconds");
		return result;
	}

}
