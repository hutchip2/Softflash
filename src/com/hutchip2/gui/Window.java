package com.hutchip2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.hutchip2.logic.Deck;

public class Window extends JFrame implements ActionListener, MouseListener, ChangeListener, ComponentListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6350750774747552539L;

	public static int WIDTH = 1024;
	public static int HEIGHT = 600;
	
	Deck currentDeck;
	
	CardPanel cp;
	DeckPanel dp;
	MenuBar mb;
	
	JButton toggle;
	JScrollPane sp;
	
	DeckGraphic deckGraphic;
	
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
		
		cp.card.addKeyListener(this);
		
		cp.card.addActionListener(this);
		dp.create.addActionListener(this);
		
		sp = new JScrollPane(dp);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		//toggle = new JButton("Show/Hide Decks");
		//toggle.setPreferredSize(new Dimension(50,50));
		//toggle.setBackground(Color.GREEN);
		//toggle.addActionListener(this);
		mb.showHideDecks.addActionListener(this);
			
		add(cp, BorderLayout.CENTER);
		add(sp, BorderLayout.SOUTH);
		
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
			if (dp.isVisible())	{
				sp.setVisible(true);
			} else {
				sp.setVisible(false);
			}
		}
		if (e.getSource() == dp.create)	{
		    JFileChooser fc = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
		    fc.setFileFilter(filter);
		    int status = fc.showOpenDialog(this);
		    if (status == JFileChooser.APPROVE_OPTION) {
		    	Deck deck = new Deck(fc.getSelectedFile());
		    	deckGraphic = new DeckGraphic(fc.getSelectedFile().getName());
		    	deckGraphic.addActionListener(this);
		    	deckGraphic.setDeck(deck);
		    	//dp.decks.add(deckGraphic);
		    	//dp.deckGraphics.add(deckG);
		    	dp.add(deckGraphic);
		    	dp.validate();
		    }
		}
		if (e.getSource() == deckGraphic)	{
			currentDeck = deckGraphic.deck;
			currentDeck.currentIndex = 0;
			currentDeck.currentCard = currentDeck.get(currentDeck.currentIndex);
			currentDeck.currentCard.isFront = true;
			cp.card.setText(currentDeck.currentCard.front);
			cp.card.validate();
		}
		//if (e.getSource() == cp.card)	{
			
		//}
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent e) {
		if (e.getSource() == this)	{
		//	WIDTH = getWidth();
		//	HEIGHT = getHeight();
		//	cp.updateSize();
		//	System.out.println("updated!");
		}
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)	{
			if (currentDeck.currentCard.isFront)	{
				cp.card.setText(currentDeck.currentCard.back);
				currentDeck.currentCard.isFront = false;
			} else {
				currentDeck.currentIndex += 1;
				if (currentDeck.currentIndex == currentDeck.size()){
					currentDeck.currentIndex = 0;
				}
				currentDeck.currentCard = currentDeck.get(currentDeck.currentIndex);
				cp.card.setText(currentDeck.currentCard.front);
				currentDeck.currentCard.isFront = true;

			}
		//	cp.card.setText(deckGraphic.deck.get(0).front);
		//	cp.card.validate();	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
