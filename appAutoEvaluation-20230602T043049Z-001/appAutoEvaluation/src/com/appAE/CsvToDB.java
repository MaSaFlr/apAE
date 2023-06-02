package com.appAE;


import java.io.*;

import java.sql.*;

import com.appAE.graphique.addFile;
import com.appAE.graphique.chooseCsv;
import com.appAE.graphique.mainF;

public class CsvToDB {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
	        
	        //csv file
	        String csvFilePath = addFile.getCsvFile() ;
	        
	        Connection connection = null;
 
            connection = DriverManager.getConnection(mainF.getUrldb(), mainF.getLogindb(), mainF.getMdpdb());
                        
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            
            
            ///////////////////////////////////////////////////header/////////////////////////////////////////////////////
            
            Statement stmtAIQ = connection.createStatement();
            Statement stmtAIR = connection.createStatement();
            stmtAIQ.execute("ALTER TABLE question AUTO_INCREMENT=0;");
            stmtAIR.execute("ALTER TABLE reponse AUTO_INCREMENT=0;");
            
            lineText = lineReader.readLine(); 
            String[] headercsv = lineText.split(";");
            String sqlHeader = "INSERT INTO question (idRole, codeq, libelle) VALUES ('" + chooseCsv.getIdRole() + "',? , ?);" ;
            int counter = 1;
            
            for ( String question : headercsv ) {
            	PreparedStatement statementHeader = connection.prepareStatement(sqlHeader);
               	statementHeader.setInt(1, counter);
               	statementHeader.setString(2, question);
            	statementHeader.execute();
            	counter += 1;
            
            }
            
            ///////////////////////////////////////////////////answers//////////////////////////////////////////////////
            
            String sql = "INSERT INTO reponse (idrole, codeq, libelle) VALUES ('" + chooseCsv.getIdRole() + "', ?, ?); ";
            int count;
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            //read line by line 
            while ((lineText = lineReader.readLine()) != null) {
            	
            	String[] line = lineText.split(";");
            	
            	count = 1;            	
            	
            	for ( String answer1 : line ) {
            		
            		//System.out.println(count); //146
            		
            		String[] reponse = answer1.split("\\|");
            		
            		for (String answer : reponse ) {
            		
	                	if ( answer == "" )
	                		answer = "Pas de réponse";
	                	else {
	                		if ( answer.contains("\"")){
	                			answer = answer.replace("\"", "");
		                	}
	                	}
	                	statement.setString(2, answer);	                		
	                	statement.setInt(1, count);
	                	statement.execute();
            		}
            		
            		count = count + 1;
                }
            }
 
            lineReader.close();
 
            connection.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
    }

}
