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
    
    <title>Réservation</title>
 <layout:skin includeScript="true"/>
 
     <script>
	
	var m="scratch";  
    function tester() {
    if (document.reservationForm.article.value =="SCRATCH DJEZ 3000DA"){
    document.reservationForm.prof.disabled=true;
    document.reservationForm.test.value=m;
 }

   
}

    function verif_qte_reserve()
    {
if  (document.reservationForm.quté.value==""||document.reservationForm.quté.value=="0") 
{
alert("Veuillez introduire une quantité SVP");
    }

else
{
	setHidden('afficher',reservationForm);
	reservationForm.submit();
	}

      }

    function activ_region()
    {
    	var profil ='<%=(String)request.getSession().getAttribute("profil_ajouter")%>';    
    	if (profil=="COORDINATEUR REGION")
   { document.getElementById('region').disabled=false ; }
       
    }
  </script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="activ_region();reserv(document.reservationForm);">
    


<jsp:include page="menu.jsp"/> 
 <hr>
 
 
     <layout:form action="/reservation.do" method="post">
       
          
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
         
       <layout:text property="hiddenTest"  mode="H,H,H"></layout:text>
      
       <layout:text property="hiddenTest2"  mode="H,H,H"></layout:text>
    
     <layout:row>
     
        
              
              <layout:column >
               <layout:submit onclick="setHidden('annuler',document.reservationForm);">Annuler</layout:submit>
              </layout:column>
              
               <layout:column>
                <layout:button onclick="validReserv(document.reservationForm);">Valider</layout:button>
              </layout:column>
     
      <layout:column width="150"> 
       </layout:column > 
      <layout:column> 
      <center>
      <h3>
      RESERVATION
      </h3>
       </center>
      </layout:column>
    
      </layout:row>
      
      <layout:row>
 <layout:column >
          <layout:select property="region" disabled="true" key="Sélectionnez une région SVP:" onchange="setHidden('remplir_combo',document.reservationForm);document.reservationForm.submit();" >
       <layout:option value=""></layout:option>
       <layout:option value="CENTRE"></layout:option>
        <layout:option value="EST"></layout:option>
        <layout:option value="OUEST"></layout:option>
       </layout:select>
       </layout:column>
      <layout:column>
      <layout:write   name="reservationForm"  property="writ"  ></layout:write>
      </layout:column>
      <layout:column>
         <layout:select property="destinataire" key="" onchange="setHidden('remplir',document.reservationForm);document.reservationForm.submit();">
       <layout:option value=""></layout:option>
       <layout:options property="nomDestinataire"></layout:options>
       </layout:select>
     
         </layout:column> 
         
      
          <layout:column>
         
          <layout:textarea property="note" key="Note :"></layout:textarea>
         
           
           </layout:column>
         </layout:row>
      
      <layout:cell>
     
<div style="position:absolute;left:10px;width:740; height:220; overflow:auto ;;border:solid 1px red">  
    <layout:panel  key="la liste des articles disponibles en stock " >
 
 
 
          <layout:collection width="700" name="reservationForm" property="reserv"  styleClass="SCROLL" styleClass="FORM" >
           <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
         <layout:collectionItem title="ARTICLE" property="art" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="PROFIL" property="prof" sortable="true"></layout:collectionItem>
           
           <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>         
           <layout:collectionItem title="+" property="ajouter"  action="/reservation.do?hidden=Ajouter" paramId="article,qute,whss,hllr,pqq,prff" paramProperty="article,qute,whss,hllr,pqq,prff">
             <center> <layout:img   srcName="add.GIF"  border="0" />  </center> 
           </layout:collectionItem>
        </layout:collection>
        </layout:panel>
        </div>
        </layout:cell>
    
                      <layout:space></layout:space>
   <layout:cell>
<div style="position:absolute;left:10px;top:400px;">   
          
        
         <layout:row width="850" >
        
          <layout:column>
         <layout:select property="warehouse" key="Région:" >
       <layout:option value=""></layout:option>
       <layout:options property="nomWarehouse"></layout:options>
       </layout:select>
      </layout:column> 
      
       <layout:column>
         <layout:select property="article" key="Article:" >
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select>
    </layout:column> 
         
          <layout:column >
         <layout:select   property="profil" key="Profil:" >
       <layout:option value=""></layout:option>
       <layout:option value="SWAP"></layout:option>
       <layout:options property="listprof"></layout:options>
       </layout:select>
 </layout:column> 

      </layout:row >
  
      <layout:row >   

         <layout:column> 
         <layout:number property="quté" key="Quantité:" ></layout:number>
         </layout:column> 
          <layout:column> 
          <layout:button onclick="verif_qte_reserve();"> Ajouter </layout:button> 
           </layout:column> 
         </layout:row>
        
        

       <layout:row>
          <layout:column>
    <layout:cell>
<div style="position:absolute;left:10px;width:720; height:150; overflow:auto ;">   
            
      <layout:panel  key="La liste des Articles à réserver " >   
       
           <layout:collection width="700" name="reservationForm" property="reserv2" styleClass="SCROLL" styleClass="FORM"  >
            <layout:collectionItem title="WAREHOUSE" property="wh" sortable="true"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="aa" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="pp" sortable="true"></layout:collectionItem>  
                  
              <layout:collectionItem title="QTE" property="qt" sortable="true"></layout:collectionItem>
             <layout:collectionItem title="Retirer" property="retirer" action="/reservation.do?hidden=Retirer" paramId="aaa,qtt,whs,ppp,hllr2,pqq2" paramProperty="aaa,qtt,whs,ppp,hllr2,pqq2">
            <center> <layout:img srcName="supp.GIF" border="0" />   </center>
            </layout:collectionItem>
           </layout:collection>
           </layout:panel>
  </div>
  </layout:cell>       
           </layout:column>
           
          
           
           </layout:row>
     </div>    
 </layout:cell>           
      </layout:form>
     
  </body>
</html:html>
