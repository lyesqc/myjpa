
/**
 * struts-layout core javascript
 *
 * All rights reserved.
 */
 
 //////////debut modif pour la date 18/02/2009
 

/*function printCalendar(day1, day2, day3, day4, day5, day6, day7, first, month1, month2, month3, month4, month5, month6, month7, month8, month9, month10, month11, month12, day, month, year) {
    document.write('<div id="caltitre" style="z-index:10;">');    
    document.write('<table cellpadding="0" cellspacing="0" border="0" width="267">');
    document.write('<tr><td colspan="15" class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
    document.write('<tr>');
    document.write('    <td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=20></td>');
    document.write('    <td class="CALENDARTITLE" colspan="3" align="right"><img src="' + imgsrc + 'previous.gif" onclick="cal_before(' + day + ');"></td>');
    document.write('    <td colspan=7 align="center" class="CALENDARTITLE" nowrap>');
    
    // month
    document.write('<select id="calmois" name="calmois" onchange="cal_chg(' + day + ');"><option value=0>...</option>');    
    
    // use the good day for week start.
    // store the day the week start for later.
    calweekstart = first;    
    // compute an array of the days, starting from Sunday.
    caldays = new Array(7);
    caldays[0] = day1;
    caldays[1] = day2;
    caldays[2] = day3;
    caldays[3] = day4;
    caldays[4] = day5;
    caldays[5] = day6;
    caldays[6] = day7;
    // compute an array of the days, starting at the good day.
    computedcaldays = new Array(7);
    for (i=0; i<7; i++) {        
        computedcaldays[(i+1-calweekstart+7)%7] = caldays[i];
    }
            
    for(i=1;i<=12;i++) {
        var str='<option value=' + i + '>';
        monthIndex = i-1;
        switch (monthIndex) {
            case 0: str += month1; break;
            case 1: str += month2; break;
            case 2: str += month3; break;
            case 3: str += month4; break;
            case 4: str += month5; break;
            case 5: str += month6; break;
            case 6: str += month7; break;
            case 7: str += month8; break;
            case 8: str += month9; break;
            case 9: str += month10; break;
            case 10: str += month11; break;
            case 11: str += month12; break;
        }
        document.write(str);
    }    

    document.write('</select>');
    
    // year
    document.write('<select id="calyear" name="calyear" onchange="cal_chg('+ day + ');">');    
    document.write("</select>");
    
    document.write('    </td>');
    document.write('    <td class="CALENDARTITLE" align="left" colspan="3"><img src="' + imgsrc + 'next.gif" onclick="cal_after(' + day + ');">&nbsp;&nbsp;<img src="' + imgsrc + 'close.gif" onclick="hideCalendar()"></td>');
    document.write('    <td class="CALENDARBORDER" width=1><img src="' + imgsrc + 'shim.gif" width="1" height="1"></td>');
    document.write('</tr>');
    
    document.write('<tr id="caltimeline"><td colspan=15 class="CALENDARBORDER"><font style="color:#ffffff;font-size:8pt;padding-left:10px">Choix d\'une heure</font> <input id="caltime" type="text" style="text-align:center" size="8" maxlength="8" onkeypress="return timeKeysAllowed(event)"/> <font style="color:#ffffff;font-size:8pt">(hh:mm:ss)</font></td></tr>');

    document.write('<tr><td colspan=15 class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
    document.write('<tr>');
    document.write('    <td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[0] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[1] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[2] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[3] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[4] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[5] + '</td>');
    document.write('    <td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('    <td class="CALENDRIER" width="38">' + computedcaldays[6] + '</td>');
    document.write('    <td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
    document.write('</tr>');
    document.write('<tr><td colspan=15 class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
    document.write('</table>');
    document.write('</div>');
    document.write('<div id="caljour" style="z-index:10;"></div>');    
}
*/
/**
 * Show the calendar
 */
 
 
 /*
function showCalendar(year, month, day, pattern, formName, formProperty, event, startYear, endYear) 
{
    try
    {
        if (document.forms[formName].elements[formProperty].disabled) 
        {
            return;
        }
    }
    catch (e)
    {
        
    }
    
    if (startYear!=null) {
        var calyear = document.getElementById("calyear");
        for (i = startYear; i <= endYear; i++) {            
            calyear.options[i - startYear] = new Option(i,i);
        }
        calyear.options.length = endYear - startYear + 1;
        if ( startYear == endYear ) calyear.style.display="none";
    }

    if(document.all) {
        // IE.
        var ofy=document.body.scrollTop;
        var ofx=document.body.scrollLeft;
        document.all.slcalcod.style.left = event.clientX+ofx+10;
        document.all.slcalcod.style.top = event.clientY+ofy+10;
        document.all.slcalcod.style.visibility="visible";
        document.all.calmois.selectedIndex= month;
    } else if(document.layers) {
        // Netspace 4
        document.slcalcod.left = e.pageX+10;
        document.slcalcod.top = e.pageY+10;
        document.slcalcod.visibility="visible";
        document.slcalcod.document.caltitre.document.forms[0].calmois.selectedIndex=month;
    } else {
        // Mozilla
        var calendrier = document.getElementById("slcalcod");
        var ofy=document.body.scrollTop;
        var ofx=document.body.scrollLeft;
        calendrier.style.left = event.clientX+ofx+10;
        calendrier.style.top = event.clientY+ofy+10;
        calendrier.style.visibility="visible";
        document.getElementById("calmois").selectedIndex=month;
    }
    
    if (document.forms[formName].elements[formProperty].stlayout) 
    {
        var lc_day = document.forms[formName].elements[formProperty].stlayout.day;
        var lc_month = document.forms[formName].elements[formProperty].stlayout.month;
        var lc_year = parseInt(document.forms[formName].elements[formProperty].stlayout.year);
        
        cal_chg(lc_day, lc_month, lc_year);
    } else {
        cal_chg(day, month, year);    
    }
    
    // Traitement de la partie heure
    // =============================
    try
    {
        var field = document.forms[formName].elements[formProperty];
        var dateTimeValue = field.value;
        if ( field.size > 10 )
        {
            if ( dateTimeValue != null )
            {
                var dt = dateTimeValue.split(" ");
                if ( dt.length > 1 )
                {
                    document.getElementById("caltime").value = dt[1];
                }
            }
        }
        else document.getElementById("caltimeline").style.display = "none";
    }
    catch (e) 
    {
        try
        {
            document.getElementById("caltimeline").style.display = "none";
        }
        catch (e) { alert(e.message); }
    }
        
    if (document.all) {
        hideElement("SELECT");
    }
    calformname = formName;
    calformelement = formProperty;
    calpattern = pattern;
}

function formatDate(day, month, year) 
{
    var date = "";
    var pos = 0;
    var pattern;
    var previousPattern;
    var patternLength = 0;
    if (calpattern!=null && calpattern.length>0) {        
        previousPattern = calpattern.charAt(0);
        while (pos <= calpattern.length) {
            if (pos < calpattern.length) {
                pattern = calpattern.charAt(pos);
            }  else {
                pattern = "";
            }
            if (pattern != previousPattern) {            
                switch (previousPattern) {
                    case 'y':
                        date += padYear(year, patternLength);                
                        break;
                    case 'M':
                        date += padNumber(month, patternLength);
                        break;
                    case 'd':
                        date += padNumber(day, patternLength);
                        break;
                    case '\'':
                        // PENDING
                        break;
                    default:
                        date += previousPattern;
                }
                previousPattern = pattern;
                patternLength = 0;
            }
            patternLength++;
            pos++;
        }
    }

    try
    {
        var valueTime = document.getElementById("caltime").value;
        if ( valueTime.length > 0 )
        {
            valueTime += ":00:00:00";
            var h = valueTime.split(":");
            
            var msg = "";
            if ( h[0] > 23 ) msg += "Heures incorrectes";
            if ( h[1] > 59 ) msg += "Minutes incorrectes";
            if ( h[2] > 59 ) msg += "Secondes incorrectes";
            if (msg.length > 0)
            {
                alert(msg);
                return null;
            }
            date += " ";
            date += h[0];
            date += ":" + h[1];
            date += ":" + h[2];
        }
    }
    catch (e)
    {
    }
    return date;
}
*/
 
////////////// fin de modif pour la date 18/02/2009
 
 
 
// Dynamic result update
// for mathDataCollection on CollectionInputTab
function roundNum (number,X){
	return Math.round(number*Math.pow(10,X))/Math.pow(10,X);
}

function mathDataUpdate (operation, resultId, tableId, columnId, rowsNumber){
	var result = document.getElementById(resultId);
	newResult = 0.0;
	if  (operation=="sum"){
		for (i=0; i<rowsNumber; i++) {
			var cel = document.getElementById("mathData_t" + tableId + "l" + i +"c" + columnId);
			if (isNaN(parseFloat(cel.value))){
				alert("\"" + cel.value + "\"" + " is not a number");
				return false;
			}		
			newResult = parseFloat(newResult) + parseFloat(cel.value);
		}
	} else if  (operation=="max"){
		for (i=0; i<rowsNumber; i++) {
			var cel = document.getElementById("mathData_t" + tableId + "l" + i +"c" + columnId);
			if (isNaN(parseFloat(cel.value))){
				alert("\"" + cel.value + "\"" + " is not a number");
				return false;
			}
			if (i==0){
				newResult = cel.value;
			}
			if (newResult < cel.value){
				newResult = cel.value;
			}		
		}
	} else if  (operation=="min"){
		for (i=0; i<rowsNumber; i++) {
			var cel = document.getElementById("mathData_t" + tableId + "l" + i +"c" + columnId);
			if (isNaN(parseFloat(cel.value))){
				alert("\"" + cel.value + "\"" + " is not a number");
				return false;
			}
			if (i==0){
				newResult = cel.value;
			}
			if (newResult > cel.value){
				newResult = cel.value;
			}		
		}
	} else {
		alert("Sorry !!. \n\"" + operation + "\" operation is not supported yet. ");
	}
	result.innerHTML = roundNum(newResult,2);
}

// type checking functions

function checkValue(field, property, type, required) {
	if (document.images[property + "required"]!=null) {
		if (field.value!="") {		
			document.images[property + "required"].src= imgsrc + "clearpixel.gif";
			if (type=="NUMBER" && !isNumber(field.value)) document.images[property + "required"].src= imgsrc + "ast.gif";
			if (type=="DATE" && !isDate(field.value)) document.images[property + "required"].src = imgsrc + "ast.gif";
			if (type=="EMAIL" && !isEmail(field.value)) document.images[property + "required"].src= imgsrc + "ast.gif";		
		} else {	
			if (required) document.images[property + "required"].src= imgsrc + "ast.gif";
		}
	}
}

// Return true if value is an e-mail address
function isEmail(value) {
	invalidChars = " /:,;";
	if (value=="") return false;
	
	for (i=0; i<invalidChars.length;i++) {
	   badChar = invalidChars.charAt(i);
	   if (value.indexOf(badChar,0) != -1) return false;
	}
	
	atPos = value.indexOf("@", 1);
	if (atPos == -1) return false;
	if (value.indexOf("@", atPos + 1) != -1) return false;
	
	periodPos = value.indexOf(".", atPos);
	if (periodPos == -1) return false;
	
	if (periodPos+3 > value.length) return false;

	return true;
}



// Return true if value is a number
function isNumber(value) {
	if (value=="") return false;

	var d = parseInt(value);
	if (!isNaN(d)) return true; else return false;		

}

// return true if value is a date
// ie in the format XX/YY/ZZ where XX YY and ZZ are numbers
function isDate(value) {
	if (value=="") return false;
	
	var pos = value.indexOf("/");
	if (pos == -1) return false;
	var d = parseInt(value.substring(0,pos));
	value = value.substring(pos+1, 999);
	pos = value.indexOf("/");
	if (pos==-1) return false;
	var m = parseInt(value.substring(0,pos));
	value = value.substring(pos+1, 999);
	var y = parseInt(value);	
	if (isNaN(d)) return false;	
	if (isNaN(m)) return false;	
	if (isNaN(y)) return false;	
	
	var type=navigator.appName;
	if (type=="Netscape") var lang = navigator.language;
	else var lang = navigator.userLanguage;
	lang = lang.substr(0,2);

	if (lang == "fr") var date = new Date(y, m-1, d);
	else var date = new Date(d, m-1, y);
	if (isNaN(date)) return false;	
	return true;
 }
 
/**
 * Check if a number is being type in.
 */
function checkNumber(el, e) {
	// Get the key.
	var key = 0;
	if (e.charCode) {
		key = e.charCode;
	} else if (e.keyCode) {
		key = e.keyCode;
	}
	
	// Check key.
	if (key>=48 && key<=57) {
		// Digit : ok
		return true;
	} else if (checkSpecialKey(el, e)) {
		// Special letter : don't block.
		return true;
	}
	
	// Block everything else.
	return false;
}

/**
 *
 */
function checkSpecialKey(element, e) {
	// Get key code.
	var key = e.keyCode;
	switch (key) {
		case 8:
		case 9:
		case 35:
		case 16:
		case 35:
		case 36:
		case 37:
		case 38:
		case 39:
		case 40:
		case 144:
		case 145:
		case 17:
		case 18:
		case 19:
		case 20:
		case 36:
		case 45:
		case 46:
		case 91:
		case 92:
		case 145:
	return true;
		default:
			return false;
	}
 }

/**
 * Check if the current field is fill.
 * If yes, move focus to the next field.
 */ 
