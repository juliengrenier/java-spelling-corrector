package spelling.corrector;


public class DefaultSpellingCorrectorHelperTest extends SpellingCorrectorHelperTest {

	@Override
	protected SpellingCorrectorHelper getHelper() {
		return new DefaultSpellingCorrectorHelper();
	}

}