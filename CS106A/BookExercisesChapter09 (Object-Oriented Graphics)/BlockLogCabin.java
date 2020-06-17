
import java.awt.Color;

import acm.graphics.*;

public class BlockLogCabin extends GCompound {

	public BlockLogCabin(int width) {
		double scale = width / 9;
		for (int i = 0; i < 4; i++) {
			GRect bottomBars = new GRect(width - i * scale - i * scale - scale, scale);
			bottomBars.setFilled(true);
			bottomBars.setFillColor(Color.green);
			add(bottomBars, scale -width / 2 + i * scale, width / 2 - scale * i - scale);
		}
		for (int i = 0; i < 4; i++) {
			GRect topBars = new GRect(width - i * scale - i * scale - scale, scale);
			topBars.setFilled(true);
			topBars.setFillColor(Color.green);
			add(topBars, -width / 2 + i * scale, - width / 2 + scale * i);
		}
		for (int i = 0; i < 4; i++) {
			GRect rightBars = new GRect(scale, width - i * scale - i * scale - scale);
			rightBars.setFilled(true);
			rightBars.setFillColor(Color.green);
			add(rightBars, width / 2 - scale * i - scale, -width / 2 + i * scale);
		}
		for (int i = 0; i < 4; i++) {
			GRect leftBars = new GRect(scale, width - i * scale - i * scale - scale);
			leftBars.setFilled(true);
			leftBars.setFillColor(Color.green);
			add(leftBars, -width / 2 + i * scale, -width / 2 + scale * i + scale );
		}
	}
			
}