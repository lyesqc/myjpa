
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
    
    <title>approbation</title>

	 <layout:skin includeScript="true"/>
	  <script>  
 function desactiverapprob()  
 {
var privileg='<%=(String)request.getSession().getAttribute("profilvalidation")%>';   
if  (privileg=="VALIDATION")
 {
document.approbationForm.montantcheque.disabled=true;   
document.approbationForm.cheque.disabled=true; 
document.approbationForm.codreserv.disabled=true;            
 }
			
 }



 function confirmer_valider ()
 {
 	if (confirm("Etes-vous sûr de vouloir valider cette transaction? ")) {      
   setHidden('valider_app_trans',document.approbationForm);
   approbationForm.submit();
 }
 }

 function confirmer_refuser ()
 {
 	if (confirm("Etes-vous sûr de vouloir Rejeter cette transaction?")) {      
   setHidden('Refuser_app_trans',document.approbationForm);
   approbationForm.submit();
 }
 }
 
 
   </script>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="desactiverapprob();">
   
<jsp:include page="menu.jsp"/>  
 <hr>
 
  
 
  
     <layout:form action="/approbation.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
     <layout:row>
 <layout:column width="300">  </layout:column> 
     <layout:column>
     
      <h3>
     APPROBATION DES TRANSACTIONS
      </h3>
     
      </layout:column>

      </layout:row>
 <layout:row>
 <layout:column width="200">  </layout:column> 
 <layout:column> <layout:button   onclick="confirmer_valider();">Valider la transaction</layout:button></layout:column>
 <layout:column width="100"></layout:column> 

 <layout:column> <layout:button  onclick="confirmer_refuser();">Rejeter la transaction</layout:button></layout:column>
 <layout:column width="100"></layout:column>  
                      
      </layout:row> 
    <layout:space></layout:space>


     <layout:row> 
 <layout:column width="180">  </layout:column> 

<layout:column>  
    <layout:panel key="Informations approbation:" styleClass="FORM" width="250">   
        <layout:row>

 
  <layout:column>
       <layout:text property="codaprob" key=" Transaction n°:" mode="R,R,R"> </layout:text>
     </layout:column>
 
 <layout:column>
  <layout:text property="distination" key="Destination:" mode="R,R,R" ></layout:text>
 </layout:column>
  </layout:row> 
  <layout:row> 



 <layout:column>
  <layout:text property="note" key="Note de validation ou de refus:" size="50"></layout:text>
 </layout:column>
  
  </layout:row> 
     
       </layout:panel > 
</layout:column> 

     </layout:row> 
 </center>
       <layout:space></layout:space>
         <layout:space></layout:space>
     
  <layout:cell>
<div style="position:absolute;left:100px;width:820; height:250;overflow-y:scroll;">   
      
           <layout:collection name="approbationForm" property="resulrang"  indexId="index" styleClass="SCROLL" styleClass="FORM" width="800">
            <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
          <layout:collectionItem title="PROMOTIOPN" property="magasin"></layout:collectionItem>
    <layout:collectionItem title="N° SERIE DEBUT" property="start" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="N°SERIE FIN" property="end" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="PACKAGING" property="packag" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="ACTIVE" property="active" sortable="true"></layout:collectionItem>
<layout:collectionItem title="QUANTITE" property="qte" sortable="true"></layout:collectionItem>


	



        </layout:collection>
  </div>
  </layout:cell>   
        
        <layout:space></layout:space>
         <layout:space></layout:space>
          <layout:space></layout:space>
           <layout:space></layout:space>
        
    
  
     
             
      </layout:form>
     
  </body>
</html:html>
	