function checkAutoSkip(el, e){
	// keyCode :  8 backtab, 9 tab, 35 end, 16 shift
	//             35 to 40 cursor , 144 verrnum ,145 defil
	// 17 ctrl,18 alt,19 attn,20 capslock,36 home,45  ins,46 del, 91/92 fenetw,93 menuw
	
	// Get key code.
	var key = e.keyCode;
	
   if ((el.tagName=="INPUT" || el.tagName=="TEXTAREA")
       && !(key >=16  && key <=20)
       && !(key >=35  && key <=40)
       && !(key >=91  && key <=93)
       && key !=  8 && key !=  9
       && key != 45 && key != 46
       && key !=144 && key !=145){

      if (el.tagName=="INPUT") {
          var longueurChamp = el.maxLength ;
          if (longueurChamp == -1) {
              longueurChamp = 9999;
      	  }
          var taille = el.maxLength ;
      }
      if (el.tagName=="TEXTAREA") {
          var longueurChamp = el.rows * el.cols ;
          var taille =  el.rows * el.cols  ;
      }

      // Check if the user hit the maximum length
      if (el.value.length>= longueurChamp || el.value.length>= taille){
         var i;
        // Find the next control on the form.
         for(i=0; i < el.form.elements.length; i++){
            if (el==el.form.elements[i]){
               break;
            }
         }
         if (i != el.form.elements.length){
            for(j=i+1; j < el.form.elements.length; j++){

              if (el.form.elements[j].disabled == false && !el.form.elements[j].readOnly) {
				  // look for the next editable field.
                 if (el.form.elements[j].type=="text" || el.form.elements[j].type=="password" || el.form.elements[j].type=="checkbox" || el.form.elements[j].type=="CHECKBOX" || el.form.elements[j].tagName=="TEXTAREA" || el.form.elements[j].tagName=="select" || el.form.elements[j].tagName=="SELECT") {
         			el.form.elements[j].focus();
                    break;
                  }
               }
            }          
		 }
         else {
            // Go to the first control if at the last control
            i=0;
            el.form.elements[i].focus();
         }
      }
   }
}

// menu functions

function initMenu(menu) {
	if (getMenuCookie(menu)=="hide") {
		document.getElementById(menu).style.display="none";
	} else {
		document.getElementById(menu).style.display="";
	}
}

function changeMenu(menu) {
if (document.getElementById(menu).style.display=="none") {
	document.getElementById(menu).style.display="";
	element = document.getElementById(menu+"b");
	if (element != null) {
		document.getElementById(element).style.display="none";
	}
	setMenuCookie(menu,"show");
} else {
	document.getElementById(menu).style.display="none";
	element = document.getElementById(menu+"b");
	if (element != null) {	
		var width = document.getElementById(menu).offsetWidth;	
		if (navigator.vendor == ("Netscape6") || navigator.product == ("Gecko"))
			document.getElementById(menu+"b").style.width = width;	
		else 
			document.getElementById(menu+"b").width = width;
		document.getElementById(menu+"b").style.display="";
	}
	setMenuCookie(menu,"hide");
}
return false;
}

function changeDisplayState(elementId, imageId, visibleImageSrc, hiddenImageSrc) {
	var display;
	if (document.getElementById(elementId).style.display=="none") {
		document.getElementById(elementId).style.display="";
		display = true;
	} else {
		document.getElementById(elementId).style.display="none";
		display = false;
	}
	if (imageId) {
		document.getElementById(imageId).src = imgsrc + (display ? visibleImageSrc : hiddenImageSrc);
	}
}

function setMenuCookie(name, state) {	
	if (name.indexOf("treeView")!=-1) {
		if (state=="show") {
			var cookie = getMenuCookie("treeView", "");
			if (cookie=="???") cookie = "_";
			cookie = cookie + name + "_";
			document.cookie = "treeView=" + escape(cookie);

		} else {
			var cookie = getMenuCookie("treeView", "");
			var begin = cookie.indexOf("_" + name + "_");
			if (cookie.length > begin + name.length + 2) {
				cookie = cookie.substring(0, begin+1) + cookie.substring(begin + 2 + name.length);
			} else {
				cookie = cookie.substring(0, begin+1);
			}
			document.cookie = "treeView=" + escape(cookie);
		}
		return;
	} 
	if (name.indexOf("selectedTab")!=-1) {
		document.cookie = "selectedTab=" + escape(state) + getCookieContextPath();
	} else {
		var cookie = name + "STRUTSMENU=" + escape(state);
		document.cookie = cookie;	
	}
}

function getCookieContextPath() {
	if (window.contextPath) {
		return "; path=" + window.contextPath;
	} else {
		return "";
	}
}


function setTabCookie(name, value) {
	var cookie = getMenuCookie("selectedTab", "");	
	var start;
	var end;
	if (cookie=="undefined") cookie = "";
	if (cookie==null) cookie = "";
	if (cookie=="???") cookie = "";	
	start = cookie.indexOf(name + "=");
	if (start==-1) {
		cookie = cookie + name + "=" + value + ";"
	} else {
		end = cookie.substring(start).indexOf(";");
		cookie = cookie.substring(0, start) + name + "=" + value + cookie.substring(start+end);
	}
	setMenuCookie("selectedTab", cookie);
}

function getMenuCookie(name, suffix) {
	if (suffix==null) {
		suffix = "STRUTSMENU";
	}
	var prefix = name + suffix + "=";
	var cookieStartIndex = document.cookie.indexOf(prefix);
	if (cookieStartIndex == -1) return "???";
	var cookieEndIndex = document.cookie.indexOf(";", cookieStartIndex + prefix.length);
	if (cookieEndIndex == -1) cookieEndIndex = document.cookie.length;
	return unescape(document.cookie.substring(cookieStartIndex + prefix.length, cookieEndIndex));
}

// sort functions
function arrayCompare(e1,e2) {
	return e1[0] < e2[0] ? -1 : (e1[0] == e2[0] ? 0 : 1);

}

var tables = new Array();
function arraySort(tableName, column, lineNumber, columnNumber) {
	var aTable = tables[tableName];
	var arrayToSort;
	var array;
	var reverse = 0;
	if (aTable) {
		array = aTable[0];
		arrayToSort = new Array(lineNumber);
		for (i=0;i<lineNumber;i++) {
			arrayToSort[i] = new Array(2);
			arrayToSort[i][0] = array[i][column];
			arrayToSort[i][1] = i;				
		}
		reverse = 1 - aTable[1];
		aTable[1] = reverse;
	} else {
		array = new Array(lineNumber);
		arrayToSort = new Array(lineNumber);
		for (i=0;i<lineNumber;i++) {	
			array[i] = new Array(columnNumber);
			for (j=0;j<columnNumber;j++) {
				obj = document.getElementById("t" + tableName + "l" + (i+1) +"c" + j);		
				array[i][j] = obj.innerHTML;
			}
			array[i][columnNumber] = obj.parentNode.parentNode.onmouseover;
			array[i][columnNumber+1] = obj.parentNode.parentNode.onmouseout;			
			
			arrayToSort[i] = new Array(2);
			arrayToSort[i][0] = array[i][column];
			arrayToSort[i][1] = i;		
	
			aTable = new Array(2);
			aTable[0] = array;
			aTable[1] = 0;
			tables[tableName] = aTable;
		}
	}

	arrayToSort.sort(arrayCompare);
	if (reverse) {
		arrayToSort.reverse();
	}

	for (i=0;i<lineNumber;i++) {
		goodLine = arrayToSort[i][1];
		for (j=0;j<columnNumber;j++) {
			document.getElementById("t" + tableName + "l" + (i+1) +"c" + j).innerHTML = array[goodLine][j];
		}
		document.getElementById("t" + tableName + "l" + (i+1) +"c" + 0).parentNode.parentNode.onmouseover = array[goodLine][columnNumber];
		document.getElementById("t" + tableName + "l" + (i+1) +"c" + 0).parentNode.parentNode.onmouseout = array[goodLine][columnNumber+1];
	}
}

// calendar functions

var calformname;
var calformelement;
var calpattern;
var calweekstart;

/**
 * Static code included one time in the page.
 *
 * a {text-decoration: none; color: #000000;}");
 * TD.CALENDRIER {background-color: #C2C2C2; font-weight: bold; text-align: center; font-size: 10px; }");
 *
 * bgColor => #000000, #C9252C, 
 */
 

