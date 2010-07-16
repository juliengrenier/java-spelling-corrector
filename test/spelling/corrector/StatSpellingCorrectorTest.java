package spelling.corrector;


public class StatSpellingCorrectorTest extends SpellingCorrectorTest {

	@Override
	protected SpellingCorrector getSpellingCorrector() {
		return new StatSpellingCorrector();
	}
	
}
