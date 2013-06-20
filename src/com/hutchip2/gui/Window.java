package com.hutchip2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window extends JFrame implements ActionListener, MouseListener, ChangeListener, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6350750774747552539L;

	public static int WIDTH = 1024;
	public static int HEIGHT = 600;
	
	CardPanel cp;
	DeckPanel dp;
	MenuBar mb;
	
	JButton toggle;
	
	public Window()	{
		
		setResizable(false);
		
		setJMenuBar(mb = new MenuBar());
		setTitle("Softflash (beta)");
		setBackground(Color.LIGHT_GRAY);
		setIconImage(null);
		setSize(WIDTH,HEIGHT);
		setLayout(new BorderLayout());
		
		cp = new CardPanel();
		dp = new DeckPanel();

		//toggle = new JButton("Show/Hide Decks");
		//toggle.setPreferredSize(new Dimension(50,50));
		//toggle.setBackground(Color.GREEN);
		//toggle.addActionListener(this);
		mb.showHideDecks.addActionListener(this);
			
		add(cp, BorderLayout.CENTER);
		add(dp, BorderLayout.SOUTH);
		
		//JPanel button = new JPanel(new FlowLayout());
		
		//button.add(toggle);
		
		//add(button, BorderLayout.EAST);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void centerFrame()	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize(); 
		int x = (screenSize.width - getWidth()) / 2;  
		int y = (screenSize.height - getHeight()) / 2;   
		setLocation(x, y); 
	}
	
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toggle || e.getSource() == mb.showHideDecks)	{
			dp.toggle();
		}
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent e) {
		if (e.getSource() == this)	{
			WIDTH = getWidth();
			HEIGHT = getHeight();
			cp.updateSize();
			System.out.println("updated!");
		}
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
