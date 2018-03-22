  <%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>j
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<%@ page import="com.yourcompany.struts.form.RecepForm"%>
<%@ page import="org.apache.struts.action.ActionForm"%>


<td> <layout:text property="ND" size="15"  onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};" onkeydown ="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onclick="tester4();" onkeypress="if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){affPrompt(document.getElementById('ND'),document.getElementById('le_prompt'),document.getElementById('sup'))};" key="N° début"  onfocus="testArt();" onblur="tester(document.getElementById('ND'));"></layout:text> </td>
 <td> <layout:text property="NF"  size="15" onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};"onclick="tester3(document.getElementById('ND'));" onkeydown ="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onkeypress="if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){affPrompt(document.getElementById('NF'),document.getElementById('le_prompt1'),document.getElementById('sup1'))};" key="N° fin" onfocus="testArt2(document.getElementById('ND'));"  onblur="tester2(document.getElementById('NF'));"></layout:text> </td>
     