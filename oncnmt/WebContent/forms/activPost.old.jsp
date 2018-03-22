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
    
    <title>demande d'activation postpaid</title>
 
   <layout:skin includeScript="true"/>

  <script type="text/javascript">
  
  function combo1(){
 document.activationpostForm.libelle.disabled=true;     
<%request.setAttribute("combo1","libelle");%> 
var param='<%=request.getAttribute("combo")%>';  
}
  
  
    function combo2(){
 document.activationpostForm.profill.disabled=true;     
<%request.setAttribute("combo2","profill");%>   
    var param='<%=request.getAttribute("combo")%>'; 
}
  
      function verifcombo(){   
 var param1='<%=request.getAttribute("combo1")%>'; 
var param2='<%=request.getAttribute("combo2")%>'; 
 alert(param1)  
if (param1=="libelle")  { document.activationpostForm.libelle.disabled=true;};  
if (param2=="profill")  { document.activationpostForm.profill.disabled=true; };     
}
   </script>

 
 
   
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="test1(document.activationpostForm);activer2();">      
    
 
  <jsp:include page="menu.jsp"/>  
 
 <hr>

     <layout:form action="/preactive.do" method="post" onsubmit="return testersubmit();">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
       
        
      <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
      
      
      <layout:row>
      
              
             <layout:column>      
              <layout:button onclick="activsubmit(document.activationpostForm,'annuler');">Annuler</layout:button>
            </layout:column>
              
              <layout:column>
        <layout:button onclick="testVide2(document.activationpostForm);">Valider</layout:button>
              </layout:column>
              <layout:column>
                <layout:button onclick="activsubmit(document.activationpostForm,'editExcel');">Expoter vers Excel</layout:button>
            
              </layout:column>       
      
      
       <layout:column width="10">
      </layout:column>
      <layout:column>  
      <h3 >
       DEMANDE D'ACTIVATION POSTPAID PRE ACTIVE
      </h3>
      
  </layout:column>
        </layout:row>
        
      
   
     
          
    <layout:cell>
<div style="position:absolute;left:10px;width:850; height:230;overflow-y:scroll; border:solid 1px red;">   
 
      
           <layout:collection name="activationpostForm" property="postpaid"  styleClass="SCROLL" styleClass="FORM" width="850">
            <layout:collectionItem title="ARTICLE" property="art"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="prof" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="100" title="N° SERIE DEBUT" property="start" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="100" title="N° SERIE FIN" property="end" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="20" title="HLR" property="hlr" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="60" title="act" property="activ" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="70" title="pack" property="pack" sortable="true"></layout:collectionItem>
           <layout:collectionItem width="50" title="QTE" property="qte" sortable="true"></layout:collectionItem>         
           <layout:collectionItem title="+" property="ajouter" action="/preactive.do?hidden=afficher" paramId="article,profil,s_str,s_end,qute,rng_id,act_id" paramProperty="article,profil,s_str,s_end,qute,rng_id,act_id">
             <center> <layout:img srcName="add.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
        </layout:collection>
      
</div>
</layout:cell>

<layout:cell>
<div style="position:absolute;left:10px;top:360px;">   
   
        <layout:row width="800">
         <table border="0">
  
   <tr>
       <td> <layout:select property="article" key="Article:" onchange="activer2();">
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select> 
       </td>
       
<jsp:include page="champ2.jsp"/>

      <td> <layout:select property="profil" key="Profil:" onfocus="testArt(document.activationpostForm);">
       <layout:option value=""></layout:option>
       <layout:options property="nomProfil"></layout:options>
       </layout:select> </td>
       
       <td> <layout:button onclick="testVide1(document.activationpostForm);"> Ajouter </layout:button> </td>
   </tr>
<jsp:include page="confirmation2.jsp"/> 
   </table>
   </layout:row>
   
   </div>
   </layout:cell>
   
<layout:cell>
<div style="position:absolute;left:10px;top:440px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   

           <layout:collection name="activationpostForm" property="postpaid2" styleClass="SCROLL" styleClass="FORM" width="550">
           <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="pp" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N° SERIE DEBUT" property="st" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N° SERIE FIN" property="se" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qt" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="X" property="retirer" action="/preactive.do?hidden=Retirer" paramId="aaa,ppp,stt,see,qtt" paramProperty="aaa,ppp,stt,see,qtt">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
           </layout:collection>
 </div>
 </layout:cell>       
    
       <layout:cell>
<div style="position:absolute;left:620px;top:440px;width:250;height:140; border:solid 1px red;">             
        <layout:row>
           <layout:column>
           <layout:space></layout:space>
           
           <layout:select property="destinataire" key="Destinataire :" onchange="setHidden('remplir',document.activationpostForm);document.activationpostForm.submit();">
               <layout:option value=""></layout:option>
               <layout:options property="listDest"></layout:options>
             </layout:select>
 
              <layout:select property="libelle" key="Libelle :" >
               <layout:option value=""></layout:option>
               <layout:options property="listLib"></layout:options>
             </layout:select>
   
             <layout:select property="profill" key="profil :">
               <layout:option value=""></layout:option>
               <layout:option value="DJEZZY CLASSIC"></layout:option>
               <layout:option value="DJEZZY CONTROL"></layout:option>
             </layout:select>
     
             <layout:textarea property="note" key="Note :"></layout:textarea>

           </layout:column>
           </layout:row>
   </div>
   </layout:cell>      
      </layout:form>
     
  </body>
</html:html>
