/*
 * File: FlightPlanner.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 8 / Programming Exercise 1
 * -----------------
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import acm.program.*;

public class FlightPlanner extends ConsoleProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);	
	}
	
	public void run() {
		println("Welcome to Flight Planner!");
		fileToMap("flights.txt");
		printAllOrigins();
		println("Let's plan a round trip!");
		startTrip();
	}
	
	private void startTrip() {
		String origin = readAirport("Enter the starting city: ");
		String destination = "";
		println("From " + origin + " you can fly directly to:");
		printAllDestinations(origin);
		while (!origin.equals(destination)) {
			if (destination.length() == 0) destination = origin;
			destination = readAirport("Where do you want to go from " + destination + "? ");
			if (!origin.equals(destination)) {
				journey.add(destination);
				println("From " + destination + " you can fly directly to:");
				printAllDestinations(destination);				
			}
		}
		printJourney(origin);
	}

	private String readAirport(String message) {
		String airport = "";
		while (airport.length() == 0) {
			airport = readLine(message);
			ArrayList temp = routes.get(airport);
				if (temp != null) return airport;
				else {
					println(airport + " is not in our database.");
					airport = "";
				}
			}
		return airport;
	}

	private void printAllOrigins() {
		println("Here is a list of all the cities in our database:");
		Iterator<String> bulk = routes.keySet().iterator();
		while (bulk.hasNext()) {
			println(" " + bulk.next());
		}
	}
	
	private void printAllDestinations(String key) {
		ArrayList<String> destinations = routes.get(key);
		for (int i = 0; i < destinations.size(); i++) {
			println(" " + destinations.get(i));
		}
	}
	
	private void printJourney(String origin) {
		String journeyLine = "";
		for (int i = 0; i < journey.size(); i++) {
			journeyLine += journey.get(i) + " -> ";
		}
		println("The route you have choosen is:");
		println(origin + " -> " + journeyLine + origin);
	}
	
	
	private void fileToMap(String fileName) {
		BufferedReader rd = fileToBuffer(fileName);
		try {
			while (rd.ready()) {
				String line = rd.readLine();
				int divider = line.indexOf("->");
				if (divider > 0) {
					String origin = line.substring(0, divider).trim();
					String destination = line.substring(divider + 2).trim();
					ArrayList temp;
					try {
						temp = routes.get(origin);
						temp.add(destination);
					}
					catch  (NullPointerException e) {
						temp = new ArrayList();
						temp.add(destination);
						routes.put(origin, temp);
					}
				}
			}
		} catch (IOException e) {
		}			
	}
	
	private BufferedReader fileToBuffer(String fileName) {
		try { return new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			println("File couldn't be read");
			return null;
		}
	}
	
	HashMap<String, ArrayList<String>> routes = new HashMap<String, ArrayList<String>>();
	ArrayList<String> journey = new ArrayList<String>();

	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 300;

}
