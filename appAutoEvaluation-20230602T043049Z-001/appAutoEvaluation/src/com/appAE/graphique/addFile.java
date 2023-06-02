package com.appAE.graphique;

import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import com.appAE.CsvToDB;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class addFile extends JFrame {

	private JPanel contentPane1;
	
	private static String csvFile;

	public static String getCsvFile() {
		return csvFile;
	}


	public static void setCsvFile(String csvFile) {
		addFile.csvFile = csvFile;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFile frameFile = new addFile();
					RefineryUtilities.centerFrameOnScreen(frameFile);
					frameFile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public addFile() {
		setTitle("Ajouter le fichier CSV");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 548);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		
		JFileChooser csvChooser = new JFileChooser();
		csvChooser.setApproveButtonText("Sélectionner");
		csvChooser.setBounds(10, 25, 596, 399);
		contentPane1.add(csvChooser);
		
		int returnVal = csvChooser.showOpenDialog(csvChooser);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    setCsvFile(csvChooser.getSelectedFile().getAbsolutePath());
		    //insert csv into db
		    CsvToDB.main(null);	    
		    System.out.println("Ajoutés !");
		    
			JPanel contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			setBounds(100, 100, 450, 300);
			setContentPane(contentPane2);
			contentPane2.setLayout(null);
			
		    JLabel lblNewLabel = new JLabel("Ajoutés");
		    lblNewLabel.setBounds(79, 99, 254, 51);
		    contentPane2.add(lblNewLabel);
		    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);

	    }
	    else {
	    	setBounds(100, 100, 450, 300);
	    	JLabel lblNewLabel = new JLabel("Vous avez annulé l'insertion");
		    lblNewLabel.setBounds(79, 99, 254, 51);
		    contentPane1.add(lblNewLabel);
		    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		    
	    }
	}
}
