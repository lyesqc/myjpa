

<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
   
    <title>Ordre de packaging</title>
    
     <layout:skin includeScript="true"/>
 
   <script type="text/javascript" src="config/javascript.js">
   
   </script>
   
   <link rel="stylesheet" type="text/css" href="styles.css">
	
   
   
   

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="activer();testt1();">

<jsp:include page="menu.jsp"/> 

 <hr>
 

    <layout:form action="/pac.do" method="post" onsubmit="return testersubmit();">
     <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
     <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
     <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
      
       <layout:row >
           
             <layout:column>
            
        <layout:button onclick="activsubmit(document.packagingForm,'annuler');">Annuler</layout:button>
              
              </layout:column>
              <layout:column> 
              <layout:button onclick="validd();">Valider</layout:button>
                   
             
            </layout:column>
            <layout:column>
                <layout:button onclick="activsubmit(document.packagingForm,'editExcel');">Expoter vers Excel</layout:button>
            
              </layout:column>
           
       <layout:column width="70">
      </layout:column>
      <layout:column>  
      <h3 >
   ORDRE DE PACKAGING 
      </h3>
  </layout:column>
        </layout:row>
      
      
      
 <layout:row>
    <layout:column> 
 <layout:select  property="maga" key="magasin :" >  
          <layout:option value=""></layout:option>
          <layout:options property="listmaga"></layout:options>
          </layout:select>
   </layout:column> 
   
      <layout:column> 
    <layout:select  property="article1" key="article:"  >
          <layout:option value=""></layout:option>
          <layout:options property="listarticle"></layout:options>
          </layout:select>  
  </layout:column>

     <layout:column width="50">  </layout:column> 
    <layout:column> 
  <layout:button onclick="setHidden('chercher',document.packagingForm);document.packagingForm.submit();">afficher les rangs </layout:button>
       </layout:column>     	
 </layout:row>
  <layout:row>
  
   <layout:column>  
   <layout:select  property="parten" key="partenaire :">
          <layout:option value=""></layout:option>
          <layout:options property="listparten"></layout:options>
          </layout:select>
           </layout:column>  
   <layout:column>  
  <layout:date property="dat" key="Date limite :"  endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date fin" ></layout:date> 
    </layout:column>  
     <layout:column>  
  <layout:radio property="priorite"  key="Priorité Haute " value="haute"></layout:radio>
   </layout:column>  
    <layout:column>  
   <layout:radio property="priorite" key="Priorité normale " value="bas"></layout:radio>
      </layout:column>  
  </layout:row>
  <logic:notEmpty property="resulrang" name="packagingForm" >
  <layout:cell>
<div style="position:absolute;left:10px;width:850; height:190;overflow-y:scroll;border:solid 1px red;">   
 
    <layout:collection id="item" name="packagingForm" property="resulrang" styleClass="SCROLL" styleClass="FORM" >
       <layout:collectionItem title="ARTICLE" property="article" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="PROFIL" property="profil" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="N° SERIE DEBUT" property="start" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="N°SERIE FIN" property="end" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="PACKAGING" property="packag" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="ACTIVE" property="active" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="HLR" property="hlr" sortable="true"></layout:collectionItem>
        <layout:collectionItem title="PQ" property="pq" sortable="true"></layout:collectionItem>
<layout:collectionItem title="QUANTITE" property="qte" sortable="true"></layout:collectionItem>
      
 <layout:collectionItem  onclick="recuperparametre('${item.art}','${item.prof}','${item.st}','${item.nd}','${item.rng_id}','${item.act_id}');"    href="javascript:void();" title="ajouter" property="ajouter" sortable="true">
   <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center> 
</layout:collectionItem>
    
    </layout:collection>
  
  </div>
  </layout:cell>
 
  
  </logic:notEmpty>    
    
   <logic:present  parameter="hidden" scope="request" >
	     <logic:equal value="chercher" parameter="hidden" scope="request">
	      <logic:present name="packagingForm"   >
	     <logic:empty property="resulrang" name="packagingForm" >
	     <layout:panel styleClass="Form"  key="aucun resultat trouvé !" >
	     <layout:message key="aucune rang "/>
	     <layout:message key="n'est dans se warehouse"/>
	     
	     </layout:panel>	    
	     </logic:empty>
	     
	     </logic:present>
	     </logic:equal>
	     </logic:present>
	     
	      <layout:space></layout:space>
	     <layout:cell>
<div style="position:absolute;left:10px;top:380px;">   
  
	       <layout:row width="500">
         <table border="0">
  
   <tr>
       <td> <layout:select  property="article" key="article:" onchange="activer();">
          <layout:option value=""></layout:option>
          <layout:options property="listarticle"></layout:options>
          </layout:select></td>

      <jsp:include page="champ.jsp"/> 
<td> <layout:select  property="profil" key="profil:">
          <layout:option value=""></layout:option>
          <layout:options property="listprof"></layout:options>
          </layout:select>   </td>
       
       <td> <layout:button onclick="testVidd(document.packagingForm);"> Ajouter </layout:button> </td>
   </tr>
<jsp:include page="confirmation.jsp"/> 
   </table>
   
   </layout:row>
   </div>
   </layout:cell>
   <layout:space></layout:space>
  
  
    
      <layout:cell>
<div style="position:absolute;left:10px;top:435px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   
  
             <layout:collection name="packagingForm" property="listajouter" styleClass="SCROLL"  styleClass="FORM" width="580">
                <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
                <layout:collectionItem title="PROFIL" property="proff"></layout:collectionItem>
                <layout:collectionItem title="N° SERIE DEBUT" property="stt"></layout:collectionItem>
                <layout:collectionItem title="N°SERIE FIN" property="endd"></layout:collectionItem>
                <layout:collectionItem title="QUANTITE" property="qtt"></layout:collectionItem>
                <layout:collectionItem title="X" property="retirer" action="/pac.do?hidden=Retirer" paramId="aaa,ppp,st,see,qt" paramProperty="aaa,ppp,st,see,qt">
                <center> <layout:img srcName="supp.GIF" border="0"/>  </center>                
                </layout:collectionItem>
             
             </layout:collection>
     </div>
     </layout:cell> 
  
    <layout:cell>
<div style="position:absolute;left:620px;top:435px;width:250;height:140; border:solid 1px red;">             
         
 <layout:row>
 <layout:column>
<layout:textarea property="note" key="Note:"></layout:textarea>
  </layout:column>
 </layout:row>   
    
    
 </div>
 </layout:cell>
    
    
    </layout:form>
  </body>
</html:html>
