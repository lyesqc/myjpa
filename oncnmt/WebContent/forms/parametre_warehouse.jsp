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
    
    <title>parametre.jsp</title>

	 <layout:skin includeScript="true"/>
    
    <script>

	function setHidden(value){document.parametre1Form.hidden.value=value;}
	
function recupereruser(param,param1,param2)    
	{
	document.parametre1Form.libelle.value=param;
document.parametre1Form.activer.value=param1;
document.parametre1Form.code.value=param2;

	
	}

function confirmer_activer ()
{
var activation;

if (document.parametre1Form.activer.value=="Actif" )   
{ activation="désactiver" ;     
}

if (document.parametre1Form.activer.value=="Inactif" )      
{ activation="activer" ;         
}

if ((document.parametre1Form.libelle.value==""))   
{alert("Veuillez  choisir un warehouse SVP ")}  
else{
	if (confirm("Etes-vous sûr de vouloir "+activation+" ce warehouse? ")) { 
	
setHidden('activerwarehouse',document.parametre1Form);  
  parametre1Form.submit();
}
}



}



function messageparametre()
{
var param=parametre1Form.hiddenTest.value;
if (parametre1Form.hiddenTest.value =="") { 
}
else{
 if (parametre1Form.hiddenTest.value =="I") {
 alert("Le warehouse a été désactivé");
 } 
 else{
 if (parametre1Form.hiddenTest.value =="A"){
 alert("le warehouse a été activé ");
 } 
 else
 {alert(param);   
 }
 }
}
}

function ajouterwarehouse ()  
{
if ((document.parametre1Form.libelle.value=="")|| (document.parametre1Form.type.value=="") ||(document.parametre1Form.region.value==""))     
{alert("Compléter les informations SVP ")} 
else{
if (confirm("Etes-vous sûr de vouloir ajouter ce warehouse ? ")) {     
  setHidden('ajouterwarehouse',document.parametre1Form);  
  parametre1Form.submit();
}
}
}

function supprimerwarehouse ()
{
if ((document.parametre1Form.libelle.value==""))   
{alert("Veuillez  choisir un warehouse SVP ")}  
else{
if (confirm("Etes-vous sûr de vouloir supprimer ce warehouse  ? ")) {       
  setHidden('supprimerwarehouse',document.parametre1Form);     
  parametre1Form.submit(); 
}
}
} 


	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body onload="messageparametre();">
 
  
<hr>
  
  
  <layout:form action="/parametre1.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
   <layout:text property="hiddenTest" mode="H,H,H" >   </layout:text>
    <layout:text property="activer" mode="H,H,H" >   </layout:text>
     <layout:text property="code" mode="H,H,H" >   </layout:text>
   
 <layout:row>
   <layout:column>
      <layout:write   property="writparam"  ></layout:write> 
        </layout:column>
         
      </layout:row>
      
       <layout:row >
      
       <layout:column >
       
        <layout:panel  key="">

         <layout:collection id="item" name="parametre1Form" property="listacteur" styleClass="SCROLL" styleClass="FORM" width="250" height="270">
        <layout:collectionItem width="30"  onclick="recupereruser('${item.user}','${item.aprob}','${item.code}');"    href="javascript:void();" title="désignation warehouse" property="user" sortable="true"></layout:collectionItem>
<layout:collectionItem title="Etat" property="aprob" sortable="true"></layout:collectionItem> 
 
         </layout:collection>

    
        </layout:panel>
        
</layout:column>  

  <layout:column >
  
     <layout:panel  key="Paramétrage warehouse" styleClass="FORM"> 
     <layout:row>
<layout:column> 
<layout:text property="libelle" key="Warehouse:" ></layout:text>
</layout:column> 


 </layout:row>
 
 <layout:row>
 
 <layout:column> 
 <layout:select  property="type" key="type :">
          <layout:option value=""></layout:option>
           <layout:option value="CENTRAL"></layout:option>
            <layout:option value="REGIONAL"></layout:option>
</layout:select>
 </layout:column> 
 <layout:column> 
 <layout:select  property="region" key="region :">
          <layout:option value=""></layout:option>
           <layout:option value="CENTRE"></layout:option>
            <layout:option value="EST"></layout:option>
             <layout:option value="OUEST"></layout:option>
         
          </layout:select>
 </layout:column>         
</layout:row>
 <layout:space></layout:space> 
<layout:row>
<layout:column>  
   <layout:button  onclick="ajouterwarehouse();">Ajouter</layout:button >
</layout:column>  
<layout:column>  
  <layout:button  onclick="supprimerwarehouse();">Supprimer</layout:button >
</layout:column> 
<layout:column>  
  <layout:button onclick="confirmer_activer()();">Activer/Désactiver</layout:button>
</layout:column> 

</layout:row>
      </layout:panel>
    </layout:column >   

</layout:row>



  
  </layout:form>
   
  </body>
</html:html>
	