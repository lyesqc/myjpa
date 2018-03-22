package com.yourcompany.struts.UtilClass;

import java.io.*;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeCHAR;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.struts.upload.FormFile;

public class Helper {

    /*
     public String lookupRangeInCoolection(long start, long end, String art,
     ArrayList coll) {

     // retour = 1 : a portion of range existe in liste

     String retour = "0";

     for (int i = 0; i < coll.size(); i++) {
     Recep recepInColl = new Recep();
     recepInColl = (Recep) coll.get(i);

     if (recepInColl.getArticle().equals(art)
     && ((end >= Double.parseDouble(recepInColl.getND()) && end <= Double
     .parseDouble(recepInColl.getNF())) || (start >= Double
     .parseDouble(recepInColl.getND()) && start <= Double
     .parseDouble(recepInColl.getNF())))) {
     retour = "1";
     break;
     }

     }

     return retour;
     }

     public String lookupRangeInDataBase(long start, long end, String art,
     Statement stm) throws SQLException {

     // retour = 2 : range n'existe pas dans la base de donne
     // retour = 3 :range existe dans la base de donne
     String req = "";
     String retour = "2";
     req = "select count(*) from gss_range r where r.rng_inactif='A' and (("
     + end + " between  r.rng_start and r.rng_end) or ( " + start
     + " between r.rng_start and r.rng_end))";
     System.out.println(req);
     ResultSet res = stm.executeQuery(req);
     if (res.next())
     if (res.getInt(1) > 0)
     retour = "3";
     return retour;
     }

     public String insertTransaction(ArrayList list, String id_frns,
     String id_act, String whs_id, String ref, String note, String po,
     Statement stm, String numLigne, String recpNu) throws SQLException {

     ResultSet res = null;
     String req = null;
     String art_id;
     int max_trans = 0, max_rng_id = 0;
     Long start, end;
     Recep recep_temp;
     boolean v = false;

     // if range doesn't existe in database
     try {
     for (int i = 0; i <= list.size() - 1; i++) {
     System.out.println(i);
     recep_temp = (Recep) list.get(i);

     if (recep_temp.getNum_ligne().equals(numLigne)) {
     start = Long.valueOf(recep_temp.getND());
     end = Long.valueOf(recep_temp.getNF());
     System.out.println("insertTransaction : " + start);
     art_id = recep_temp.getArticle();

     // 2 : means that range doesn't exist in data base

     if (this.lookupRangeInDataBase(start, end, art_id, stm)
     .equals("2")) {
     System.out.println("enter for insertTransaction :"
     + start);

     stm.getConnection().setAutoCommit(false);
     req = "select ACT_ID from gss_actor where act_name='"
     + id_act + "'";
     res = stm.executeQuery(req);
     if (res.next())
     id_act = res.getString(1);
     System.out.println(" id_act " + id_act);
     stm.clearBatch();
     req = "select w.whs_id from gss_warehouse w where w.whs_adresse='"
     + whs_id + "'";
     res = stm.executeQuery(req);
     if (res.next())
     whs_id = res.getString(1);
     System.out.println(" whs_id " + whs_id);
     stm.clearBatch();
     req = "select DEST_ID from gss_destinataire where dest_nom='"
     + id_frns + "' ";
     res = stm.executeQuery(req);
     if (res.next())
     id_frns = res.getString(1);
     System.out.println(" id_frns " + id_frns);
     stm.clearBatch();
     req = "select max(trans_no)+1 from gss_transaction  where (trans_type='REC') and (whs_id='"
     + whs_id + "')";
     res = stm.executeQuery(req);
     if (res.next())
     max_trans = res.getInt(1);
     System.out.println(" max_trans " + max_trans);
     stm.clearBatch();
     req = "insert into  gss_transaction(trans_no,trans_type,whs_id,trans_date,act_id,dest_id,trans_ext_ref,trans_notes,trans_no_po,trans_date_limite,whs_dest,approver,annuler) values('"
     + max_trans
     + "','REC','"
     + whs_id
     + "',SYSDATE,'"
     + id_act
     + "','"
     + id_frns
     + "','"
     + ref
     + "','"
     + note
     + "','"
     + po
     + "','','','','N')";
     stm.executeUpdate(req);
     stm.clearBatch();

     req = "select ART_ID from gss_article where art_art_libelle='"
     + art_id + "'";
     res = stm.executeQuery(req);
     if (res.next())
     art_id = res.getString(1);
     System.out.println(" art_id " + art_id);
     stm.clearBatch();
     req = "select max(rng_id)+1 from gss_range where ACT_ID='"
     + id_act + "'";
     res = stm.executeQuery(req);
     if (res.next())
     max_rng_id = res.getInt(1);
     System.out.println(" rng_start " + start);
     stm.clearBatch();
     req = "insert into gss_range values ('" + max_rng_id
     + "','" + id_act + "','','" + art_id + "','"
     + start + "','" + end + "','" + max_rng_id
     + "','" + id_act
     + "','A',SYSDATE,'','','BRUTE','REC','"
     + whs_id + "','" + max_trans
     + "','','','','','N','N','N','N','" + whs_id
     + "','','','','','')";
     stm.executeUpdate(req);
     stm.clearBatch();
     req = "insert into gss_transaction_range values('REC','"
     + whs_id
     + "','"
     + max_trans
     + "','"
     + max_rng_id + "','" + id_act + "',SYSDATE)";
     stm.executeUpdate(req);

     // TO BE AFTER THE PRODUCTION
     req = "update XXOTA_RECEPTION_GSS_ALL rec set rec.insertion_gss='R' where rec.NUM_RECEPTION='"
     + recpNu
     + "' and rec.LIGNE_RECPTION='"
     + numLigne + "'";
     stm.executeUpdate(req);
     v = true;

     }
     // return "Exist";
     }

     // return "REC-"+whs_id+"-"+max_trans;
     }
     stm.getConnection().commit();
     // stm.getConnection().close();
     if (v)
     return "OK";
     else
     return "Nothing";
     } catch (SQLException sqlEx) {
     sqlEx.printStackTrace();
     stm.getConnection().rollback();
     stm.getConnection().close();
     return "Exception";
     }

     }

	
     */
    public java.util.List getListAnnulTransaction(String rng_start,
            String rng_end, HttpServletRequest request) throws SQLException {

        ResultSet res = null;
        java.util.List list = new ArrayList();
        Connection con = null;
        try {

            Connexion conn = new Connexion();
            con = conn.createConnection(request);
            CallableStatement cstmt = null;

            cstmt = con.prepareCall("{? = call last_transaction_range(?,?)}");
            OracleCallableStatement oracleCallableStm = (OracleCallableStatement) cstmt;
            oracleCallableStm.registerOutParameter(1, OracleTypes.ARRAY,
                    "LIST_TRANS");
            oracleCallableStm.setString(2, rng_start);
            oracleCallableStm.setString(3, rng_end);
            oracleCallableStm.execute();
            java.sql.Array ar = oracleCallableStm.getARRAY(1);
            res = ar.getResultSet();
            while (res.next()) {
                System.out.println(decode(res.getString(2)));
                list.add(decode(res.getString(2)));
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            con.close();
        }
        return list;
    }

    public String annulTransaction(String trans, HttpServletRequest request)
            throws SQLException {

        ResultSet rs1 = null, rs2 = null;
        Connexion conn = new Connexion();
        Connection con = conn.createConnection(request);
        Statement stm3 = con.createStatement();
        String txt, txt1, txt2;
        String retun = "NO";
        if (trans != "") {
            txt = trans.substring(0, 3);
            System.out.println("txt=" + txt);
            txt1 = trans.substring(4, 7);
            System.out.println("txt1=" + txt1);
            txt2 = trans.substring(8);
            System.out.println("txt2=" + txt2);
            CallableStatement cstmt = null;
            String test;
            cstmt = con.prepareCall("{? = call last_transaction(?,?,?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            cstmt.setString(2, txt);
            cstmt.setString(3, txt1);
            cstmt.setString(4, txt2);
            cstmt.execute();
            test = cstmt.getString(1);
            if (test.equals("true")) {
                System.out.println("Last transation");
                retun = trans;
            } else {
                System.out.println("Not last Transaction");
                retun = "NO";
            }

        }
        return retun;

    }

    public static void log(Connection con, String actuer, String lmdString,
            String dbTable, HttpServletRequest request) {

        try {
            lmdString = lmdString.replace("'", "''");
            Statement stm3 = con.createStatement();
            System.out.println("insert into dblog (user_id,sqlLMD,table_name,lmdtime) values('"
                    + actuer
                    + "','"
                    + lmdString
                    + "','"
                    + dbTable
                    + "',sysdate);");
            stm3.executeUpdate("insert into dblog (user_id,sqlLMD,table_name,lmdtime) values('"
                    + actuer
                    + "','"
                    + lmdString
                    + "','"
                    + dbTable
                    + "',sysdate)");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String decode(final String hexString) {
        final int len = hexString.length();
        if (len % 2 != 0) {
            throw new RuntimeException("bad length");
        }
        final StringBuilder sb = new StringBuilder(len / 2);
        for (int i = 2; i < len; i += 2) {
            final String code = hexString.substring(i, i + 2);
            sb.append((char) Integer.parseInt(code, 16));
        }
        return sb.toString();
    }

    

}
