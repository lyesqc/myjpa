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
	document.parametre1Form.code.value=param1;
	document.parametre1Form.activer.value=param2;

	
	}

function confirmer_activer ()
{
var activation;
var acteur=document.parametre1Form.libelle.value;
if (document.parametre1Form.activer.value=="Actif" )   
{ activation="désactiver" ;     
}

if (document.parametre1Form.activer.value=="Inactif" )      
{ activation="activer" ;         
}

if (document.parametre1Form.libelle.value=="")
{alert("Veuillez   choisir un élément  SVP")}      
else{
	if (confirm("Etes-vous sûr de vouloir "+activation+" "+acteur+"? ")) {      
  setHidden('activer',document.parametre1Form);
  parametre1Form.submit();
}
}
}

function confirmer_ajouter ()
{
var code=parametre1Form.code.value;
var lib=parametre1Form.libelle.value;

if (document.parametre1Form.libelle.value=="")
{alert("Compléter les informations SVP ")
	document.parametre1Form.libelle.focus();
	} 

else{
 if ((document.parametre1Form.writcode2.disabled==false)&&(document.parametre1Form.writcode2.value==""))    

{alert("Veuillez   saisir le code   SVP ")
	 document.parametre1Form.writcode2.focus();
	 } 
 else
 {	 
	 if ((document.parametre1Form.region.disabled==false)&& (document.parametre1Form.region.value==""))    

	 {alert("Veuillez   choisir la  région  SVP ")
		 document.parametre1Form.region.focus();} 
	  else
	  {	 
	  if (confirm("Etes-vous sûr de vouloir ajouter"+code+"-"+lib+" ? ")) {              
	    setHidden('ajouter',document.parametre1Form);
	    parametre1Form.submit();
	  }
	  }
 }
}

}




function confirmer_supprimer ()
{
var code=parametre1Form.code.value;
var lib=parametre1Form.libelle.value;

if (document.parametre1Form.libelle.value=="")
{alert("Veuillez   choisir un élément  SVP")}      
else{
if (confirm("Etes-vous sûr de vouloir supprimer"+code+"-"+lib+" ? ")) {          
  setHidden('supprimer',document.parametre1Form);
  parametre1Form.submit();
}
}
}


function messageparametre()
{
var param=parametre1Form.hiddenTest.value;
var code=parametre1Form.code.value;
var lib=parametre1Form.libelle.value;
if (parametre1Form.hiddenTest.value =="") { 
}
else{
 if (parametre1Form.hiddenTest.value =="Inactif") {
 alert(code+"-"+lib+" a été désactivé"); 
 } 
 
 else{
 if (parametre1Form.hiddenTest.value =="Actif") {
 alert(code+"-"+lib+" a été activé"); 
 } 
else{
 alert(param);
 }   
 }
}
}


function desactiver()   
{
var param='<%=request.getParameter("param")%>';
if ('<%=request.getParameter("param")%>'=="FOURNISSEUR") 
{document.parametre1Form.writcode2.disabled=true;  }
if ('<%=request.getParameter("param")%>'=="PARTENAIRE") 
{document.parametre1Form.writcode2.disabled=true;  }
if ('<%=request.getParameter("param")%>'=="SORTIE DIVERSE") 
{document.parametre1Form.writcode2.disabled=true;  }

if (param=="SORTIE DIVERSE"||param=="FOURNISSEUR"||param=="PARTENAIRE"||param=="DISTRIBUTEUR") 
{
	document.parametre1Form.region.disabled=true;  }
}  


	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body onload="desactiver();messageparametre();">
  <jsp:include page="menuPrincipal.jsp"/> 
<hr>
  
  
  <layout:form action="/parametre1.do">
        <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
   <layout:text property="hiddenTest" mode="H,H,H" >   </layout:text>
    <layout:text property="activer" mode="H,H,H" >   </layout:text>
    <center>
<layout:row>
   <layout:column>
      <layout:write   property="writparam"  ></layout:write> 
        </layout:column>
         
      </layout:row>

     <layout:cell>
<div style="top:200;position:absolute;width:420;height:320;overflow:auto; border:solid 1px red;">   
         
        <layout:panel  key="" >

         <layout:collection id="item" name="parametre1Form" property="listacteur" styleClass="SCROLL" styleClass="FORM" width="400" >
           <layout:collectionItem title="code" property="code" sortable="true"></layout:collectionItem>
<layout:collectionItem  onclick="recupereruser('${item.user}','${item.code}','${item.aprob}');"    href="javascript:void();" title="Libelle" property="user" sortable="true"></layout:collectionItem>
<layout:collectionItem title="Etat" property="aprob" sortable="true"></layout:collectionItem>  
         </layout:collection>
</layout:panel>
</div>
</layout:cell>

 <layout:cell>
<div style="top:200;left:470;position:absolute;width:450;height:200; border:solid 1px RED;">   
 <layout:panel  key="paramètrage" styleClass="FORM"  >    
<layout:row>
<layout:column>
 <layout:write   property="writlib"  ></layout:write>
</layout:column>
<layout:column> 
<layout:text property="libelle"   key="" ></layout:text>
</layout:column>
<layout:column>
 <layout:write   property="writcod"  ></layout:write>
</layout:column> 
<layout:column> 

<layout:text size="3" property="code" key="" mode="R,R,R"></layout:text>
</layout:column>
 </layout:row>
 
 <layout:row>
 <layout:column>
      <layout:write   property="writcode1"  ></layout:write>
      </layout:column>
       <layout:column>
   <layout:text property="writcode2" key="" size="5" maxlength="3" ></layout:text>
      </layout:column>
      
      <layout:column>
<layout:select property="region" key="Région :" >
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
   <layout:button onclick="confirmer_ajouter()();">Ajouter</layout:button>
</layout:column>  
<layout:column>  
  <layout:button onclick="confirmer_supprimer()();">Supprimer</layout:button>
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
	