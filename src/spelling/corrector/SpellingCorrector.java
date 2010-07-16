package spelling.corrector;

import java.util.Collection;

public interface SpellingCorrector {

	/**
	 * This method will return the correction to a word passed in parameter
	 * @param word The word to be corrected
	 * @return The correction to the word or the word if no correction has been found
	 */
	public String correct(final String word);
	
	/**
	 * This method will return the candidates for the correction of a word
	 * @param word The word to be corrected
	 * @return A unmodifiable Collection of candidates
	 */
	public Collection<String> getCandidates(final String word);
	
}