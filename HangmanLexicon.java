

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
* File: HangmanLexicon.java
* -------------------------
* This file contains a stub implementation of the HangmanLexicon
* class that you will reimplement for Part III of the assignment.
*/
import acm.util.*;
public class HangmanLexicon {
	/** Returns the number of words in the lexicon. */
		
		public HangmanLexicon(){
			String word;
			
			try{
				BufferedReader words=new BufferedReader(new FileReader("/Users/BrahmaSPavse/Documents/workspace/trial/src/trial/HangmanLexicon.txt"));
				while(true){
					word=words.readLine();
					if(word==null){
						break;
					}
					wordList.add(word);
				}
			}catch(IOException ex){}
			
			
		}
		public int getWordCount() {//to give size for random generator
			return wordList.size();
		}
		
		/** Returns the word at the specified index. */
		public String getWord(int index) {
			
			return wordList.get(index);
			
		};
		/*instance variables*/
		
		private ArrayList<String> wordList=new ArrayList<String>();
	}
