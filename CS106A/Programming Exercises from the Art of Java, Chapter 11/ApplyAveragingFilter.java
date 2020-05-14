/*
 * File: ApplyAveragingFilter.java
 * -------------------------------
 * This program applies an averaging filter to an image.
 */

import acm.graphics.*;
import acm.program.*;

/*
 * This program applies an averaging filter to an image so that each
 * pixel is replaced by the average luminosity of the current pixel
 * and its four immediate neighbors (left, right, up, down, but not
 * diagonally).
 */
public class ApplyAveragingFilter extends GraphicsProgram {

	public void run() {
		GImage original = new GImage("Saturn.gif");
		GImage smoothed = applyAveragingFilter(original);
		double x = (getWidth() - original.getWidth()) / 2;
		double y = (getHeight() - original.getHeight()) / 2;
		add(smoothed, x, y);
	}

/*
 * Creates a new image by applying an averaging filter to the
 * original.  Each pixel in the original image is replaced by
 * a grayscale pixel with the average luminosity of the current
 * pixel and its four immediate neighbors (left, right, up, down,
 * but not diagonally).
 */
	private GImage applyAveragingFilter(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int xx = averageNeighborLuminosity(array, i, j);
				array[i][j] = (0xFF << 24) | (xx << 16) | (xx << 8) | xx;
			}
		}
		return new GImage(array);
	}

/*
 * Computes the average luminosity of the pixel at array[i][j]
 * and its four immediate neighbors.  The code checks to make sure
 * that the neighbors are within the array bounds.
 */
	private int averageNeighborLuminosity(int[][] array, int i, int j) {
		int sum = getLuminosity(array, i, j);
		int count = 1;
		if (i > 0) {
			sum += getLuminosity(array, i - 1, j);
			count++;
		}
		if (i < array.length - 1) {
			sum += getLuminosity(array, i + 1, j);
			count++;
		}
		if (j > 0) {
			sum += getLuminosity(array, i, j - 1);
			count++;
		}
		if (j < array[0].length - 1) {
			sum += getLuminosity(array, i, j + 1);
			count++;
		}
		return GMath.round((double) sum / count);
	}

/* Determines the luminosity of the pixel at array[i][j] */
 	private int getLuminosity(int[][] array, int i, int j) {
		int pixel = array[i][j];
		int red = (pixel >> 16) & 0xFF;
		int green = (pixel >> 8) & 0xFF;
		int blue = pixel & 0xFF;
		return computeLuminosity(red, green, blue);
	}

/* Applies the standard luminosity formula */
	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
	}

}
