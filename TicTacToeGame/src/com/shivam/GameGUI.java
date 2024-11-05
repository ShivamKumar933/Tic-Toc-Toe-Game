package com.shivam;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GameGUI implements ActionListener{
	private JFrame f;
	private JPanel panel;
	private JButton b[];
	private JLabel playerLabel, scoreLabel;
	private int i = 1;
	private int x = 0, o = 0;
	private String winner, player1, player2;
	public GameGUI() {
		new Splash();
		
		f = new JFrame("TicTacToe Game");
		b = new JButton[9];
		
		panel = new JPanel();
		playerLabel = new JLabel("Start The Game", SwingConstants.CENTER); 
		playerLabel.setFont(new Font("Arial", Font.ITALIC, 20));
		
		scoreLabel = new JLabel("X = "+ x + " O = "+ o, SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		for (int i = 0; i < 9; i++) {
			b[i] = new JButton();
			b[i].addActionListener(this);
			b[i].setBackground(Color.BLACK);
			b[i].setFont(new Font("Arial", Font.PLAIN, 35));;
			panel.add(b[i]);
		}
		
		
		f.setLayout(new BorderLayout());
		
		panel.setLayout(new GridLayout(3,3));
		panel.setSize(300,300);
		
		f.add(scoreLabel, BorderLayout.NORTH);
		f.add(panel, BorderLayout.CENTER);
		f.add(playerLabel, BorderLayout.SOUTH);
		f.setLocationRelativeTo(null);
		f.setSize(400,400);
		
		f.setVisible(true);
		
		player1 = (String)JOptionPane.showInputDialog(f,"Enter Player 1 Name :","Enter Details" ,JOptionPane.QUESTION_MESSAGE);
		player2 = (String)JOptionPane.showInputDialog(f,"Enter Player 2 Name :","Enter Details",JOptionPane.QUESTION_MESSAGE);
		
		if(player1==null || player2 == null) {
			player1 = "Player 1";
			player2 = "Player 2";
		}
		playerLabel.setText(player1 + "'s turn!!");
	}
	
	private void loadGame() {
		for (int i = 0; i < 9; i++) {
			b[i].setText("");
		}
		playerLabel.setText(player1 + "'s turn!!");
		scoreLabel.setText("X = "+ x + " O = "+ o);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		if(button.getText().equals("")) {
			setXOrO(button);
		}
	}
	
	private void setXOrO(JButton button) {
		
		
		if(i%2==0) {
			button.setText("O");
			button.setForeground(Color.GREEN);
			playerLabel.setText(player1 + "'s turn!!");
		}
		else {
			button.setText("X");
			button.setForeground(Color.red);
			playerLabel.setText(player2 + "'s turn!!");
		}
		i++;
		checkWin();
	}

	
	private void checkWin() {
		
		if(b[0].getText().equals("X") && b[1].getText().equals("X") && b[2].getText().equals("X") ||
			b[0].getText().equals("O") && b[1].getText().equals("O") && b[2].getText().equals("O")	) {
			showWinner(b[0].getText());
		}
		else if (b[3].getText().equals("X") && b[4].getText().equals("X") && b[5].getText().equals("X") ||
			b[3].getText().equals("O") && b[4].getText().equals("O") && b[5].getText().equals("O")) {
			showWinner(b[3].getText());
		}
		else if (b[6].getText().equals("X") && b[7].getText().equals("X") && b[8].getText().equals("X") ||
			b[6].getText().equals("O") && b[7].getText().equals("O") && b[8].getText().equals("O")) {
			showWinner(b[6].getText());
		}
		else if (b[0].getText().equals("X") && b[3].getText().equals("X") && b[6].getText().equals("X") ||
			b[0].getText().equals("O") && b[3].getText().equals("O") && b[6].getText().equals("O")) {
			showWinner(b[0].getText());
		}
		else if (b[1].getText().equals("X") && b[4].getText().equals("X") && b[7].getText().equals("X") ||
			b[1].getText().equals("O") && b[4].getText().equals("O") && b[7].getText().equals("O")){
			showWinner(b[1].getText());
		}
		else if (b[2].getText().equals("X") && b[5].getText().equals("X") && b[8].getText().equals("X") ||
			b[2].getText().equals("O") && b[5].getText().equals("O") && b[8].getText().equals("O")){
			showWinner(b[2].getText());
		}
		else if (b[0].getText().equals("X") && b[4].getText().equals("X") && b[8].getText().equals("X") ||
			b[0].getText().equals("O") && b[4].getText().equals("O") && b[8].getText().equals("O")){
			showWinner(b[0].getText());
		}
		else if (b[2].getText().equals("X") && b[4].getText().equals("X") && b[6].getText().equals("X") ||
			b[2].getText().equals("O") && b[4].getText().equals("O") && b[6].getText().equals("O")){
			showWinner(b[2].getText());
		}	
		else if(!(b[0].getText().equals("")) &&  !(b[1].getText().equals("")) && !(b[2].getText().equals(""))&& 
				!(b[3].getText().equals("")) &&  !(b[4].getText().equals("")) && !(b[5].getText().equals(""))&& 
				!(b[6].getText().equals("")) &&  !(b[7].getText().equals("")) && !(b[8].getText().equals(""))) {
			JOptionPane.showMessageDialog(f, "Match Draw, Play again!!", "Match Draw",JOptionPane.INFORMATION_MESSAGE);
			loadGame();
		}
	}
	
	private void showWinner(String s) {
		if(s.equals("X")) {
			winner = player1 + " Won this Match";
			x += 1;
		}
		else {
			winner = player2 + " Won this Match";
			o += 1;
		}
		
		JOptionPane.showMessageDialog(f, winner,"Match Winner", JOptionPane.INFORMATION_MESSAGE);
		loadGame();
	}
}
