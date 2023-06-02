package com.appAE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import com.appAE.graphique.mainF;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class parametres extends JFrame {

	private JPanel contentPane;
	private JTextField txtFUrl;
	private JTextField txtFLogin;
	private JTextField txtFMdp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parametres frame = new parametres();
			        RefineryUtilities.centerFrameOnScreen(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public parametres() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chemin d'accès");
		lblNewLabel.setBounds(77, 55, 112, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur");
		lblNewLabel_1.setBounds(77, 107, 112, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de Passe");
		lblNewLabel_2.setBounds(77, 159, 112, 13);
		contentPane.add(lblNewLabel_2);
		
		txtFUrl = new JTextField();
		txtFUrl.setBounds(222, 55, 96, 19);
		contentPane.add(txtFUrl);
		txtFUrl.setColumns(10);
		if (txtFUrl.getText()!= "" || txtFUrl.getText()!= null)
			mainF.setUrldb(txtFUrl.getText());
		
		txtFLogin = new JTextField();
		txtFLogin.setBounds(222, 107, 96, 19);
		contentPane.add(txtFLogin);
		txtFLogin.setColumns(10);
		if (txtFLogin.getText()!= "" || txtFLogin.getText()!= null )
			mainF.setLogindb(txtFLogin.getText());
		
		txtFMdp = new JTextField();
		txtFMdp.setBounds(222, 159, 96, 19);
		contentPane.add(txtFMdp);
		if (txtFMdp.getText()!= "" || txtFMdp.getText()!= null )
			mainF.setMdpdb(txtFMdp.getText());
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainF.main(null);
			}
		});
		btnNewButton.setBounds(77, 216, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url , log, mdp;
				
			//if (txtFUrl.getText()!= "" || txtFUrl.getText()!= null)
				url = txtFUrl.getText();
			//if (txtFLogin.getText()!= "" || txtFLogin.getText()!= null )
				log = txtFLogin.getText();
			//if (txtFMdp.getText()!= "" || txtFMdp.getText()!= null )
				mdp = txtFMdp.getText();
		 
				String linkDbStr = url + ";" + log + ";" + mdp + ";";
				
				String spath = "infosDB.txt";
				
				Path path = Paths.get(spath) ;
				
				File file = new File( spath );
				
				byte[] byteLink = linkDbStr.getBytes() ;
				
				try {
			          Files.write(path, byteLink);
			            
				} catch (IOException ex) {
			            	ex.printStackTrace();
			          }
				  
				dispose();
				mainF.main(null);
			}
		});
		btnNewButton_1.setBounds(233, 216, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
