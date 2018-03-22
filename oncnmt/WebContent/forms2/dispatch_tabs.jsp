


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
                    
              <layout:select property="typ" key="Type :" onchange="activernum();">
                       <layout:option value=""></layout:option>
                         <layout:option value="SIM"></layout:option>
                         <layout:option value="SCRATCH"></layout:option>
                         <layout:option value="E_VOUTCHER"></layout:option>
              </layout:select>
                    <layout:text property="sdu" key="N° SERIE  Du :" disabled="true" ></layout:text>
                    <layout:text property="sau" key="N° SERIE  Au :" disabled="true" ></layout:text>
                   
                  
          </layout:column>    
          <layout:column>
                   <layout:select property="article" key="Article :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomArticle"></layout:options>
                   </layout:select>
                   <layout:select property="profil" key="Profil :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomProfil"></layout:options>
                   </layout:select>
                   <layout:select property="warehouse" key="Warehouse :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomWarehouse"></layout:options>
                   </layout:select>
                    <layout:select property="dist" key="Distributeur :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomDist"></layout:options>
                   </layout:select>
           </layout:column>
            <layout:column>
                  
                   <layout:select property="cds" key="CDS :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomCds"></layout:options>
                   </layout:select>
                   <layout:select property="part" key="Partenaire :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomPart"></layout:options>
                   </layout:select>
                   <layout:select property="position" key="Position :">
                         <layout:option value=""></layout:option>
                          <layout:option value="BRUTE"></layout:option>
                          <layout:option value="EN COURS"></layout:option>
                           <layout:option value="ACTIVE"></layout:option>
                       
                             
                     </layout:select>
                     <layout:select property="packaging" key="Packaging :">
                         
                         <layout:option value=""></layout:option>
                         <layout:option value="Non Package"></layout:option>
                         <layout:option value="Sous ordre"></layout:option>
                         <layout:option value="En Cours"></layout:option>
                         <layout:option value="Package"></layout:option>
                         </layout:select>
           </layout:column>
           
            <layout:column>
                     
                     
                                 
                         <layout:select property="HLR" key="HLR :">
                         
                         <layout:option value=""></layout:option>
                         <layout:option value="00"></layout:option>
                         <layout:option value="01"></layout:option>
                         <layout:option value="02"></layout:option>
                         <layout:option value="03"></layout:option>
                         <layout:option value="04"></layout:option>
                         <layout:option value="05"></layout:option>
                         <layout:option value="06"></layout:option>
                         <layout:option value="07"></layout:option>
                         <layout:option value="08"></layout:option>
                         <layout:option value="09"></layout:option>
                         <layout:option value="10"></layout:option>
                         <layout:option value="11"></layout:option>
                         <layout:option value="12"></layout:option>
                         <layout:option value="13"></layout:option>
                         <layout:option value="14"></layout:option>
                         <layout:option value="15"></layout:option>
                         <layout:option value="16"></layout:option>
                         <layout:option value="17"></layout:option>
                         <layout:option value="18"></layout:option>
                         <layout:option value="19"></layout:option>
                         <layout:option value="20"></layout:option>
                         <layout:option value="21"></layout:option>
                         <layout:option value="22"></layout:option>
                         <layout:option value="23"></layout:option>
                         <layout:option value="24"></layout:option>
                         <layout:option value="25"></layout:option>
                         <layout:option value="26"></layout:option>
                         <layout:option value="27"></layout:option>
                         <layout:option value="28"></layout:option>
                         <layout:option value="29"></layout:option>
                         
                         </layout:select>
                       
                       <layout:select property="PQ" key="PQ :">
                         
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
                       
                        <layout:checkbox property="sortie"  key="Inclure les sorties " value="sortie" onclick="checkboxsorti();"></layout:checkbox>
  
                       <layout:checkbox property="tdp" key="Inclure les T D P" value="tdp" onclick="checkboxtdp();"></layout:checkbox>
         
            <layout:select property="promotion" key="" >
                       <layout:option value=""></layout:option>
                         <layout:option value="Scratch promotionnel"></layout:option>
                         <layout:option value="Scratch securite"></layout:option>
                         
              </layout:select>
         
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
     <layout:collectionItem title="____PROFIL____" property="prof" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="DESTINATAIRE" property="dest" sortable="true"></layout:collectionItem>
      <layout:collectionItem  title="N°SERIE DEBUT" property="start" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="N°SERIE FIN" property="end" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="POSITION" property="pos" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="PACKAGING" property="pack" sortable="true"></layout:collectionItem>
        <layout:collectionItem title="HLR" property="hlr" sortable="true"></layout:collectionItem>
        <layout:collectionItem title="PQ" property="pq" sortable="true"></layout:collectionItem>
          <layout:collectionItem title="TRANSFERT" property="tra" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="SORTIE" property="sor" sortable="true"></layout:collectionItem> 
       <layout:collectionItem title="REINTEGRATION" property="reint" sortable="true"></layout:collectionItem> 
       <layout:collectionItem title="TDP" property="tdp" sortable="true"></layout:collectionItem>
      
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