
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
    
    <title>ajouter</title>

	 <layout:skin includeScript="true"/>
    
    <script>
	

 

    
 function recuperprofil(param,param1)     
  {
    		document.parametre1Form.profil.value=param;
    		document.parametre1Form.whs.value=param1;

    		if (confirm("Etes-vous sûr de vouloir supprimer ce profil")) {

    			  setHidden('supprimerprofil',document.parametre1Form);
    			  parametre1Form.submit();

        		 
    		} 
    	
  }
	
	function recupereruser(param,param1,param2)     
	{
	document.parametre1Form.libelle.value=param;
	document.parametre1Form.code.value=param1;
	document.parametre1Form.activer.value=param2; 
}
	
function confirmer_activer ()
{
var acteur=document.parametre1Form.libelle.value;

if (document.parametre1Form.libelle.value=="") 
{
alert("Veuillez choisir un utilisateur SVP")
document.parametre1Form.libelle.focus();
}  
else{
	if (confirm("Etes-vous sûr de vouloir Activer/Désactiver "+acteur+"? ")) {      
  setHidden('activeracteur',document.parametre1Form);
  parametre1Form.submit();
}
}
}

function confirmer_ajouter ()
{
var lib=parametre1Form.libelle.value;
if (document.parametre1Form.libelle.value=="") 
{
alert("Veuillez saisir un utilisateur SVP")   
document.parametre1Form.libelle.focus();
}
else{
	if  (check()==true)
	{
if (confirm("Etes-vous sûr de vouloir ajouter "+lib+" ? ")) {                
  setHidden('addacteur',document.parametre1Form);  
  parametre1Form.submit();
}
}}
}

function confirmer_supprimer ()
{

var lib=parametre1Form.libelle.value;


if (document.parametre1Form.libelle.value=="") 
{
alert("Veuillez choisir un utilisateur SVP")  
document.parametre1Form.libelle.focus();
} 
else{
if (confirm("Etes-vous sûr de vouloir supprimer "+lib+" ? ")) {          
  setHidden('supprimeracteur',document.parametre1Form);
  parametre1Form.submit();
}
}
}


function confirmer_afficher ()
{

var lib=parametre1Form.libelle.value;

if (document.parametre1Form.libelle.value=="") 
{
alert("Veuillez choisir un utilisateur SVP")
document.parametre1Form.libelle.focus();
} 
else{
setHidden('afficheracteur',document.parametre1Form);
parametre1Form.submit();

}
}


function confirmer_modifer ()
{
var lib=parametre1Form.libelle.value;
if (document.parametre1Form.libelle.value=="") 
{
alert("Veuillez choisir un utilisateur SVP")  
document.parametre1Form.libelle.focus();
} 
else{

if  ((check()==true)&&(check1()==true))
	{
	if (confirm("Etes-vous sûr de vouloir ajouter Les profils selectionées ? ")) {  
  setHidden('modifacteur',document.parametre1Form);
  parametre1Form.submit();}}
}

}   



function messageparametre()
{
var param=parametre1Form.hiddenTest.value;

var lib=parametre1Form.libelle.value;
if (parametre1Form.hiddenTest.value =="") { 
}
else{
 if (parametre1Form.hiddenTest.value =="I") {
 alert(lib+" a été désactivé");
 parametre1Form.hiddenTest.value=""; 
 } 
 
 else{
 if (parametre1Form.hiddenTest.value =="A") {
 alert(lib+" a été activé"); 
 parametre1Form.hiddenTest.value=""; 
 } 
else{
 alert(param);
 parametre1Form.hiddenTest.value=""; 
 }   
 }
}
}

function confirmer_modifer ()
{

var lib=parametre1Form.libelle.value;
alert('inside add pro');
if (document.parametre1Form.libelle.value=="") 
{
alert('inside add pro1');
alert("Veuillez choisir un utilisateur SVP") ; 
document.parametre1Form.libelle.focus();
} 
else{
alert('inside add pro2');

if  ((check()==true)&&(check1()==true))
	{
	alert('inside add pro3');
	if (confirm("Etes-vous sûr de vouloir ajouter Les profils selectionées ? ")) {  
  setHidden('modifacteur',document.parametre1Form);
  parametre1Form.submit();}}
}

}
	
	
	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
