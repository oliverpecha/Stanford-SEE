//package com.javacodegeeks.snippets.desktop;
 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
 
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class aaaaaaaaaaTemp {
     public static void main(String args[]) {
 
	  JFrame jFrame = new JFrame();
	 
	  Container cPane = jFrame.getContentPane();
	 
		  ItemListener itemListener = new ItemListener() {
 
				@Override
				 
				public void itemStateChanged(ItemEvent event) {
				    System.out.println(" ");
		
				    System.out.println("Source: " + getName(event.getSource()));
				 
				    System.out.println("Item: " + getName(event.getItem()));
				 
				    int state = event.getStateChange();
				 
				    System.out.println("State: " + ((state == ItemEvent.SELECTED) ? "Selected"	: "Deselected"));
				 
				}
		 
				private String getName(Object o) {
		 
					if (o instanceof JComponent) {
		 
						JComponent jComponent = (JComponent) o;
		 
						return jComponent.getName();
		 
					} else {
		 
						return o.toString();
		 
					}
		 
				}
		 
			  };
 
  	  JPanel jPanel = new JPanel(new GridLayout(0, 1));
 
			  String itemArray[] = {"Item 1", "Item 2", "Item 3"};
			 
			  JComboBox combobox = new JComboBox(itemArray);
			 
					  combobox.setName("Combo");
					 
					  combobox.addItemListener(itemListener);
					 
					  combobox.setMaximumRowCount(4);
			 
			 
	  cPane.add(combobox, BorderLayout.SOUTH);
	  
	  jFrame.pack();
	 
	  jFrame.setVisible(true);
    }

 }

