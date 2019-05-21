package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlien;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private AlienDictionary dictionary;
    
    @FXML
    void initialize() {
        assert txtAlien != null : "fx:id=\"txtAlien\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
        dictionary=new AlienDictionary();

    }  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String riga=this.txtAlien.getText().toLowerCase(); //convertiamo tutto nel lower case perchè la ricerca deve essere case sensitive
    	
    	if(riga.trim()==null||riga.trim().length()==0) {
    		this.txtResult.setText("Inserire una oppure due parole!\n");
    		return;
    	}
    	
    	StringTokenizer st=new StringTokenizer(riga, " ");
    	String alienWord=st.nextToken();
    	
    	if(st.hasMoreElements()) {
    		String traduzione=st.nextToken();
    		if(!(alienWord.matches("[a-zA-Z]*")||traduzione.matches("[a-zA-Z]*"))) {
    			this.txtResult.appendText("Inserire parole formate da caratteri alfabetici!!\n");
    			return;
    		}
    		alienWord.toLowerCase();
    		traduzione.toLowerCase();
    		
    		this.dictionary.addWord(alienWord, traduzione);
    		
    		this.txtResult.appendText("Aggiunta una nuova parola: "+alienWord+"\nCon traduzione: "+traduzione+"\n");
    	}else {
    		if(!(alienWord.matches("[a-zA-Z]*"))) {
    			this.txtResult.appendText("Inserire parole formate da caratteri alfabetici!!\n");
    			return;
    		}
    		alienWord.toLowerCase();
    		this.txtResult.appendText("La traduzione della parola "+alienWord+" è: "+this.dictionary.translateWord(alienWord)+"\n");
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtAlien.clear();

    }

  

    
}

