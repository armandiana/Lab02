package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word>dictionary;
	
	
	
	public AlienDictionary() {
		dictionary=new ArrayList<Word>();
	}
	
	
	
	public void addWord(String alienWord, String translation) {
		Word newWord=new Word(alienWord,translation);
		
		if(dictionary.contains(newWord)) {//se la Word e' gia' presente nel dizionario allora aggiorniamo la traduzione.
			dictionary.get(dictionary.indexOf(newWord)).setTranslation(translation);
			return;
		}
		dictionary.add(newWord);//se la Word non è presente nel dizionario allora la aggiungiamo.
		
	}
	
	public String translateWord(String alienWord) {
		//se la Word contiene la parola aliena allora ci restituisce la traduzione
		
		for(Word w: dictionary) {
			
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		return null; //se non la contiene invece restituisce null
	}
	
	

}
