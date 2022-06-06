package com.day8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Frame implements ActionListener{
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JButton jbtn_south = new JButton();
	JLabel jl = new JLabel();
	JTextField answer;
	int lifeReamining = 5 ;
	
	Frame(){
		game_start();
	}

	public void game_start() {
		int num =(int)(Math.random()*10);
		System.out.println(num);
		
		jf.setBounds(100, 100, 1000, 620);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		jp.setBounds(0, 0, 1026, 574);
		jf.getContentPane().add(jp);
		jp.setLayout(null);
		
		
		jf.setSize(300,300);
		jf.setVisible(true);
		jbtn_south.addActionListener(this);

		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}

public class NumberGame {

	public static void main(String[] args) {
		new Frame();
	}

}
