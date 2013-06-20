package com.hutchip2.gui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar	 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4191701217140550344L;

	JMenuItem showHideDecks;
	
	public MenuBar()	{
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu view = new JMenu("View");
		JMenu help = new JMenu("Help");
		
		showHideDecks = new JMenuItem("Show/Hide Decks");
		JMenuItem about = new JMenuItem("About...");

		view.add(showHideDecks);
		help.add(about);
		
		add(file);
		add(edit);
		add(view);
		add(help);
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		view.setMnemonic(KeyEvent.VK_V);
		help.setMnemonic(KeyEvent.VK_H);
		showHideDecks.setMnemonic(KeyEvent.VK_S);
		about.setMnemonic(KeyEvent.VK_A);
		
	}
	
}
