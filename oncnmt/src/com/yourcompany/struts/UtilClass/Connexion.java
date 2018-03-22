package com.yourcompany.struts.UtilClass;



import java.io.*; 

//import java.util.jar.*;
//import java.util.zip.*;


import java.sql.Connection;
import java.sql.DriverManager;





import javax.servlet.http.HttpServletRequest;


import java.util.Properties;


public class Connexion {
	
	
	public static  Connection createConnection(HttpServletRequest request)  {
	    // Utilise DRIVER et DBURL pour créer une connexion
	    // Il est recommandé d’utiliser un pool de connexion
		
		Connection con = null;
	
		   BufferedReader lecteurAvecBuffer = null;
		    String ligne;
		 
 
			
		    File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
			
			  
		File jasperFile=new File(projectRealPath,"config/param.conf");
		System.out.println(jasperFile.getAbsolutePath());

		
		
		Properties prop = new Properties();
	
		FileInputStream in = null;
		try {
			in = new FileInputStream(jasperFile);
		} catch (FileNotFoundException e1) {

    	e1.printStackTrace();
		}
		try {
			prop.load(in);
			in.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		// Extraction des propriétés
		 String URL = prop.getProperty("url");
		 String USER =prop.getProperty("user");
	     String PASSWD =prop.getProperty("password");
		



	     //connexion à la base 

	     
	
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
 
    
    //connexion à la base 
    try
    
    { 	
        con =DriverManager.getConnection(URL,USER, PASSWD);
    	System.out.println ("connexion  base pfe etablie");
    	
    }


    catch(Exception e)
    
      {
       e.printStackTrace();
  
     }
   
/*    
    String URL = "jdbc:oracle:thin:@puma:1521:POS";
	String USER = "gss2app"; 
	String PASSWD = "gss2app"; */
    
    return con;
}
}

