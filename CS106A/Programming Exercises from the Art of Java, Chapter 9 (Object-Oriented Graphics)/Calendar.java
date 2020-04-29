/*
 * File: DrawHeartFilled.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 9
 * -----------------
 * Write a GraphicsProgram that draws a simple calendar similar to the one shown in the following diagram:
 * Your program should use the following named constants to control the format of the calendar:
 * 		* The number of days in the month *
 *  		private static final int DYAS_IN_MONTH = 31;
 *		* The day of the week on which the month starts 
 *		* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) 
 * 			private static final int DAY_MONTH_STARTS = 5;
 *
 * Your program should generate exactly the number of rows necessary to display the days of the month. Here, in a 31- day month that 
 * begins on a Friday, the calendar needs six rows; if you were generating a calendar for a non-leap-year February that began on 
 * a Sunday, the calendar display should fill the available space in both dimensions.
 */


import java.awt.Font;

import acm.graphics.*;
import acm.program.*;

public class Calendar extends GraphicsProgram {

	/* The number of days in the month */
    private static final int DAYS_IN_MONTH = 31;
    
    /* The day of the week on which the month starts */
    /* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
    private static final int DAY_MONTH_STARTS = 6;
    
    /* The height in pixels of a day on the calendar */
    private static final double DAYS_X_LINE = 7;
    
    /* The width in pixels of a day on the calendar */
    private static final int DAY_WIDTH = 40;
    
    /* The height in pixels of a day on the calendar */
    private static final int DAY_HEIGHT = 30;
    
    
    public void run() {
	    
    	double lines = 0.0;
    	int days = 0;
    	int position = 0;
    	String day = null;
    	
    	/* Days of the Week */
    	for (int i = 1; i <= DAYS_X_LINE; i++) {
    		
    		switch (i) {	
    			case 1: day = SUNDAY; break;
	    		case 2: day = MONDAY; break;
	    		case 3: day = TUESDAY; break;
	    		case 4: day = WEDNESDAY; break;
	    		case 5: day = THURSDAY; break;
	    		case 6: day = FRIDAY; break;
	    		case 7: day = SATURDAY; break;
    		}
    		GLabel topDays = new GLabel(day);
    		double margin = (DAY_WIDTH - topDays.getWidth()) / 2;
    		topDays.setFont("-Bold");
    		add(topDays, i * DAY_WIDTH + margin, 12);
    	}
    	
    	/* Calculate calendar lines */
    	lines = (DAYS_IN_MONTH + DAY_MONTH_STARTS)/DAYS_X_LINE;
    	if (lines > 5.0)lines = 6;
    	else if (lines <= 5.0 && lines > 4)lines = 5;
    	else lines = 4;
    
    	
    	/* Draw calendar slots */
    	for (int n = 0; n < lines; n++) {
		    	for (int i = 1; i <= DAYS_X_LINE; i++) {
		    	add (new GRect (i * DAY_WIDTH, DAY_HEIGHT / 2 + n * DAY_HEIGHT, DAY_WIDTH, DAY_HEIGHT));
	    	}
    	}
    
    	/* Fill calendar slots with days related to constants */
    	for (int n = 0; n < 6; n++) {
	    	for (int pr = 1; pr <= 7; pr++) {
	    		
	    		position++;	
	        	System.out.println("day is " + days);
	        	
	    		if (position > DAY_MONTH_STARTS && position <= DAYS_IN_MONTH + DAY_MONTH_STARTS) {
	    			days++;
	    			add (new GLabel (days + "", 5 + pr * DAY_WIDTH, DAY_HEIGHT /2 + 13 + n * DAY_HEIGHT ));
	    		}	
	    	}
    	}
    	
    }
	private static final String SUNDAY = "SUN";
	private static final String MONDAY = "MON";
	private static final String TUESDAY = "TUE";
	private static final String WEDNESDAY = "WED";
	private static final String THURSDAY = "THU";
	private static final String FRIDAY = "FRI";
	private static final String SATURDAY = "SAT";
}
