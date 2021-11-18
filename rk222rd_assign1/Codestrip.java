/*
* Date: 2021-09-09.
* File Name: Codestrip.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Reads a java file and prints its contents after 
* removing blank lines and comments
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class Codestrip {
	private static int redacted_comments = 0; //comments found
	private static int redacted_empty = 0; //empy lines found
	private static ArrayList<String> code = new ArrayList<>(); //lines of code found
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name of java file: ");
		String filename = sc.next();
		sc.close();
		
		//read and process java file
		processJavaFile(readFile(filename));
		
		//print specified outputs
		for(String line: code) {
			System.out.println(line);
		}
		
		System.out.println("\nNumber of actual lines of code: " + code.size());
		System.out.println("Number of blank lines removed: " + redacted_empty);
		System.out.println("Number of comments removed: " + redacted_comments);
		
	}
	
	/*
	* Takes an arraylist where each element is a line of the imported file
	* and process the file (removing blank lines & comments)
	*/
	private static void processJavaFile(ArrayList<String> file_content) {
		boolean inside_comment = false;
		
		//iterate over each element/line
		for(String line: file_content) {
			//javadoc or multiline comment
			if(line.contains("/*")) {
				redacted_comments++;
				inside_comment = true;
				continue;
			} else if(line.contains("*/")) {
				inside_comment = false;
				continue;
			} else if(inside_comment) {
				continue;
			} 
			
			//"normal" comment
			else if(line.contains("//")) {
				redacted_comments++;
				continue;
			}
			
			//empty line
			if(line.trim().isEmpty()) {
				redacted_empty++;
				continue;
			}
			
			//line neither empty nor comment -> code
			code.add(line);
		}
	}
	
	/*
	* Read content of file into an ArrayList
	*/
	private static ArrayList<String> readFile(String file) {
		ArrayList<String> data = new ArrayList<>();
		
		Scanner sc;
		try {
			sc = new Scanner(new FileReader(file));
			
			while(sc.hasNext()) {
				data.add(sc.nextLine());
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(file + " does not exist!");
			System.exit(0);
		}
		
		return data;
	}
}
