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
   
    <title>Annulation</title>
    
     <layout:skin includeScript="true"/>
 
  
   
     <script type="text/javascript">
     function setHidden(value){document.rechercheForm.hidden.value=value;}  
   </script>
   
     <script type="text/javascript">
  function recuper_code_annulation(par){         
  alert(par);  
document.getElementById('code').value=par; 
 alert(document.getElementById('code').value=par);            
activsubmit(document.rechercheForm,'valider');     
  } 
  
  
  function verif_annuler()
		{
		if(document.rechercheForm.nrec.value=="" && document.rechercheForm.transaction.value=="" && document.rechercheForm.dat_rec_du.value=="" && document.rechercheForm.dat_rec_au.value=="" && document.rechercheForm.responsable.value=="" && document.rechercheForm.article.value=="" && document.rechercheForm.debut.value=="" && document.rechercheForm.fin.value=="")
		
		{	 alert('veuillez remplir un des critères de recherche,SVP!');	}	
		
		else {
		
		  setHidden('chercher');		  
		  document.rechercheForm.submit();
		}
		 
		}
		
		    function effacer_annuler(form)
		{
		document.rechercheForm.nrec.value="";
		document.rechercheForm.transaction.value="";
       document.rechercheForm.dat_rec_du.value="";
		document.rechercheForm.dat_rec_au.value="";
		document.rechercheForm.responsable.value="";
         document.rechercheForm.article.value="";
        document.rechercheForm.debut.value="";
		document.rechercheForm.fin.value="";
      
				
		}
		
		  function valider_annulation()
		{
	
		
		  setHidden('valider');		  
		  document.rechercheForm.submit();
		}
		 
		
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
  
  <body onload="testannuler();activer();">
   

  
 <jsp:include page="menu.jsp"/> 
 <hr>
 

    <layout:form action="/annuler.do" method="post" onsubmit="return testersubmit();">
  <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
  <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
  

  <layout:text property="code"  mode="H,H,H"></layout:text>
  <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
  <layout:text property="rng_pere"  mode="H,H,H"></layout:text>
  <layout:text property="act_pere"  mode="H,H,H"></layout:text>
   
   
   <layout:row >
            
  
       <layout:column width="100">
      </layout:column>
      <layout:column>  
      <h3 >
      Annulation Transaction 
      </h3>  
  </layout:column>  
        </layout:row>  
        
        
      <layout:panel key="Recherche des transactions :" styleClass="FORM">
  
       <layout:row>
                  <layout:column>
                        <layout:text property="nrec" key="Code de transaction :"></layout:text>
                        <layout:select property="transaction" key="Type de transaction :">
                            <layout:option value=""></layout:option>
                            <layout:options property="typeTrans"></layout:options>
                        </layout:select>
                     
                        <layout:row>   
                         <layout:column>
                       <layout:date property="dat_rec_du" key="Date transaction Du :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date debut"  ></layout:date>
                       </layout:column>
                     
                         </layout:row>
                         
                          <layout:row>   
                         <layout:column>
                        <layout:date property="dat_rec_au" key="Date transaction Au :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date fin"  ></layout:date>
            </layout:column>
             
                         </layout:row>
           
                  </layout:column>
             
              <layout:column>
              
                 <layout:select property="responsable" key="Responsable :">
                            <layout:option value=""></layout:option>
                            <layout:options property="nomResp"></layout:options>
                        </layout:select>
              
                   <layout:select property="article" key="Article :">
                         <layout:option value=""></layout:option>
                         <layout:options property="listarticle"></layout:options>
                   </layout:select>
              
                   
            
                   
                   <layout:number property="debut" key="N° SERIE  Du :" maxlength="15"></layout:number>
                    <layout:number property="fin" key="N° SERIE  Au :" maxlength="15"></layout:number>
                </layout:column>
                
                  
       </layout:row>
       <layout:row width="800"> 
          <layout:column width="100" ></layout:column>
          <layout:column width="100"> <layout:button onclick="effacer_annuler(this.form)">Réinitialiser</layout:button>  </layout:column>
          <layout:row> </layout:row>
          <layout:column> <layout:button onclick="verif_annuler();">Rechercher</layout:button> </layout:column>
  <layout:column> <layout:button onclick="valider_annulation();">annuler la transaction </layout:button>  </layout:column>
 </layout:row>
       
    
    </layout:panel>    
        
        
    <layout:space></layout:space>    
     <layout:space></layout:space>     
  
        <logic:notEmpty property="resultat" name="rechercheForm">
 
  <layout:cell>
<div style="position:absolute;left:10px;width:620; height:500; overflow:auto; border:solid 1px black;">   
 
     <layout:collection styleId="resultat" selectName="code_art" selectProperty="code" selectType="radio" name="rechercheForm" property="resultat" styleClass="SCROLL"  styleClass="FORM" width="600" >
 <layout:collectionItem title="CODE TRANSACTION" property="code" sortable="true"></layout:collectionItem>
<layout:collectionItem title="___DATE___" property="date" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="RESPONSABLE" property="resp" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="DESTINATAIRE" property="dest" width="200" sortable="true"></layout:collectionItem>
  
  
    </layout:collection>
  
</div>
</layout:cell>
  
 </logic:notEmpty > 
 <logic:present parameter="hidden" scope="request">
    <logic:equal value="chercher" parameter="hidden" scope="request">
       <logic:present name="rechercheForm" >
         <logic:empty name="rechercheForm" property="resultat">
        
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <layout:message key="aucun resultat corespondant"/>
         </layout:panel>
       
         </logic:empty>
       </logic:present>
    </logic:equal>
 </logic:present>  
   
 <layout:cell>
<div style="position:absolute;left:630px;width:40;height:60; border:solid 1px red;">             
         
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
