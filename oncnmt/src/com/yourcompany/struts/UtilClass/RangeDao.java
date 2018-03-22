package com.yourcompany.struts.UtilClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RangeDao {
	
	public void getConnectionMe() throws ClassNotFoundException, SQLException{
	
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@CLUSPOSA:1507:POS11","gss2data","data2gss");
	 Statement stm1 = con.createStatement();
	 Statement stm2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 String trans_typ = null, trans_no = null,  whs_id = null;
	 ResultSet res2 = null;
	 ResultSet res1 = stm1.executeQuery("select * from gss_range r where r.rng_inactif='A' ");
	 try{
		 int i = 0;
	 while(res1.next()){
		 System.out.println(i);
		 i++;
		 res2 = stm2.executeQuery("select tr.t_r_trans_type,tr.t_r_trans_whs,tr.t_r_trans_no, tr.t_r_date from gss_transaction_range tr where tr.t_r_rng_id='"+res1.getString(1)+"' and tr.t_r_rng_act_id='"+res1.getString(2)+"' order by tr.t_r_date asc");
		 //res2.setFetchDirection( ResultSet.FETCH_REVERSE);
		 res2.afterLast(); 
		 //
		 if(res2.previous()) {trans_typ = res2.getString(1);whs_id = res2.getString(2); trans_no = res2.getString(3);} ;
	    	 if(trans_typ.equals("SOR") && !res1.getString("RNG_SORTIE").equals("S")) System.out.println("id : "+res1.getString(1)+":"+res1.getString(2)+", TR :"+trans_typ+"-"+whs_id+"-"+trans_no);
	     }
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
	 
	 System.out.println("end");
	 
	}
	 public static void main (String[] args) throws ClassNotFoundException, SQLException{
		 RangeDao dao = new RangeDao();
		 dao.getConnectionMe();
	 }

}
