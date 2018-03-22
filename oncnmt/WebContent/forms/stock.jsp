


<%@ page buffer="none"%>
<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
 <title>Etat de Stock</title>
    <layout:skin includeScript="true"/>

  <script type="text/javascript">
  
     function mafonction(item)
{
	var tr = item.parentNode.parentNode;
	var td = tr.getElementsByTagName('td');
	var i= td[0].firstChild.value;
	document.etaStkForm.sdu.value= ""+i;
}
    
   function checkboxsorti() 
   {
 if  (document.etaStkForm.sortie.checked)
{
document.etaStkForm.sortie.value="true" ;  

document.etaStkForm.hiddenSorti.value="true";
}
else
{
document.etaStkForm.sortie.value="false"; 
document.etaStkForm.hiddenSorti.value="false";

} 
   }
   
   
      function checkboxtdp() 
   {
 if  (document.etaStkForm.tdp.checked)
{
document.etaStkForm.tdp.value="true" ;

document.etaStkForm.hiddenTdp.value="true";
}
else
{
document.etaStkForm.tdp.value="false"; 
document.etaStkForm.hiddenTdp.value="false";

} 
   }
      function effacer(form)
		{
		//document.etaStkForm.dat_du.value="";
		document.etaStkForm.typ.value="";
		document.etaStkForm.sdu.value="";
		document.etaStkForm.sau.value="";
		document.etaStkForm.profil.value="";
		document.etaStkForm.article.value="";
		document.etaStkForm.warehouse.value="";
		document.etaStkForm.dist.value="";
		document.etaStkForm.cds.value="";
		document.etaStkForm.part.value="";
		document.etaStkForm.PQ.value="";
		document.etaStkForm.packaging.value="";
		document.etaStkForm.HLR.value="";
		document.etaStkForm.position.value="";
		document.etaStkForm.sortie.value="false"; 
		document.etaStkForm.sortie.checked=false;
		document.etaStkForm.tdp.value="false"; 
		document.etaStkForm.tdp.checked=false;
		document.etaStkForm.hiddenTdp.value="false";
		document.etaStkForm.hiddenSorti.value="false";
		}
		
		function activernum(){
		
		
		if(document.getElementById('typ').value=="SIM")
		{document.getElementById('sdu').maxLength="12";
		document.getElementById('sau').maxLength="12";
		document.getElementById('sdu').disabled=false;
		document.getElementById('sau').disabled=false;
}
		if(document.getElementById('typ').value=="SCRATCH")
		{
		document.getElementById('sdu').maxLength="15";
		document.getElementById('sau').maxLength="15";
		document.getElementById('sdu').disabled=false; 
		document.getElementById('sau').disabled=false;
		}
		
	
}
		function etat(param1)
		{
document.getElementById('hiddenTest').value=param1;
setHidden('historique',document.etaStkForm); 
document.etaStkForm.submit(); 
 openpopup("stock.do?hidden=historique",'','750','450', event);                 

}	
		
function fonctioncopier	()	

{ alert(event.keyCode); } 



	
	
		
  </script>
   <script type="text/javascript">
     function setHidden(value){document.etaStkForm.hidden.value=value;}
   </script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
<body onload="activernum();">
  
 

  
<jsp:include page="menu.jsp"/> 
 <hr>


   
  
  
  <layout:form action="/stock.do" method="post">
  <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
   <layout:text property="hiddenTest" value="default" mode="H,H,H"></layout:text>
   <layout:text property="hiddenTdp" mode="H,H,H"></layout:text>
     <layout:text property="hiddenSorti" mode="H,H,H"></layout:text>
   <layout:panel key="Etat de stock global :" styleClass="FORM">   
    <layout:row> 
  
          <layout:column>   
              <layout:date  property="dat_du"  key="Jusqu'à la date Du :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir une date" ></layout:date>
           <layout:text property="heur1" key="heure:" size="8" maxlength="8" ></layout:text>
                    
              
                    <layout:text property="sdu" key="N° SERIE  Du :" disabled="false" ></layout:text>
                    <layout:text property="sau" key="N° SERIE  Au :" disabled="false" ></layout:text>
                   
                  
          </layout:column>    
          <layout:column>
                   <layout:select property="article" key="Article :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomArticle"></layout:options>
                   </layout:select>
                  
                   <layout:select property="warehouse" key="Warehouse :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomWarehouse"></layout:options>
                   </layout:select>
                   
           </layout:column>
            <layout:column>
                  
                   <layout:select property="cds" key="CDS :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomCds"></layout:options>
                   </layout:select>
                   
                   
                     
           </layout:column>
           
            <layout:column>
                     
                     
                                 
                       
                       
                      
                       
                        <layout:checkbox property="sortie"  key="Inclure les sorties " value="sortie" onclick="checkboxsorti();"></layout:checkbox>
  
                       <layout:checkbox property="tdp" key="Inclure les T D P V" value="tdp" onclick="checkboxtdp();"></layout:checkbox>
         
         
           </layout:column>
           

         
          
                 
     
     </layout:row>
      <layout:row width="800"> 
          <layout:column width="100" ></layout:column>
          <layout:submit value="Consulter historique  rang"  onclick="setHidden('historique',document.etaStkForm);return openpopup(this.form,'','430','500', event);"> </layout:submit>   
          <layout:column width="100"> <layout:button onclick="effacer(this.form)">Réinitialiser</layout:button>  </layout:column>
          <layout:row> </layout:row>
          <layout:column> <layout:submit onclick="setHidden('Rechercher');">Rechercher</layout:submit> </layout:column>
      <layout:column> <layout:submit onclick="setHidden('exporter');">exporter vers EXCEL</layout:submit> </layout:column>
    
     
     </layout:row>
     
   </layout:panel>
   
    <layout:text property="result" key="" size="50" mode="H,H,H">
    </layout:text>
   
   
   <layout:write  name="etaStkForm" property="result" ></layout:write>
<logic:notEmpty property="etat" name="etaStkForm"> 
  <layout:cell>
<div style="position:absolute;left:10px;width:1010; height:1000;overflow-y:scroll; border:solid 1px black;">   
<layout:pager maxPageItems="65000">
 <layout:collection styleId="etat" model="fixedHeader" id="item"  selectName="dat_au" selectProperty="rng_id" selectType="radio" name="etaStkForm" property="etat" styleClass="FORM" >
<layout:collectionItem    title="_______ARTICLE______" property="art" sortable="true"></layout:collectionItem>
    
      <layout:collectionItem  title="N°SERIE " property="start" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
       
       
        <layout:collectionItem title="TRANSFERT" property="tra" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="SORTIE" property="sor" sortable="true"></layout:collectionItem> 
       <layout:collectionItem title="REINTEGRATION" property="reint" sortable="true"></layout:collectionItem> 
       
      
   </layout:collection>
   
   </layout:pager>
 </div >
  </layout:cell>
  
  </logic:notEmpty>
  
   <logic:present parameter="hidden" scope="request">
    <logic:equal value="Rechercher" parameter="hidden" scope="request">
       <logic:present name="etaStkForm">
          <logic:empty name="etaStkForm" property="etat">
             <layout:panel key="Resultat de Recherche" styleClass="FORM">
             <center>
                <layout:message key="Aucun résultat correspondant "/>
             </layout:panel>
         
          </logic:empty>
       </logic:present>
    </logic:equal>
  
  </logic:present>
 
  
  </layout:form>
   

  </body>

</html:html>