package com.hutchip2.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import com.hutchip2.logic.Deck;

public class DeckGraphic extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8493105277844393L;

	Deck deck;
	String name;
	//JLabel title = new JLabel();
	
	public DeckGraphic(String n)	{
		setPreferredSize(new Dimension(200,100));
		setBackground(Color.WHITE);
		//title.setName(name);
		name = n;
		setText(name.substring(0, name.indexOf('.')));
		
	}
	
	public void setDeck(Deck d)	{
		deck = d;
	}
	
	public Deck getDeck()	{
		return deck;
	}
}
