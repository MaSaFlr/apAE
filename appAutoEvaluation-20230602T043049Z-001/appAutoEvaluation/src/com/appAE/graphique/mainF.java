package com.appAE.graphique;

import java.awt.EventQueue;

import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RefineryUtilities;

import com.appAE.deleteAll;
import com.appAE.parametres;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class mainF extends JFrame {

	private JPanel contentPane;
	private static int actionfirst ;
	private static String urldb ;
	private static String logindb ;
	private static String mdpdb ;

	public static int getActionfirst() {
		return actionfirst;
	}

	public static void setActionfirst(int actionfirst) {
		mainF.actionfirst = actionfirst;
	}
	

	public static String getUrldb() {
		return urldb;
	}

	public static void setUrldb(String urldb) {
		mainF.urldb = urldb;
	}


	public static String getLogindb() {
		return logindb;
	}

	public static void setLogindb(String logindb) {
		mainF.logindb = logindb;
	}


	public static String getMdpdb() {
		return mdpdb;
	}

	public static void setMdpdb(String mdpdb) {
		mainF.mdpdb = mdpdb;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
//						if ( getUrldb() == null || getLogindb() == null || getMdpdb() == null || getUrldb() == "" || getLogindb() == "" || getMdpdb() == "" ) 
//						{
//							urldb = "jdbc:mysql://192.168.220.58:3306/dbae" ;
//							logindb = "dbae" ;
//							mdpdb = "kU85Ee" ;
			//			}
						
						Scanner read;
						
						try {
						   String path = "infosDB.txt" ;
							
						   read = new Scanner (new File(path));
						
						   read.useDelimiter(";");
						   
						   while(read.hasNext())
						   {
						       mainF.setUrldb(read.next());
						       mainF.setLogindb(read.next());
						       mainF.setMdpdb(read.next());
						   }
						   read.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						final mainF frame = new mainF();
				        RefineryUtilities.centerFrameOnScreen(frame);
				        frame.setVisible(true);
				        
				       				     
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
//			
		});
	}

	/**
	 * Create the frame.
	 */
	public mainF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton emptying = new JButton("Vider la base de données");
		emptying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainF.setActionfirst(3);
				delete.main(null);
			}
		});
		emptying.setBounds(119, 168, 191, 30);
		contentPane.add(emptying);
		
		JButton charting = new JButton("Créer un graphique");
		charting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainF.setActionfirst(2);
				chooseCsv.main(null);
			}
		});
		charting.setBounds(119, 115, 191, 30);
		contentPane.add(charting);
		
		JButton insert = new JButton("Insérer un .csv");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainF.setActionfirst(1);
				chooseCsv.main(null);			
			}
		});
		insert.setBounds(119, 58, 191, 30);
		contentPane.add(insert);
		
		JButton btnNewButton = new JButton("Paramètres");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				parametres.main(null);
			}
		});
		btnNewButton.setBounds(10, 10, 113, 21);
		contentPane.add(btnNewButton);
	}
}
