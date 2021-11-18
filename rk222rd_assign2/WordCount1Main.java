/*
* Date: 2021-10-04.
* File Name: WordCount1Main.Java
* Author: Robin Karlsson
* 
* Copyright (c): MIT
*/

package rk222rd_assign2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
* read Word obects from file and store in hash & tree sets
* 
* @version 1.0 Sep 2021
* @author Robin Karlsson
*/
public class WordCount1Main {
	public static void main(String[] args) {
		HashSet<Word> hash_set = new HashSet<>();
		TreeSet<Word> tree_set = new TreeSet<>();
		boolean unique;
		
		try {
			ArrayList<String> file_content = readFile("words.txt");
			
			for(String s: file_content) {
				Word word = new Word(s);
				unique = true;
				
				for(Word o: tree_set) {
					if(word.equals(o)) {
						unique = false;
						break;
					}
				}
				
				if(unique) {
					hash_set.add(word);
					tree_set.add(word);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("file does not exist!");
			System.exit(0);
		}
		
		System.out.println("HashSet size: " + hash_set.size());
		System.out.println("TreeSet size: " + tree_set.size());
		System.out.println(tree_set);
	}
	
	/*
	* Read words from a textfile
	* in: 	string filename
	* out:	ArrayList<String> with words from file
	*/
	private static ArrayList<String> readFile(String file) throws FileNotFoundException {
		String line;
		ArrayList<String> data = new ArrayList<>();
		
		Scanner sc;
		sc = new Scanner(new FileReader(file));
			
		while(sc.hasNext()) {
			data.add(sc.next());
		}
		
		sc.close();
		return data;
	}
}
