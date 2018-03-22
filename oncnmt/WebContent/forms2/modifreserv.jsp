<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Réservation</title>
 <layout:skin includeScript="true"/>
 
     <script>
	
	var m="scratch";  
    function tester() {
    if (document.reservationForm.article.value =="SCRATCH DJEZ 3000DA"){
    document.reservationForm.prof.disabled=true;
    document.reservationForm.test.value=m;
 }
}

 function updatedatagrid() {

      setHidden('update',document.reservationForm);
    document.reservationForm.submit();
 
}

 function recuperdonne(par1) {
document.reservationForm.note.value=par1;	 
alert(par1);
}




  </script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="reserv(document.reservationForm);test(document.getElementById('div1'));">
  
 <jsp:include page="menu.jsp"/> 
 <hr>
 
  
     <layout:form action="/listreserv.do" method="post" styleClass="PANEL">
      
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest"  mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest2"  mode="H,H,H"></layout:text>
 
     <layout:row>
     
      <layout:column> 
      <center>
      <h3>
      RESERVATION
      </h3>
       </center>
      </layout:column>
      
      <layout:column>
       <layout:text property="trans" key="Réservation n°:" mode="R,R,R">
      </layout:text>
      </layout:column>
      
       <layout:column>
  <layout:text property="destinataire" key="distributeur:" mode="R,R,R"></layout:text>
 </layout:column>
      
      </layout:row>
      
         <layout:row width="800">
             <layout:column width="100" ></layout:column>
             <layout:column></layout:column>
              <layout:column width="200">
                <layout:submit onclick="setHidden('modifier',document.reservationForm);">Enregistrer les modifications</layout:submit>
              </layout:column>
              <layout:column></layout:column>
              <layout:column width="200">
               <layout:submit onclick="setHidden('annuler',document.reservationForm);">Annuler la réservation</layout:submit>
              </layout:column>
             </layout:row>
          
        
       <layout:cell>
     
<div id="div1"  style="position:absolute;left:10px;width:720; height:200; overflow:auto ;">  
  
           <layout:collection name="reservationForm" property="reserv"  styleClass="SCROLL" styleClass="FORM" width="700">
           <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
         <layout:collectionItem title="ARTICLE" property="art" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="PROFIL" property="prof" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="activation" property="activ" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="packaging" property="pack" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>         
        
  <layout:collectionItem title="+" property="ajouter"  action="/listreserv.do?hidden=afficher" paramId="article,qute,whss,hllr,pqq,prff" paramProperty="article,qute,whss,hllr,pqq,prff">
   <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center>   
           </layout:collectionItem> 
            </layout:collection>
     </div>
     </layout:cell> 

      <layout:cell>
<div style="position:absolute;left:10px;top:400px;width:570;overflow-y:scroll;height:160; border:solid 1px red;">   
     
  <layout:write   name="reservationForm"  property="writ1"  ></layout:write>
    
       <layout:collection name="reservationForm" property="reserv2" indexId="index" styleClass="SCROLL" styleClass="FORM" width="550" >
            <layout:collectionItem title="WAREHOUSE" property="wh" sortable="true"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="aa" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="pp" sortable="true"></layout:collectionItem>  
            
              <layout:collectionItem title="QTE ">
              <layout:text property="reserv2[${index}].qt" layout="false"/>
           </layout:collectionItem>
<layout:collectionItem title="X" property="retirer"   action="/listreserv.do?hidden=Retirer" paramId="aaa,qtt,whs,ppp,hllr2,pqq2" paramProperty="aaa,qtt,whs,ppp,hllr2,pqq2">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
        </layout:collectionItem>
    </layout:collection>
         
       
 </div>
 </layout:cell>        
        
          
           
  <layout:cell>
<div style="position:absolute;left:620px;top:400px;width:250;height:140; border:solid 1px red;">             
<layout:row>
           <layout:column>
         
          <layout:textarea property="note" key="Note :"></layout:textarea>
          <layout:space></layout:space>
           
           </layout:column>
           
           </layout:row>
 </div>
 </layout:cell>           
      </layout:form>
     
  </body>
</html:html>
