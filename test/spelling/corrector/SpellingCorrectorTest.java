package spelling.corrector;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import junit.framework.TestCase;
import spelling.dictionary.Dictionary;

public abstract class SpellingCorrectorTest extends TestCase {
	
	public final void testCorrect(){
		try {
			Dictionary.load(Locale.ENGLISH, new File("holmes.txt"));
			SpellingCorrector sp = getSpellingCorrector();
			String correction = sp.correct("speling");
			assertEquals("spelling", correction);
			correction = sp.correct(null);
			assertEquals("", correction);
			correction = sp.correct("");
			assertEquals("", correction);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	abstract protected SpellingCorrector getSpellingCorrector();
	
}
