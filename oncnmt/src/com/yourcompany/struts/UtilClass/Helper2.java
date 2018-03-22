package com.yourcompany.struts.UtilClass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.struts.upload.FormFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lyes.BENSAADA
 */
public class Helper2 {
    
    public static File convertFormFileToFile(FormFile bulkUpload) throws Exception {

        File file = null;
        byte i = 1;
        OutputStream os = null;
        try {
            file = new File(bulkUpload.getFileName());
            System.out.println("Creating File temp");
            os = new FileOutputStream(file);
            System.out.println("Creating File output temp");
            InputStream is = new BufferedInputStream(bulkUpload.getInputStream());
            System.out.println("Creating File input temp");
            int count;
            byte buf[] = new byte[4096];

            while ((count = is.read(buf)) > -1) {
                os.write(buf, 0, count);
            }
            os.close();
        } catch (Exception e) {
            System.out.println("Exception occured during file conversion");
            e.printStackTrace();
        }
        return file;
    }
    public static String checkReceptionFileFormat(File file){
        
    Workbook w;
    Cell cell, cell0 = cell = null;
    try{
    w = Workbook.getWorkbook(file);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      
      for (int i = 0; i < sheet.getRows(); i++) {
    	  cell0 = sheet.getCell(0,i);
    	  if(cell0.getContents() == null ||cell0.getContents().length()==0)
    		   return "ERROR: le nom d'article est vide  :"+0+":"+i;
          cell = sheet.getCell(1, i);
          CellType type = cell.getType();
          Long.parseLong(cell.getContents());
          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
          if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
              return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
          System.out.println("Check for "+cell.getContents().toString());
      }
    }catch(NumberFormatException e){
        //e.printStackTrace();
        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    }catch( jxl.read.biff.BiffException e ){
    	return "ERROR:Format de fichier est incompatible, elle doit etre :Modèle Excel 97-2003";
        //ex.printStackTrace();
    }    
    catch( Exception e ){
    	
        e.printStackTrace();
    }
        return "OK:File_GOOD";
    }
    public String checkIfItemsInStockForStatus(File file, Connection con,String statusToCheck ) throws SQLException{
    	
    	Workbook w;
        Cell cell = null;
    	ResultSet res;
    	Statement stm = null ;
    	
    	try{
    		stm = con.createStatement();
    		
    	    w = Workbook.getWorkbook(file);
    	      // Get the first sheet
    	      Sheet sheet = w.getSheet(0);
    	      
    	      for (int i = 0; i < sheet.getRows(); i++) {
    	          cell = sheet.getCell(0, i);
    	          CellType type = cell.getType();
    	          Long.parseLong(cell.getContents());
    	          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
    	          /*if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
    	              return "ERROR:"+cell.getContents()+" has bad format";
    	          System.out.println("Check for "+cell.getContents().toString());
    	          */
    	          if(statusToCheck !=null)
    	          res = stm.executeQuery("select count(*) from gss_range r where r.rng_start='"+cell.getContents().toString()+"' and "+statusToCheck);
    	          else 
    	        	  res = stm.executeQuery("select count(*) from gss_range r where r.rng_start='"+cell.getContents().toString());
    	        	  //
    	          if(res.next() && res.getInt(1)<1) return "ERROR:"+cell.getContents()+" n est pas autorisé pour cette transaction ";
    	          
    	      }
    	      //con.commit();
    	    }catch(NumberFormatException e){
    	        //e.printStackTrace();
    	        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    	    }catch( Exception ex){
    	        ex.printStackTrace();
    	    }
    	finally{
    	   con.rollback();
    	}
    	
    	return "OK:0";
    	
    	
    }
    
    
 public String checkIfItemsInStockForStatus(File file, Connection con,String statusToCheck, boolean checkArticleInFile ) throws SQLException{
    	
    	Workbook w;
        Cell cell, cell0 = cell = null;
    	ResultSet res;
    	Statement stm = null ;
    	
    	try{
    		stm = con.createStatement();
    		
    	    w = Workbook.getWorkbook(file);
    	      // Get the first sheet
    	      Sheet sheet = w.getSheet(0);
    	      
    	      for (int i = 0; i < sheet.getRows(); i++) {
    	          cell = sheet.getCell(1, i);
    	          cell0 = sheet.getCell(0, i);
    	          CellType type = cell.getType();
    	          Long.parseLong(cell.getContents());
    	          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
    	          /*if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
    	              return "ERROR:"+cell.getContents()+" has bad format";
    	          System.out.println("Check for "+cell.getContents().toString());
    	          */
    	          if(statusToCheck !=null)
    	          res = stm.executeQuery("select count(*) from gss_range r, gss_article ar where r.rng_start='"+cell.getContents().toString()+"' and ar.art_id = r.art_id and lower(ar.art_art_libelle)=lower('"+cell0.getContents()+"')  and "+statusToCheck);
    	          else 
    	        	  res = stm.executeQuery("select count(*) from gss_range r, gss_article ar where   ar.art_id = r.art_id and lower(ar.art_art_libelle)=lower('"+cell0.getContents()+"') and r.rng_start='"+cell.getContents().toString());
    	        	  //
    	          if(res.next() && res.getInt(1)<1) return "ERROR:"+cell.getContents()+" n est pas autorisé pour cette transaction ";
    	          
    	      }
    	      //con.commit();
    	    }catch(NumberFormatException e){
    	        //e.printStackTrace();
    	        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    	    }catch( Exception ex){
    	        ex.printStackTrace();
    	    }
    	finally{
    	   con.rollback();
    	}
    	
    	return "OK:0";
    	
    	
    }
    
    
    public String updateItemsStatus(File file, Connection con, String statusToPut, String trans_type, String trans_no, String whs_id, String actorId){
    	
    	
    	Workbook w;
        Cell cell = null;
    	ResultSet res;
    	Statement stm = null ;
    	Statement stm2 = null;
    	
    	try{
    		stm = con.createStatement();
    		con.setAutoCommit(false);
    		
    	    w = Workbook.getWorkbook(file);
    	      // Get the first sheet
    	      Sheet sheet = w.getSheet(0);
    	      
    	      for (int i = 0; i < sheet.getRows(); i++) {
    	          cell = sheet.getCell(0, i);
    	          CellType type = cell.getType();
    	          Long.parseLong(cell.getContents());
    	          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
    	          /*if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
    	              return "ERROR:"+cell.getContents()+" has bad format";
    	          System.out.println("Check for "+cell.getContents().toString());
    	          */
    	          //stm.
    	          res = stm.executeQuery("select * from gss_range r where r.rng_start='"+cell.getContents().toString()+"' and r.rng_whs ='"+whs_id+"'");
    	          if( !res.next())
    	          {
    	        	  System.out.println("le EMEI can not be update because it is not in warehouse "+cell.getContents().toString());
    	        	  con.rollback();
    	        	  return "ERROR:"+cell.getContents().toString()+" n'existe pas dans le magasin";
    	          }
    	          res = stm.executeQuery("update gss_range r  set "+statusToPut+" where r.rng_start='"+cell.getContents().toString()+"' and r.rng_whs ='"+whs_id+"'");
    	          
    	          if(trans_type !=null)
    	          stm.executeUpdate("insert into gss_transaction_range values('"+trans_type+"','"+whs_id+"','"+trans_no+"','"+cell.getContents().toString()+"',(select act_id from gss_actor   where act_name='"+actorId+"'),SYSDATE,'"+i+"')");
    	        	  //
    	          //if(res.getInt(1)>0) return "ERROR:"+cell.getContents()+" n est pas autorisé a sortir ";
    	          con.commit();
    	      }
    	      
    	    }catch(NumberFormatException e){
    	        e.printStackTrace();
    	        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    	    }catch( Exception ex){
    	        ex.printStackTrace();
    	    }
    	finally{
    	   //con.rollback();
    	}
    	
    	return "OK:0";
    	
    }
    
    
public String updateItemsStatus(File file, Connection con, String statusToPut, String trans_type, String trans_no, String whs_id, String actorId, boolean checkArticleInFile){
    	
    	
    	Workbook w;
        Cell cell = null;
    	ResultSet res;
    	Statement stm = null ;
    	Statement stm2 = null;
    	
    	try{
    		stm = con.createStatement();
    		con.setAutoCommit(false);
    	    w = Workbook.getWorkbook(file);
    	      // Get the first sheet
    	      Sheet sheet = w.getSheet(0);
    	      
    	      for (int i = 0; i < sheet.getRows(); i++) {
    	          cell = sheet.getCell(1, i);
    	          CellType type = cell.getType();
    	          Long.parseLong(cell.getContents());
    	          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
    	          /*if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
    	              return "ERROR:"+cell.getContents()+" has bad format";
    	          System.out.println("Check for "+cell.getContents().toString());
    	          */
    	          //stm.
    	          System.out.println("select * from gss_range r where r.rng_start='"+cell.getContents().toString()+"' and r.rng_whs ='"+whs_id+"'");
    	          res = stm.executeQuery("select * from gss_range r where r.rng_start='"+cell.getContents().toString()+"' and r.rng_whs ='"+whs_id+"'");
    	          if( !res.next())
    	          {
    	        	  System.out.println("le IMEI can not be update because it is not in warehouse "+cell.getContents().toString());
    	        	  con.rollback();
    	        	  return "ERROR:"+cell.getContents().toString()+" n'existe pas dans le magasin";
    	          }
    	          res = stm.executeQuery("update gss_range r  set "+statusToPut+" where r.rng_start='"+cell.getContents().toString()+"' and r.rng_whs ='"+whs_id+"'");
    	          
    	          if(trans_type !=null)
    	          stm.executeUpdate("insert into gss_transaction_range values('"+trans_type+"','"+whs_id+"','"+trans_no+"','"+cell.getContents().toString()+"',(select act_id from gss_actor   where act_name='"+actorId+"'),SYSDATE,'"+i+"')");
    	        	  //
    	          //if(res.getInt(1)>0) return "ERROR:"+cell.getContents()+" n est pas autorisé a sortir ";
    	          con.commit();
    	      }
    	      
    	    }catch(NumberFormatException e){
    	        e.printStackTrace();
    	        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    	    }catch( Exception ex){
    	        ex.printStackTrace();
    	    }
    	finally{
    	   //con.rollback();
    	}
    	
    	return "OK:0";
    	
    }
    
