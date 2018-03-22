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
    
    <title>modifier acteur</title>

	 <layout:skin includeScript="true"/>
    
    <script>
	
	function setHidden(value){document.parametreForm.hidden.value=value;}
	
		function testactt(){

 if (parametreForm.hiddenTest.value =="no user")
		         {alert("l'utilisater n'éxiste pas ");
		          document.parametreForm.acteur.focus();
		          parametreForm.hiddenTest.value="";
		         }
		         
		        
	}
	
	function tes(){
	 return(confirm('Etes-vous sûr de vouloir supprimer cette étape ?'));return false;
		         
	}
	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
<body onload="testactt();">
  <layout:img src="../images/entete2.JPG" width="100%"/>
  <jsp:include page="menu.jsp"/> 

 <hr>

     
     
     <layout:form action="/parametre.do">
    
     <layout:text property="hiddenTest" key="" mode="H,H,H" ></layout:text>
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
  
   <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       
        <layout:panel  key="modifier un utilisateur:" width="500" styleClass="FORM">
       <center>
         
          <layout:row>
      <layout:column>      
         <layout:text property="acteur"  key="nom utilisateur:">   </layout:text>
       </layout:column>
       <layout:column>  
        <layout:submit onclick="setHidden('chercher');">chercher</layout:submit>   
        </layout:column>
         </layout:row> 
         
          <layout:row>  
          <layout:column>  
         <layout:checkbox  key="magasinier Beraki" property="magaberaki" styleClass="LABEL"/>
          
        <layout:checkbox  key="magasinier Ouad Smar" property="magasmar" styleClass="LABEL"/>
             
         <layout:checkbox  key="magasinier Reghaia" property="magaregh" styleClass="LABEL"/>
         
         <layout:checkbox  key="magasinier Blida" property="magablida" styleClass="LABEL"/>
          
          <layout:checkbox  key="magasinier Constantine" property="magaconst" styleClass="LABEL"/>
          
          <layout:checkbox  key="magasinier Oran" property="magaoran" styleClass="LABEL"/>
          
          </layout:column>
          <layout:column>
           <layout:checkbox  key="administrateur" property="admin" styleClass="LABEL"/>
            
            <layout:checkbox  key="superviseur distribution" property="superdist" styleClass="LABEL"/>
            
             <layout:checkbox  key="superviseur reporting" property="supereport" styleClass="LABEL"/>
            
             <layout:checkbox  key="superviseur prepaid" property="superpre" styleClass="LABEL"/>
            
             <layout:checkbox  key="superviseur postpaid" property="superpost" styleClass="LABEL"/>
    </layout:column>
    </layout:row> 
       <layout:row>    
           <layout:submit onclick="setHidden('modifier');">modifier</layout:submit> 
           
 <layout:submit onclick="setHidden('chercher');">annuler</layout:submit>
        </layout:row>   
          
          </center>
        </layout:panel>
</layout:column>      
</layout:row>
    </layout:form>
  </body>
</html:html>
    