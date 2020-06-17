/*
 * File: RandomCircles.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 4 / Programming Exercise 2
 * -----------------
 */

public class RemoveAllOcurrences {

    public static void main(String args[]){  
    	 System.out.println(removeAllOccurrences("This is a test", 't'));  
    	 System.out.println(removeAllOccurrences("Summer is here!", 'e'));  
    	 System.out.println(removeAllOccurrences("---0---", '-'));   
   }  
    
    private static String removeAllOccurrences(String str, char ch) {
    	String result = "";
    	int current = 0;
    	while (true) {
    		int ocurrence = str.indexOf(ch, current);
    		if (ocurrence > -1) {
    			result += str.substring(current, ocurrence);
    			if (ocurrence + 1 <= str.length()) current = ocurrence + 1;
    		}
    		else break;	
    	}
    	return result;
    }
        
}  
