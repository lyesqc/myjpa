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
    
    <title>reintegr.jsp</title>

	 <layout:skin includeScript="true"/>
 <script type="text/javascript" src="config/javascript.js">
   
   </script>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="test7();activer();">
 
<jsp:include page="menu.jsp"/> 
 <hr>
 <layout:form action="/reintegr.do" method="post" onsubmit="return false;">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
        <layout:text property="rng_id"  mode="H,H,H"></layout:text>
  <layout:text property="act_id"  mode="H,H,H"></layout:text>
    
    <layout:row >
           
             <layout:column>
            
               <layout:button onclick="valid5();">Valider</layout:button>
              </layout:column>
              
              <layout:column>
           <!--      <layout:button onclick="activsubmit(document.reintegrForm,'editExcel');">Expoter vers Excel</layout:button>
             -->
              </layout:column> 
          
       <layout:column width="70">
      </layout:column>
      <layout:column>  
      <h3 >
     REINTEGRATION
      </h3>
  </layout:column>
        </layout:row>
     
          
      <layout:cell>
<div style="position:absolute;left:10px;width:850; height:230;overflow-y:scroll; border:solid 1px red;">   
 <layout:collection id="item"  name="reintegrForm" property="resulrang"  styleClass="SCROLL" styleClass="FORM" width="850" >
            <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
           <layout:collectionItem title="N° SERIE DEBUT" property="start"></layout:collectionItem>
           <layout:collectionItem title="N°SERIE FIN" property="end"></layout:collectionItem>
         
           <layout:collectionItem title="ACTIVATION" property="active"></layout:collectionItem>
           <layout:collectionItem title="PACKAGING" property="packag"></layout:collectionItem>
            <layout:collectionItem title="HLR" property="hlr"></layout:collectionItem>
         <layout:collectionItem title="PQ" property="pq"></layout:collectionItem>
         
           <layout:collectionItem title="QTE" property="qte"></layout:collectionItem>         
          
 <layout:collectionItem  onclick="recuperparametre('${item.art}','${item.prof}','${item.st}','${item.nd}','${item.rng_id}','${item.act_id}');"    href="javascript:void();" title="ajouter" property="ajouter" sortable="true">
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
       <td> <layout:select property="article" key="Article:" onchange="activer();">
       <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select> </td>
     
      <jsp:include page="champ.jsp"/> 
    <td> <layout:select property="profil" key="Profil:">
       <layout:option value=""></layout:option>
       <layout:options property="listprof"></layout:options>
        <layout:option value="SWAP"></layout:option>
       </layout:select> </td>
       
        <td> <layout:button onclick="testVidd(document.reintegrForm);"> Ajouter </layout:button> </td>
  
       </tr>
   <jsp:include page="confirmation.jsp"/> 
   </table>
   </layout:row>
 
 </div>
 </layout:cell>
 
 <layout:cell>
<div style="position:absolute;left:10px;top:420px;width:570;overflow-y:scroll;height:140; border:solid 1px red;">   
 
             
              
           <layout:collection name="reintegrForm" property="listajouter" styleClass="SCROLL" styleClass="FORM" width="550" >
           <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="proff" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N° SERIE DEBUT" property="stt" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="N°SERIE FIN" property="endd" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qtt" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="X" property="retirer" action="/reintegr.do?hidden=Retirer" paramId="aaa,ppp,st,see,qt" paramProperty="aaa,ppp,st,see,qt">
            <center> <layout:img srcName="supp.GIF" border="0"/>  </center>
            </layout:collectionItem>
           </layout:collection>
           </div>
           </layout:cell>
    
    <layout:cell>
<div style="position:absolute;left:620px;top:420px;width:250;height:140; border:solid 1px red;">             
          
   <layout:row>       
       <layout:column>
     
         
      
           <layout:text property="doc" key="documents partenaire:" ></layout:text>        

           <layout:textarea property="note" key="Note:"></layout:textarea>
        
          </layout:column>
     </layout:row>
           
    </div>
    </layout:cell>   
             
      </layout:form>
     
  </body>
</html:html>
	