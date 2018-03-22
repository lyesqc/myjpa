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
	
function recupereruser(param,param1,param2,param3)    
	{
	document.parametre1Form.libelle.value=param;
document.parametre1Form.activer.value=param1;
document.parametre1Form.code.value=param2;
document.parametre1Form.consommation.value=param3;
	
	}

function confirmer_activer ()
{
var activation;

if (document.parametre1Form.libelle.value=="")  
{alert("Choisissez un article SVP ")}  
else{
if (document.parametre1Form.activer.value=="Actif" )   
{ activation="désactiver" ;     
}

if (document.parametre1Form.activer.value=="Inactif" )      
{ activation="activer" ;         
}

	if (confirm("Etes-vous sûr de vouloir "+activation+" cet article ? ")) {     
  setHidden('activerarticle',document.parametre1Form);  
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
 if (parametre1Form.hiddenTest.value =="Inactif") {
 alert("L'article a été désactivé");
 } 
 else{
 if (parametre1Form.hiddenTest.value =="Actif"){
 alert("L'article a été activé ");
 } 
 else
 {alert(param);   
 }
 }
}
}

function ajouterarticle ()  
{
var type=document.parametre1Form.type.value; 
if ((document.parametre1Form.libelle.value=="")||(document.parametre1Form.type.value==""))            
{alert("Compléter les informations SVP ")} 
else{


 if (confirm("Etes-vous sûr de vouloir ajouter cet article ? ")) {     
  setHidden('ajouterarticle',document.parametre1Form);  
  parametre1Form.submit();

}
}
}



function supprimerartcle ()
{
if ((document.parametre1Form.libelle.value==""))   
{alert("Choisissez un article SVP ")}  
else{
if (confirm("Etes-vous sûr de vouloir supprimer cet article ? ")) {       
  setHidden('supprimerartcle',document.parametre1Form);   
  parametre1Form.submit(); 
}
}
}     

function modifierarticle()
{
if ((document.parametre1Form.libelle.value=="")&&(document.parametre1Form.consommation.value==""))         
{alert("Compléter les informations SVP ")}    
else{
if (confirm("Etes-vous sûr de vouloir modifer la consommation journalière de cet article ? ")) {       
  setHidden('modifierarticle',document.parametre1Form);   
  parametre1Form.submit(); 
}
}
}    

function activeartcle ()
{
if (document.parametre1Form.type.value=="SCRATCH"||document.parametre1Form.type.value=="E_VOUTCHER")
{
document.parametre1Form.categorie.disabled=true;   
}

if (document.parametre1Form.type.value=="SIM")
{
document.parametre1Form.categorie.disabled=false;       
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
  <jsp:include page="menuPrincipal.jsp"/> 
<hr>
  
  
  <layout:form action="/parametre1.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
   <layout:text property="hiddenTest" mode="H,H,H">   </layout:text>
    <layout:text property="activer" mode="H,H,H" >   </layout:text>
     <layout:text property="code" mode="H,H,H" >   </layout:text>
   
  
   <layout:row>
   <layout:column>
      <layout:write   property="writparam"  ></layout:write> 
        </layout:column>
         
      </layout:row>   
      
      
       <layout:row >
       
       <layout:column>
       
        <layout:panel  key="" width="500">
   
      
      <layout:cell>
<div style="top:200;position:absolute;width:320;height:320;overflow:auto; border:solid 0px black;">   
   
         <layout:collection id="item" name="parametre1Form" property="listacteur" styleClass="SCROLL" styleClass="FORM" width="300" >
        <layout:collectionItem  onclick="recupereruser('${item.user}','${item.aprob}','${item.code}','${item.consommation}');"    href="javascript:void();" title="Libelle article " property="user" sortable="true"></layout:collectionItem>
<layout:collectionItem title="Etat  article" property="aprob" sortable="true"></layout:collectionItem> 
 
         </layout:collection>
</div>
</layout:cell>
      
        </layout:panel>
</layout:column>      
</layout:row>

  <layout:cell>
<div style="top:200;left:350;position:absolute;width:450;height:300;overflow:auto; border:solid 1px red;"> 
 <layout:panel  key="paramètrage article" styleClass="FORM"  >
 <layout:space></layout:space>     
  <layout:space></layout:space>  
<layout:row>
<layout:column> 
<layout:text size="30" property="libelle" key="article:"  ></layout:text>
</layout:column> 
<layout:column> 


</layout:column> 
</layout:row>
<layout:row>
<layout:column> 
 <layout:select  property="type" key="type :" >
 <layout:option value=""></layout:option>
          <layout:options property="lisTypeId" labelProperty="lisTypeLib" ></layout:options>
         
</layout:select>
 </layout:column>   
 
 <layout:column> 
 
 </layout:column>  
    
</layout:row>
<layout:row>
 <layout:column> 
   </layout:column> 
  </layout:row>
  <layout:row>
   <layout:column> 
   
  </layout:column> 
</layout:row>
  <layout:space></layout:space> 
<layout:row>
<layout:column>  
   <layout:button onclick="ajouterarticle();">Ajouter</layout:button>
</layout:column>  
<layout:column>  
  <layout:button onclick="supprimerartcle();">Supprimer</layout:button>   
</layout:column> 
<layout:column>  
  <layout:button onclick="confirmer_activer()();">Activer/Désactiver</layout:button>
</layout:column> 

</layout:row>
</layout:panel>
  </div>
  </layout:cell>
  </layout:form>
   
  </body>
</html:html>
	