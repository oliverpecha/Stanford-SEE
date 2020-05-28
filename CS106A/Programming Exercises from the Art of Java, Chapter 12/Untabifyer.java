/*
 * File: Untabifyer.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 11
 * -----------------
 * Complete the implementation of the radix sort algorithm that will sort an array of nonnegative integers up to ten digits in length. 
 * A pseudocode version of the algorithm appears on page 480.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Untabifyer extends Applet implements ActionListener  {
	
	static private final String newline = "\n";
	JButton openButton;
	JTextArea log;
	JFileChooser fc;
	
	public void init() {
		setSize(300,400);
	    // Create the log first, because the action listeners
	    // need to refer to it.
		log = new JTextArea(20, 20);
	    log.setMargin(new Insets(5, 5, 5, 5));
	    log.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(log);
	
	    // Create a file chooser
	    fc = new JFileChooser();
	
	    // Create the open button. We use the image from the JLF
	    // Graphics Repository (but we extracted it from the jar).
	    openButton = new JButton("Open a File...");
	    openButton.addActionListener(this);
	
	    // For layout purposes, put the buttons in a separate panel
	    JPanel buttonPanel = new JPanel(); // use FlowLayout
	    buttonPanel.add(openButton);
	
	    // Add the buttons and the log to this panel.
	    add(buttonPanel, BorderLayout.PAGE_START);
	    add(logScrollPane, BorderLayout.CENTER);
	    log.append("Open a file to Untabify it's content." + newline);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	    // Handle open button action.
	    if (e.getSource() == openButton) {
	        int returnVal = fc.showOpenDialog(this);
	
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            // This is where a real application would open the file.
	            log.append("Opening: " + file.getName() + "." + newline);
	            unTabify(file);
	        } else {
	        	log.append("Open command cancelled by user." + newline);
	        }
	    } 
	}
	
	private void unTabify(File file) {
		BufferedReader buffer = fileToBuffer(file);
	    try {
	    	ArrayList<String> bufferMod = ammendBuffer(buffer);
	    	saveUntabified(bufferMod, file.getName());
		} catch (IOException e) {
			log.append(file.getName() + " is corrupted." + newline);
			e.printStackTrace();
		}
	}
	
	private BufferedReader fileToBuffer(File file) {
		BufferedReader buffer = null;
		while (buffer == null) {
			try {
				buffer = new BufferedReader(new FileReader(file));
			} catch (IOException ex) {
				log.append("Can't open that file.");
			}
		}
		return buffer;
	}
	
	private ArrayList<String> ammendBuffer(BufferedReader buffer) throws IOException {
		String line = buffer.readLine();
		ArrayList<String> bufferMod = new ArrayList<String>();
		while (line != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			int tokensInLine = tokenizer.countTokens();
			String lineMod = "";
			for (int i = 0; i < tokensInLine; i++) {
				String wordMod;
				wordMod = wordPlusSpaces(tokenizer.nextToken(), 8);
				lineMod += wordMod;
			}
			bufferMod.add(lineMod);
			line = buffer.readLine();
		}
		buffer.close();
		return bufferMod;
	}
		
	private String wordPlusSpaces(String word, int desiredLenght) {
		int wordLength = word.length();
		int spacesToAdd = desiredLenght - wordLength;
		for (int i = 0; i < spacesToAdd; i++) {
			word += " ";
		}
		return word;
	}
	
	private void saveUntabified(ArrayList<String> bufferMod, String oldName) {
		String txtExtension = ".txt";
		int fileExtensionAt = oldName.indexOf(txtExtension);
		String newName = oldName.substring(0, fileExtensionAt) + "_new" + txtExtension;
		try {
			File directory = directoryChoice();		
			PrintWriter bufferWriter = new PrintWriter(new FileWriter(new File(directory, newName)));
			for (int i = 0; i < bufferMod.size(); i++) {
				bufferWriter.println(bufferMod.get(i));
			}
			bufferWriter.close();
			log.append(oldName + " has been untabified."+ newline + "New file has been saved as " + newName + newline + "File is found at location choosen: " + directory + newline);
		} catch (IOException e) {
			log.append("File couldn't be saved.");
			e.printStackTrace();
		}
	}
	
	private File directoryChoice() {
	    int returnVal = fc.showSaveDialog(this);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        File directory = fc.getCurrentDirectory();
	        return directory;
	    } else {
	    	log.append("Save command cancelled by user." + newline);
	    	return null;
	        
	    }   
	}
}