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
    
    <title>ordretrans.jsp</title>

	 <layout:skin includeScript="true"/>
     <script type="text/javascript" src="config/javascript.js">
   
   </script>
   
   
   

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="test4();activer();">

<jsp:include page="menu.jsp"/> 
 
 
    <layout:form action="/ordretrans1.do" method="post" onsubmit="return testersubmit();" >
     <layout:text property="hiddenTest" mode="H,H,H" key="test"></layout:text>
     <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
   
    <layout:row >
            
   
              
                 <layout:column>      
              <layout:button onclick="activsubmit(document.transfertForm,'annuler');">Annuler</layout:button>
            </layout:column>
            
           <layout:column>
            
               <layout:button onclick="valid3();">Valider</layout:button>
              </layout:column>
              
            <layout:column>
                <layout:button onclick="activsubmit(document.transfertForm,'editExcel');">Expoter vers Excel</layout:button>
            
              </layout:column>  
              
            
       <layout:column width="70">
      </layout:column>
      <layout:column>  
      <h3 >
      ORDRE DE TRANSFERT   
      </h3>  
  </layout:column>  
        </layout:row>  
    
      
      
 <layout:row>
 <layout:column>
 <layout:select  property="magasourc" key="entrepot source:">
          <layout:option value=""></layout:option>
          <layout:options property="listmaga"></layout:options>
          </layout:select>
 </layout:column>
 
 <layout:column>
  <layout:select  property="magadist" key="entrepot distination :" onchange="document.getElementById('magadist').readonly = true ;">
          <layout:option value=""></layout:option>
          <layout:options property="listmaga1"></layout:options>
          </layout:select>
  
 </layout:column>
 
         <layout:column> 
    <layout:select  property="article1" key="article:"  >
          <layout:option value=""></layout:option>
          <layout:options property="listarticle"></layout:options>
          </layout:select>  
  </layout:column>
  
  
  </layout:row> 
   <layout:row> 
     <layout:column width="350">  </layout:column> 
    <layout:column> 
 <layout:button onclick="transfert_verif();">afficher les rangs </layout:button>
       </layout:column>     	
 </layout:row> 
  
  
  
  <logic:notEmpty property="resulrang2" name="transfertForm" >
  <layout:cell>
<div style="position:absolute;left:10px;width:850; height:230;overflow-y:scroll; border:solid 1px red;">   
 
    <layout:collection id="item" name="transfertForm" property="resulrang2" styleClass="SCROLL" styleClass="FORM"  width="830">
       <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
       <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
       <layout:collectionItem title="N° SERIE DEBUT" property="start"></layout:collectionItem>
       <layout:collectionItem title="N°SERIE FIN" property="end"></layout:collectionItem>
       <layout:collectionItem title="PACKAGING" property="packag"></layout:collectionItem>
       <layout:collectionItem title="ACTIVE" property="active"></layout:collectionItem>
       <layout:collectionItem title="HLR" property="hlr"></layout:collectionItem>
   <layout:collectionItem title="PQ" property="pq"></layout:collectionItem>
         
   <layout:collectionItem title="QUANTITE" property="qte"></layout:collectionItem>
 <layout:collectionItem  onclick="recuperparametre('${item.art}','${item.prof}','${item.st}','${item.nd}','${item.rng_id}','${item.act_id}');"    href="javascript:void();" title="ajouter" property="ajouter" sortable="true">
   <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center> 
</layout:collectionItem>
    
    </layout:collection>
  
  </div>
  </layout:cell>
  
  
  </logic:notEmpty>    
    
   <logic:present  parameter="hidden" scope="request" >
	     <logic:equal value="chercher" parameter="hidden" scope="request">
	      <logic:present name="transfertForm"   >
	     <logic:empty property="resulrang2" name="transfertForm" >
	     <center>
	     <layout:panel styleClass="Form"  key="aucun resultat trouvé !" >
	     <layout:message key="aucune rang "/>
	     <layout:message key="n'est dans se warehouse"/>
	     
	     </layout:panel>	
	     </center>    
	     </logic:empty>
	     
	     </logic:present>
	     </logic:equal>
	     </logic:present>
	     
	      <layout:space></layout:space>
	     <layout:cell>
<div style="position:absolute;left:10px;top:380px;">   
 
	       <layout:row>
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
           <layout:option value="SWAP"></layout:option>
          </layout:select>   </td>
       
        <td> <layout:button onclick="testVidd(document.transfertForm);"> Ajouter</layout:button> </td>
 
       
       </tr>
      <jsp:include page="confirmation.jsp"/> 
   </table>
   </layout:row>
  </div>
  </layout:cell> 
 <layout:cell>
<div style="position:absolute;left:10px;top:440px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   

             <layout:collection name="transfertForm" property="listajouter" styleClass="SCROLL"  styleClass="FORM" width="600" height="120">
                <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
                <layout:collectionItem title="PROFIL" property="proff"></layout:collectionItem>
                <layout:collectionItem title="N° SERIE DEBUT" property="stt"></layout:collectionItem>
                <layout:collectionItem title="N°SERIE FIN" property="endd"></layout:collectionItem>
                <layout:collectionItem title="QUANTITE" property="qtt"></layout:collectionItem>
                <layout:collectionItem title="X" property="retirer" action="/ordretrans1.do?hidden=Retirer" paramId="aaa,ppp,st,see,qt" paramProperty="aaa,ppp,st,see,qt">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
             </layout:collection>
  </div>
  </layout:cell>         
        
    <layout:cell>
<div style="position:absolute;left:630px;top:440px;width:250;height:140; border:solid 1px red;">             
<layout:row>         
<layout:column >
<layout:textarea property="note" key="Note:"></layout:textarea>
 </layout:column>
    </layout:row>
    </div>
    </layout:cell>
    
    
    
    </layout:form>
  </body>
</html:html>
	