function printCalendar(day1, day2, day3, day4, day5, day6, day7, first, month1, month2, month3, month4, month5, month6, month7, month8, month9, month10, month11, month12, day, month, year) {
	document.write('<div id="caltitre" style="z-index:10;">');	
	document.write('<table cellpadding="0" cellspacing="0" border="0" width="267">');
//	document.write('<form>');
	document.write('<tr><td colspan="15" class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
	document.write('<tr>');
	document.write('	<td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=20></td>');
	document.write('	<td class="CALENDARTITLE" colspan="3" align="right"><img src="' + imgsrc + 'previous.gif" onclick="cal_before(' + day + ');"></td>');
	document.write('	<td colspan=7 align="center" class="CALENDARTITLE" nowrap>');
	
	// month
	document.write('<select id="calmois" name="calmois" onchange="cal_chg(' + day + ');"><option value=0>...</option>');	
	
	// use the good day for week start.
	// store the day the week start for later.
	calweekstart = first;	
	// compute an array of the days, starting from Sunday.
	caldays = new Array(7);
	caldays[0] = day1;
	caldays[1] = day2;
	caldays[2] = day3;
	caldays[3] = day4;
	caldays[4] = day5;
	caldays[5] = day6;
	caldays[6] = day7;
	// compute an array of the days, starting at the good day.
	computedcaldays = new Array(7);
	for (i=0; i<7; i++) {		
		computedcaldays[(i+1-calweekstart+7)%7] = caldays[i];
	}
			
	for(i=1;i<=12;i++) {
		var str='<option value=' + i + '>';
		monthIndex = i-1;
		switch (monthIndex) {
			case 0: str += month1; break;
			case 1: str += month2; break;
			case 2: str += month3; break;
			case 3: str += month4; break;
			case 4: str += month5; break;
			case 5: str += month6; break;
			case 6: str += month7; break;
			case 7: str += month8; break;
			case 8: str += month9; break;
			case 9: str += month10; break;
			case 10: str += month11; break;
			case 11: str += month12; break;
		}
		document.write(str);
	}	

	document.write('</select>');
	
	// year
	document.write('<select id="calyear" name="calyear" onchange="cal_chg('+ day + ');">');	
	document.write("</select>");
	
	document.write('	</td>');
	document.write('	<td class="CALENDARTITLE" align="left" colspan="3"><img src="' + imgsrc + 'next.gif" onclick="cal_after(' + day + ');">&nbsp;&nbsp;<img src="' + imgsrc + 'close.gif" onclick="hideCalendar()"></td>');
	document.write('	<td class="CALENDARBORDER" width=1><img src="' + imgsrc + 'shim.gif" width="1" height="1"></td>');
	document.write('</tr>');
	document.write('<tr><td colspan=15 class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
	document.write('<tr>');
	document.write('	<td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[0] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[1] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[2] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[3] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[4] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[5] + '</td>');
	document.write('	<td class="CALENDRIER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('	<td class="CALENDRIER" width="38">' + computedcaldays[6] + '</td>');
	document.write('	<td class="CALENDARBORDER" width="1"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>');
	document.write('</tr>');
	document.write('<tr><td colspan=15 class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>');
//	document.write('</form>');
	document.write('</table>');
	document.write('</div>');
//	document.write('<div id="caljour" style="position:absolute; left:0px; top:45px; width:253; height:130; z-index:10;"></div>');
	document.write('<div id="caljour" style="z-index:10;"></div>');	
}



/**
 * Show the calendar
 */
 

function showCalendar(year, month, day, pattern, formName, formProperty, event, startYear, endYear) {
	if (document.forms[formName].elements[formProperty].disabled) {
			return;
	}
	if (startYear!=null) {
		var calyear = document.getElementById("calyear");
		for (i = startYear; i <= endYear; i++) {			
			calyear.options[i - startYear] = new Option(i,i);
		}
		calyear.options.length = endYear - startYear + 1;
	}

	// Update the calendar.
	if (document.layers) {
		document.slcalcod.document.caltitre.document.forms[0].calmois.selectedIndex=month;
	} else if (document.all) {
		document.all.calmois.selectedIndex= month;
	} else {
		document.getElementById("calmois").selectedIndex=month;
	}
	if (document.forms[formName].elements[formProperty].stlayout) {
		var lc_day = document.forms[formName].elements[formProperty].stlayout.day;
		var lc_month = document.forms[formName].elements[formProperty].stlayout.month;
		var lc_year = parseInt(document.forms[formName].elements[formProperty].stlayout.year);
		cal_chg(lc_day, lc_month, lc_year);	
	} else {
		cal_chg(day, month, year);	
	}

	if(document.all) {
		// IE.
		var position = cal_place(event);
		document.all.slcalcod.style.left = position[0];
		document.all.slcalcod.style.top = position[1];
		document.all.slcalcod.style.visibility="visible";
	} else if(document.layers) {
		// Netspace 4
		document.slcalcod.left = e.pageX+10;
		document.slcalcod.top = e.pageY+10;
		document.slcalcod.visibility="visible";
	} else {
		// Mozilla
		var calendrier = document.getElementById("slcalcod");
		var position = cal_place(event);
		calendrier.style.left = position[0];
		calendrier.style.top = position[1];				
		calendrier.style.visibility="visible";
	}	
	if (document.all) {
		hideElement("SELECT");
	}
	calformname = formName;
	calformelement = formProperty;
	calpattern = pattern;
}

/**
 * Compute the size of the window.
 */
function cal_window_size() {
	var myWidth = 0, myHeight = 0;
  	if( typeof( window.innerWidth ) == 'number' ) {
	    //Non-IE
	    myWidth = window.innerWidth;
	    myHeight = window.innerHeight;
  	} else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
	    //IE 6+ in 'standards compliant mode'
	    myWidth = document.documentElement.clientWidth;
	    myHeight = document.documentElement.clientHeight;
	} else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
	    //IE 4 compatible
	    myWidth = document.body.clientWidth;
	    myHeight = document.body.clientHeight;
	}
	return [myWidth, myHeight];  
}

/**
 * Compute where the calendar popup should be placed
 */
function cal_place(event) {
	var calendrier = document.getElementById("slcalcod");
	var ofy=document.body.scrollTop;
	var ofx=document.body.scrollLeft;
	var size = cal_window_size();

	var endX = calendrier.clientWidth + event.clientX + ofx + 10;	
	var endY = calendrier.clientHeight + event.clientY + ofy + 10;
	
	var calX;
	var calY;

	if (endX>size[0]) {
		calX = event.clientX + ofx - 10 - calendrier.clientWidth;
	} else {
		calX = event.clientX + ofx + 10;
	}
	
	if (endY>size[1]) {
		calY = event.clientY + ofy - 10 - calendrier.clientHeight;
	} else {
		calY = event.clientY + ofy + 10;
	}
	
	return [calX, calY];
}

/**
 * Redraw the calendar for the current date and a selected month
 */
function cal_chg(day, month, year){
	var str='',j;	
	
	champMonth = document.getElementById("calmois");
	if (month==null) {		
		month = champMonth.options[champMonth.selectedIndex].value;
	} else {
		champMonth.selectedIndex = month;
	}
		
	
	champYear = document.getElementById("calyear");
	if (year==null) {		
		year = champYear.options[champYear.selectedIndex].value;
	} else {
		index = year - champYear.options[0].value;
		if (index >= 0 && index < champYear.options.length) {
			champYear.selectedIndex = index;
		} else {
			// the initial year is not in the calendar allowed years.
			year = champYear.options[0].value;
		}
	}
	
	
	if(month>0) {
	
		j=1;
		weekEnd1Pos = (1 - calweekstart + 7) % 7;
		weekEnd2Pos = (7 - calweekstart + 7) % 7;
				
		str+='<table cellpadding=0 cellspacing=0 border=0 width=267>\n';
		for(u=0;u<6;u++){
			str+='	<tr>\n';
			for(i=0;i<7;i++){
				ldt=new Date(year,month-1,j);				
				str+='		<td class="CALENDARBORDER" width=1><img src="' + imgsrc + 'shim.gif" width=1 height=20></td>\n';
				
				str+='		<td class="CALENDAR'; 
				if((ldt.getDay()+1-calweekstart+7)%7==i && ldt.getDate()==j && j==day /*&& newMonth==month && lc_annee==year*/) {
					str+='SELECTED'; 
				} else if(i==weekEnd1Pos || i==weekEnd2Pos) {
					str+='WEEKEND'; 
				} else {
					str+='WEEK'; 
				}
				str+='" width="38" align="center">';
				if ((ldt.getDay()+1-calweekstart+7)%7==i && ldt.getDate()==j) {
					str+='<a class="CALENDRIER" href="javascript://" class="CALENDRIER" onmousedown="dtemaj(\'' + j + '\',\'' + month + '\',\'' + year +'\');">'+j+'</a>'; 
					j++;
				} else {
					str+='&nbsp;';
				}
				str+='</td>\n';
			}
			str+='		<td class="CALENDARBORDER" width=1><img src="' + imgsrc + 'shim.gif" width=1 height=1></td>\n';
			str+='	</tr>\n';
			str+='	<tr><td colspan=15 class="CALENDARBORDER"><img src="' + imgsrc + 'shim.gif" width=1 height=1></td></tr>\n';
		}
		str+='</table>\n';
	
	}
	
	if(document.all) {
		document.all.caljour.innerHTML=str;
	}
	if(document.layers) {
		obj=document.calendrier.document.caljour; 
		obj.top=48; 
		obj.document.write(str); 
		obj.document.close();
	}
	if (!document.all && document.getElementById) {
		document.getElementById("caljour").innerHTML = str;
	}
}

/**
 * Display the previous month
 */
function cal_before(day, month, year) {
	var champMonth, champYear;
	champMonth = document.getElementById("calmois");
	champYear = document.getElementById("calyear");
			
	if (champMonth.selectedIndex>1) { 
		champMonth.selectedIndex--;
	} else if (champYear.selectedIndex>0) {
		champYear.selectedIndex--;
		champMonth.selectedIndex = champMonth.options.length - 1;
	}
	cal_chg(day, champMonth.options[champMonth.selectedIndex].value, champYear.options[champYear.selectedIndex].value);
}

/**
 * Display the next month
 */
function cal_after(day, month, year) {
	// get required objects
	var champMonth, champYear;
	champMonth = document.getElementById("calmois");
	champYear = document.getElementById("calyear");
	if (champMonth.selectedIndex < champMonth.options.length - 1) {
		champMonth.selectedIndex++;
	} else if (champYear.selectedIndex < champYear.options.length - 1) {
		champYear.selectedIndex++;	
		champMonth.selectedIndex = 1;
	}
	cal_chg(day, champMonth.options[champMonth.selectedIndex].value, champYear.options[champYear.selectedIndex].value);
}

/**
 * Update the date in the input field and hide the calendar.
 * PENDING: find a way to make the format customable.
 */














   
function check()
{
if  ((document.parametre1Form.adminfrns.checked==false)&& (document.parametre1Form.admin.checked==false)&& (document.parametre1Form.adminprtnr.checked==false)&& (document.parametre1Form.magaberaki.checked==false)
		&& (document.parametre1Form.adminartcl.checked==false)&& (document.parametre1Form.adminwrhs.checked==false)&& (document.parametre1Form.admincds.checked==false)&& (document.parametre1Form.edition.checked==false))

{alert("Aucun profil  n’est sélectionné")
	return false ;}
else
{return true;}

}







function dtemaj(jour, mois, annee){
	document.forms[calformname].elements[calformelement].value = formatDate(jour, mois, annee);
	document.forms[calformname].elements[calformelement].stlayout = new Object();
	document.forms[calformname].elements[calformelement].stlayout.day = jour;
	document.forms[calformname].elements[calformelement].stlayout.month = mois;
	document.forms[calformname].elements[calformelement].stlayout.year = annee;
	hideCalendar();
	if (document.forms[calformname].elements[calformelement].onchange) {
		document.forms[calformname].elements[calformelement].onchange();
	}
}

function formatDate(day, month, year) {
	var date = "";
	var pos = 0;
	var pattern;
	var previousPattern;
	var patternLength = 0;
	if (calpattern!=null && calpattern.length>0) {		
		previousPattern = calpattern.charAt(0);
		while (pos <= calpattern.length) {
			if (pos < calpattern.length) {
				pattern = calpattern.charAt(pos);
			}  else {
				pattern = "";
			}
			if (pattern != previousPattern) {			
				switch (previousPattern) {
					case 'y':
						date += padYear(year, patternLength);				
						break;
					case 'M':
						date += padNumber(month, patternLength);
						break;
					case 'd':
						date += padNumber(day, patternLength);
						break;
					case '\'':
						// PENDING
						break;
					default:
						date += previousPattern;
				}
				previousPattern = pattern;
				patternLength = 0;
			}
			patternLength++;
			pos++;
		}
	}
	return date;
}

function padYear(year, patternLength) {
	if (patternLength==2 && year.length==4) {
		return year.substring(2);
	} else {
		return year;
	}
}

function padNumber(number,length) {
    var str = '' + number;
    while (str.length < length)
        str = '0' + str;
    return str;
}

function hideCalendar() {
	if(document.all) {
		// IE.
		document.all.slcalcod.style.visibility="hidden";
		showElement("SELECT");
	} else if(document.layers) {
		// Netspace 4
		document.slcalcod.visibility="hidden";
	} else {
		// Mozilla
		var calendrier = document.getElementById("slcalcod");
		calendrier.style.visibility="hidden";
	}
}

/**
 * Fix IE bug
 */
function hideElement(elmID)
{
	if (!document.all) {
		return;
	}
	x = parseInt(document.all.slcalcod.style.left);
	y = parseInt(document.all.slcalcod.style.top);
	var node = event.srcElement;
    while(node.tagName != "DIV") {
     	node = node.parentNode;
    	if (node.tagName == 'HTML') break;
	}
    if(node.tagName == "DIV"){
     	x+= node.scrollLeft;
        y+=node.scrollTop;
    }
	//xxx = 253; // document.all.slcalcod.offsetWidth;	
	//yyy = 145; // document.all.slcalcod.offsetHeight;
	
	xxx = document.all.slcalcod.offsetWidth;
	yyy = document.all.slcalcod.offsetHeight;
		
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
		if (! obj || ! obj.offsetParent || obj.id=="calmois" || obj.id=="calyear")
			continue;

		// Find the element's offsetTop and offsetLeft relative to the BODY tag.
		objLeft   = obj.offsetLeft;
		objTop    = obj.offsetTop;
		objParent = obj.offsetParent;
		if(obj.style.visibility != "hidden"){
		while (objParent.tagName.toUpperCase() != "BODY")
		{
			objLeft  += objParent.offsetLeft;
			objTop   += objParent.offsetTop;
			objParent = objParent.offsetParent;
		}
		}
		obj.statusVisibility = obj.style.visibility;
										
		// Adjust the element's offsetTop relative to the dropdown menu
		//objTop = objTop - y;
	
		if (x > (objLeft + obj.offsetWidth) || objLeft > (x + xxx))
			;
		else if (objTop > y + yyy)
			;
		else if (y > (objTop + obj.offsetHeight))
			;
		else
             if(obj.statusVisibility != "hidden"){
			obj.style.visibility = "hidden";
	}
}
}

/**
 * Fix IE bug
 */
function showElement(elmID)
{
	if (!document.all) {
		return;
	}
	for (i = 0; i < document.all.tags(elmID).length; i++)
	{
		obj = document.all.tags(elmID)[i];
		if (! obj || ! obj.offsetParent)
			continue;
			
		if(obj.statusVisibility != "hidden")
		obj.style.visibility = "";
	}
}

/**
 * Tabs code.
 *
 * @param tabVarName: name of the form variable that holds the id of the selected tab.
 */
function selectTab(tabGroupId, tabGroupSize, selectedTabId, enabledStyle, disabledStyle, errorStyle, tabKeyName, tabKeyValue, callback) {
	// first unselect all tab in the tag groups.
	for (i=0;i<tabGroupSize;i++) {
		var element = document.getElementById("tabs" + tabGroupId + "head" + i);
		
		var element_left = document.getElementById("tabs" + tabGroupId + "head" + i + "_left");
		var element_right = document.getElementById("tabs" + tabGroupId + "head" + i + "_right");
		var element_bottom = document.getElementById("tabs" + tabGroupId + "head" + i + "_bottom");
		
		var element_body = document.getElementById("tabs" + tabGroupId + "tab" + i);
		
		if (element.classNameErrorStdLayout) {
			element.className = errorStyle;
		
			if (element_right) element_right.className = errorStyle;
			if (element_left) element_left.className = errorStyle;
			if (element_bottom) element_bottom.className = errorStyle;
		
			element.style.color = "";			
		} else if (element.className == enabledStyle) {
			element.className = disabledStyle;
			
			if (element_right) element_right.className = disabledStyle+"_right";
			if (element_left) element_left.className = disabledStyle+"_left";
			if (element_bottom) element_bottom.className = disabledStyle+"_bottom";
			
			element.style.color = "";
		} else if (element.className == errorStyle) {
			// do nothing more
		}
		
		if (element_body) {
			element_body.style.display = "none";
		}
	}
	if (document.getElementById("tabs" + tabGroupId + "head" + selectedTabId).className==errorStyle) {
		document.getElementById("tabs" + tabGroupId + "head" + selectedTabId).classNameErrorStdLayout = new Object();
	}
	document.getElementById("tabs" + tabGroupId + "head" + selectedTabId).className = enabledStyle;
	
	if (document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_left")) 
		document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_left").className = enabledStyle+"_left";
	if (document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_right"))
		document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_right").className = enabledStyle+"_right";
	if (document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_bottom"))
		document.getElementById("tabs" + tabGroupId + "head" + selectedTabId + "_bottom").className = enabledStyle+"_bottom";
	
	document.getElementById("tabs" + tabGroupId + "head" + selectedTabId).style.cursor = "default";
	document.getElementById("tabs" + tabGroupId + "tab" + selectedTabId).style.display = "";
		
	if (tabKeyName!=null) {
		if (callback!=null) {
			// cookie should not be used. Inform the server of the new seletec tab.
			var xhr = null; 
			if(window.XMLHttpRequest) {
				// Standard 
				xhr = new XMLHttpRequest(); 
			} else if(window.ActiveXObject) { 
				// Internet Explorer 
				xhr_object = new ActiveXObject("Microsoft.XMLHTTP");
			} else { 
				// Impossible to inform the server of the change.			    
			   return; 
			} 
			xhr.open("POST", callback, false);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");  
			xhr.send("tabKey=" + tabKeyName + "&tabValue=" + tabKeyValue); 
			if(xhr.readyState != 4) alert("Fail to update tab state on server");
		} else {
			// update a cookie holding the name of the selected tab.
			setTabCookie(tabKeyName, tabKeyValue);
		}
	}
}
function onTabHeaderOver(tabGroupId, selectedTabId, enabledStyle) {
	element = document.getElementById("tabs" + tabGroupId + "head" + selectedTabId);
	if (element.className == enabledStyle) {
		element.style.cursor = "default";
	} else {
		element.style.cursor = "hand";
	}
}

/**
 * Treeview code
 */
function loadTree(url, tree) {
	element = document.getElementById("treeView" + url);
	element.innerHTML = tree;	
	element.style.display = "";
	element = document.getElementById("treeViewNode" + url);
	element.href = "javascript://";
	setMenuCookie("treeView" + url, "show")	
}

function changeTree(tree, image1, image2) {
	if (!isTreeviewLocked(tree)) {
		var image = document.getElementById("treeViewImage" + tree);
		if (image.src.indexOf(image1)!=-1) {
			image.src = image2;
		} else {
			image.src = image1;
		}
	
		if (document.getElementById("treeView" + tree).innerHTML == "") {
			return true;
		} else {
			changeMenu("treeView" + tree);
			return false;
		}
	} else {
		return false;
	}
}

function changeTreeAndSubtrees(tree) {
	var image = document.getElementById("treeViewImage" + tree);
	
	var link = image.parentNode;
	if (link.href.indexOf("javascript://") == -1) {
		// il s'agit d'un lien vers le treeview.do
		// => les sous-menus n'ont pas ?t? charg?s dans la page HTML
		// => on ne peut pas proc?der au changement
		return false;
	}
	
	if (image.src.indexOf("Close")!=-1) {
		reg=new RegExp("Close", "g");
		image.src = image.src.replace(reg, "Open");
	} else {
		reg=new RegExp("Open", "g");
		image.src = image.src.replace(reg, "Close");
	}
	
	if (document.getElementById("treeView" + tree).innerHTML == "") {
		return true;
	} else {
		// change the menu itself
		menu = "treeView" + tree;
		changeMenu(menu);
					
		toShow = true;
		if (document.getElementById(menu).style.display=="none") {
			// the "menu" menu has just been hidden : all its subtrees must collapse too
			toShow = false;
		}
		
		list = document.getElementsByTagName("td");
		for (i=0; i<list.length; i++) {
			currentElement = list[i];
			if (currentElement.id.indexOf(menu) != -1
				&& currentElement.id!=menu) {
				// we are at a submenu level
				subTreeName = currentElement.id.substring(8);
				
				if (currentElement.style.display=="none" && toShow
					|| currentElement.style.display=="" && !toShow) {	
					image = document.getElementById("treeViewImage" + subTreeName);
					
					link = image.parentNode;
					if (link.href.indexOf("javascript://") != -1) {
						// il s'agit d'un javascript
						// => les sous-menus ont ?t? charg?s dans la page HTML
						// => on peut proc?der au changement
						
						if (image.src.indexOf("Close")!=-1) {
							reg=new RegExp("Close", "g");
							image.src = image.src.replace(reg, "Open");
						} else {
							reg=new RegExp("Open", "g");
							image.src = image.src.replace(reg, "Close");
						}
					
						if (document.getElementById("treeView" + subTreeName).innerHTML == "") {
							//return true;
						} else {
							changeMenu("treeView" + subTreeName);
						}
					}
					
				}
			}
		}
		
		return false;
	}
}

function expandFirstLevels(treeviewId, numberOfLevelsToExpand) {
	menuId = "treeView" + treeviewId;
		
	list = document.getElementsByTagName("td");
	for (i=0; i<list.length; i++) {
		currentElement = list[i];
		if (currentElement.id.indexOf(menuId) != -1
			&& currentElement.id!=menuId) {
			// we are at a submenu level
			
			idSuffix = currentElement.id.substring(menuId.length);
			if (countStringOccurence(idSuffix, "*") <= numberOfLevelsToExpand) {
				
				subTreeName = currentElement.id.substring(8);
				
				image = document.getElementById("treeViewImage" + subTreeName);
				
				link = image.parentNode;
				if (link.href.indexOf("javascript://") != -1) {
					// il s'agit d'un javascript
					// => les sous-menus ont ?t? charg?s dans la page HTML
					// => on peut proc?der au changement
					
					if (image.src.indexOf("Close")!=-1) {
						reg=new RegExp("Close", "g");
						image.src = image.src.replace(reg, "Open");
					} else {
						reg=new RegExp("Open", "g");
						image.src = image.src.replace(reg, "Close");
					}
				
					if (document.getElementById("treeView" + subTreeName).innerHTML == "") {
						//return true;
					} else {
						changeMenu("treeView" + subTreeName);
					}
				}
			}
		}
	}
}

function openAll(treeviewId, numberOfLevelsToExpand) {
	if (!isTreeviewLocked(treeviewId)) {
	    menuId = "treeView" + treeviewId;
	    var doModify;
		list = document.getElementsByTagName("td");
		for (i=0; i<list.length; i++) {
			currentElement = list[i];
			if (currentElement.id.indexOf(menuId) != -1
				&& currentElement.id!=menuId) {
				// we are at a submenu level
	
				idSuffix = currentElement.id.substring(menuId.length);
				if (countStringOccurence(idSuffix, "*") <= numberOfLevelsToExpand) {
	
					subTreeName = currentElement.id.substring(8);
	
					image = document.getElementById("treeViewImage" + subTreeName);
	
					link = image.parentNode;
					if (link.href.indexOf("javascript://") != -1) {
	
						if (image.src.indexOf("Close")!=-1) {
							reg=new RegExp("Close", "g");
							image.src = image.src.replace(reg, "Open");
							doModify = true;
						} else {
						    // do nothing
	                        doModify = false;
						}
	
						if (document.getElementById("treeView" + subTreeName).innerHTML == "") {
							//return true;
						} else {
						    if(doModify) {
							    changeMenu("treeView" + subTreeName);
	                        }
						}
					}
				}
			}
		}
	}
}

function closeAll(treeviewId, numberOfLevelsToExpand) {
	if (!isTreeviewLocked(treeviewId)) {
	    menuId = "treeView" + treeviewId;
	    var doModify;
		list = document.getElementsByTagName("td");
		for (i=0; i<list.length; i++) {
			currentElement = list[i];
			if (currentElement.id.indexOf(menuId) != -1
				&& currentElement.id!=menuId) {
				// we are at a submenu level
	
				idSuffix = currentElement.id.substring(menuId.length);
				if (countStringOccurence(idSuffix, "*") <= numberOfLevelsToExpand) {
	
					subTreeName = currentElement.id.substring(8);
	
					image = document.getElementById("treeViewImage" + subTreeName);
	
					link = image.parentNode;
					if (link.href.indexOf("javascript://") != -1) {
	
						if (image.src.indexOf("Close")!=-1) {
						    // do nothing						
							doModify = false;
						} else {
							reg=new RegExp("Open", "g");
							image.src = image.src.replace(reg, "Close");
							doModify = true;
						}
	
						if (document.getElementById("treeView" + subTreeName).innerHTML == "") {
							//return true;
						} else {
						    if (doModify) {
							    changeMenu("treeView" + subTreeName);
	                        }
						}
					}
				}
			}
		}
	}
}

function countStringOccurence(stringToTest, occurenceToCount) {
	index = stringToTest.indexOf(occurenceToCount);
	if (stringToTest.indexOf(occurenceToCount) != -1) {
		/*document.write((index + occurenceToCount.length) + "<br/>");
		document.write(stringToTest.substring(index + occurenceToCount.length) + "<br/>");
		occ = countStringOccurence(stringToTest.substring(index + occurenceToCount.length) , occurenceToCount);
		document.write(occ + "<br/>");*/
		return 1 + countStringOccurence(stringToTest.substring(index + occurenceToCount.length) , occurenceToCount);
	} else {
		return 0;
	}
}

var lockedTrees = new Array();

function lockTreeview(in_name) {
	lockedTrees[in_name] = "locked";
	var item = document.getElementById("treeView" + in_name);
	var links = item.getElementsByTagName("a");
	var link;
	item.style.cursor = "wait";
	for (i=0; i < links.length; i++) {
		link = links.item(i);
		link.style.cursor = "wait";
	}
}

function unlockTreeview(in_name) {
	lockedTrees[in_name] = null;
	var item = document.getElementById("treeView" + in_name);
	var links = item.getElementsByTagName("a");
	var link;
	item.style.cursor = "default";
	for (i=0; i < links.length; i++) {
		link = links.item(i);
		link.style.cursor = "default";
	}
}

function isTreeviewLocked(in_name) {
	var pos = in_name.indexOf('*');
	var name = pos==-1 ? in_name : in_name.substring(0, pos);
	var value = lockedTrees[name];
	return "locked" == value;
}

/**
 * Popup code
 */
function openpopup(form, popup, width, height, e) {
	var xx, yy;
	xx = e.screenX;
	yy = e.screenY;
	window.open('about:blank', 'popup', 'directories=0, location=0, menubar=0, status=0, toolbar=0, width=' + width + ', height=' + height + ', top=' + yy + ', left=' + xx); 	
	var action = form.action;
	var target = form.target;
	if (popup == null || popup == "") {
		popup = action;
	}
	form.target='popup';
	form.action = popup;
	form.submit();
	form.target = target;
	form.action = action;
		
	return false;
}

function closepopup(form, openerField, popupField) {
	var inputField = form[popupField];
	var value;
	if (inputField.options) {
		value = inputField.options[form[popupField].selectedIndex].value;
	} else if (inputField.type == "file") {
		value = inputField.value;
	} else {
		for (i=0; i < form.elements.length; i++) {
			var element = form.elements[i];
			if (element.name == popupField && element.checked) {
				value = element.value;
				break;
			}
		}
	}
	window.opener.document.forms[0][openerField].value = value;
	window.close();
}

/**
 * form changes detect code
 */
function checkFormChange(link, text) {
  var ok = true;
  for (var form=0; form < document.forms.length; form++) {
    what = document.forms[form];
    for (var i=0, j=what.elements.length; i<j; i++) {

        if (what.elements[i].type == "checkbox" || what.elements[i].type == "radio") {
            if (what.elements[i].checked != what.elements[i].defaultChecked) {
				ok = false; break;
		    }
		} else if (what.elements[i].type == "text" || what.elements[i].type == "hidden" || what.elements[i].type == "password" || what.elements[i].type == "textarea") {
            if (what.elements[i].value != what.elements[i].defaultValue) {
				ok = false; break;
		    }
		} else if (what.elements[i].type == "select-one" || what.elements[i].type == "select-multiple") {
			var selectSet = false;
			for (var k=0, l=what.elements[i].options.length; k<l; k++) {
				if (what.elements[i].options[k].defaultSelected) {
					selectSet = true;
				}
			}
			for (var k=0, l=what.elements[i].options.length; k<l; k++) {
				if (what.elements[i].options[k].selected != what.elements[i].options[k].defaultSelected && (selectSet || k!=0)) {
					if ("calmois"!=what.elements[i].name && "calyear"!=what.elements[i].name) { 
						// don't check changes on the popup calendar						
						ok = false; break;
					}
				}
			}
		} else if (what.elements[i].type == "submit") {
			continue;	    
		} else if (what.elements[i].type == "button") {
			continue;		
		}  else if (what.elements[i].type == "file") {
			if (what.elements[i].value !=null && what.elements[i].value!="") {
				ok = false;
				break;			
			}	
		} else if (what.elements[i].type == "reset") {
			continue;		
		} else {
			alert(what.elements[i].type);
		}
    }
  }
    if (ok) {	
		window.location.href = link;
		return;
	    }
    if (confirm(text == null ? "Data will be lost. Continue ?" : text)) {
		window.location.href = link;
		return;
    }
}

/**
 * Shows the detail of the specified line.
 */
function showDetail(id, line) {
	// Get the object 
	var object = id[line];
	
	var fields = document.getElementsByTagName("input");
	var field;
	var value;
	
	// Update each property
	for (i in object) {
	
		// find the field tag.
		field = null;
		for (j in fields) {
			if (fields[j].type=="text" && fields[j].name==i) {
				field = fields[j];
				break;
			}
		}
		
		if (field) {
			value = object[i];
			field.value = value;
		}
	}
}

/**
 * Clear the details
 */
function clearDetail(id) {
	// Get the first object to check its properties
	var object = id[0];
	
	var fields = document.getElementsByTagName("input");
	var field;
	var value;
	
	// Update each property
	for (i in object) {
	
		// find the field tag.
		field = null;
		for (j in fields) {
			if (fields[j].type=="text" && fields[j].name==i) {
				field = fields[j];
				break;
			}
		}
		
		if (field) {
			value = object[i];
			field.value = "";
		}
	}
}

/**
 * Init dependent combo
 */
function initDependentComboHandler(masterSelectName, childSelectName, jsArrayName, jsChildArrayName, childSelectedValue) {
	// find the master select.
	var combo = findCombo(masterSelectName);
	var customFunction = new Function("updateCombo('" + masterSelectName + "', '" + childSelectName + "', " + jsArrayName + ", '" + jsChildArrayName + "');");
	if (combo.addEventListener) {
		combo.addEventListener("change", customFunction, false);
		customFunction();
	} else if (combo.attachEvent) {
		combo.attachEvent("onchange", customFunction);
		customFunction();
	} else {
		combo.onchange = customFunction;
		combo.onchange();
	}	
	
	// init child combo selected value.
	var childCombo = findCombo(childSelectName);
	for (i=0; i < childCombo.options.length;i++) {
		if (childCombo.options[i].value==childSelectedValue) {
			childCombo.selectedIndex = i;
			break;
		}
	}
}

function findCombo(comboName) {
	var elements = document.getElementsByTagName("SELECT");
	var combo;
	for (i in elements) {
		if (elements[i].name == comboName) {
			combo = elements[i];
		}
	}
	return combo;
}
 
/**
 * Update dependent combo.
 * @param masterCombo : the main select object.
 * @param comboName : the name of the child select object.
 * @param jsData : the name of the js data array holding the data.
 * @param jsCollectionProperty : the name of the nested collection property.
 */
function updateCombo(masterComboName, childComboName, jsData, jsCollectionProperty) {
	var masterCombo = findCombo(masterComboName);
	var combo = findCombo(childComboName);

	// get the option list.
	var value = masterCombo.options[masterCombo.selectedIndex].value;

	// get the selected bean
	var selectedValue = masterCombo.options[masterCombo.selectedIndex].value;
	var masterSelectedOption;
	for (i=0; i < jsData.length; i++) {		
		if (jsData[i].value == selectedValue) {
			masterSelectedOption = jsData[i];
			break;
		}
	}

	// remove old options
	while (combo.options.length!=0) {
		combo.remove(0);
	}

	// add new options
	if (masterSelectedOption!=null) {
		for (i = 0; i < masterSelectedOption[jsCollectionProperty].length; i++) {
			var option = new Option(masterSelectedOption[jsCollectionProperty][i].label, masterSelectedOption[jsCollectionProperty][i].value);
			if (document.all) {
				combo.add(option);
			} else {
				combo.add(option, null);
			}
		}
	}
}

/**
 * Get the key that was pressed
 */
function getKeyCode(e) {
	var code;
	if (!e) var e = window.event;
	if (e.keyCode) code = e.keyCode;
	else if (e.which) code = e.which;
	//var character = String.fromCharCode(code);
	return code;
}

/**
 * Go to the specified pager page.
 */
function pagerGoto(inputField, e, url, paramName, max) {	
	if (getKeyCode(e)!=13) {
		return;
	}	
	
	var value = inputField.value;
	var computedUrl = url;
	
	if (isNaN(parseInt(value, 10))) {
		return;
	}
	if (value<=0) {
		return;
	}
	if (value>max) {
		return;
	}
		
	if (url.indexOf("?")==-1) {
		computedUrl += "?";
	} else {
		computedUrl += "&";
	}
	computedUrl += paramName + "=" + (value-1);
	document.location = computedUrl;
}

function showRootMenu(td) {
	td.id = "css_hover";
	var element;
	var i;
	var length = td.childNodes.length;
	for (i=0; i < length; i++) {
		element = td.childNodes[i];	
		if (element.nodeName=="UL") {
			element.style.display = "block";		
		}
	}
}

function hideRootMenu(td) {
	td.id = null;
	var element;
	var i;
	var length = td.childNodes.length;
	for (i=0; i < length; i++) {
		element = td.childNodes[i];	
		if (element.nodeName=="UL") {
			element.style.display = "none";		
		}
	}
}

/**
 * Select / unselect all checkboxes for the collectionTag.
 */
function selectAllCollectionItems(checkbox,n,v,j) {
	var f = checkbox.form;
	var chk   = ( v == null ? true : v );
	for ( i = 0; i < j ; i++) {
		var name =  n + "[" + i + "]";
		if( f[name].type == "checkbox" ) {
			f[name].checked = checkbox.checked;
		}
	}
}

/**
 * For Layer tag
 */

var layerXOffset = 20;
var layerYOffset = 0;

function showLayoutLayer(ID,event) {
	var thisLayer = document.getElementById(ID);
	objLeft = 0;
	objTop = 0;
	objParent = thisLayer.offsetParent;
	while (objParent.tagName.toUpperCase() != "BODY") {
		objLeft  += objParent.offsetLeft;
		objTop   += objParent.offsetTop;
		objParent = objParent.offsetParent;
	}
	
	var layerPosY = event.clientY - objTop;
	var layerPosX = event.clientX - objLeft;	
   	var finalPosX = layerPosX - layerXOffset;   
   	if(finalPosX < 0) finalPosX = 0;
   	document.getElementById(ID).style.top = layerPosY + layerYOffset;
   	document.getElementById(ID).style.left = finalPosX;
//	document.getElementById(ID).style.zIndex= 3;
   	document.getElementById(ID).style.visibility = "visible";
}

function hideLayoutLayer(ID) {
    document.getElementById(ID).style.visibility = "hidden";
}
/**
 * Call by the default BasicImageRender
 */
function getParentForm(obj,reqCode){
 	var par=obj.parentNode;
 	while(par.nodeName!="FORM" && par.nodeName!="BODY"){
  		par=par.parentNode;
 	}
 	var form=null;
 	if(par.nodeName=='FORM'){
  		form=par;
  		form.elements['reqCode'].value = reqCode; 
  		form.submit();
 	} else {
  		alert("Javascript Error.No form linked to this button.");
 	}
}


// mes fonctions 
     
     function setHidden(value, frm){frm.hidden.value=value; alert(value);}
     
//////////////////////////
  function testVideLogin(){
  
   var trouver = "false";
  
  if((document.loginForm.username.value==""))
  {
           alert("veuillez introduire votre identifiant SVP!");
           document.loginForm.username.focus();
           trouver="true";
  }
  
if( (document.loginForm.password.value==""))
  {
           alert("veuillez introduire votre mot de passe SVP!");
           document.loginForm.password.focus();
           trouver="true";
  }
 
  if (trouver=="false"){
document.loginForm.submit();
  }


   }
   
   //////////////////////////
   function loginTest(){
   
      if (document.loginForm.hiddenTest.value =="Erreur user/pass")
		        {  
		            alert("Erreur lors de l'authentification. V�rifiez votre Username/Password.!");
		            document.loginForm.username.value="";
		            document.loginForm.password.value="";
		            document.loginForm.username.focus();
		        }
		        
	  if (document.loginForm.hiddenTest.value =="status d�sactiv�")
		        {  
		            alert("votre Statut est d�sactiv�, Contactez votre administrateur ");
		            document.loginForm.username.value="";
		            document.loginForm.password.value="";
		            document.loginForm.username.focus();
		        }
		        
	if (document.loginForm.hiddenTest.value =="refus�")
		        {  
		            alert("vous n'avez pas l'acc�s � GSS, Contactez votre administrateur ");
		            document.loginForm.username.value="";
		            document.loginForm.password.value="";
		            document.loginForm.username.focus();
		        }
    
   }


////////////////////////////////
 //changer par naima
 
  function testVid(frm){
  
  var trouver ="false";
   
     if (frm.profil.disabled==false)
     {
       if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
          {
            alert("remplir les champs d'abord");
            frm.article.focus();
            trouver="true";
          }
          
     }
  else
  {
   if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
   {
    alert("remplir les champs d'abord");
    frm.article.focus();
    trouver="true";
   }
  }

  
  
 
  if (trouver=="false"){
 
  setHidden('ajouter', frm);
  frm.submit();
  
  }
  
  
  }
  

  /*
   function testVid(frm){
  
  var trouver ="false";
   
     if (frm.profil.disabled==false)
     {
       if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value==""||frm.profil.value=="")
          {
            alert("remplir les champs d'abord");
            frm.article.focus();
            trouver="true";
          }
          
     }
  else
  {
   if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
   {
    alert("remplir les champs d'abord");
    frm.article.focus();
    trouver="true";
   }
  }
  if (trouver=="false"){
 
  setHidden('ajouter', frm);
  frm.submit();
  
  }
  
  
  }*/
	
	
	///////////////////////////////
 function testVide(){
		  
		   if (document.recepForm.fournisseur.value =="")
		         {alert('Ins�rer un fournisseur SVP')
		          document.recepForm.fournisseur.focus();
		         }
		          
		          
		   else{   
		            if (document.recepForm.ref.value =="")
		            {
		             alert('Ins�rer un num�ro de r�f�rence externe SVP')
		             document.recepForm.ref.focus();
		            } 
		            
		            else{
		             if (document.recepForm.PO.value =="")
		            {
		             alert('Ins�rer un num�ro de PO SVP')
		             document.recepForm.PO.focus();
		            } 
		         
		                else 
		                {
		                   setHidden('valider',document.recepForm)
		                   recepForm.submit(); 
		                }
		              }
		     }}
		        
		        ///////////////////////
     function test(){
		         if (document.recepForm.hiddenTest.value =="collection null")
		                {
		                   alert('Ins�rer un article SVP');
		                   document.recepForm.hiddenTest.value="";
		                   document.recepForm.article.focus();
		                } 
		        if (document.recepForm.hiddenTest.value =="range dans la base"){
		                   alert('Ce Range/ une partie de ce Range � d�ja �t� r�ceptionn� !')
		                   document.recepForm.hiddenTest.value="";
		                   
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.article.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.focus();}
		        
		         if (document.recepForm.hiddenTest.value =="range dans la coll"){
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   document.recepForm.hiddenTest.value="";
		                   
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();} 
		                   
		         if (document.recepForm.hiddenTest.value =="hlr diff�rent") {
		         
		                   alert("un HLR � la fois, Merci!");
		                   document.recepForm.hiddenTest.value="";
		                  
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();
		               
		                   
		         }  
		         
		         if (document.recepForm.hiddenTest.value =="quantit� grande") {
		         
		                   alert("La quantit�e ne peut pas d�passer le 1 Milliard d'unit�s");
		                   document.recepForm.hiddenTest.value="";
		                   
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();
		               
		                   
		         } 
		         
		          if (document.recepForm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                   document.recepForm.hiddenTest.value="";
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();
		               
		                   
		         } 
		         
		         if (document.recepForm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   document.recepForm.hiddenTest.value="";
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();
		               
		                   
		         } 
		         
		         
		          if (document.recepForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num s�rie fin<num s�rie d�but");
		                   document.recepForm.hiddenTest.value="";
		                  
		                   document.recepForm.ND.value="";
		                   document.recepForm.NF.value="";
		                   document.recepForm.profil.value="";
		                   document.recepForm.article.value="";		                   
		                   document.recepForm.article.focus();
		               
		                   
		         }  
		                   
		                }
		                
		                 
	  function testArt(){
	  if (document.getElementById('article').value==""){
	  alert("Choisir un article d'abord !")
	  document.getElementById('article').focus();
	  }
	  else
	  {
	 document.getElementById('hiddenTest').value="demande"; 
	  }
	  }
	  
	  function testArt3(elm){
	  if (document.getElementById('art_id').value==""){
	  alert("Choisir un article d'abord !")
	  document.getElementById('art_id').focus();
	  }
	  else
	  {

if( (document.getElementById('hiddenTest').value=="demande")||(document.getElementById('hiddenTest').value=="echec"))
{
elm.focus();
}
else
{
//tro="true";
document.getElementById('hiddenTest').value="demande2";
}
	  
	  }
	  }
	  
	   function testArt2(elm){
	  if (document.getElementById('article').value==""){
	  alert("Choisir un article d'abord !")
	  document.getElementById('article').focus();
	  }
	  else
	  {

if( (document.getElementById('hiddenTest').value=="demande")||(document.getElementById('hiddenTest').value=="echec"))
{
elm.focus();
}
else
{
//tro="true";
document.getElementById('hiddenTest').value="demande2";
}
	  
	  }
	  }
	  
	  
	  
	                 
	 function testVide1(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		    


		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             
        function ajout(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             
             /////////////
              function add(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value==""||frm.profil.value=="")
		    {
		     alert("remplir les champs d'abord");
		    // frm.article.focus();
             trouver="true";
		    }
		    

		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             
             //////////////////////////
              function ajouter(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		   
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             //////////////////
              function add2(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		 
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             
             
             /*     function add2(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value==""||frm.PQ.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		 
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             */
             
             /////////////////////
              function addScr(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		   
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             /////////////////////
             
             function addSw(frm){
		    
		    var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.ND.value==""||frm.NF.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		    
		
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
             }
             /////////////////////
             
             
             function prepaid(frm){
             
              var verif="false";
     
       /* if (frm.PQ.value=="")
          {alert("indiquer un PQ SVP");
           frm.PQ.focus();
           verif="true";}*/
           
           if (verif=="false")
     
        {setHidden('valider',frm);
         frm.submit();}
             }
             
             /////////////////////////////
             
     function testVide2(frm){
    var verif="false";
    /*
     if(frm.destinataire.value==""){
     
      alert("indiquer le type de destinataire SVP");
      frm.destinataire.focus();
      verif="true";
     }
     else
     
     {
        if (frm.libelle.value==""){
        alert("indiquer le destinataire SVP");
        frm.libelle.focus();
        verif="true";
        }
      else
      {
       */
        if (frm.profill.value==""){
        alert("indiquer le profil SVP");
        frm.profill.focus();
        verif="true";
      }  
     
     if (verif=="false")
     
     {setHidden('valider',frm);
      frm.submit();}
     
     
     
    
     
     }
     
     function testValid(frm){
     var verif="false";
  if   (document.getElementById('profill').disabled==false) 
  { if (frm.profill.value=="")
          {alert("indiquer un profil SVP");
           frm.profill.focus();
           verif="true";}}
           
           if (verif=="false")
  {setHidden('valider',frm);
         frm.submit();}
         

     }
             
     function test1(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		      if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		          if (frm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";} 
		                   
		                   
		                    if (frm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		    }
	
	/////////////////
	function valid(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		          if (frm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		                   if (frm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		    }
		    
		    //////////////////////
		    function verif(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		          if (frm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
} 

 if (frm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		    }
		    
		    ////////////////////////
		    
		    function pre(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         
 if (frm.hiddenTest.value =="rang deja touche") {
		         
		                   alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		          if (frm.hiddenTest.value =="probleme insertion") {
		         
		                   alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		    }
	
	
	/////////////////////////////
	
	
	
	
	
	 function confirmm(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="rang deja touche") {
		         
		                   alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		                 if (frm.hiddenTest.value =="probleme insertion") {
		         
		                   alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		    }
		    
		    ////////////////
		    
		     function scratch(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � activ�");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="rang deja touche") {
		         
		                   alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (frm.hiddenTest.value =="probleme insertion") {
		         
		                   alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		    }
	/////////////////////////
	
	function dmdSw(frm){
		    
		    if (frm.hiddenTest.value=="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   frm.hiddenTest.value="";
		                   
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();} 
		    
		     if (frm.hiddenTest.value=="range n'est pas dans la coll grande") {
		         
		                   alert("range n'existe pas dans la liste des ranges � charger pour swap");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";
		                                      
		                   frm.article.focus();}  
		                   
		       if (frm.hiddenTest.value =="serial d�but insuffisant") {
		         
		                   alert("Format de num�ro de s�rie d�but insuffisante, Resaisir SVP");
		                  
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="serial fin insuffisant") {
		         
		                   alert("Format de num�ro de s�rie fin insuffisante, Resaisir SVP");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         if (frm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   frm.hiddenTest.value="";
		                   frm.ND.value="";
		                   frm.NF.value="";
		                   frm.profil.value="";
		                   frm.article.value="";		                   
		                   frm.article.focus();
		               
		                   
		         } 
		         
		         
		         if (frm.hiddenTest.value =="rang deja touche") {
		         
		                   alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		         
		          if (frm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   frm.hiddenTest.value="";
		               
		                   
		         } 
		    }
		    
		    
		    
		     function addReserv(frm){
   
   var trouver = "false";
		    
		    if (frm.article.value=="" ||frm.qutQt.value==""||frm.warehouse.value=="")
		    {
		     alert("remplir les champs d'abord");
		     frm.article.focus();
             trouver="true";
		    }
		    
		     if (trouver=="false"){
 
             setHidden('Ajouter',frm);
             frm.submit();
  
             }
   
   
   }
   
    function modifreserv(frm){
   
   
   
     if (frm.hiddenTest.value=="quantite reserve sup"){
		                   
		                   alert('la quantit� r�serv�e est sup�rieure � la quantit� disponible !')
		                    frm.hiddenTest.value="";
		                   frm.qutQt.value=""; 
		                   frm.article.value="";
		                   frm.warehouse.value="";
		                    frm.PQ.value="";	
		                     frm.HLR.value="";			                   
		                   frm.article.focus();
		                   }
  
    if (frm.hiddenTest.value=="article dans la coll"){
		                   
		                   alert('Cet Article est d�ja choisi !')
		                  
		                   } 
	
	                   
		                   
		    
		     if (frm.hiddenTest.value=="article n'est pas dans la coll grande") {
		         
		                   alert("Article n'existe pas dans la liste des article � r�server");
		            
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                 }  
		                   
		     if (frm.hiddenTest.value=="annuler"){
		                   
		                   alert('la r�servation � �t� annul�e');
		                   
		     }
		     
		     if (frm.hiddenTest.value=="modifier"){
		                   
		                   alert('la r�servation � �t� modifi�e');
		                   
		     }
   
   }
   function reserv(frm){
   
     if (frm.hiddenTest.value=="S�lectionner un destinataire SVP"){
		                   
		                   alert('S�lectionner un destinataire SVP  !')
		                    frm.hiddenTest.value="";
		                    frm.destinataire.focus();
		                   }
   
     if (frm.hiddenTest.value=="quantite reserve sup"){
		                   
		                   alert('la quantit� r�serv�e est sup�rieure � la quantit� disponible !')
		                    frm.hiddenTest.value="";
		                   frm.qutQt.value=""; 
		                   frm.article.value="";
		                   frm.warehouse.value="";
		                    frm.PQ.value="";	
		                     frm.HLR.value="";			                   
		                   frm.article.focus();
		                   }
  
    if (frm.hiddenTest.value=="article dans la coll"){
		                   
		                   alert('Cet Article est d�ja choisi !')
		                   frm.hiddenTest.value="";
		                   frm.qutQt.value="";
		                   frm.article.value="";
		                   frm.warehouse.value="";
		                    frm.PQ.value="";	
		                     frm.HLR.value="";			                   
		                   frm.article.focus();
		                   } 
	
	if (frm.hiddenTest2.value=="remplir un destinataire"){
		                   
		                   alert("Choisir un destinataire d'abord !")
		                   frm.hiddenTest2.value="";
		                   frm.destinataire.focus();
		                   } 	                   
		                   
		    
		     if (frm.hiddenTest.value=="article n'est pas dans la coll grande") {
		         
		                   alert("Article n'existe pas dans la liste des article � r�server");
		                   frm.hiddenTest.value="";
		                   frm.qutQt.value="";
		                   frm.article.value="";
		                   frm.warehouse.value="";
		                    frm.PQ.value="";	
		                     frm.HLR.value="";			                   
		                   frm.article.focus();
		                   
		         } 
		         
		      if (frm.hiddenTest.value=="collection null"){
		                   
		                   alert('Ins�rer un article SVP!')
		                   frm.hiddenTest.value="";
		                   frm.qutQt.value="";
		                   frm.article.value="";
		                   frm.warehouse.value="";
		                    frm.PQ.value="";	
		                     frm.HLR.value="";			                   
		                 
		                                      
		                   frm.article.focus();}  
		                   
		     if (frm.hiddenTest.value=="annuler"){
		                   
		                   alert('la r�servation � �t� annul�e');
		                   
		     }
		     
		     if (frm.hiddenTest.value=="modifier"){
		                   
		                   alert('la r�servation � �t� modifi�e');
		                   
		     }
   
   }
   
   function validReserv(frm){
      var verif="false";
      
      if (frm.destinataire.value=="")
      {
      verif="true";
      alert("Veuillez choisir un destinataire SVP");
      frm.destinataire.focus();
      }
    
           if (verif=="false")
     
        {setHidden('valider',frm);
         frm.submit();}
       
   }
		    
			
	        		
    function confirmerND(frm){
    
   var test="false";
   var serial1=frm.ND.value;
     
   /*   if(frm.ND.value==""){
      
     alert("remplir le num�ro de s�rie d�but d'abord");
     frm.ND.focus();
     }*/
       
     if(frm.ND.value!=""){
      
             if (frm.hiddenTest.value=="SCRATCH"){
     
                       if (frm.ND.length<15){
      
                           alert('num�ro de s�rie Scratch insuffisant');
                           test="true";
                           frm.ND.focus();
                       }
               }
             else{
                       if (frm.ND.length<12){
      
                       alert('num�ro de s�rie Sim insuffisant');
                       test="true";
                       frm.ND.focus();
      
                       }
               }
      
     if(test=="false"){
 
  // code mod�rateur   
     
      var serial = prompt('Confirmer num�ro de s�rie debut','');
      var serial1=frm.ND.value// pas besoin de de 'String' qui est une erreur de syntaxe mais js est faiblement typ� et les variables ont le type de la derni�re valeur d�clar�e
      document.getElementById('ND').style.display = "none";// cripter le champs de texte pour que l'utilisateur ne voit pas le code tap�
      
      if(serial1==serial){
    	     frm.NF.focus();
	         alert("les deux serial sont �gales :"+serial)
	  }
      else{
      alert("num�ro de s�rie incorrect re�crire SVP");
      frm.ND.value="serial1";
      frm.ND.focus();
      
	  confirmer();
	  }
    
     }
  
      }
      }
      
      
     
      
       
 /*   window.onload = function(e){
    document.recepForm.NF.onkeyup = function(e){
        confirmer(e, document.recepForm.NF);
    }
}
function confirmer(e, elmt){
 var e=window.event || e;
if(e.keycode==13 && elmt.value.length==elmt.maxlength){
 var serial = prompt('Confirmer num�ro de s�rie debut','');
var serial1=document.recepForm.ND.value
if(serial1==serial){
	document.recepForm.NF.focus();
   }
 else{
  alert("num�ro de s�rie incorrect re�crire SVP");
      recepForm.ND.value="serial1";
      recepForm.ND.focus();
  
	}
 }
 else{
 recepForm.NF.value="serial1";
      recepForm.NF.focus();
 }
      }
      
     */ 
      
     
      
      function confirmer1(elmt){

if(elmt.value.length==elmt.maxlength){
 var serial = prompt('Confirmer num�ro de s�rie debut','');
var serial1=document.recepForm.NF.value
if(serial1==serial){
	document.recepForm.ND.focus();
   }
 else{
  alert("num�ro de s�rie incorrect re�crire SVP");
      recepForm.NF.value=serial1;
      recepForm.NF.focus();
  
	}
 }
 
 else
 {
  recepForm.ND.value=serial1;
      recepForm.ND.focus();
 }
      }
      
     //document.getElementById('ND').style.display = "none";	
	//prompt('Confirmer num�ro de s�rie debut','');
	// document.getElementById('ND').style.display = "none";
	// serial=prompt('Confirmer num�ro de s�rie debut','' );
	// document.recepForm.ND.focus();
	
	// alert(serial1);
	//  String serial1=document.recepForm.ND.value
	//  prompt('Confirmer num�ro de s�rie debut','');
	//  document.getElementById('ND').style.display = "none";	  
	 // serial=prompt('Confirmer num�ro de s�rie debut','' );
	 // alert(serial);
	//  alert(serial1);
	// frm.ND.focus();
	/*  if(serial1==serial){
	    document.recepForm.NF.focus();
	    alert(serial)
	  }
	  else{
	  confirmer();
	  }*/
	 // }
	  
	
	
	 function confirmerNF(frm){
     var test="false";
     var serial1=frm.NF.value;
     
      
       
      if(frm.NF.value!=""){
      
      if (frm.hiddenTest.value=="SCRATCH"){
     
      if (serial1.length<15){
      
      alert('num�ro de s�rie Scratch insuffisant');
      test="true";
      frm.NF.focus();
      }
      }
      else{
      if (serial1.length<12){
      
      alert('num�ro de s�rie Sim insuffisant');
      frm.NF.focus();
      test="true";
     // document.recepForm.NF.focus();
      }
      }
      
    /*  if(test=="false"){

	 prompt('Confirmer num�ro de s�rie debut','');
	 document.recepForm.NF.focus();
	 alert(serial1);
	  String serial1=document.recepForm.ND.value
	  prompt('Confirmer num�ro de s�rie debut','');
	  document.getElementById('ND').style.display = "none";	  
	  serial=prompt('Confirmer num�ro de s�rie debut','' );
	  if(serial1==serial){
	  document.recepForm.NF.focus();
	  alert(serial)
	  }
	  else{
	  confirmer();
	  }*/
	  
	  
	}}
	 

//fonctions naima

function testVidd(frm){
  
  var trouver = "false";
     
     
   if (frm.article.value=="" ||frm.debut.value=="")
   {
    alert("remplir les champs d'abord");
      frm.article.focus();
    trouver="true";
   }
  

  if (trouver=="false"){
 
  setHidden('ajouter1',frm);
  frm.submit(); 
  }  
  }









function testVidd2(frm){
  
  var trouver = "false";
     
     if (frm.profil.disabled==true)
     {
       if (frm.article.value=="" ||frm.debut.value==""||frm.fin.value=="")
          {
            alert("remplir les champs d'abord");
           trouver="true";
          }
          
     }
  else {
   if (frm.article.value=="" ||frm.debut.value==""||frm.fin.value==""||frm.profil.vallue=="")
   {
    alert("remplir les champs d'abord");
      frm.article.focus();
    trouver="true";
   }
  }


  if (trouver=="false"){
 
  setHidden('ajouter2',frm);
  frm.submit();
  
  }
  
  
  }

 function testt1(){
 
  if (document.packagingForm.hiddenTest.value =="S�lectionner un warehouse SVP"){
		                   
		                   alert('S�lectionner un warehouse SVP !')
		              	                   
		                   document.packagingForm.maga.focus();} 
		    
		    if (document.packagingForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   document.packagingForm.hiddenTest.value="";
		                   
		                   document.packagingForm.debut.value="";
		                   document.packagingForm.fin.value="";
		                   document.packagingForm.profil.value="";
		                   document.packagingForm.value="";		                   
		                   document.packagingForm.focus();} 
		    
		     if (document.packagingForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("range n'est pas parmi les rangs pr�ts pour etre packag�s");
		                   document.packagingForm.hiddenTest.value="";
		             
		                   
		         } 
		         
		           if (document.packagingForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   document.packagingForm.hiddenTest.value="";
		               
		 } 
		         
if (document.packagingForm.hiddenTest.value =="date limite inf")
{
                    alert("la date limite doit etre superieure � date d'aujourhui+5jours");
		                   document.packagingForm.hiddenTest.value="";
}		        

if (document.packagingForm.hiddenTest.value =="priorite vide")
{
                    alert("vous devez indiquez la priorite");
		                   document.packagingForm.hiddenTest.value="";
}



if (document.packagingForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   packagingForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		         if (document.packagingForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   packagingForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		             
		             
		             }



function test2(){
		    
		    if (envoiForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   envoiForm.hiddenTest.value="";
		                   
		                   envoiForm.debut.value="";
		                   envoiForm.fin.value="";
		                   envoiForm.profil.value="";
		                   envoiForm.article.value="";		                   
		                   envoiForm.article.focus();} 
		    
		     if (envoiForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("range n'est pas parmi les rangs � envoyer pour packaging");
		                   envoiForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (envoiForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   envoiForm.hiddenTest.value="";
		              
		                   
		         } 
		         
		     if (document.envoiForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   envoiForm.hiddenTest.value="";
		               
		                   
		         }     
		          if (document.envoiForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   envoiForm.hiddenTest.value="";
		               
		                   
		         } 
		    }
		    


function test3(){
		    
		    if (envoipackagForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   envoipackagForm.hiddenTest.value="";
		                   
		                   envoipackagForm.debut.value="";
		                   envoipackagForm.fin.value="";
		                   envoipackagForm.profil.value="";
		                   envoipackagForm.article.value="";		                   
		                   envoipackagForm.article.focus();} 
		    
		     if (envoipackagForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("range n'est pas parmi les rangs � envoyer pour packaging");
		                   envoipackagForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (envoipackagForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   envoipackagForm.hiddenTest.value="";
		              
		                   
		         } 
		         
		         if (envoipackagForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   envoipackagForm.hiddenTest.value="";
		               
		                   
		         }     
		         
		          if (document.envoipackagForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   envoipackagForm.hiddenTest.value="";
		               
		                   
		         } 

		     
		    }



function test4(){
		    
		     if (document.transfertForm.hiddenTest.value =="S�lectionner un warehouse source SVP"){
		                   
		                   alert('S�lectionner un warehouse SVP !')
		              	                   
		                   document.transfertForm.magasourc.focus();}
		    
		    if (transfertForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   transfertForm.hiddenTest.value="";
		                   
		                   transfertForm.debut.value="";
		                   transfertForm.fin.value="";
		                   transfertForm.profil.value="";
		                   transfertForm.article.value="";		                   
		                   transfertForm.article.focus();} 
		    
		     if (transfertForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("rang n'est pas parmi les rangs � transf�rer");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (transfertForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		         if (transfertForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		         
		         if (transfertForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         }  
		         
		          if (document.transfertForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         }   
		         
		            if (document.transfertForm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer de valider SVP");
		                   transfertForm.hiddenTest.value="";
		               
		                   
		         }   
		     
		    }
		    
		    
		    function testannuler(){
		    
		    if (rechercheForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   rechercheForm.hiddenTest.value="";
		                   
		                   rechercheForm.debut.value="";
		                   rechercheForm.fin.value="";
		                   rechercheForm.profil.value="";
		                   rechercheForm.article.value="";		                   
		                   rechercheForm.article.focus();} 
		    
		    
		    if (rechercheForm.hiddenTest.value =="trans n'est pas egale") {
		         
		                   alert("le code de la transaction n'est pas le meme");
		                   rechercheForm.hiddenTest.value="";
		               
		                   
		         }
		     if (rechercheForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("range n'est pas parmi les rangs � annuler");
		                   rechercheForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (rechercheForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   rechercheForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		         if (rechercheForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   rechercheForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		         
		         if (rechercheForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   rechercheForm.hiddenTest.value="";
		               
		                   
		         }     
		     
		    }






function test5(){
		    
		    if (transfert1Form.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   transfert1Form.hiddenTest.value="";
		                   
		                   transfert1Form.debut.value="";
		                   transfert1Form.fin.value="";
		                   transfert1Form.profil.value="";
		                   transfert1Form.article.value="";		                   
		                   transfert1Form.article.focus();} 
		    
		     if (transfert1Form.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("range n'est pas parmi les rangs � transf�rer");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (transfert1Form.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   transfert1Form.hiddenTest.value="";
		              
		                   
		         } 
		         
		     if (transfert1Form.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         }    
		         
		          if (document.transfert1Form.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         }     
		    }

function test6(){
		    
		    if (transfert1Form.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   transfert1Form.hiddenTest.value="";
		                   
		                   transfert1Form.debut.value="";
		                   transfert1Form.fin.value="";
		                   transfert1Form.profil.value="";
		                   transfert1Form.article.value="";		                   
		                   transfert1Form.article.focus();} 
		    
		     if (transfert1Form.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("ce range n'est pas parmi les rangs re�us");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (transfert1Form.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   transfert1Form.hiddenTest.value="";
		              
		                   
		         } 
		     
		     if (transfert1Form.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         }     
		        if (document.transfert1Form.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   transfert1Form.hiddenTest.value="";
		               
		                   
		         }     
		    }

function test7(){

if (document.reintegrForm.hiddenTest.value =="S�lectionner un warehouse source SVP"){
		                   
		                   alert('S�lectionner un warehouse SVP !')
		              	                   
		                   document.reintegrForm.magasourc.focus();}
		    
		    if (reintegrForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   reintegrForm.hiddenTest.value="";
		                   
		                   reintegrForm.debut.value="";
		                   reintegrForm.fin.value="";
		                   reintegrForm.profil.value="";
		                   reintegrForm.article.value="";		                   
		                   reintegrForm.article.focus();} 
		    
		    if (reintegrForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		    	
		    	     alert("ce range n'est pas parmi les rangs � r�int�grer"+ "\nAssurer vous des crit�res de recherche  ");
		            reintegrForm.hiddenTest.value="";
		            reintegrForm.debut.value="";
	                   reintegrForm.fin.value="";
	                   reintegrForm.profil.value="";
	                   reintegrForm.article.value="";	
		    	
		    }
		    
		     if (reintegrForm.hiddenTest.value =="range n'est pas dans la base") {
		         
		    	 
			     if (confirm("Ce rang n�a jamais exist� sur GSS "+ "\nvoulez vous le r�int�grer comme meme? ")) {    
			      //   setHidden('reintegr_nouveau_rang',document.reintegrForm)
			     
			         reintegrForm.position.disabled=false;
			         reintegrForm.packaging.disabled=false;
			         reintegrForm.PQ.disabled=false;
			         reintegrForm.botton2.disabled=false;
			         reintegrForm.hiddenTest.value="";
			         reintegrForm.idcode.disabled=true; 
			         
			    }
			     reintegrForm.hiddenTest.value="";
			   //  reintegrForm.submit(); 
               //  reintegrForm.hiddenTest.value="";
		            
		    	 
		    	 //      alert("ce range n'est pas parmi les rangs � r�int�grer");
		        //      reintegrForm.hiddenTest.value="";
		               
		                   
		         } 
		     
	
		         
		           if (reintegrForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   reintegrForm.hiddenTest.value="";
		              
		                   
		         } 
		         
		         if (reintegrForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   reintegrForm.hiddenTest.value="";
		               
		                   
		         }  
		            if (document.reintegrForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   reintegrForm.hiddenTest.value="";
		               
		                   
		         }     
		     
		    }


function test8(){

 if (document.sortiForm.hiddenTest.value =="S�lectionner un warehouse source SVP"){
		                   
		                   alert('S�lectionner un warehouse SVP !')
		              	                   
		                   document.sortiForm.magasourc.focus();}
		    
		    if (sortiForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   sortiForm.hiddenTest.value="";
		                   
		                   sortiForm.debut.value="";
		                   sortiForm.fin.value="";
		                   sortiForm.profil.value="";
		                   sortiForm.article.value="";		                   
		                   sortiForm.article.focus();} 
		    
		     if (sortiForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("ce range n'est pas parmi les rangs � autoriser � sortir");
		                   sortiForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (sortiForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   sortiForm.hiddenTest.value="";
		              
		                   
		         } 
		         
		           if (sortiForm.hiddenTest.value =="fin inferieur debut") {
		         
		                   alert("le num de s�rie fin<num de s�rie debut");
		                   sortiForm.hiddenTest.value="";
		               
		                   
		         }
		         
		          if (sortiForm.hiddenTest.value =="quantitesup") {
		         
		                   alert("Vous avez autorisez au-del� de la quantit� r�serv�e ");
		                   sortiForm.hiddenTest.value="";
		               
		                   
		         }
		         
		          if (document.sortiForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   sortiForm.hiddenTest.value="";
		               
		                   
		         }   
		               if (document.sortiForm.hiddenTest.value =="probleme insertion") {
		         alert("Une erreur c'est produite  veuillez R��ssayer SVP de valider");
		                   sortiForm.hiddenTest.value="";
		               
		                   
		         }    
		    
		    }

function tdp(){  

 if (document.tdpForm.hiddenTest.value =="S�lectionner un warehouse source SVP"){
		                   
		                   alert('S�lectionner un warehouse SVP !')
		              	                   
		                   document.tdpForm.warehouse.focus();}
		    
		    if (tdpForm.hiddenTest.value =="range dans la coll"){
		                   
		                   alert('Ce Range/ une partie de ce Range est d�ja choisie !')
		                   tdpForm.hiddenTest.value="";
		                   
		                   tdpForm.ND.value="";
		                   tdpForm.FN.value="";
		                   tdpForm.profil.value="";
		                   tdpForm.article.value="";		                   
		                   tdpForm.article.focus();} 
		    
		     if (tdpForm.hiddenTest.value =="range n'est pas dans la coll grande") {
		         
		                   alert("ce range n'est pas parmi la liste des article");
		                   tdpForm.hiddenTest.value="";
		               
		                   
		         } 
		         
		           if (tdpForm.hiddenTest.value =="collection null") {
		         
		                   alert("voulez vous introduire des articles SVP");
		                   tdpForm.hiddenTest.value="";
		              
		                   
		         } 
		         
		           if (tdpForm.hiddenTest.value =="FN inferieur ND") {
		         
		                   alert("le num de s�rie FN<num de s�rie ND");
		                   tdpForm.hiddenTest.value="";
		               
		                   
		         }
		         
		        
		         
		          if (document.tdpForm.hiddenTest.value =="rang deja touche") {
		         alert("Une personne est en train d'effectuer une transaction sur le m�me rang\n R��ssayer SVP");
		                   tdpForm.hiddenTest.value="";
		               
		                   
		         }     
		    
		    }



	
function validd(){

var vrai="false";
		   if (document.packagingForm.parten.value =="")
		         {alert("Ins�rer un partenaire SVP")
		          document.packagingForm.parten.focus();
		          vrai ="true";
		         }
		          
		 
	 else{            
		              
		    if (document.packagingForm.dat.value =="")
		            {
		             alert("voulez vous indiquer une date limite SVP")
		             document.packagingForm.dat.focus();
		             vrai ="true";
		              
		            } 
		            
		                        else{
		        n = (document.packagingForm.priorite.length) ;
                 var checkvalue = '';

   for (i=0; i<n; i++)
   {
	 if (document.packagingForm.priorite[i].checked)
     {
         checkvalue = document.packagingForm.priorite[i].value;
    break;
     }
   }

   if(checkvalue == '')
   {
       alert('veuillez s�lectionner une priorit� SVP!');
        vrai ="true";
       return(false);
   }
  
}
		            }
	   
		        if (vrai=="false")
		                {
		                   setHidden('valider',document.packagingForm)
		                   document.packagingForm.submit(); 
		                }                 
		             
		     }

 
 
 function valid1(){
		   if (document.envoiForm.doc.value =="")
		         {alert("voulez vous indiquer le num de r�f�rence externe SVP")
		          document.envoiForm.doc.focus();
		         }
		          
		               
		                else 
		                {
		                   setHidden('valider',document.envoiForm)
		                   envoiForm.submit(); 
		                }
		              
		     }
 
 
 function valid2(){
		   if (document.envoipackagForm.doc.value =="")
		         {alert("voulez vous indiquer le num de r�f�rence externe SVP")
		          document.envoipackagForm.doc.focus();
		         }
		          
		               
		                else 
		                {
		                   setHidden('valider',document.envoipackagForm)
		                   envoipackagForm.submit(); 
		                }
		              
		     }
		     
		     
		     
function valid3(){
		   if (document.transfertForm.magadist.value =="")
		         {alert("voulez vous choisir un magasin de distination SVP")
		          document.transfertForm.magadist.focus();
		         }
		          
		               
		                else 
		                {
		                   setHidden('valider',document.transfertForm)
		                   transfertForm.submit(); 
		                }
		              
		     }
		     
		     
		     
		     function transfert_verif(){  
		   if (document.transfertForm.magasourc.value =="")
		         {alert("voulez vous choisir un magasin  SVP")
		          document.transfertForm.magasourc.focus();
		         }
		          
		               
		                else 
		                {
		                
		                  if (document.transfertForm.article1.value =="")
		         {alert("voulez vous choisir un article  SVP")
		          document.transfertForm.article1.focus();
		         }
		         else
		         {
		                   setHidden('chercher',document.transfertForm)
		                   transfertForm.submit(); 
		                }
		              
		     }

 }
 
  function valid4(){
		   if (document.transfert1Form.doc.value=="")
		         {alert(" vous devez indiquez un num de r�ference externe SVP")
		          document.transfert1Form.doc.focus();
		         }
		          
		               
		                else 
		                {
		                   setHidden('valider',document.transfert1Form)
		                   document.transfert1Form.submit(); 
		                }
		              
		     }
 
 
 function valid5(){
		   if (document.reintegrForm.doc.value=="")
		         {alert(" vous devez indiquez un num de r�ference externe SVP")
		          document.reintegrForm.doc.focus();
		         }
		          
		               
		                else 
		                {
		                   setHidden('valider',document.reintegrForm)
		                   reintegrForm.submit(); 
		                }
		              
		     }
		     
function valid6(){

 if ((document.sortiForm.magasourc.value==""))
{ alert("vous devez indiquez un magasin  SVP")
          document.sortiForm.magasin.focus();
          }
          else
 { if ((document.sortiForm.distination.value==""))
{ alert("vous devez indiquez un destinataire  SVP")
          document.sortiForm.distination.focus();
          }else{
		              

     setHidden('valider',document.sortiForm)
	 sortiForm.submit(); 

	   
		            } }        
		     }

function valid60(){

	 if ((document.returnForm.magasourc.value==""))
	{ alert("vous devez indiquez un magasin  SVP")
	          document.returnForm.magasin.focus();
	          }
	          else
	 { if ((document.returnForm.distination.value==""))
	{ alert("vous devez indiquez un destinataire  SVP")
	          document.returnForm.distination.focus();
	          }else{
			              

	     setHidden('valider',document.returnForm)
		 returnForm.submit(); 

		   
			            } }        
			     }
		     
		     
		     function chercher_sortie(){
		     
		      if ((document.sortiForm.magasourc.value==""))
{ alert("vous devez indiquez un magasin  SVP")
          document.sortiForm.magasourc.focus();
          }
          else
 { if ((document.sortiForm.distination.value==""))
{ alert("vous devez indiquez un destinataire  SVP")
          document.sortiForm.distination.focus();
          }else{
		              
		      if ((document.sortiForm.article1.value==""))
{ alert("vous devez indiquez un article  SVP")
          document.sortiForm.article1.focus();
          }
     else
     {

     setHidden('chercher',document.sortiForm)
	 sortiForm.submit(); 

	   }
		            } } 
		 }    
		     
		  
		     function chercher_retour(){
			     
			      if ((document.returnForm.magasourc.value==""))
	{ alert("vous devez indiquez un magasin  SVP")
	          document.returnForm.magasourc.focus();
	          }
	          else
	 { if ((document.returnForm.distination.value==""))
	{ alert("vous devez indiquez un destinataire  SVP")
	          document.returniForm.distination.focus();
	          }else{
			              
			      if ((document.returnForm.article1.value==""))
	{ alert("vous devez indiquez un article  SVP")
	          document.returnForm.article1.focus();
	          }
	     else
	     {

	     setHidden('chercher',document.returnForm)
		 returnForm.submit(); 

		   }
			            } } 
			 }
		     

/*if (confirm("Etes-vous s�r de vouloir valider cette transaction ?")) {
     setHidden('valider',document.sortiForm)
	 sortiForm.submit(); 
}*/

		     
		     function validreserv(){
		     
		     if ((document.sortiForm.magasin.value==""))
{ alert("vous devez indiquez un magasin  SVP")
          document.sortiForm.magasin.focus();
          }
          if ((document.sortiForm.distination.value==""))
{ alert("vous devez indiquez un destinataire  SVP")
          document.sortiForm.distination.focus();
          }
if ((document.sortiForm.codaprob.value==""))
{ alert("vous devez indiquez le code de la r�servation  SVP")
          document.sortiForm.codaprob.focus();
          }
          
       else 
		                {
		                
		                
		                
		                   setHidden('valider2',document.sortiForm)
		                   sortiForm.submit(); 
		             }        
		     }



function valid7(){
		   if (document.sortiForm.doc.value=="")
		         {alert(" vous devez indiquez un num de r�ference externe SVP")
		          document.sortiForm.doc.focus();
		         }
		          
		               
		                else 
		                {
		               
		               setHidden('valider',document.sortiForm)
		                  sortiForm.submit();
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


function activer(){
if(document.getElementById('article').value=="SIM PREPAID ALLO"||document.getElementById('article').value=="SIM PREPAID DJEZZY"||document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS 128K")  
{
document.getElementById('fin').maxLength="12";
document.getElementById('debut').maxLength="12";
document.getElementById('sup').maxLength="12";
document.getElementById('sup1').maxLength="12";
}
else
{
document.getElementById('fin').maxLength="15";
document.getElementById('debut').maxLength="15";
document.getElementById('sup').maxLength="15";
document.getElementById('sup1').maxLength="15";
}

/*
if(document.getElementById('article').value=="SIM POSTPAID DJEZZY")
{document.getElementById('profil').disabled=false;}
else
{document.getElementById('profil').disabled=true;}*/

 }
 

function activer2(){
if(document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID ALLO"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
document.getElementById('NF').maxLength="12";
document.getElementById('ND').maxLength="12";
document.getElementById('sup').maxLength="12";
document.getElementById('sup1').maxLength="12";
}
else
{
document.getElementById('NF').maxLength="15";
document.getElementById('ND').maxLength="15";
document.getElementById('sup').maxLength="15";
document.getElementById('sup1').maxLength="15";
}

/*
if (document.getElementById('article').value=="SIM POSTPAID DJEZZY")
{
document.getElementById('profil').disabled=false;
}
else{
document.getElementById('profil').disabled=true;
}
*/
 }
 
 
 function activer3(){
if(document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID ALLO" ||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
document.getElementById('NF').maxLength="12";
document.getElementById('ND').maxLength="12";
document.getElementById('sup').maxLength="12";
document.getElementById('sup1').maxLength="12";
}
else
{
document.getElementById('NF').maxLength="15";
document.getElementById('ND').maxLength="15";
document.getElementById('sup').maxLength="15";
document.getElementById('sup1').maxLength="15";
}


/*if (document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL")
{
document.getElementById('profil').disabled=false;
}
else{
document.getElementById('profil').disabled=true;
}*/

 }
 
 
 
 
 
 
 
function max(elmt){
if(document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID ALLO"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
elmt.maxLength="12";
}
else
{
elmt.maxLength="15";
}
}


function affPrompt(elm,elm1,elm2){
     

if(document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID DJEZZY"||document.getElementById('article').value=="SIM PREPAID ALLO"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
elm2.size="12";
elm2.maxLength="12";
elm.maxLength="12";
}
else
{
elm2.size="15";
elm2.maxLength="15";
elm.maxLength="15";
}



if( elm.value.length==elm.maxLength){

elm1.style.display='block';
elm2.focus(); 
document.getElementById('start_div').value=elm.value;
document.getElementById('end_div').value=elm.value;
elm.value="***************";
}
else
{
alert("La taille du num�ro saisi est insuffisante"); 
}
//document.getElementById('fin').value="13";


}


function quelle_touche(event)
{
var touche = window.event ? event.keyCode : evenement.which;

if (touche == 13) {
return false;
} else {
alert(touche);
return touche;
}
}

//elm2.size=elm.maxLength;
//elm2.maxLength=elm.maxLength;

// }


function comparer(fin,deb) {
if(document.getElementById('sup').value.length==document.getElementById('sup').maxLength)
{
if(document.getElementById('sup').value==document.getElementById('start_div').value)
{
document.getElementById('le_prompt').style.display='none';
document.getElementById('hiddenTest').value="confirmation";
deb.value=document.getElementById('start_div').value;

fin.focus();
//document.getElementById('fin').focus();
}
else
{
document.getElementById('le_prompt').style.display='none';
 alert("Veuillez  resaisir le num�ro de s�rie  SVP");
// document.getElementById('hiddenTest').value="echec";
 deb.focus();
deb.value="";
}
document.getElementById('sup').value="";
}
}



function comparer1(fin) {
if(document.getElementById('sup1').value.length==document.getElementById('sup1').maxLength)
{
if(document.getElementById('sup1').value==document.getElementById('end_div').value)
{
document.getElementById('le_prompt1').style.display='none';
document.getElementById('hiddenTest').value="confirmation2";
fin.value=document.getElementById('end_div').value;
}
else
{
document.getElementById('le_prompt1').style.display='none';
 alert("Veuillez  resaisir le num�ro de s�rie SVP ");
 document.getElementById('hiddenTest').value="echec2";
 fin.focus();
fin.value="";
}
document.getElementById('sup1').value="";
}
}

function tester3(elm)
{
if( (document.getElementById('hiddenTest').value=="demande")||(document.getElementById('hiddenTest').value=="echec"))
{
elm.focus();
}
else
{
//tro="true";

}
}


function tester4()
{
(document.getElementById('hiddenTest').value="demande");
}



function tester2(elm)
{
var tro="true";

//document.getElementById('debut').value=document.getElementById('hiddenTest').value;
if(document.getElementById('le_prompt1').style.display=='block')
{
document.getElementById('sup1').focus();
}
else
{
if(elm.value.length==elm.maxLength)
{
if( (document.getElementById('hiddenTest').value=="demande")||(document.getElementById('hiddenTest').value=="echec")||document.getElementById('hiddenTest').value=="confirmation")

{
 tro="false";
}
if( (document.getElementById('hiddenTest').value=="demande2")||(document.getElementById('hiddenTest').value=="echec2"))
{
tro="true";
}

if (tro=="true")
{
if (document.getElementById('hiddenTest').value=="confirmation2")
  {
	  tro="false";
  }
  else
	  {
    alert("veuillez confirmer la saisi avec la touche Entr�e  svp"); 
elm.focus();
  }
}

}
}
}





function testersup1(num) 

{
if(document.getElementById('le_prompt1').style.display=='block')
{
document.getElementById('sup1').focus();
}
}


function testersup(num) 

{
if(document.getElementById('le_prompt').style.display=='block')
{
document.getElementById('sup').focus();
}
}





function tester(num) {
var trou;


if(document.getElementById('le_prompt').style.display=='block')
{
document.getElementById('sup').focus();
}

else{
if(num.value.length==num.maxLength)
{
if (document.getElementById('hiddenTest').value=="confirmation")
  {
	  trou="false";
	 // document.getElementById('fin').focus();
  }
  else
	  {
    alert("veuillez confirmer la saisi avec la touche Entr�e  svp"); 
num.focus();
  }
 
  }
/*  else{

 num.focus();
  }*/
}  

}


var res;
function activreserv(){
  
    if  (document.getElementById('reserv').value=="avec reserv" )  
    {
    document.sortiForm.codaprob.disabled=false;
    document.sortiForm.popup.disabled=false;
 
    }
  
    }
    
   function  DetecteTouche(touche){
var EnterKey
 e = event
    EnterKey = e.keyCode // IE specific code
  
  return  (EnterKey == touche) 
}




 function  DetecteTouche(e, touche){
var EnterKey
  if(e && e.which){           // pour non IE
    e = e
    EntrerKey = e.which
  }
  else {
    e = event
    EnterKey = e.keyCode // IE specific code
  }
  return  (EnterKey == touche) 
}


 function  activsubmit(frm,elm)
     {
     document.getElementById('hiddenTest').value="true";
     setHidden(elm,frm);
     frm.submit();
     }
     
      function  activsubmit1(frm)
     {
     document.getElementById('hiddenTest').value="true";
     setHidden(editExcel,frm);
     frm.submit();
     }


function testersubmit(){ 
//document.getElementById('fin').value=document.getElementById('hiddenTest').value ;
if(document.getElementById('hiddenTest').value=="true")
{return true;}
else
{return false;}
}

function sessionexpire()
{
alert("Votre session a expir� veuillez se reconnecter SVP")}



function testafficher_rang(frm){
    var verif="false";
       if (frm.article1.value=="")
         {alert("indiquer un article SVP");
          frm.article1.focus();
          verif="true";}
          
          if (verif=="false")
 {setHidden('afficherrang',frm);
        frm.submit();}
        

    }





function testViddreintegr(frm){
	  
	  var trouver = "false";
	     
	  if (trouver=="false"){

		  
	  setHidden('reintegr_nouveau_rang',frm);  
	  frm.submit(); 
	  }  
	  }


function recuperparametre(param,param2)    
{
document.getElementById('article').value=param;
document.getElementById('debut').value=param2;
/*
if (param1=="_"){param1="";}
document.getElementById('profil').value=param1;
document.getElementById('debut').value=param2;
document.getElementById('fin').value=param3;
document.getElementById('rng_id').value=param4;
document.getElementById('act_id').value=param5;
*/
}


       

function check()
{
if  ((document.parametre1Form.admincds.checked==false)&&(document.parametre1Form.adminwrhs.checked==false) &&(document.parametre1Form.adminfrns.checked==false) &&(document.parametre1Form.adminprtnr.checked==false) &&
	(document.parametre1Form.adminartcl.checked==false) &&(document.parametre1Form.admin.checked==false) &&(document.parametre1Form.magaberaki.checked==false) &&(document.parametre1Form.edition.checked==false))

{alert("Aucun profil  n�est s�lectionn�")
	return false ;}
else
{return true;}

}

function check1()
{
	var trouv=true;
if  ((document.parametre1Form.magaberaki.checked==true)&&(document.parametre1Form.warehouse.value==""))

{alert("veuillez choisir un warehouse pour le profil magasinier SVP ")
document.parametre1Form.warehouse.focus();
trouv=false;
return false ;}

if  ((document.parametre1Form.charge.checked==true)&&(document.parametre1Form.distributeur.value==""))

{alert("veuillez choisir un distributeur  pour le profil charg� de compte SVP ") 
document.parametre1Form.distributeur.focus();
trouv=false;
return false ; }


if  ((document.parametre1Form.sales.checked==true)&&(document.parametre1Form.cds.value==""))

{alert("veuillez choisir un CDS pour le profil responsable CDS SVP ") 
document.parametre1Form.cds.focus();
trouv=false;
return false ; }

if  ((document.parametre1Form.coordinateur.checked==true)&&(document.parametre1Form.region.value==""))

{alert("veuillez choisir une r�gion  pour le profil coordinateur r�gion SVP ")
document.parametre1Form.region.focus();
trouv=false;
return false ; }

if (trouv==true)
{return true;}

}

function testVid2new(frm){
 
  var trouver ="false";
   
    
   if (frm.art_id.value=="" ||frm.ND.value==""||frm.NF.value=="")
   {
    alert("remplir les champs d'abord");
  
    trouver="true";
   }
  if(frm.NF.value-frm.ND.value<0){
  alert("Range invalid : num�ro debut > num�ro fin");
    } else
  if (trouver=="false"){
  
  setHidden('ajouter', frm);
  frm.submit();
  
  }
  
  
  }


function affPromptByPo(elm,elm1,elm2){
     
var frm = document.forms[0];
var v = document.getElementById("art_id").value;
  
if(v=="SIM POSTPAID DJEZZY"||v=="SIM PREPAID DJEZZY"||v=="SIM PREPAID ALLO"||v=="SIM POSTPAID DJEZZY BUSINESS"||v=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||v=="SIM POSTPAID DJEZZY CLASSIC"||v=="SIM POSTPAID DJEZZY CONTROL"||v=="SIM POSTPAID DJEZZY CONTROL 128 K"||v=="SIM POSTPAID DJEZZY CLASSIC  128 K"||v=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||v=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
elm2.size="12";
elm2.maxLength="12";
elm.maxLength="12";
}
else
{
elm2.size="15";
elm2.maxLength="15";
elm.maxLength="15";
}



if( elm.value.length==elm.maxLength){

elm1.style.display='block';
elm2.focus(); 
document.getElementById('start_div').value=elm.value;
document.getElementById('end_div').value=elm.value;
//elm.value='***************';
}
else
{
alert("La taille du num�ro saisi est insuffisante"); 
}
//document.getElementById('fin').value="13";


}

function activer03(){
 
//if(document.getElementById('art_id')!=null)
{
if(document.getElementById('art_id').value=="SIM POSTPAID DJEZZY"||document.getElementById('art_id').value=="SIM PREPAID DJEZZY"||document.getElementById('art_id').value=="SIM PREPAID ALLO" ||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY CONTROL"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY CONTROL 128 K"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY CLASSIC  128 K"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"||document.getElementById('art_id').value=="SIM POSTPAID DJEZZY BUSINESS 128K")
{
document.getElementById('NF').maxLength="12";
document.getElementById('ND').maxLength="12";
document.getElementById('sup').maxLength="12";
document.getElementById('sup1').maxLength="12";
}
else
{
document.getElementById('NF').maxLength="15";
document.getElementById('ND').maxLength="15";
document.getElementById('sup').maxLength="15";
document.getElementById('sup1').maxLength="15";
}
}

/*if (document.getElementById('article').value=="SIM POSTPAID DJEZZY"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS"||document.getElementById('article').value=="SIM POSTPAID DJEZZY BUSINESS CONTROL"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CLASSIC"||document.getElementById('article').value=="SIM POSTPAID DJEZZY CONTROL")
{
document.getElementById('profil').disabled=false;
}
else{
document.getElementById('profil').disabled=true;
}*/

 }




function valid_reintegr(){
	   if (document.reintegrForm.maga_reintegr.value=="")
	         {alert(" vous devez indiquez entrepot de r�int�gration SVP")
	          document.reintegrForm.maga_reintegr.focus();
	         }
	     	               
	                else 
	                {
	                   setHidden('valider',document.reintegrForm)
	                   document.reintegrForm.submit(); 
	                }
	              
	     }
		 
		 
		 
		 
