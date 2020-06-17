/*
 * File: Calendar.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise Bonus (12 in old book)
 * -----------------
 */


import acm.graphics.*;
import acm.program.*;

public class Calendar extends GraphicsProgram {

	/* The number of days in the month */
    private static final int DAYS_IN_MONTH = 31;
    
    /* The day of the week on which the month starts */
    /* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
    private static final int DAY_MONTH_STARTS = 5;
    
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
    	
    	/* Calculate calendar lines */
    	if ((DAYS_IN_MONTH + DAY_MONTH_STARTS)/DAYS_X_LINE > 5.0)lines = 6;
    	else if ((DAYS_IN_MONTH + DAY_MONTH_STARTS)/DAYS_X_LINE <= 5.0)lines = 5;
    
    	
    	/* Draw calendar slots */
    	for (int n = 0; n < lines; n++) {
		    	for (int i = 1; i <= DAYS_X_LINE; i++) {
		    	add (new GRect (i * DAY_WIDTH, n * DAY_HEIGHT, DAY_WIDTH, DAY_HEIGHT));
	    	}
    	}
    
    	/* Fill calendar slots with days related to constants */
    	for (int n = 0; n < 6; n++) {
	    	for (int pr = 1; pr <= 7; pr++) {
	    		
	    		position++;	
	        	System.out.println("day is " + days);
	        	
	    		if (position > DAY_MONTH_STARTS && position <= DAYS_IN_MONTH + DAY_MONTH_STARTS) {
	    			days++;
	    			add (new GLabel (days + "", 5 + pr * DAY_WIDTH, 13 + n * DAY_HEIGHT ));
	    		}	
	    	}
    	}
	
    }
    
}
