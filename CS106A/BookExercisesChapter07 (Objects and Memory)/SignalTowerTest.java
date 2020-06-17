/*
 * File: SignalTowerTest.java
 * --------------------------
 * This class supplies a test program for the SignalTower class.
 * The SignalTowerTest class creates a list of SignalTower objects
 * and then sends a signal message to the first tower in the list.
 */

import acm.program.*;

public class SignalTowerTest extends ConsoleProgram {

	public void run() {
		createSignalTowers();
		pause(1000);
		minasTirith.signal();
	}

/* Creates the list of signal towers */
	private void createSignalTowers() {
		rohan = new SignalTower("Rohan", null);
		halifirien = new SignalTower("Halifirien", rohan);
		calenhad = new SignalTower("Calenhad", halifirien);
		minRimmon = new SignalTower("Min-Rimmon", calenhad);
		erelas = new SignalTower("Erelas", minRimmon);
		nardol = new SignalTower("Nardol", erelas);
		eilenach = new SignalTower("Eilenach", nardol);
		amonDin = new SignalTower("Amon Din", eilenach);
		minasTirith = new SignalTower("Minas Tirith", amonDin);
	}

/* Private instance variables */
	private SignalTower minasTirith, amonDin, eilenach, nardol, erelas,
	                    minRimmon, calenhad, halifirien, rohan;

}
