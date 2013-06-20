package com.hutchip2.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DeckGraphic extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8493105277844393L;

	//JLabel title = new JLabel();
	
	public DeckGraphic(String name)	{
		setPreferredSize(new Dimension(200,100));
		setBackground(Color.WHITE);
		//title.setName(name);
		setText(name.substring(0, name.indexOf('.')));
	}
}
