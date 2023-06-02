package com.appAE;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*; 

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Log;

import com.appAE.graphique.chooseCsv;
import com.appAE.graphique.mainF;
import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.Rectangle2D.Double;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class dbToCharts {
	static DefaultPieDataset dataset = new DefaultPieDataset( );
	//static DefaultCategoryDataset dtaset = new DefaultCategoryDataset();
	
    public static DefaultPieDataset getDataset() {
		return dataset;
	}

	public static void setDataset(DefaultPieDataset dataset) {
		dbToCharts.dataset = dataset;
	}

	public static Integer getSeries1() {
		return series1;
	}

	public static void setSeries1(Integer series1) {
		dbToCharts.series1 = series1;
	}

	public static Integer getCategory1() {
		return category1;
	}

	public static void setCategory1(Integer category1) {
		dbToCharts.category1 = category1;
	}

	static Integer series1 = 0;
    static Integer category1 = 0;
    
    
      
   public static void main( String[ ] args )throws Exception {
      
    
      
      /* Create MySQL Database Connection */
      
      Connection connect = DriverManager.getConnection( mainF.getUrldb(), mainF.getLogindb(), mainF.getMdpdb());
      
      String sqlQuestions = "SELECT count(libelle) as nbq from question where idrole = " + chooseCsv.getIdRole() + " ;";
      Statement statementQuestions = connect.createStatement();
      ResultSet resultSetQuestions = statementQuestions.executeQuery(sqlQuestions);
      resultSetQuestions.next();
      Integer nbq = Integer.parseInt(resultSetQuestions.getString("nbq"));
      
      int i;
      
      for (i = 3; i <= nbq ; i++) {
	    	   
    	  //Construire dataset
	      String sql = "SELECT libelle, count(libelle) AS Compte from reponse WHERE idrole = " + chooseCsv.getIdRole() + " AND codeq = " + i + " GROUP by LIBELLE";
	      Statement statement = connect.createStatement();
	      ResultSet resultSet = statement.executeQuery(sql);
	      dataset.clear();
	      
	      while( resultSet.next( ) ) {
    	 
	    	  dataset.setValue( 
	    			  resultSet.getString( "libelle" ),
	    			  resultSet.getInt( "compte" ));
	      }
	      
	      //titre 
	      String sqltitle = "SELECT libelle from question where idrole = " + chooseCsv.getIdRole() + " AND codeq = " + i + " ";
	      Statement statementTitle = connect.createStatement();
	      ResultSet resultSetTitle = statementTitle.executeQuery(sqltitle);
	      resultSetTitle.next();
	      String title = resultSetTitle.getString("libelle");
	      
	      JFreeChart chart = null;
	      
	      //Construire chart
    	  chart = ChartFactory.createPieChart(
	         title,   // chart title           
	         dataset,          // data           
	         false,             // include legend          
	         true,           
	         false );
    	  
    	 ((PiePlot) chart.getPlot()).setLabelGenerator(null);
         PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");
         final PiePlot plot1 = (PiePlot) chart.getPlot();
         plot1.setLabelGenerator(labelGenerator);
         plot1.setSectionPaint("Oui", Color.green);
         plot1.setSectionPaint("Positif", Color.green);
         
         plot1.setSectionPaint("Non", Color.red);
         plot1.setSectionPaint("Négatif", Color.red);
         
         plot1.setSectionPaint("Pas de réponse", Color.gray);
         
         plot1.setSectionPaint("Neutre", Color.white);
         plot1.setSectionPaint("Sans objet", Color.white);
         
         int nbtitle = i -2;
         
         String path = File.separator + "AppAE" + File.separator + "Reponses_Questionnaire_Diagrammes" + File.separator + chooseCsv.getNomRole() + File.separator +  chooseCsv.getNomRole() + "_" + nbtitle + ".jpeg";
         
	     int width = 560;    /* Width of the image */
	     int height = 370;   /* Height of the image */ 
	     File f = new File(path);
	     f.getParentFile().mkdirs();
	     f.createNewFile();
	     ChartUtilities.saveChartAsJPEG( f , chart , width , height );
	     
      }
      
      
   }
      
      
      
   }


