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
    
    <title>Activation Prepaid</title>
 <layout:skin includeScript="true"/>
 
   
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="scratch(document.chargementForm);activer2();">

<jsp:include page="menu.jsp"/>  

     <layout:form action="/demandScr.do" method="post" onsubmit="return false;">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
      <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
    <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
 
      <layout:row>
      
       <layout:column>      
              <layout:button onclick="activsubmit(chargementForm,'annuler');">Annuler</layout:button>
            </layout:column>
             <layout:column>
                <layout:button onclick="activsubmit(chargementForm,'valider');">Valider</layout:button>
            
              </layout:column>
            <layout:column>
                <layout:button onclick="activsubmit(chargementForm,'editExcel');">Expoter vers Excel</layout:button>
            
              </layout:column> 
          
              
      
  
       <layout:column width="70">
      </layout:column>
      <layout:column>  
      <h3 >
         DEMANDE DE CHARGEMENT SCRATCH
      </h3>
  </layout:column>
        </layout:row>
        
                 <layout:row>
       <layout:column>
       <layout:select property="article1" key="Article:">
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select>
       </layout:column>
        <layout:column>
           <layout:button onclick="testafficher_rang(document.chargementForm);">afficher les rangs</layout:button>
       </layout:column>
       
       </layout:row>
      

     
         
        <layout:cell>
<div style="position:absolute;left:10px;width:850; height:230;overflow-y:scroll; border:solid 1px red;">   
  
      
           <layout:collection name="chargementForm" property="scratch"  styleClass="SCROLL" styleClass="FORM" width="850">
            <layout:collectionItem title="ARTICLE" property="art"></layout:collectionItem>
            <layout:collectionItem title="N� SERIE DEBUT" property="start" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N� SERIE FIN" property="end" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="ACTIVATION" property="activ" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>         
           <layout:collectionItem title="+" property="ajouter" action="/demandScr.do?hidden=afficher" paramId="article,s_str,s_end,qute,rng_id,act_id" paramProperty="article,s_str,s_end,qute,rng_id,act_id">
                <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
        </layout:collection>
       
 </div>
 </layout:cell>
 
 <layout:cell>
<div style="position:absolute;left:10px;top:360px;">   
   
    
        
        <layout:row width="800">
         <table border="0">
  
   <tr>
       <td> <layout:select property="article" key="Article:" onchange="activer2();">
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select> </td>
     <jsp:include page="champ2.jsp"/>    
         
       
       
       <td> <layout:button onclick="addScr(document.chargementForm);"> Ajouter </layout:button>  </td>
   </tr>


<jsp:include page="confirmation2.jsp"/> 
   </table>
   </layout:row>
   
 </div>
 </layout:cell>
  
  
  <layout:cell>
<div style="position:absolute;left:10px;top:440px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   
 
      
 <layout:collection name="chargementForm" property="scratch2" styleClass="SCROLL" styleClass="FORM" width="550" >
           <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
           <layout:collectionItem title="N� SERIE DEBUT" property="st" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N� SERIE FIN" property="se" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qt" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="X" property="retirer" action="/demandScr.do?hidden=Retirer" paramId="aaa,stt,see,qtt" paramProperty="aaa,stt,see,qtt">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
           </layout:collection>

     </div>
     </layout:cell>   
           
      <layout:cell>
<div style="position:absolute;left:620px;top:440px;width:250;height:140; border:solid 1px red;">             
          
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
