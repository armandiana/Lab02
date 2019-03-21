package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word>dictionary;
	
	public AlienDictionary() {
		dictionary=new ArrayList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word newWord=new Word(alienWord.toLowerCase(),translation.toLowerCase());
		
		for(Word w: dictionary) {
			if(!w.equals(newWord)) {
				dictionary.add(newWord);
			}else {
				//aggiornare la traduzione
				dictionary.remove(w);
				dictionary.add(newWord);
			}
		}
		
	}
	
	public String translateWord(String alienWord) {
		String traduzione=new String();
		
		for(Word w: dictionary) {
			
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
				traduzione=w.getTranslation();
			}else {
				traduzione=null;
			}
		}
		
		return traduzione;
		
	}
	
	
	
	
	
	

}
