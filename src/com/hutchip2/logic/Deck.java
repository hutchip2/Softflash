package com.hutchip2.logic;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deck extends ArrayList<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1911992343128670634L;

	String title = null;
	
	public Deck(File file)	{

	}
	
	public void create(File file)	{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();
	        while (line != null) {
	            String frontText = line.substring(0, line.indexOf(','));
	            String backText =  line.substring(line.indexOf(','), line.length()-1);
	            add(new Card(frontText, backText));
	        }
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
}
