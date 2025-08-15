package com.Nishu.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class userview extends JFrame{
	int counter;
    public userview() {
    	counter=0;
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,500);
    	setResizable(false);
    	setTitle("Login");
    	// setLocation(500,150);
    	setLocationRelativeTo(null); // show screen in center of window screen
    	JLabel welcome=new JLabel("Login");
    	welcome.setFont(new Font("Arial", Font.BOLD,40));
    	Container container=this.getContentPane();
        container.setLayout(null);
        welcome.setBounds(180,70,200,60);
    	container.add(welcome);
    	JButton button=new JButton("Count"); // source
    	button.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			counter++;
    			welcome.setText("Count: "+ counter);
    		}
    	});
    	button.setBounds(150,200,150,50);
    	container.add(button);
    	setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        userview userView= new userview();
        
	}

}
