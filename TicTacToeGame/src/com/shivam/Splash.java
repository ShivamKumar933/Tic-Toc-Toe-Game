package com.shivam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Splash {
	private JFrame f;
	private JProgressBar progressBar; 
	private JLabel title;
	public Splash() {
		f = new JFrame();
		f.setLayout(new BorderLayout());
		title = new JLabel("Tic Tac Toe", SwingConstants.CENTER);
		title.setFont(new Font("Monospaced", Font.BOLD, 45));
		
		progressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
		
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.RED);
		
		f.add(title, BorderLayout.CENTER);
		f.add(progressBar, BorderLayout.SOUTH);
		
		f.setLocationRelativeTo(null);
		f.setUndecorated(true);
		f.setSize(400,200);
		f.setVisible(true);
		
		iterate();
	}
	
	private void iterate() {
		int i = 0; 
		
		while(i<=100){
			progressBar.setValue(i);
			if(i>=70) {
				progressBar.setString("bs ho hi gya bhai");
			}
			else if(i>=30) {
				progressBar.setString("thodi der or bs");
			}
			else {
				progressBar.setString("rukja thoda");
			}
			try {
				Thread.sleep(150);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			i = i+2;
		}
		
		if(i>=100) {
			f.dispose();
		}
		
	}
	
}
