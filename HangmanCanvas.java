
import acm.program.GraphicsProgram;
import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	/* Constants for the simple version of the picture (in pixels) */
		private static final int SCAFFOLD_HEIGHT = 360;//the hanging device
		private static final int BEAM_LENGTH = 144;//the top bar horiztontal
		private static final int ROPE_LENGTH = 18;//small piece of vertical line
		private static final int HEAD_RADIUS = 36;
		private static final int BODY_LENGTH = 144;
		private static final int ARM_OFFSET_FROM_HEAD = 28;//distance of head to torso
		private static final int UPPER_ARM_LENGTH = 72;
		private static final int LOWER_ARM_LENGTH = 44;
		private static final int HIP_WIDTH = 36;
		private static final int LEG_LENGTH = 108;
		private static final int FOOT_LENGTH = 28;

	
	/** HangmanCanvas constructor. You can do initialization (if needed) here. */
	public HangmanCanvas() {//sets scaffold,beam and rope up automatically
		GLine scaffold=new GLine(50,50,50,SCAFFOLD_HEIGHT);
		GLine beam=new GLine(50,50,BEAM_LENGTH,50);
		GLine rope=new GLine(BEAM_LENGTH,50,BEAM_LENGTH,50+ROPE_LENGTH);
		add(scaffold);
		add(beam);
		add(rope);
	}
	
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(Object letter) {//displays wrong letter guesed on screen using GLabel
													//always updates because of string constantly appends
		wrongCharString+=letter;                    //used Object as parameter type because i am passing string by char is required
		wrongChar=new GLabel(wrongCharString,200,400);
		wrongChar.setFont("SansSeriff-20");
		add(wrongChar);
		
		drawHangman();//draw Hangman because mistake occurred
		
		
	}
	private void drawHangman(){
		errorCounter++;//starts at 0 and each time executes it increments by 1 to meet apt case below
		
		switch(errorCounter){
		case 1://head first
			GOval head=new GOval(BEAM_LENGTH-HEAD_RADIUS,50+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS);
			add(head);
		    break;
		case 2://body
			GLine body=new GLine(BEAM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS,BEAM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
			add(body);
			break;
		case 3://torso and left arm
			GLine UpperArm=new GLine(BEAM_LENGTH-UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
			GLine leftLowerArm=new GLine(BEAM_LENGTH-UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH-UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(UpperArm);
			add(leftLowerArm);
			break;
		case 4://right arm
			GLine rightLowerArm=new GLine(BEAM_LENGTH+UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+UPPER_ARM_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
			add(rightLowerArm);
			break;
		case 5://waist with left leg
			GLine waist=new GLine(BEAM_LENGTH-HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH+HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
			GLine leftLeg=new GLine(BEAM_LENGTH-HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH-HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
			add(waist);
			add(leftLeg);
			break;
		case 6://right leg
			GLine rightLeg=new GLine(BEAM_LENGTH+HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,BEAM_LENGTH+HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
			add(rightLeg);
			break;
		case 7://left foot at bottom
			GLine leftFoot=new GLine(BEAM_LENGTH-HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH-HIP_WIDTH/2-FOOT_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
			add(leftFoot);
			break;
		case 8://right foot at bottom
			GLine rightFoot=new GLine(BEAM_LENGTH+HIP_WIDTH/2,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH+HIP_WIDTH/2+FOOT_LENGTH,50+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
			add(rightFoot);
			break;
			
		
		}
	}
	
	/*instance variables*/
	private int errorCounter=0;
	private String wrongCharString="";
	private  GLabel wrongChar;//uses above string and prints on canvas

}