    public static String checkSerialsExistInDb(File file, Connection con) throws SQLException{
    	Workbook w;
        Cell cell, cell0 = cell = null;
    	ResultSet res;
    	Statement stm = null ;
    	String artName ="";
    	
    	try{
    		stm = con.createStatement();
    		
    	    w = Workbook.getWorkbook(file);
    	      // Get the first sheet
    	      Sheet sheet = w.getSheet(0);
    	      
    	      for (int i = 0; i < sheet.getRows(); i++) {
    	          cell0 = sheet.getCell(0, i);
    	          cell = sheet.getCell(1, i);
    	          artName = cell0.getContents();
    	          res =stm.executeQuery("select count(*) from gss_article ar where lower(ar.art_art_libelle) = lower('"+artName+"') and ar.art_status='A'");
    	          if(!res.next() || res.getInt(1)<1) return "ERROR:le nom article n'existe pas pour item:"+cell.getContents();
    	          
    	          CellType type = cell.getType();
    	          Long.parseLong(cell.getContents());
    	          System.out.println(cell.getContents().toString() + " : "+cell.getContents().toString().length());
    	          /*if(cell.getContents().toString().length() == 0 || cell.getContents().toString().length()> 15)
    	              return "ERROR:"+cell.getContents()+" has bad format";
    	          System.out.println("Check for "+cell.getContents().toString());
    	          */
    	          res = stm.executeQuery("select count(*) from gss_range r where r.rng_start='"+cell.getContents().toString()+"'");
    	          if(res.next() && res.getInt(1)>0) return "ERROR:"+cell.getContents()+" déja receptionné";
    	          
    	      }
    	      //con.commit();
    	    }catch(NumberFormatException e){
    	        //e.printStackTrace();
    	        return "ERROR:"+cell.getContents()+" a un mauvais numéro IMEI";
    	    }catch( Exception ex){
    	        ex.printStackTrace();
    	    }
    	finally{
    	   con.rollback();
    	}
    	
    	return "OK:0";
    }
    public static String newTransaction(String transtype, String whh, Connection con, String note, String actor, String destId, String doc){
    	
    	ResultSet rs6 = null;
    	Statement st6 = null;
    	int max = 0;
    	try{
    		st6 = con.createStatement();
    		
    		System.out.println("select nvl(max(trans_no),1) from gss_transaction  where (trans_type='"+transtype+"') and (whs_id='"+whh+"')");
    		   
    		rs6=st6.executeQuery("select nvl(max(trans_no),1) from gss_transaction  where (trans_type='"+transtype+"') and (whs_id='"+whh+"')");
    	   	  while (rs6.next()){
    	   	  max = rs6.getInt(1)+1;
    	   	if(destId.startsWith("W"))
    	   	st6.executeUpdate("insert into gss_transaction values ('"+max+"','"+transtype+"','"+whh+"',SYSDATE,(select act_id from gss_actor2 d where d.act_name='"+actor+"'),'','"+doc+"','"+note+"','','','"+destId+"','','N')");
    	   	else 
    	   		st6.executeUpdate("insert into gss_transaction values ('"+max+"','"+transtype+"','"+whh+"',SYSDATE,(select act_id from gss_actor2 d where d.act_name='"+actor+"'),'"+destId+"','"+doc+"','"+note+"','','','','','N')");
    	   	  }
    	   	  /*int res =Integer.parseInt(max);
    	   	   res=res+1;
    	   	  max = Integer.toString(res);
    	   	  */
    	   	  System.out.println("********* le max :"+max);
    	   	  }

    	   	  catch (Exception e){
    	   		max = -100000;
    	   		System.out.println("Exception in newTransaction");
    	   		  e.printStackTrace();
    	   	         
    	   	         //System.out.println("rs est null"); 
    	   	        }
    	return String.valueOf(max);
    	
    }
    
