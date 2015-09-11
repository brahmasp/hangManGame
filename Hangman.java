

import acm.program.*;
import acm.util.RandomGenerator;
import java.io.*;


public class Hangman extends ConsoleProgram {
	
	public void run(){
		println("Welcome to Hangman! (Total 8 guesses)");
		setSize(700,500);
		chooseRandomWord();
		oneTimeDashSetter();
		while(!gameOver){//waits for word to match with what dude answered
			displayStatusOfWord();
			if(gameOver){
				break;
			}
			takeGuess();
			makeChangesToWord();
		}
		
		
	}
	
	public void init(){//setting up connection with HangmanCanvas
		canvas = new HangmanCanvas();
		add(canvas);
		
	}
	
	private void chooseRandomWord(){//picks random word from list in other class
		
		hangmanDict=new HangmanLexicon();
		int randomIndexOfWord=rgen.nextInt(0,hangmanDict.getWordCount()-1);//imp because based on size...incase doc changes i never have to change this part-good sftwre eng
		word=hangmanDict.getWord(randomIndexOfWord);
		
	}
	private void oneTimeDashSetter(){ //sets the dashes one time and doesn't confuse later
		for(int i=0;i<word.length();i++){
			changedWord+="-";
			
		}
	
	}
	private void displayStatusOfWord(){//display for first time and after every change
		println("Guess word below: ");
		for(int i=0;i<word.length();i++){
			
			if(correctLetter==i){
				changedWord=changedWord.substring(0,i)+word.charAt(i)+changedWord.substring(i+1);
				
			}
			
			
		}
		println(changedWord);
		if(changedWord.equals(word)){
			gameOver=true;
			println("DONE CONGRATS!");
		}
		
		
	}
	private void takeGuess(){//ask user for guess of letter
		if(numOfGuessLeft>0){
			guessedLetter=readLine("Guess a letter: ");
			
		}
		else{
			
			println("Sorry 8 guesses over!");
			println("Come again!");
			gameOver=true;
			
			
		}
	}
	
	private void makeChangesToWord(){//make changes if needed
		correctLetter=-1;
		for(int i=0;i<word.length();i++){
			if(word.substring(i,i+1).equalsIgnoreCase(guessedLetter)){//check presence of guessed letter in word(lower or upper)
				if(changedWord.charAt(i)=='-'){//in case of duplication V IMP!
					correctLetter=i;
					
				}
				
			}
			
		}
		if(correctLetter==-1){//in case wrong guess is entered
			numOfGuessLeft--;
			
			println("You have "+numOfGuessLeft+" left!");
			println("sorry, wrong guess please continue!");
			canvas.noteIncorrectGuess(guessedLetter);//passes the guesed letter which is wrong to function in class HangmanCanvas
			if(numOfGuessLeft==0){
				println(word);
			}
		}
		
		
	}
	
	
	
	/*instance variables */
	private String changedWord="";//since string immutable ..this string changes to result
	private int correctLetter=-1;//indicates position of correct letter
	private int numOfGuessLeft=8;//keep in account amount of guess left
	private boolean gameOver=false;
	private String guessedLetter;//user input
	private HangmanLexicon hangmanDict;//object to access lexicon class
	private String word;//word acquired from lexicon class
	private RandomGenerator rgen=RandomGenerator.getInstance();//help in picking random word from lexicon class
	
	private HangmanCanvas canvas;
	

	

}
