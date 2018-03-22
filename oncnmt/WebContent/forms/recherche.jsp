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

   
    
    <title>Rapport des transactions</title>
    <layout:skin includeScript="true"/>
    
      <script type="text/javascript">
	
	     function setHidden(value){document.rechercheForm.hidden.value=value;}
	
	    
	      function recuperannuler(par1){    
	   document.rechercheForm.hidden1.value=par1;
	 setHidden('rapportapprob_annul',document.rechercheForm)   
 rechercheForm.submit(); 
	      
	      }
	      
	    function activernum(){
		
		
		if(document.getElementById('type').value=="SIM")
		{document.getElementById('sdu').maxLength="12";
		document.getElementById('sau').maxLength="12";
		document.getElementById('sdu').disabled=false;
		document.getElementById('sau').disabled=false;
}
		if(document.getElementById('type').value=="SCRATCH")
		{
		document.getElementById('sdu').maxLength="15";
		document.getElementById('sau').maxLength="15";
		document.getElementById('sdu').disabled=false;
		document.getElementById('sau').disabled=false;
		}
}
	    
	    
	    function effacer(form)
		{
		document.rechercheForm.nrec.value="";
		document.rechercheForm.transaction.value="";
	
		document.rechercheForm.dat_rec_du.value="";
		document.rechercheForm.dat_rec_au.value="";
		document.rechercheForm.responsable.value="";
		document.rechercheForm.warehouse.value="";
		document.rechercheForm.packaging.value="";
		document.rechercheForm.HLR.value="";
		document.rechercheForm.PQ.value="";
		document.rechercheForm.article.value="";
		document.rechercheForm.profil.value="";
		document.rechercheForm.position.value="";
		document.rechercheForm.type.value="";
		document.rechercheForm.sdu.value="";
		document.rechercheForm.sau.value="";
		document.rechercheForm.heur1.value="";  
		document.rechercheForm.heur2.value=""; 
		document.rechercheForm.dispatch_tabs.value="";
		document.rechercheForm.destination.value="";       
				
		}
		
	function afich()
	{
setHidden('exporter')	   
rechercheForm.submit(); 
//features = "width=1,height=1,resizable=0,scrollbars=1,status=1";    
//window.open("recherche1.do?hidden=exporter","parametre",features);  
//window.navigate("autosorti.do?hidden=listaprob");  
  }


		function recuperannuler(par)   
		{	
	alert(par);
	
	}
		function verif()
		{
		if(document.rechercheForm.nrec.value=="" && document.rechercheForm.transaction.value=="" && document.rechercheForm.dat_rec_du.value=="" && document.rechercheForm.dat_rec_au.value=="" && document.rechercheForm.responsable.value=="" && document.rechercheForm.warehouse.value=="" && document.rechercheForm.packaging.value=="" && document.rechercheForm.HLR.value=="" && document.rechercheForm.PQ.value=="" && document.rechercheForm.article.value=="" && document.rechercheForm.profil.value=="" && document.rechercheForm.position.value=="" && document.rechercheForm.type.value=="" && document.rechercheForm.sdu.value=="" && document.rechercheForm.sau.value=="")
		
		{	 alert('veuillez remplir un des critères de recherche,SVP!');	}	
		
		else {
		
		  setHidden('Rechercher');		  
		  document.rechercheForm.submit();
		}
		 
		}
		

		  function CheckDateField(oField, isMandatory)
{ var fValue = oField.value, ok;
  //ok = (fValue == "") ? (isMandatory != true) : ((fValue=CheckDate(fValue)) != null); 
  ok = (fValue == "") ? true : ((fValue=CheckDate(fValue)) != null); 
  if (ok) oField.value = fValue; else oField.focus();
  return ok;
}