    public String insertNewItem(FormFile file, Connection con, String actor, String idArt, String whr, String trans_num){
    	Statement stm;
    	ResultSet res;
    	Workbook w;
    	String item = "";
        Cell cell, cell0 = cell = null;
    	try{
    		stm = con.createStatement();
    		File file1 = Helper2.convertFormFileToFile(file);
    		w = Workbook.getWorkbook(file1);
  	      // Get the first sheet
  	      Sheet sheet = w.getSheet(0);
  	      int j = 0;
  	      for (int i = 0; i < sheet.getRows(); i++) {
  	          cell = sheet.getCell(1, i);
  	          cell0 = sheet.getCell(0,i);
  	          item = cell.getContents();
  	          stm.executeUpdate("insert into gss_range values ('"+item+"',(select ac.act_id from gss_actor ac where ac.act_name='"+actor+"'),'',(select ar.art_id from gss_article ar where lower(ar.art_art_libelle) = lower('"+cell0.getContents()+"') and ar.art_status='A'),'"+item+"','"+item+"','','','A',SYSDATE,'','','BRUTE','REC','"+whr+"','"+trans_num+"','','','','','N','N','N','N','"+whr+"','','','','','')");
  	          stm.executeUpdate("insert into gss_transaction_range values('REC','"+whr+"','"+trans_num+"','"+item+"',(select ac.act_id from gss_actor ac where ac.act_name='"+actor+"'),SYSDATE,'"+j+"')");
  	          j++;
  	      }
    		
  	      con.commit();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	return "";
    }
    
}
