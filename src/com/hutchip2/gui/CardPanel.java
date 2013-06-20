package com.hutchip2.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2398552140259237676L;

	JButton card;
	
	public CardPanel()	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//setBackground(Color.BLUE);
		//setPreferredSize(new Dimension(600,300));
		
		card = new JButton();
		card.setBackground(Color.WHITE);
		updateSize();
				
		//JPanel holder = new JPanel(new FlowLayout());
		//holder.add(card);
		
		

		add(card, gbc);
		
		setVisible(true);
	}
	
	public void updateSize()	{
		int width = (int)(Window.WIDTH * 0.78125);
		card.setPreferredSize(new Dimension(width, (int)(width/2)));
	}
}
