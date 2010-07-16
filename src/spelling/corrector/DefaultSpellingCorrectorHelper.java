package spelling.corrector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;


public class DefaultSpellingCorrectorHelper implements SpellingCorrectorHelper {
	
	public List<String> getDeletion(final String word) {
		List<String> deletions = new ArrayList<String>();
		for(int i=0;i<word.length();i++){
			String deletion = word.substring(0, i) + word.substring(i+1);
			deletions.add(deletion);
		}
		return Collections.unmodifiableList(deletions);
	}
	
	public List<String> getTransposition(final String word) {
		List<String> transpositions = new ArrayList<String>();
		for(int i=0;i<word.length()-1;i++){
			String transposition = word.substring(0, i) + word.charAt(i+1) + word.charAt(i)+ word.substring(i+2);
			transpositions.add(transposition);
		}
		return Collections.unmodifiableList(transpositions);
	}

	public List<String> getAlterations(final String word){
		List<String> alterations = new ArrayList<String>();
		for(int i=0;i<word.length();i++){
			for(Character current='a';current <='z';current++){
				String alteration = word.substring(0, i) + current +word.substring(i+1);
				alterations.add(alteration);
			}
		}
		return Collections.unmodifiableList(alterations);
	}

	public List<String> getInsertions(final String word){
		List<String> insertions = new ArrayList<String>();
		for(int i=0;i<word.length()+1;i++){
			for(Character current='a';current <='z';current++){
				String alteration = word.substring(0, i) + current +word.substring(i);
				insertions.add(alteration);
			}
		}
		return Collections.unmodifiableList(insertions);
	}

	public Collection<String> getFirstDegreeAlternatives(final String word){
		Collection<String> alternatives = new TreeSet<String>();
		alternatives.addAll(getDeletion(word));
		alternatives.addAll(getTransposition(word));
		alternatives.addAll(getAlterations(word));
		alternatives.addAll(getInsertions(word));
		return Collections.unmodifiableCollection(alternatives);
	}

	public Collection<String> getSecondDegreeAlternatives(final Collection<String> words){
		Collection<String> alternatives = new TreeSet<String>();
		for(String alternative : words){
			alternatives.addAll(getFirstDegreeAlternatives(alternative));
		}
		return Collections.unmodifiableCollection(alternatives);
	}
}
