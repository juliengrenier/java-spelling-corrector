package spelling.corrector;

public class DefaultSpellingCorrectorTest extends SpellingCorrectorTest{

	@Override
	protected SpellingCorrector getSpellingCorrector() {
		return new DefaultSpellingCorrector(new DefaultSpellingCorrectorHelper());
	}

}
