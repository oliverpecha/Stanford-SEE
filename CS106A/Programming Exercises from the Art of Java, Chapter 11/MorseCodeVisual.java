/*
 * File: MorseCode.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 9.
 * -----------------
 * In May of 1844, Samuel F. B. Morse sent the message “What hath God wrought!” by telegraph from Washington to Baltimore, heralding 
 * the beginning of the age of electronic communication. To make it possible to communicate information using only the presence or 
 * absence of a single tone, Morse designed a coding system in which letters and other symbols are represented as coded sequences of 
 * short and long tones, traditionally called dots and dashes. In Morse code, the 26 letters of the alphabet are represented by the 
 * following codes:
 * A• J• S••• B•••K•T C••L•••U•• D••MV••• E•N•W• F•••OX•• G•P••Y• H•••• Q• Z•• I•• R••
 * You can easily store these codes in a program by declaring an array with 26 elements and storing the sequence of characters 
 * corresponding to each letter in the appropriate array entry.
 * Write a program that reads in a string from the user and translates each letter in the string to its equivalent in Morse code, 
 * using periods to represent dots and hyphens to represent dashes. Separate words in the output by calling println whenever you 
 * encounter a space in the input, but ignore all other punctuation characters. Your program should be able to generate the following 
 * sample run:
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JTextField;

	public class MorseCodeVisual extends GraphicsProgram {
		
		String [] alphabet = { 
				"•-","-•••","-•-•","-••","•","••-•","--•","••••","••",
				"•---","-•-","•-••","--","-•","---","•--•","--•-","•-•",
				"•••","-","••-","---•","•--","-••-","-•--","--••",	
		};
		
		public void init() {
			setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			// Adds JLabel and JTextField to which text will be entered and read when enter action is performed
			add(new JLabel("Enter text: "), SOUTH);
			input = new JTextField(TEXT_FIELD);
			input.addActionListener(this);
			add(input, SOUTH);
		}
		
		private void startTranslation() {
			StringTokenizer allTokens = new StringTokenizer(enteredText);
			int totalTokens = allTokens.countTokens();
			MorseToken currentToken = null;
			for (int i = 0; i < totalTokens; i++) {
				// Display the result of extracting next token and translating it to Morse. Add a token separation after.
					// Extract token
					String nextToken = allTokens.nextToken().toUpperCase();
					// Initialize TokenToMorse by sending a token and receiving an object that draws translation of the String to Morse
					currentToken = new MorseToken(nextToken);
					// Add returning GObject by contemplating how many other Strings have already been transferring to defined height
					add(currentToken, TOKEN_SEPARATOR, TOKEN_SEPARATOR + i * (SYMBOL_HEIGHT + TOKEN_SEPARATOR) + lineBeginsAtY);
			}
			// Sets Position where new lines of drawn Morse should begin by storing the position of last entered line
			lineBeginsAtY = currentToken.getY() +  TOKEN_SEPARATOR / 2;
		}
		
	/* Called when any action event is generated */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == input) {
				// Extracts text from JTextField
				enteredText = input.getText();
				// Initiates method to translate entered text to Morse
				startTranslation();
				// Resets JTextField after translation request has been sent
				input.setText("");
			}
		}
			
	/* Private instance variables */
		private JTextField input;
		private String enteredText;
		private double lineBeginsAtY = 0;
	
	/* Private constants */
		private static final int SCREEN_WIDTH = 500;
		private static final int SCREEN_HEIGHT = 300;
		private static final int TEXT_FIELD = 30;
		private static final double TOKEN_SEPARATOR = 0.05 * SCREEN_HEIGHT;
		private static final double SYMBOL_HEIGHT = 0.5 * TOKEN_SEPARATOR;

/*
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 *  Private Classes that draw objects equivalent to Morse code
 *  
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *	
 */
		
	private class MorseToken extends GCompound {
		
		public MorseToken(String token) {
			// Initializes a GCompound object to which other GObjects will be added
			GCompound StringToMorse = new GCompound();
			// Position in the X_axis to which new morseChar will be added below
			double lastMorseTokenEnd = 0;
			// extract each char from token, convert it to morse, add it to GCompound and add a space until no more chars in token
			for (int i = 0; i < token.length(); i++) {
				char currentChar = token.charAt(i);
				// Creates a MorseChar object which will include a drawing of all the symbols necessary to represent a Morse char
				MorseChar morseChar = new MorseChar(currentChar);
				// Adds it to the GCompound
				StringToMorse.add(morseChar, lastMorseTokenEnd, 0);
				// Computes position to which new morseChar_s will be added
				lastMorseTokenEnd = StringToMorse.getWidth() + TOKEN_SEPARATOR;
			}
			// Adds GCompound to object
			add(StringToMorse);
		}
	}
	
	private class MorseChar extends GCompound {
		
		public MorseChar(char currentChar) {
			// Initializes a string that contains the symbols necessary to represent currentChar of the alphabet in Morse code
			String morseEquivalent = alphabet[currentChar - 'A'];
			// All the symbols necessary to represent currentChar will be added to charToMorse GCompound
			GCompound charToMorse = new GCompound();
			// lastMorseSymbolEnd will be manipulated to track where added symbols need to be postioned in the x axis
			int lastMorseSymbolEnd = 0;
			// For as many symbols as morseEquivalent contains as that is the necessary quantity to represent currentChar in Morse
			for (int i = 0; i < morseEquivalent.length(); i++) {
				// Extract each symbol
				char currentSymbol = morseEquivalent.charAt(i);
				// Symbols can only be '-' or '•'
				if (currentSymbol == '-') {
					// If symbol to draw is - add and construct a Dash object
					charToMorse.add(new Dash(), lastMorseSymbolEnd + TOKEN_SEPARATOR / 2, 0);
					// Manipulate lastMorseSymbolEnd so upcoming symbols are properly placed
					lastMorseSymbolEnd += TOKEN_SEPARATOR / 2 + 2 * SYMBOL_HEIGHT;
				}
				else {
					charToMorse.add(new Dot(), lastMorseSymbolEnd + TOKEN_SEPARATOR / 2, 0);
					lastMorseSymbolEnd += TOKEN_SEPARATOR / 2 + SYMBOL_HEIGHT;
				}
			}
			add(charToMorse);
		}
	}
	
	private class Dot extends GCompound {
		
		public Dot() {
			GOval dot = new GOval(SYMBOL_HEIGHT, SYMBOL_HEIGHT);
			dot.setFilled(true);
			add(dot);
		}
	}
	
	private class Dash extends GCompound {
		
		public Dash() {
			GRect dash = new GRect(2 * SYMBOL_HEIGHT, 0.8 * SYMBOL_HEIGHT);
			dash.setFilled(true);
			add(dash, 0, dash.getHeight() / 4);
		}
	}
	
}
	
