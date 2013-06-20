package com.hutchip2.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DeckPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2424061206585303508L;
	
	JButton create;
	
	ArrayList<DeckGraphic> decks;
	ButtonGroup deckGraphics = new ButtonGroup();
	
	public DeckPanel()	{
		//setBackground(Color.BLUE);
		setPreferredSize(new Dimension(1024, 110));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		create = new JButton("Create New Deck...");
		create.setPreferredSize(new Dimension(200,100));
		create.addActionListener(this);
		
		add(create);
		
		JScrollPane pane = new JScrollPane(this);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		setVisible(true);
	}
	
	public void toggle() {
		if (isVisible()) {
			setVisible(false);
		} else {
			setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create)	{
		    JFileChooser fc = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
		    fc.setFileFilter(filter);
		    int status = fc.showOpenDialog(this);
		    if (status == JFileChooser.APPROVE_OPTION) {
		    	DeckGraphic deck = new DeckGraphic(fc.getSelectedFile().getName());
		    	//decks.add(deck);
		    	deckGraphics.add(deck);
		    	add(deck);
		    	validate();
		    }
		    System.out.println(this.getComponentCount());
		}
	}
	
}
