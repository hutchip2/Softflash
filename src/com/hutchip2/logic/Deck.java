package com.hutchip2.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.hutchip2.gui.DeckGraphic;

public class Deck extends ArrayList<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1911992343128670634L;

	public Card currentCard;
	public int currentIndex;
	public DeckGraphic dg;
	
	public Deck(File file)	{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
	        while ((line = br.readLine()) != null) {
	        	if (line.isEmpty())	{
	        		break;
	        	}
	            String front = line.substring(0, line.indexOf(','));
	            String back =  line.substring(line.indexOf(',') + 1, line.length());
	            add(new Card(front.trim(), back.trim()));
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
		dg = new DeckGraphic(file.getName());
	}
	
	
}
