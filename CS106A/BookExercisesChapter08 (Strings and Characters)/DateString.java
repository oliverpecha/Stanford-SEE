/*
 * File: DateString.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 4
 * -----------------
 *  Write a method dateString(day, month, year) that returns a string consisting of the day of the month, a hyphen, the first three letters in the
 *  name of the month, another hyphen, and the last two digits of the year. For example, calling the method
 *  			dateString(22, 11, 1963) 
 *  should return the string "22-Nov-63".		
 */

public class DateString {

	
	public DateString(int day, int month, int year) {
		Day = day;
		Month = month;
		Year = year;
	}
	
	public String toString() {
		monthToWords();
		String twoDigitYear = Year.toString();
		twoDigitYear = twoDigitYear.substring(2,4);
		return "" + Day + "-" + MonthInLetters + "-" + twoDigitYear;
	}
	
	private void monthToWords() {
		switch (Month) {
			case 1: MonthInLetters = "Jan"; break;
			case 2: MonthInLetters = "Feb"; break;
			case 3: MonthInLetters = "Mar"; break;
			case 4: MonthInLetters = "Apr"; break;
			case 5: MonthInLetters = "May"; break;
			case 6: MonthInLetters = "Jun"; break;
			case 7: MonthInLetters = "Jul"; break;
			case 8: MonthInLetters = "Aug"; break;
			case 9: MonthInLetters = "Sep"; break;
			case 10:MonthInLetters = "Oct"; break;
			case 11:MonthInLetters = "Nov"; break;
			case 12:MonthInLetters = "Dec"; break;
		}
	}
	
	private int Day;
	private int Month;
	private Integer Year;
	private String MonthInLetters;

}
