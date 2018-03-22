  <%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<%@ page import="com.yourcompany.struts.form.RecepForm"%>
<%@ page import="org.apache.struts.action.ActionForm"%>

 
       <tr align="CENTER">
        <td align="CENTER"> <div id="le_prompt" style="display:none;;position:absolute;left:300px;">
<input type="text" id="sup"  size="15" name="confirmer start" onblur="testersup();"  onmousedown="if (event.button==2){alert('Vous ne pouvez pas  coller le contenu du champ');};" onkeydown ="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  coller le contenu du champ');} ;" onkeypress="if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){comparer(document.getElementById('fin'),document.getElementById('debut'))};">
<input type="hidden"  id="start_div" size="15" >
</div></td>


</div></td>

   </tr>
