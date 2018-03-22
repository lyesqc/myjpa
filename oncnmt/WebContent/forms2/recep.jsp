<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<%@ page import="com.yourcompany.struts.form.RecepForm"%>
<%@ page import="org.apache.struts.action.ActionForm"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Reception</title>
 <layout:skin includeScript="true"/>
 
   <script>
   

function cachePrompt() {
document.getElementById('le_prompt').style.display='none';
}
   
function viewListes(){
		features = "width=600,height=600,resizable=0,scrollbars=1,status=1";
		window.open("autosorti.do?hidden=listprob","parametre",features);
		
		 window.onload = function(){
    document.recepForm.ND.onkeydown = function(e){
        var e=window.event || e;
        var touche = e.keyCode;
        if(e.keyCode==13){
            affPrompt1(document.getElementById('le_prompt').value);
        }
        else
        {
        alert("j'ai rentre mais cpas entre");
        }
    }
}

}
</script>	
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  <body onload="test();">
  


<jsp:include page="menu.jsp"/>  

 <hr>
 
    <layout:form action="/recep3.do" method="post" onsubmit="return false;">
    
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
      <layout:text property="hiddenTest"  mode="H,H,H"></layout:text>
     
      
       <layout:row>
       
       
          
           <layout:column>      
              <layout:button onclick="activsubmit(document.recepForm,'annuler');">Annuler</layout:button>
            </layout:column>
              <layout:column>
    <layout:button onclick="testVide();">Valider</layout:button>
            </layout:column>
           <layout:column>
                <layout:button onclick="activsubmit(document.recepForm,'exporter');">Exporter vers Excel</layout:button>
            
              </layout:column>
            
            <layout:column width="70">
            </layout:column> 
            
      <layout:column>  
      <h3 >
     RECEPTION
      </h3>
  </layout:column>
        </layout:row>
 <layout:panel key="Informations de réception:" styleClass="FORM" width="600">
      
         
      
          <layout:select property="fournisseur" key="Fournisseur :">
          <layout:option value=""></layout:option>
          <layout:options property="nomFournisseur"></layout:options>
          </layout:select>
         
          <layout:text property="ref" key="N° Ref Ext:" ></layout:text>
          <layout:text property="PO" key="N° PO :"></layout:text>
          <layout:textarea property="note" key="Note de réception:"></layout:textarea>
          <layout:text property="magas" key="Magasin :" mode="R,R,R"></layout:text> 
      </layout:panel>
      
        <layout:space></layout:space>
        
         
      
       <layout:row width="800">
         <table border="0">
  
   <tr>
       <td> <layout:select property="article" key="Article:" onchange="activer3();">
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select> </td>
       
      <jsp:include page="champ2.jsp"/>
       
    
 
        
       
       <td> <layout:select property="profil" key="Profil:" disabled="true">
       <layout:option value=""></layout:option>
       <layout:options property="nomProfil"></layout:options>
       </layout:select> </td>
       
       
      
        
        
      
       
       <td> <layout:button onclick="testVid(document.recepForm);"> Ajouter </layout:button> </td>
   </tr>
  
   
   
     <jsp:include page="confirmation2.jsp"/> 
   </table>
  
  
   </layout:row>
   
     <layout:space></layout:space>
   
 
  
         
   <layout:cell>
 
<div style="position:absolute;left:10px;width:650; height:170;overflow-y:scroll;">  
 

           <layout:collection name="recepForm" property="recepList" styleClass="SCROLL" styleClass="FORM" width="630">
           <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="profil" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="SERIAL_START" property="ND" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="SERIAL_END" property="NF" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="X" property="retirer" action="/recep3.do?hidden=Retirer" paramId="aaa,ppp,stt,see,qtt" paramProperty="aaa,ppp,stt,see,qtt">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
           </layout:collection>
</div>
</layout:cell>
           

 
   

   </layout:form>
 
   
  </body>
  
</html:html>
