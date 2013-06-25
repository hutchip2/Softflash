package com.hutchip2.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.hutchip2.logic.Deck;

public class DeckPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2424061206585303508L;
	
	JButton create;
	
	ArrayList<Deck> decks = new ArrayList<Deck>();
	ButtonGroup deckGraphics = new ButtonGroup();
	
	public static int WIDTH = 1020;
	
	public DeckPanel()	{
		//setBackground(Color.BLUE);
		setPreferredSize(new Dimension(WIDTH, 110));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		create = new JButton("Create New Deck...");
		create.setPreferredSize(new Dimension(200,100));
		create.addActionListener(this);
		
		
		add(create);
		setVisible(true);
	}
	
	public void update() {

		if (getComponentCount() > 4) {
		    System.out.println(this.getComponentCount());
			WIDTH += 200;
		}
		setPreferredSize(new Dimension(WIDTH, 110));
		validate();
	}
	
	public void toggle() {
		if (isVisible()) {
			setVisible(false);
		} else {
			setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
}
