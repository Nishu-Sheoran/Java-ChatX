package com.Nishu.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.Nishu.chatapp.dao.UserDAO;
import com.Nishu.chatapp.dto.UserDTO;
import com.Nishu.chatapp.utils.UserInfo;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
	UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO=new UserDAO();
	private void doLogin() {
		String userid= useridtxt.getText();
		char []password= passwordField.getPassword();
		UserDTO userDTO=new UserDTO(userid,password);
		try {
			String message="";
			if(userDAO.isLogin(userDTO)) {
				message="Welcome"+userid;
				UserInfo.USER_NAME= userid;
				JOptionPane.showMessageDialog(this, message );
				setVisible(false);
				dispose();
				DashBoard dashBoard=new DashBoard(message);
				dashBoard.setVisible(true);
			}
			else {
				message="Invalid Userid or password";
				JOptionPane.showMessageDialog(this, message );
			}
			// JOptionPane.showMessageDialog(this, message );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void register() {
		String userid= useridtxt.getText();
		char []password= passwordField.getPassword();
		// UserDAO userDAO=new UserDAO();
		UserDTO userDTO=new UserDTO(userid,password);
		try {
		int result=userDAO.add(userDTO);
		if(result>0) {
			// System.out.println("Record added...");
			JOptionPane.showMessageDialog(this, "Register Successfully");
		}
		else {
			// System.out.println("Record not added...");
			JOptionPane.showMessageDialog(this, "Register fail");
		}
		}
		catch(ClassNotFoundException |SQLException ex) {
			System.out.println("DB Issue...");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some generic exception raised..");
			ex.printStackTrace(); // where is the Exception
		}
		System.out.println("userid "+ userid + " Password " + password); // ClassName@HashCode(Hexa)
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(227, 40, 198, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel Userid_lbl = new JLabel("User id");
		Userid_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Userid_lbl.setBounds(176, 126, 60, 24);
		getContentPane().add(Userid_lbl);
		
		JLabel Pwd_lbl = new JLabel("Password");
		Pwd_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Pwd_lbl.setBounds(176, 172, 87, 24);
		getContentPane().add(Pwd_lbl);
		
		useridtxt = new JTextField();
		useridtxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		useridtxt.setBounds(327, 131, 221, 19);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(327, 177, 221, 19);
		getContentPane().add(passwordField);
		
		JButton Loginbt = new JButton("Login");
		Loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		Loginbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		Loginbt.setBounds(227, 257, 92, 31);
		getContentPane().add(Loginbt);
		
		JButton Registerbt = new JButton("Register");
		Registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		Registerbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		Registerbt.setBounds(376, 257, 132, 31);
		getContentPane().add(Registerbt);
		setTitle("Login");
		setResizable(false);
		setSize(696, 377);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
