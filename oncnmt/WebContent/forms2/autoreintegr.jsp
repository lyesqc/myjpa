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
    
    <title>autorisation réintegration</title>

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
  
  <body onload="test7();activer();">
 
<jsp:include page="menu.jsp"/>  
 <hr>
<layout:form action="/autoreintegr1.do" method="post" onsubmit="return testersubmit();">
    <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
     
     <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
      <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
      
    <layout:row>
    
    <layout:column>      
              <layout:button onclick="activsubmit(document.reintegrForm,'annuler');">Annuler</layout:button>
            </layout:column>
             <layout:column>
             <layout:button onclick="valid_reintegr();">Valider</layout:button>
            </layout:column>
            <layout:column>
                <layout:button onclick="activsubmit(document.reintegrForm,'editExcel');">Expoter vers Excel</layout:button>
            
              </layout:column> 
              
         
              
    
    
       <layout:column width="70">
      </layout:column>

      <layout:column>  
      <h3 >
     AUTORISATION REINTEGRATION 
      </h3>
  </layout:column>

        </layout:row>
      
      
 <layout:row>
 <layout:column>
 <layout:select  property="magasourc" key=" source:">
          <layout:option value=""></layout:option>
          <layout:options property="listmaga"></layout:options>
          </layout:select>
 </layout:column>
 
 <layout:column>
  <layout:select  property="magadist" key="entrepot original :" >
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
        <layout:column>
  <layout:select  property="maga_reintegr" key="entrepot de réintegration :" >
          <layout:option value=""></layout:option>
          <layout:options property="listmaga1"></layout:options>
          </layout:select>
  
 </layout:column>
    
    <layout:column> 
  <layout:button onclick="setHidden('chercher',document.reintegrForm);document.reintegrForm.submit();">afficher les rangs </layout:button>
       </layout:column>     	
 </layout:row> 
  <logic:notEmpty property="resulrang" name="reintegrForm" >
 
  <layout:cell>
<div style="position:absolute;left:10px;width:850; height:190;overflow-y:scroll; border:solid 1px red;">   
   
    <layout:collection id="item" name="reintegrForm" property="resulrang" styleClass="SCROLL" styleClass="FORM"  width="850" >
       <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
       <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
       <layout:collectionItem title="N° SERIE DEBUT" property="start"></layout:collectionItem>
       <layout:collectionItem title="N° SERIE FIN" property="end"></layout:collectionItem>
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
	      <logic:present name="reintegrForm"   >
	     <logic:empty property="resulrang" name="reintegrForm" >
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
<div style="position:absolute;left:10px;top:370px;">   
  	      
	       <layout:row width="800">
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
       <td> <layout:button  property="idcode"  onclick="testVidd(document.reintegrForm);"> Ajouter </layout:button> </td>
  
       </tr>
       <jsp:include page="confirmation.jsp"/> 
   
    
       
   </table>
   </layout:row>
   </div>
   </layout:cell>
 
<layout:cell>
<div style="position:absolute;left:10px;top:420px;">   
  <layout:row >
<tr>
   <td>
  <layout:select  property="position" key="position:" disabled="true">
          <layout:option value="ACTIVE"></layout:option>
          <layout:option value="BRUTE"></layout:option>
</layout:select>   
   </td>
   
     <td>
  <layout:select  property="packaging" key="packaging:" disabled="true">
          <layout:option value="Package"></layout:option>
          <layout:option value="Non Package"></layout:option>
</layout:select>   
      </td>
   
         <td>
  <layout:select property="PQ" key="PQ :" disabled="true">
                         
                         <layout:option value=""></layout:option>
                         <layout:option value="71"></layout:option>
                         <layout:option value="72"></layout:option>
                         <layout:option value="73"></layout:option>
                         <layout:option value="74"></layout:option>
                         <layout:option value="75"></layout:option>
                         <layout:option value="76"></layout:option>
                         <layout:option value="77"></layout:option>
                         <layout:option value="78"></layout:option>
                         <layout:option value="79"></layout:option>
                         <layout:option value="90"></layout:option>
                         <layout:option value="91"></layout:option>
                         <layout:option value="92"></layout:option>
                         <layout:option value="93"></layout:option>
                        <layout:option value="94"></layout:option>
                        <layout:option value="95"></layout:option>
                        <layout:option value="96"></layout:option>
                        <layout:option value="97"></layout:option>
                        <layout:option value="98"></layout:option>
                        <layout:option value="99"></layout:option>             
                       </layout:select> 
   </td>
       <td>
     
     <layout:button property="botton2" onclick="testViddreintegr(document.reintegrForm);" disabled="true"> Ajouter le nouveau rang </layout:button>
       </td>
   </tr>
</layout:row>

 </div>
 </layout:cell>
  
       <layout:cell>
<div style="position:absolute;left:10px;top:450px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   

           
             <layout:collection name="reintegrForm" property="listajouter" styleClass="SCROLL"  styleClass="FORM" width="600" height="120">
                <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
                <layout:collectionItem title="PROFIL" property="proff"></layout:collectionItem>
                <layout:collectionItem title="N° SERIE DEBUT" property="stt"></layout:collectionItem>
                <layout:collectionItem title="N° SERIE FIN" property="endd"></layout:collectionItem>
                <layout:collectionItem title="QUANTITE" property="qtt"></layout:collectionItem>
                <layout:collectionItem title="X" property="retirer" action="/autoreintegr1.do?hidden=Retirer" paramId="aaa,ppp,st,see,qt" paramProperty="aaa,ppp,st,see,qt">
                <center> <layout:img srcName="supp.GIF" border="0"/>  </center>                
                </layout:collectionItem>
             
             </layout:collection>
         
</div>
</layout:cell>

  <layout:cell>
<div style="position:absolute;left:630px;top:450px;width:250;height:140; border:solid 1px red;">             
      
  <layout:row >
<layout:column width="350">
<layout:textarea property="note" key="Note:"></layout:textarea>
 </layout:column>
</layout:row> 
</div>

</layout:cell>
    </layout:form>
  </body>
</html:html>
	