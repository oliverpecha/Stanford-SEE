
import java.awt.Color;

import acm.graphics.*;

public class BlockNestedSquare extends GCompound {
	
	public BlockNestedSquare(double width) {
		GRect base = new GRect(width,width);
		base.setFilled(true);
		base.setFillColor(Color.CYAN);
		add(base, -width / 2, -width /2);
		add(center(width));
		add(flower(width));
	}
	
	private GPolygon flower(double width) {
		double hypotenuse = width / 2 * GMath.sinDegrees(45);
		GPolygon flower = new GPolygon();
		flower.addVertex(-hypotenuse, 0);
		flower.addVertex(-hypotenuse, hypotenuse);
		flower.addVertex(hypotenuse, hypotenuse);
		flower.addVertex(hypotenuse, -hypotenuse);
		flower.addVertex(-hypotenuse, -hypotenuse);
		flower.addVertex(-hypotenuse, 0);
		flower.addVertex(0, -hypotenuse);
		flower.addVertex(hypotenuse, 0);
		flower.addVertex(0, hypotenuse);
		flower.rotate(45);
		flower.setFilled(true);
		flower.setFillColor(Color.magenta);
		return flower;
	}
	
	private GPolygon center(double width) {
		double hypotenuse = width / 2 * GMath.sinDegrees(45);
		GPolygon flower = new GPolygon();
		flower.addVertex(-hypotenuse / 2, hypotenuse / 2);
		flower.addVertex(hypotenuse / 2, hypotenuse / 2);
		flower.addVertex(hypotenuse / 2, -hypotenuse / 2);
		flower.addVertex(-hypotenuse / 2, -hypotenuse / 2);
		flower.rotate(45);
		flower.setFilled(true);
		flower.setFillColor(Color.magenta);
		return flower;
	}

}
