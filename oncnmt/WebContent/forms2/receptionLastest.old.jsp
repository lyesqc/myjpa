<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Reception</title>
 <layout:skin includeScript="true"/>
 
<script>

function checkNFKeyPress(){
        if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){affPromptByPo(document.getElementById('NF'),document.getElementById('le_prompt1'),document.getElementById('sup1'))};
        }


  
  
   
   
function envoyer()
{
var form = document.forms[0];
form.action="/gss2/recepLatest.do?hidden=loadQuantite&ligne="+form.ligneRecepNumber.value;

form.submit();


}
function cachePrompt() {
document.getElementById('le_prompt').style.display='none';
}
   
function viewListes(){
		features = "width=600,height=600,resizable=0,scrollbars=1,status=1";
		window.open("autosorti.do?hidden=listprob","parametre",features);
		
		 window.onload = function(){
		 document.recepForm.ND.onkeydown = function(e){
        var e=window.event || e;
        var touche = e.keyCode;
        if(e.keyCode==13){
            affPrompt1(document.getElementById('le_prompt').value);
        }
        else
        {
        alert("j'ai rentre mais cpas entre");
        }
    }
}

}

function testHiddenTest(){
var h = document.forms[0].hiddenTest.value;
if(h!="" && h!="null" && h!="confirmation2")
alert(document.forms[0].hiddenTest.value);
document.forms[0].hiddenTest.value ="";
}
</script>	
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  <body onload="testHiddenTest()">
  


<jsp:include page="menu.jsp"/>  

 <hr>
 
    <layout:form  action="/recepLatest.do" method="post" onsubmit="return false;">
    
      
     
      
       <layout:row>
       
       
          
           <layout:column>      
              <layout:button onclick="activsubmit(document.recepForm,'annuler');">Annuler</layout:button>
            </layout:column>
              <layout:column>
    <layout:button onclick="setHidden('valider2',document.forms[0]);document.forms[0].submit()">Valider</layout:button>
            </layout:column>
           <layout:column>
                <layout:button onclick="activsubmit(document.recepForm,'exporter');">Exporter vers Excel</layout:button>
            
              </layout:column>
            
            <layout:column width="70">
            </layout:column> 
            
      <layout:column>  
      <h3 >
     RECEPTION
      </h3>
  </layout:column>
        </layout:row>
 <layout:panel key="Informations de réception:" styleClass="FORM" width="600">
      
         
          <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
          <layout:text property="hiddenTest"  mode="H,H,H"></layout:text>
          <layout:text property="frns" key="Fournisseur :" ></layout:text>
          <layout:text property="ref" key="N° Ref Ext:" ></layout:text>
          <layout:text property="po_Num" key="N° PO :"></layout:text>
          <layout:textarea property="note" key="Emplacement :"></layout:textarea>
          <layout:select property="ligneRecepNumber"  key="Numero ligne :" onchange="envoyer();">
          <layout:optionsCollection    property="recepLines" label="label" value="value" />
          <logic:notEqual value="null" name="RecepLatestForm" property="qte">
          <layout:text property="art_id" key="Article :" mode="R,R,R"></layout:text>
          <layout:text property="magas" key="Magasin :" mode="R,R,R"></layout:text> 
          <layout:text property="qte" key="Quantite :" mode="R,R,R"></layout:text>
          </logic:notEqual>
          </layout:select>
          
      </layout:panel>
      
        <layout:space></layout:space>
        
         
      
       <layout:row width="800">
         <table border="0">
  
   <tr>
       <td> 
       
       
       </td>
       
       
       
    
 
        
       
       <td>  </td>
       
       
      
      
       
       <td>  <layout:text property="ND" size="15"  onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};" onkeydown ="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onclick="activer03();" onkeypress="if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){affPromptByPo(document.getElementById('ND'),document.getElementById('le_prompt'),document.getElementById('sup'))};" key="N° début"  onfocus="testArt();" onblur="tester(document.getElementById('ND'));"></layout:text> </td>
 <td> <layout:text property="NF"   size="15" onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};" onclick="tester3(document.getElementById('ND'));" onkeydown="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onkeypress="checkNFKeyPress()" key="N° fin" onfocus="testArt2(document.getElementById('ND'));"  onblur="tester2(document.getElementById('NF'));"></layout:text> </td> 
       <td><layout:button  onclick="testVid2new(document.RecepLatestForm);" >Ajouter</layout:button> </td>
   </tr>
  
   
   
     <jsp:include page="confirmation2.jsp"/> 
   </table>
  
  
   </layout:row>
   
     <layout:space></layout:space>
   
 
  
         
   <layout:cell>
 
<div style="position:absolute;left:10px;width:650; height:170;overflow-y:scroll;">  
 
          
          <layout:collection name="RecepLatestForm" property="recepAddList" styleClass="SCROLL" styleClass="FORM" width="630">
           <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="SERIAL_START" property="ND" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="SERIAL_END" property="NF" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N° Ligne" property="num_ligne" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="X" property="retirer" action="/recepLatest.do?hidden=Retirer" paramId="ss,ff" paramProperty="ND,NF">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
           </layout:collection>
</div>
</layout:cell>
           

 
   

   </layout:form>
 
   
  </body>
  
</html:html>
