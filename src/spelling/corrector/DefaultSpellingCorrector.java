package spelling.corrector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import spelling.dictionary.Dictionary;

public class DefaultSpellingCorrector implements SpellingCorrector {
	private final Dictionary dictionnary;
	private final SpellingCorrectorHelper helper;
	protected DefaultSpellingCorrector(SpellingCorrectorHelper helper){
		this(helper,Locale.ENGLISH);
	}
	protected DefaultSpellingCorrector(SpellingCorrectorHelper helper,Locale locale){
		this.helper = helper;
		this.dictionnary = Dictionary.getDictionnary(locale);
	}

	public String correct(final String word){
		String correction = "";
		if(word == null || word.equals("")){
			return correction;
		}
		
		Collection<String> candidates = getCandidates(word.toLowerCase());
		int max = 0;
		for(String candidate : candidates){
			if(dictionnary.getOccurences(candidate) > max){
				correction = candidate;
			}
		}
		return correction;
	}
	

	public Collection<String> getCandidates(final String word){
		List<String> words = new ArrayList<String>();
		words.add(word);
		Collection<String> knownWords = dictionnary.known(words);
		if(knownWords.size() >0){
			return knownWords;
		}
		
		Collection<String> alternatives = helper.getFirstDegreeAlternatives(word);
		knownWords = dictionnary.known(alternatives);
		if(knownWords.size() > 0){
			return knownWords;
		}
		
		Collection<String> secondDegreeAlternatives =  helper.getSecondDegreeAlternatives(alternatives);
		knownWords = dictionnary.known(secondDegreeAlternatives);
		if(knownWords.size() > 0){
			return knownWords;
		}
		
		return Collections.unmodifiableCollection(words);
	}

}
