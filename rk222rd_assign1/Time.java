/*
* Date: 2021-09-10.
* File Name: Time.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

/**
* A simple (24h) time object
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Time {
	private byte hour;
	private byte minute;
	private byte second;
	
	public Time() {
	}
	
	public Time(byte hour, byte minute, byte second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	/*
	* Constructor which takes time in seconds
	*/
	public Time(int seconds) {
		setClock(seconds);
	}
	
	/*
	* Set time, seconds are converted to the time value 
	* in hours, minutes, and seconds
	*/
	public void setClock(int seconds) {
		importTime(travelSeconds(seconds, new Time()));
	}
	
	/*
	* Increment Time 1 second
	*/
	public void tick() {
		travelSeconds(1, this);
	}
	
	/*
	* Decrement Time 1 second
	*/
	public void tickDown() {
		travelSeconds(-1, this);
	}
	
	/*
	* Return new Time object where the argument Time objects time 
	* is added to this objects time
	*/
	public Time addTime(Time time) {
		int seconds = timeToSeconds(time);
		return travelSeconds(seconds, copy());
	}
	
	/*
	* Return new Time object representing the time difference
	* between this object and the argument Time object
	*/
	public Time subtracTime(Time time) {
		int seconds_this = timeToSeconds(this);
		int seconds_other = timeToSeconds(time);
	
		//difference as greater time - lower time
		if(seconds_this > seconds_other)
			return travelSeconds(-seconds_other, copy());
		return travelSeconds(-seconds_this, time.copy());
	}
	
	/*
	* Return a Time objects time parameters as seconds since midnight
	*/
	private int timeToSeconds(Time time) {
		int seconds = 	time.gethour() * 60 * 60 +
						time.getminute() * 60 +
						time.second;
		return seconds;
	}
	
	/*
	* Set this Time objects parameters equal to the arguments
	*/
	private void importTime(Time time) {
		this.hour = time.gethour();
		this.minute = time.getminute();
		this.second = time.getsecond();
	}
	
	/*
	* Return a copy of this object
	*/
	private Time copy() {
		Time time = new Time();
		time.importTime(this);
		return time;
	}
	
	/*
	* Increment/decrement the argument Time object the 
	* number of seconds as specified in argument seconds
	*/
	private Time travelSeconds(int seconds, Time time) {
		boolean backward = false; //boolean to keep track of movement direction
		
		if(seconds < 0) {
			backward = true;
			seconds = -seconds;
		}
		
		//seconds and hours in mod 60
		int minutes = seconds / 60;
		int hours = minutes / 60;
		seconds = seconds % 60;
		minutes = minutes % 60;
		
		//if time is decrementing
		if(backward) {
			seconds = -seconds;
			minutes = -minutes;
			hours = -hours;
		}
		
		//update time object
		time.second += seconds;
		time.minute += minutes;
		time.hour += hours;
		
		if(time.second >= 60)
			time.minute += this.second / 60;
		else if(time.second < 0)
			time.minute--;
		
		if(time.minute >= 60)
			time.hour += this.minute / 60;
		else if(time.minute < 0)
			time.hour--;

		//modulo map time objects sec and min parameters to [0,60)
		time.second = (byte) (modulo(time.second, 60));
		time.minute = (byte) (modulo(time.minute, 60));
		//modulo map time objects hour parameter to [0,24)
		time.hour = (byte) (modulo(time.hour, 24));

		return time;
	}
	
	/*
	* Get objects second parameter
	*/
	public byte getsecond() {
		return this.second;
	}
	
	/*
	* Get objects minute parameter
	*/
	public byte getminute() {
		return this.minute;
	}
	
	/*
	* Get objects hour parameter
	*/
	public byte gethour() {
		return this.hour;
	}
	
	/*
	* Set objects second parameter
	*/
	public void setsecond(byte second) {
		this.second = second;
	}
	
	/*
	* Set objects minute parameter
	*/
	public void setminute(byte minute) {
		this.minute = minute;
	}
	
	/*
	* Set objects hour parameter
	*/
	public void sethour(byte hour) {
		this.hour = hour;
	}
	
	/*
	* String representation of object
	*/
	public String toString() {
		return String.format("%02d", hour) + "." + 
				String.format("%02d", minute) + "." + 
				String.format("%02d", second);
	}
	
	/*
	* Modulo operation mapping i to [0,j) instead of (-j,j)
	*/
	private int modulo(int i, int j) {
		return ((i % j) + j) % j;
	}
}
