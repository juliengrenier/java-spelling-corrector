package spelling.corrector;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public abstract class SpellingCorrectorHelperTest extends
		TestCase {

	public final void testGetDeletions() {
		try {
			List<String> expected = new ArrayList<String>();
			expected.add("ase");
			expected.add("cse");
			expected.add("cae");
			expected.add("cas");
			List<String> result = getHelper().getDeletion("case");
			assertEquals(expected, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public final void testGetTranspositions() {
		try {
			List<String> expected = new ArrayList<String>();
			expected.add("acse");
			expected.add("csae");
			expected.add("caes");
			List<String> result = getHelper().getTransposition("case");
			assertEquals(expected, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public final void testGetAlterations() {
		try {
			List<String> expected = new ArrayList<String>();
			String word = "case";
			for (int i = 0; i < word.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					expected.add(word.replace(word.charAt(i), c));
				}
			}
			List<String> result = getHelper().getAlterations("case");
			assertEquals(expected, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	public final void testGetInsertions() {
		try {
			List<String> expected = new ArrayList<String>();
			String word = "case";
			for (int i = 0; i < word.length() + 1; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					expected.add(word.substring(0, i) + c + word.substring(i));
				}
			}
			List<String> result = getHelper().getInsertions("case");
			assertEquals(expected, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	abstract protected SpellingCorrectorHelper getHelper();
}
