package com.appAE.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import com.appAE.deleteAll;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tout a été effacé de la base de données");
		lblNewLabel.setBounds(114, 70, 254, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour à l'accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainF.main(null);
				
			}
		});
		btnNewButton.setBounds(151, 145, 135, 27);
		contentPane.add(btnNewButton);
		
		deleteAll.main(null);
	}
}
