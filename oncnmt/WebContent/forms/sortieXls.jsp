<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>

<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>

<%@ page import="org.apache.struts.action.ActionForm"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>SORTIE</title>
 <layout:skin includeScript="true"/>
 
   <script>
   




</script>	
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  <body >
  


<jsp:include page="menu.jsp"/>  

 <hr>
 
 <layout:form action="/sortie.do" method="post" onsubmit="return false;"  enctype="multipart/form-data" >
    
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
      <layout:text property="hiddenTest"  mode="H,H,H"></layout:text>
            <layout:row>
        <layout:column>      
              <layout:button onclick="activsubmit(document.sortiForm,'annuler');">Annuler</layout:button>
            </layout:column>
              <layout:column>
                  <layout:button onclick="activsubmit(document.sortiForm,'valider');">Valider</layout:button>
            </layout:column>
           
            
            <layout:column width="70">
            </layout:column> 
            
      <layout:column>  
      <h3 >
     SORTIE
      </h3>
  </layout:column>
        </layout:row>
 <layout:panel key="Informations de sortie:" styleClass="FORM" width="600">
      
         
      
          <layout:select property="destId" key="Destination :" isRequired="true">
          <layout:options property="listdistId" labelProperty="listdistLabel" ></layout:options>
             
             </layout:select>
             
             
             <layout:select property="magasourc" key="Magasin :" isRequired="true">
              <layout:options property="listMagasinId" labelProperty="listMagasinLabel" ></layout:options>
             </layout:select>
             
             <layout:file property="file" fileKey="fileKey" key="List Items" ></layout:file>
              
              
          
         
          
          <layout:text property="note" key="Note :" isRequired="true"/>
          
        
          
          
           
          
      </layout:panel>
      
        <layout:space></layout:space>
        
         
      
       <layout:row width="800">
         <table border="0">
  
   <tr>
       <td>  </td>
       
     
       
    
 
        
       
       <td>  </td>
       
       
      
        
        
      
       
       <td> </td>
   </tr>
  
   
    
    
   </table>
     </layout:row>
   
     <layout:space></layout:space>
      </layout:form>
 
   
  </body>
  
</html:html>
