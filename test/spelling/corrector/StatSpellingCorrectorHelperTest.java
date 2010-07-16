package spelling.corrector;


public class StatSpellingCorrectorHelperTest extends SpellingCorrectorHelperTest{

	@Override
	protected SpellingCorrectorHelper getHelper() {
		return new StatSpellingCorrectorHelper();
	}
}
