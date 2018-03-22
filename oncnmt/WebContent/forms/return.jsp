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
    
    <title>RETOUR FOURNISSEUR</title>
    
    	 <layout:skin includeScript="true"/>
    
    <script>
    
     function  choisirdist()
     {
if  (document.returnForm.distination.value=="" )    
   {
   alert("vous devrez choisir un destinataire");  
   }
   else{
 javascript:window.open('autosorti.do?hidden=listaprob','','location=100,status=0,scrollbars=0,width=750,height=350');void('');
 
    }
    }
   
   
   
   function  submiter()
    {
     if  (document.getElementById('reserv').value=="sans reserv" )
     { 
    if (document.returnForm.magasourc.value=="" )  
   {
   alert("vous devrez choisir un magasin");
   }
   else{
   
     if   (document.returnForm.distination.value=="" )
   {
   alert("vous devrez choisir un destinataire");
   }
   else
   {
    setHidden('chercher',document.returnForm);
    document.returnForm.submit();}
    }
    }
 }
    
	
	    var w2;
    function Ouvrir(url) {
w2=window.open(url,'_blank','width=790,height=500,top=200,left=300,scrollbars=1,resize=1');
    }



	function viewListes(){
		features = "width=600,height=600,resizable=0,scrollbars=1,status=1";
		window.open("autosorti.do?hidden=listaprob","parametre",features);
}

function setHidden(value,frm){frm.hidden.value=value;}
	
var m;
function activ()

{

m=document.returnForm.magasourc.value;
document.returnForm.mag.value=m;
document.returnForm.magasourc.disabled=true;
}


var m1;
function activ1()
{

m1=document.returnForm.distination.value;
document.returnForm.dis.value=m1;
document.returnForm.distination.disabled=true;
}


	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>

   
   <body onload="test8();activer();">
    
 <jsp:include page="menu.jsp"/>  
 
   
    <layout:form action="/return.do" method="post" onsubmit="return testersubmit();">
 <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
  <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
   <layout:text property="mag" key="mag"  mode="H,H,H"></layout:text>
    <layout:text property="dis" key="dis"  mode="H,H,H"></layout:text>
     <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
   
        
 <layout:row>
  <layout:column>      
              <layout:button onclick="activsubmit(document.returnForm,'annuler');">Annuler</layout:button>
            </layout:column>
 
  
 
   <layout:column >
              
         <layout:button onclick="valid60();">valider</layout:button>
            
              </layout:column>
            
             <layout:column>
           <!--      <layout:button onclick="activsubmit(document.returnForm,'editExcel');">Expoter vers Excel</layout:button>
             -->
              </layout:column>
 
 
       <layout:column width="70">
      </layout:column>
      <layout:column>  
      <h3 >
       returnEGRATOON 
      </h3>
  </layout:column>
        </layout:row>
   
    
     
  
	  <layout:row>
	  
	   <layout:select  property="magasourc" key=" magasin:" >
          <layout:option value=""></layout:option>
          <layout:options property="listmaga"></layout:options>
          </layout:select>
          
          <layout:column> 
    <layout:select  property="distination" key="Fournisseur:"   >
          <layout:option value=""></layout:option>
          <layout:options property="listdist"></layout:options>
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
     <layout:column width="350">  </layout:column> 
    <layout:column> 
  <layout:button onclick="chercher_retour();">afficher les rangs </layout:button>
       </layout:column>     	
 </layout:row> 
 
  <logic:notEmpty property="resulrang" name="returnForm" >
 <layout:cell>
<div style="position:absolute;left:10px;width:850; height:230;overflow-y:scroll; border:solid 1px red;">   
 
    <layout:collection id="item" name="returnForm" property="resulrang" styleClass="SCROLL" styleClass="FORM"  width="850" >
       <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
       <layout:collectionItem title="N° SERIE DEBUT" property="start"></layout:collectionItem>
      
            
 <layout:collectionItem  onclick="recuperparametre('${item.art}','${item.st}');"    href="javascript:void();" title="ajouter" property="ajouter" sortable="true">
   <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center> 
</layout:collectionItem>
    
    </layout:collection>
  
</div>
</layout:cell>  

  
  </logic:notEmpty>    
    
   <logic:present  parameter="hidden" scope="request" >
	     <logic:equal value="chercher" parameter="hidden" scope="request">
	      <logic:present name="returnForm"   >
	     <logic:empty property="resulrang" name="returnForm" >
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
<div style="position:absolute;left:10px;top:380px;">   
         	      
	       <layout:row width="800">
         <table border="0">
  
   <tr>
       <td> <layout:select  property="article" key="article:" onchange="activer();">
          <layout:option value=""></layout:option>
          <layout:options property="listarticle"></layout:options>
          </layout:select></td>
<jsp:include page="champ.jsp"/>
       <td> 
       </td>
       
       <td> <layout:button onclick="testVidd(document.returnForm);"> Ajouter </layout:button> </td>
   </tr>
 
   </table>
   </layout:row>
   </div>
   </layout:cell>
   
    <layout:space></layout:space>
 <layout:cell>
<div style="position:absolute;left:10px;top:440px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   

         
             <layout:collection name="returnForm" property="listajouter" styleClass="SCROLL"  styleClass="FORM" width="550">
                <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
                
                <layout:collectionItem title="N° SERIE DEBUT" property="stt"></layout:collectionItem>
                
                <layout:collectionItem title="X" property="retirer" action="/autosorti.do?hidden=Retirer" paramId="aaa,ppp,st,see,qt" paramProperty="aaa,ppp,st,see,qt">
                <center> <layout:img srcName="supp.GIF" border="0"/>  </center>                
                </layout:collectionItem>
             
             </layout:collection>
</div>
</layout:cell>
   <layout:cell>
<div style="position:absolute;left:620px;top:440px;width:250;height:140; border:solid 1px red;">             
      
      <layout:row>       
             <layout:column >
 
  <layout:textarea property="note" key="Note:"></layout:textarea>
    
           
      </layout:column>
    </layout:row>
   </div>
   </layout:cell> 
    
 
 
 
 
 
     
    </layout:form>
  </body>
</html:html>