<body onload="messageparametre();" >

<layout:img src="../images/entete_gss.JPG"/>
 <jsp:include page="menu_entete.jsp"/>

     <layout:form action="/parametre1.do">
  
     <layout:text property="hiddenTest" key="" mode="H,H,H" ></layout:text>
     <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
<layout:text property="activer" mode="H,H,H" >   </layout:text>
 <layout:text property="code" mode="H,H,H" >   </layout:text>
<layout:text property="profil" mode="H,H,H" >   </layout:text>
 <layout:text property="whs" mode="H,H,H" >   </layout:text>

<layout:cell>
 <div class="position_entet">
      <h2>
  Paramétrage Utilisateur
      </h2>
</div>
</layout:cell>
   <layout:space></layout:space>
 



 
   <layout:cell>
<div style="top:200;left:150px;position:absolute;width:700;height:70;border:solid 2px #990000;text-align: center; ">  
 
  <layout:row>  
  
    <layout:text property="libelle"  key="Nom  utilisateur:" >   </layout:text>
   </layout:row>   
    <layout:row>         
   <layout:button  onclick="confirmer_ajouter();">Ajouter l'utilisateur</layout:button>

  <layout:button onclick="confirmer_supprimer();">Supprimer l'utilisateur </layout:button>

  <layout:button onclick="confirmer_activer();">Activer/Désactiver</layout:button>

</layout:row>
   <layout:row>
 <layout:button onclick="confirmer_afficher();">Afficher les profils de l'utilisateur </layout:button>

<layout:button onclick="confirmer_modifer();">Ajouter les profils sélectionnés </layout:button>  
 
 
 </layout:row>
</div>
</layout:cell>

  
 <layout:cell>
<div style="top:330;left:25px;position:absolute;width:400;height:240;overflow:auto; border:solid 1px red">   
<layout:collection  id="item" name="parametre1Form" property="listprofil_user"  styleClass="FORM" width="380">
 <layout:collectionItem title="Profil Utilisateur" property="profil_user" sortable="true"></layout:collectionItem>  

<layout:collectionItem  onclick="recuperprofil('${item.profil}','${item.whs}');"    href="javascript:void();" title="supprimer profil" property="supprimer" sortable="true"></layout:collectionItem>

</layout:collection>   
</div>
</layout:cell>






 <layout:cell>
<div style="top:330;left:450px;position:absolute;width:550; height:240; border:solid 1px rd;">   

  <layout:panel key="Liste des profils des utilisateurs  :" styleClass="FORM">  
   <layout:row>
   <layout:column>
 
            
   

 
   <layout:checkbox  key="magasinier" property="magaberaki" styleClass="LABEL"/>
      
      
      
      
      <layout:checkbox  key="Adminstrateur Warehouse" property="adminwrhs" styleClass="LABEL"/>
      
      <layout:checkbox  key="Adminstrateur CDS" property="admincds" styleClass="LABEL"/>
      <layout:checkbox  key="edition des rapports" property="edition" styleClass="LABEL"/>
      
     </layout:column> 
     
       <layout:column>
       
          <layout:checkbox  key="administrateur" property="admin" styleClass="LABEL"/>    
          
    
           
    
<layout:select property="warehouse" key="Magasin :" styleClass="LABEL">
       <layout:option value=""></layout:option>
        <layout:options property="warehouselist"></layout:options>
</layout:select>
  
  
  <layout:checkbox  key="Adminstrateur Fournisseur" property="adminfrns" styleClass="LABEL"/>
      <layout:checkbox  key="Adminstrateur Partenaire" property="adminprtnr" styleClass="LABEL"/>
      <layout:checkbox  key="Adminstrateur Article" property="adminartcl" styleClass="LABEL"/>
      
  
  
  
        </layout:column> 
       </layout:row> 
       
       
          <layout:row>
   <layout:column>
       
       
    
           
 
 


 </layout:column>  
  <layout:column>    



           

        

           
  
            
       

  </layout:column>
  

  </layout:row> 


  

    
            

          

  </layout:panel>  
  </div>
  </layout:cell> 
    </layout:form>
  </body>
</html:html>
    