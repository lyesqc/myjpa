package com.yourcompany.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
public static void main(String[] args) throws SQLException{
	
	
	
	try
    {
     Class.forName("oracle.jdbc.driver.OracleDriver");                    
           System.out.println ("driver etablie");
    }
    catch(Exception e)
    {
      System.out.println ("erreur:Driver int" +
                  "rouvable");
    }
 
    
    //connexion  la base 
    try
    
    {       
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@otadebeadev:1521:POSD","tlvdata", "tlvdata");
      System.out.println ("connexion  base pfe etablie");
      
      Statement stm;
      stm = con.createStatement();
      ResultSet res = stm.executeQuery("select * from telesales");
      int i = 1;
      String str1,str2;
      while (res.next()){
    	  //if(res.getString("secteur_activite")!=null) str2= res.getString("secteur_activite");
    	  System.out.println(res.getString("cleclient")+" "+res.getString("secteur_activite")+" "+i);
    	  i++;
    	  
    	  
      }
    }finally{
    	
    }

}
}
