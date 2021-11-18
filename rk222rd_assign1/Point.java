/*
* Date: 2021-09-09.
* File Name: Point.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* Point class by exercise specifications
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Point {
	private int x, y;
	
	public Point() {
	}
	
	
	public Point(int x_coordinates, int y_coordinates) {
		x = x_coordinates;
		y = y_coordinates;
	}
	
	/*
	* Check whether another point is equal to this point
	*/
	public boolean isEqualTo(Point other_point) {
		return x == other_point.x && y == other_point.y;
	}
	
	/*
	* String representation of point
	*/
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/*
	* Distance between two points
	*/
	public double distanceTo(Point other_point) {
		return Math.sqrt(
				Math.pow(x-other_point.x, 2) + Math.pow(y-other_point.y, 2));
	}
	
	/*
	* Moves the point certain steps in x- and y-direction
	*/
	public void move(int steps_x, int steps_y) {
		x += steps_x;
		y += steps_y;
	}
	
	/*
	* Set new coordinates
	*/
	public void moveToXY(int new_x, int new_y) {
		x = new_x;
		y = new_y;
	}
}
