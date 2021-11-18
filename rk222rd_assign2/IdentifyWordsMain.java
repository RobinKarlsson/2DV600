/*
* Date: 2021-10-04.
* File Name: IdentifyWordsMain.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Reads a file, stripping non letters, and writes the content to a new file
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class IdentifyWordsMain {
	public static void main(String[] args) throws Exception {
		try {
			ArrayList<String> file_content = readFile("HistoryOfProgramming.txt");
			writeToFile(file_content, "words.txt");
		} catch (FileNotFoundException e) {
			System.out.println("file does not exist!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	* Read and strip non letters from a textfile
	* in: 	string filename
	* out:	ArrayList<String> with lines from file
	*/
	private static ArrayList<String> readFile(String file) throws FileNotFoundException {
		String line;
		ArrayList<String> data = new ArrayList<>();
		
		Scanner sc;
		sc = new Scanner(new FileReader(file));
			
		while(sc.hasNext()) {
			line = sc.nextLine();
			line = line.replaceAll("[^a-zA-Z\\s]", "");
			line = line.replace("  ", " ");
				
			if(!line.isEmpty())
				data.add(line);
		}
		
		sc.close();
		
		return data;
	}
	
	/*
	* Write content of a list into a textfile
	* in: 	ArrayList<String> content to write
	* 		String file to write to
	*/
	private static void writeToFile(ArrayList<String> content,
			String file) throws Exception {
		FileWriter fw = new FileWriter(file);
		
		for(String line: content) {
			fw.write(line);
			fw.write("\r\n");
		}
		
		fw.flush();
		fw.close();
	}
}
