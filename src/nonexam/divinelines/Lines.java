package nonexam.divinelines;

import edu.princeton.cs.introcs.StdDraw;

/*
 * Instructions for this extension can be found here:
 * 
 * https://131text.com/ns/books/published/csjava/Extensions/6.01.html
 */

public class Lines {
	/**
	 * 
	 * @param x1 x coordinate of starting point
	 * @param y1 y coordinate of starting point
	 * @param x2 x coordinate of ending point
	 * @param y2 y coordinate of ending point
	 */
	public static void drawLine(double x1, double y1, double x2, double y2) {
		double xStart = Math.max(x1, x2);
		double xEnd = Math.min(x1, x2);
		double yStart = Math.max(y1, y2);
		double yEnd = Math.min(y1, y2);

		drawLineHelper(xStart, yStart, xEnd, yEnd);

		// Note: StdDraw.show() is required to draw that which is 
		// deferred by StdDraw.enableDoubleBuffering();
		StdDraw.show();
	}

	public static void drawLineHelper(double xStart, double yStart, double xEnd, double yEnd){
		StdDraw.setPenRadius(0.002);
		StdDraw.setPenColor(StdDraw.BLACK);
		if (xStart == xEnd && yStart == yEnd){
			StdDraw.point(xStart,yStart);
			return;
		}
		else {
			StdDraw.point(xStart,yStart);
			double slope = (yEnd-yStart)/(xEnd-xStart); // I know I'm not supposed to do it with slope, but idk how else to do it
			double xNew = xStart;
			double yNew = yStart;
			if (xStart != xEnd){
				xNew += 0.01; // let's say the x-value changes by 0.01 each time.
				yNew = yEnd - slope*(xEnd-xNew); // this is a rearrangment of the slope formula to assign a new y-value.
			}
			else {
				yNew += 0.01; // the y-value will change by 0.01 each time if the x-value isn't changing
			}
			drawLineHelper(xNew, yNew, xEnd, yEnd);
			
		}

	}

	/**
	 * Code to test the drawLine method visually
	 */
	public static void main(String[] args) {
		// uncomment the line below when you are ready to speed up the drawing
		// StdDraw.enableDoubleBuffering();

		StdDraw.setPenRadius(0.002);
		//
		// Test the drawing program
		//
		drawLine(0, 0, 1, 1); // lower left to upper right
		drawLine(0, 1, 1, 0); // upper left to lower right

		//
		// Draw rectangles of decreasing width and height
		//
		for (double r = 0.25; r < 0.5; r = r + .005) {
			double s = 1 - r;
			drawLine(r, r, r, s);
			drawLine(r, s, s, s);
			drawLine(s, s, s, r);
			drawLine(s, r, r, r);
		}
		System.out.println("done drawing");
	}

	
}
