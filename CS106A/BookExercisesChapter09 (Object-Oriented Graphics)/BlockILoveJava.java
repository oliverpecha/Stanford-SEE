
import java.awt.Color;
import java.util.StringTokenizer;

import acm.graphics.*;

public class BlockILoveJava extends GCompound {

	
	public BlockILoveJava(double width) {
		GRect base = new GRect(width,width);
				base.setFilled(true);
				base.setFillColor(Color.PINK);
		GPolygon heart = heart(width / 4);
		GLabel textI = new GLabel("I");
				textI.setColor(Color.white);
				textI.setFont("-Bold-15");
		GLabel textLove = new GLabel("Love");
				textLove.setColor(Color.white);
				textLove.setFont("-Bold-15");
		GLabel textJava = new GLabel("Java");
				textJava.setColor(Color.white);
				textJava.setFont("-Bold-15");
		add(base, -width / 2, -width /2);
		add(heart, 0, ((width - heart.getHeight()) / 4));
		add(textI, -textI.getWidth() / 2, -textI.getAscent() );
		add(textLove, -textLove.getWidth() / 2, 0);
		add(textJava, -textJava.getWidth() / 2, textI.getAscent());
		}
			
	GPolygon heart(double radius) {
		double hypotenuse = 2 * radius;
		double adjacent = hypotenuse * GMath.sinDegrees(45);
		GPolygon heart = new GPolygon();
				heart.addVertex(0, adjacent);
				heart.addVertex(-adjacent, 0);
				heart.addArc(2 * radius, 2 * radius, -135, -180);
				heart.addArc(2 * radius, 2 * radius, -225, -180);
				heart.setFilled(true);
				heart.setFillColor(Color.red);
				heart.setColor(Color.red);
		return heart;
	}

}