package spelling.corrector;

import java.util.Collection;
import java.util.List;

public interface SpellingCorrectorHelper {

	/**
	 * Create a list of all deletions possible for the <code>word</code>.
	 * Example : <b>good</b> will return {ood, god,goo}
	 * @param word
	 * @return
	 */
	public List<String> getDeletion(final String word);

	/**
	 * Create a list of all transpositions for the <code>word</code>
	 * Example : <b>case</b> will return {acse, csae, caes}
	 * @param word
	 * @return
	 */
	public List<String> getTransposition(final String word);

	/**
	 * Create a list of all alterations for the <code>word</word>
	 * It will replace every letter of the word with all the letters of the alphabet.
	 * Example : <b>god</b> will return {aod,...,zod,gad,...gzd,gad,...,gzd,goa,goz}
	 * @param word
	 * @return
	 */
	public List<String> getAlterations(final String word);

	/**
	 * Create a list of all insertions for the <code>word</word>
	 * It will insert every letter of the alphabet at every possible position of the word.
	 * Example : <b>god</b> will return {agod,...,zgod,gaod,...gzod,goad,...,gozd,goda,godz}
	 * @param word
	 * @return
	 */
	public List<String> getInsertions(final String word);
	
	/**
	 * Return a set of alternative word of edit distance of 1
	 * @param word
	 * @return a Set of word
	 */
	public Collection<String> getFirstDegreeAlternatives(final String word);
	
	
	/**
	 * Return a set of alternative word of edit distance of 2
	 * @param word
	 * @return a Set of word
	 */
	public Collection<String> getSecondDegreeAlternatives(final Collection<String> words);

}