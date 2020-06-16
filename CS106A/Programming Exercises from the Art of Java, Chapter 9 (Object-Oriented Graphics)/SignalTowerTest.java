/*
 * File: SignalTowerTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 13 
 * -----------------
 * This class supplies a test program for the SignalTower class.
 * The SignalTowerTest class creates a list of SignalTower objects
 * and then sends a signal message to the first tower in the list.
 */


import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.*;

public class SignalTowerTest extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
		createSignalTowers();
	}

/* Creates the list of signal towers */
	private void createSignalTowers() {
		int i = 9;
		rohan = new SignalTower("Rohan", null, TOWER_WIDTH, TOWER_HEIGHT);
		add(rohan, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		halifirien = new SignalTower("Halifirien", rohan, TOWER_WIDTH, TOWER_HEIGHT);
		add(halifirien, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		calenhad = new SignalTower("Calenhad", halifirien, TOWER_WIDTH, TOWER_HEIGHT);
		add(calenhad, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		minRimmon = new SignalTower("Min-Rimmon", calenhad, TOWER_WIDTH, TOWER_HEIGHT);
		add(minRimmon, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		erelas = new SignalTower("Erelas", minRimmon, TOWER_WIDTH, TOWER_HEIGHT);
		add(erelas, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		nardol = new SignalTower("Nardol", erelas, TOWER_WIDTH, TOWER_HEIGHT);
		add(nardol, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		eilenach = new SignalTower("Eilenach", nardol, TOWER_WIDTH, TOWER_HEIGHT);
		add(eilenach, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		amonDin = new SignalTower("Amon Din", eilenach, TOWER_WIDTH, TOWER_HEIGHT);
		add(amonDin, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
		minasTirith = new SignalTower("Minas Tirith", amonDin, TOWER_WIDTH, TOWER_HEIGHT);
		add(minasTirith, MARGIN_SIDES + i * MARGIN_TOWERS, MARGIN_BOTTOM);
		i--;
	}
	
	private void startSignaling() {
		minasTirith.signal();
	}
	                      
	public void mousePressed(MouseEvent e) {
		startSignaling();	
	}
	
/* Private instance variables */
	private SignalTower minasTirith, amonDin, eilenach, nardol, erelas,
	                    minRimmon, calenhad, halifirien, rohan;
/* Private constants */
	private static final int TOWER_WIDTH = 20;
	private static final int TOWER_HEIGHT = TOWER_WIDTH * 6;
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 200;
	private static final double MARGIN_SIDES = SCREEN_WIDTH * 0.01;
	private static final double MARGIN_TOWERS = (SCREEN_WIDTH - MARGIN_SIDES * 2 - 9 * TOWER_WIDTH) / 8;
	private static final int MARGIN_BOTTOM = SCREEN_HEIGHT - 20;

}
