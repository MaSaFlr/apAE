package com.appAE.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chooseCsv extends JFrame {

	private JPanel contentPane;
	private static String idRole;
	private static String nomRole;

	public static String getIdRole() {
		return idRole;
	}

	public static void setIdRole(String idRole) {
		chooseCsv.idRole = idRole;
	}
	
	public static String getNomRole() {
		return nomRole;
	}

	public static void setNomRole(String nomRole) {
		chooseCsv.nomRole = nomRole;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					chooseCsv frame = new chooseCsv();
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
	public chooseCsv() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnseignants = new JButton("Enseignants");
		btnEnseignants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("Enseignants");
				setIdRole("01");
				
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
					
			}
		});
		btnEnseignants.setBounds(61, 69, 107, 21);
		contentPane.add(btnEnseignants);
		
		JButton btnNonEnseignants = new JButton("Non Enseignants");
		btnNonEnseignants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("NonEnseignants");
				setIdRole("02");
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
			}
		});
		btnNonEnseignants.setBounds(263, 69, 107, 21);
		contentPane.add(btnNonEnseignants);
		
		JButton btnParents = new JButton("Parents");
		btnParents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("Parents");
				setIdRole("03");
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
			}
		});
		btnParents.setBounds(61, 130, 107, 21);
		contentPane.add(btnParents);
		
		JButton btnVieScolaire = new JButton("Vie Scolaire");
		btnVieScolaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("VieScolaire");
				setIdRole("05");
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
			}
		});
		btnVieScolaire.setBounds(61, 194, 107, 21);
		contentPane.add(btnVieScolaire);
		
		JButton btnExterne = new JButton("Partenaires Exterieurs");
		btnExterne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("PExterieurs");
				setIdRole("06");
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
			}
		});
		btnExterne.setBounds(263, 194, 107, 21);
		contentPane.add(btnExterne);
		
		JButton btnEleves = new JButton("Elèves");
		btnEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNomRole("Eleves");
				setIdRole("04");
				if ( mainF.getActionfirst() == 1 )
					addFile.main(null);
				
				else {
					if ( mainF.getActionfirst() == 2)
						createCharts.main(null);
					
					else 
						delete.main(null);
				}
			}
		});
		btnEleves.setBounds(263, 130, 107, 21);
		contentPane.add(btnEleves);
	}



	
}
