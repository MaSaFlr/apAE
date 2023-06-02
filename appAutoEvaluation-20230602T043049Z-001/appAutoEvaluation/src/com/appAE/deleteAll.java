package com.appAE;


import java.io.*;
import java.sql.*;

import com.appAE.graphique.addFile;
import com.appAE.graphique.mainF;

public class deleteAll {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
        Connection connection = null;
 
        try {
 
            connection = DriverManager.getConnection(mainF.getUrldb(), mainF.getLogindb(), mainF.getMdpdb());
            
            Statement statementA = connection.createStatement();
            statementA.executeUpdate("Delete from reponse;");
            Statement statementQ = connection.createStatement();
            statementQ.executeUpdate("Delete from question;");
            
            connection.close();
            
            System.out.println("Questions et réponses effacées !");
 
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }

}