//Date String validation
function CheckDate(tDate)  
{ var sDate, aDate, tDay, tMonth, tYear;
  sDate = "" + tDate;
  //alert("CheckDate:Start,  sDate="+sDate);
  aDate = sDate.split("/");
 
  if (aDate.length!=3) { alert("Bad Date: Format is DD/MM/yyYY"); return null }
  tDay  = aDate[0];
  tMonth= aDate[1];
  tYear = aDate[2];
  if (isNaN(tDay  )) { alert("Day should be numeric value");   return null;}  else tDay  = Number(tDay);
  if (isNaN(tMonth)) { alert("Month should be numeric value"); return null;}  else tMonth= Number(tMonth);
  if (isNaN(tYear )) { alert("Year should be numeric value");  return null;}  else tYear = Number(tYear);
  

  if (tMonth==2) i2=( ((tYear%4==0)||(tYear%400==0)) ? 29 : 28 );
  else           i2=( ((tMonth==4)||(tMonth==6)||(tMonth==9)||(tMonth==11)) ? 30 : 31);
  
  if ( (tDay < 1) || (tDay > i2) ) { alert("Day should be between 01 and "+i2); return null; }
  if ( (tMonth < 1) || (tMonth > 12) ) { alert("Month should be between 01 and 12."); return null; }
  if ( (tYear <1 ) ) { alert("Year error ."); return null;}

  sDate = (tDay>9?"":"0")+tDay +"/"+ (tMonth>9?"":"0")+tMonth +"/"+ tYear;
 
  return sDate;
}
	
		
		
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


    
  
  
    <layout:form action="/recherche1.do" method="post">
    <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
     <layout:text property="hidden1" value="default" mode="H,H,H"></layout:text>
     
     
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
                        <layout:column>
                       <layout:text property="heur1" key="heure:" size="8" maxlength="8" ></layout:text>
                       </layout:column>
                         </layout:row>
                         
                          <layout:row>   
                         <layout:column>
                        <layout:date property="dat_rec_au" key="Date transaction Au :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date fin"  ></layout:date>
            </layout:column>
                        <layout:column>
            <layout:text property="heur2" key="heure:" size="8"  maxlength="8"></layout:text>
          </layout:column>
                         </layout:row>
         <layout:row>   
          <layout:column>
       <layout:select property="responsable" key="Responsable :">
                            <layout:option value=""></layout:option>
                            <layout:options property="nomResp"></layout:options>
                        </layout:select>
           </layout:column>   
            <layout:column>           
   <layout:select property="destination" key="destination :">
   <layout:option value=""></layout:option>
    <layout:options property="listdestination"></layout:options>
    </layout:select>
     </layout:column>
          </layout:row>   
           
                        
                  </layout:column>
                  <layout:column>
                       <layout:select property="warehouse" key="Warehouse :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomWarehouse"></layout:options>
                       </layout:select>
                       
                       
                         
                        
                       
                        
                       
                       
                  </layout:column>
              <layout:column>
                   <layout:select property="article" key="Article :">
                         <layout:option value=""></layout:option>
                         <layout:options property="nomArticle"></layout:options>
                   </layout:select>
                  
                   
                    
                   
                   <layout:number property="sdu" key="N° SERIE  Du :" maxlength="15"></layout:number>
                    <layout:number property="sau" key="N° SERIE  Au :" maxlength="15"></layout:number>
                </layout:column>
                
                  
       </layout:row>
       <layout:row width="800"> 
          <layout:column width="100" ></layout:column>
          <layout:column width="100"> <layout:button onclick="effacer(this.form)">Réinitialiser</layout:button>  </layout:column>
          <layout:row> </layout:row>
          <layout:column> <layout:button onclick="verif();">Rechercher</layout:button> </layout:column>
      <layout:column> <layout:button  onclick="afich();">exporter vers EXCEL</layout:button > </layout:column>
     
     </layout:row>
       
    
    </layout:panel>
    
   
    
 <logic:notEmpty property="resultat" name="rechercheForm">
 <layout:cell>
<div style="position:absolute;left:10px;width:1080; height:1000; overflow:auto; border:solid 1px black;">   
 
     <layout:collection  id="item"  model="fixedHeader" name="rechercheForm" property="resultat" styleClass="SCROLL" length="2160" styleClass="FORM" >
       <layout:collectionItem title="BON TRANSACTION" property="bon" action="/recherche1.do?hidden=visualiser" paramId="code_art" paramProperty="code_art">
       <center> Visualiser Bon </center>
       </layout:collectionItem>
        
     <layout:collectionItem title="CODE TRANSACTION" property="code" sortable="true"></layout:collectionItem>
      
     <layout:collectionItem title="DESTINATAIRE" property="dest" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="___DATE___" property="date" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="RESPONSABLE" property="resp" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="____ARTICLE____" property="art" width="200" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="N° SERIE " property="start" sortable="true"></layout:collectionItem>
     
      <layout:collectionItem title="TRANSFERT" property="tra" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="SORTIE" property="sor" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="REINTEGRATION" property="reint" sortable="true"></layout:collectionItem> 
       
  
     </layout:collection>
</div>
</layout:cell>
 </logic:notEmpty > 
 <logic:present parameter="hidden" scope="request">
    <logic:equal value="Rechercher" parameter="hidden" scope="request">
       <logic:present name="rechercheForm" >
         <logic:empty name="rechercheForm" property="resultat">
        
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <layout:message key="Aucun résultat correspondant"/>
         </layout:panel>
       
         </logic:empty>
       </logic:present>
    </logic:equal>
 </logic:present>  
    
    </layout:form>
   
   
  
  
   
    
  </body>
</html:html>
