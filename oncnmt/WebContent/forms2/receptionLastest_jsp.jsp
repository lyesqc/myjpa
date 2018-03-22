 
 
 
 
 
 
 
 
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="fr">
  <head>
    <base href="http://otadebflexy:6552/gss2/forms/receptionLastest.jsp">
    
    <title>Reception</title>
 <link rel="stylesheet" href="/gss2/config/default.css" type="text/css"><script type="text/javascript">var imgsrc="/gss2/config/"; var scriptsrc="/gss2/config/"; var langue="fr"; var contextPath="/gss2";</script><script type="text/javascript" src="/gss2/config/javascript.js"></script>
 
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
  
 
 
 
  
   
 
 
 
 
 
 
 
 
 
 
 
   
   
  
 
 
   
 
     
     
                       
                   
     
    
 
 
     
 
 
 
       
             
           
 
 
 
 
          
            
           
 
 
 
 
 
              
 
  
 
 
     
     
     
      
 
 
 
       
            
 
  
 
 
 
                  
 
 
 
 
 
 
  
 
 
 
 
 
 
            
 
 
              
     
 
 
 
 
        
     
     
    
       
          
         
         
         
       
         
             
             
   
 
 
              
          
         
      
                
     
     
       
      
      
           
       
          
         
    
    
    
    
    
      
          
          
            
      
                   
      
             
  
  
  
 
 
      
      
                              
                                
                              
                              
    
 
 
 
 
 
                         
                              
                              
                              
                              
                                
           
  
  
  
       
 
      
     
                               
  
 
                            
                                                   
                             
                             
                                     
                  
      
      
             
      
  
         
        
 
 
  
          
         
         
      
        
       
      
                     
                   
         
                    
                      
                    
                     
 
 
 
 
                      
                  
 
 
                   
                     
                      
                     
 
 
 
 
                     
                      
                     
                     
                 
                   
                   
                                     
                   
                                      
                     
                      
                     
 
 
 
 
                     
                       
                     
  
                   
                   
        
      
      
          
                                      
                     
                      
                     
 
 
 
 
                     
                       
                     
 
 
                                 
                   
      
       
               
                    
                      
                    
                     
                   
                   
 
                      
                      
                      
                             
                    
 
 
   
  
      
      
                  
                             
 
 
      
                  
                             
 
      
  
 
 
     
 
                  
                             
 
 
  
 
 
   
     
 
 
 
 
 
                
    
   
 
     
      
       
     
 
 
 
    
 
 
  
            
 
          
 
 
 
     
 
         
     
      
 
 
     
     
      
 
 
                         
                              
                            
                              
 
     
   
 
  
  
  
 
  
 
 
      
    
       
   
 
  
   
                         
                   
              
                      
      
     
                                  
 
  
      
     
                                        
 
  
  
      
    
 
     
   
   
                     
                      
                      
                        
                      
    
                                    
                                 
                                 
                                 
                                 
                                 
                                   
                                   
                                 
    
                                 
                               
                    
                      
                      
   
  
       
      
      
  
 <script LANGUAGE='JavaScript1.2' TYPE='text/javascript'> 
HM_Array1 = [
[140,100,5,"#ffffff","#FFFFFF","#990000","#c08080","#c00000","#c00000",1,1,0,1,1,1,"null","null" ],
["Mouvements","",1,0,1]
,["Action","",1,0,1]
,["Edition","",1,0,1]
,["Administration","",1,0,1]
,["Déconnexion ","forms/login.jsp",1,0,0]
]
 
HM_Array1_2 = [
[],
["Activation Postpaid","",1,0,1]
,["Activation Prepaid","",1,0,1]
,["Chargement Scratch","",1,0,1]
,["Affectation statut","",1,0,1]
,["Désactivation SIMS et SCRATCHS","",1,0,1]
,["Dépackaging des Sims","",1,0,1]
,["Annulation transaction","",1,0,1]
,["Réservation","",1,0,1]
,["Approbation/Validation","/gss2/approbation.do?hidden=recherche",1,0,0]
,["Validation des transactions","/gss2/approbation.do?hidden=initiallisttransaction",1,0,0]
]
 
HM_Array1_2_3 = [
[],
["Demande de chargement","/gss2/preparScr.do",1,0,0]
,["Confirmation de chargement","/gss2/confirmChargement.do?hidden=ouvrir",1,0,0]
]
 
HM_Array1_2_6 = [
[],
["Dépackaging des Sims","/gss2/nonactivpost.do?param=depackaging",1,0,0]
]
 
HM_Array1_2_1 = [
[],
["Demande d'activation","",1,0,1]
,["Confirmation d'activation","/gss2/preparConfirm.do",1,0,0]
]
 
HM_Array1_2_1_1 = [
[],
["Pré/Activé","/gss2/preactivpost.do",1,0,0]
]
 
HM_Array1_2_8 = [
[],
["rapport des réservations","/gss2/listreserv.do?hidden=rapportreserv",1,0,0]
]
 
HM_Array1_2_4 = [
[],
["Affectation Swap","",1,0,1]
,["affectation profil prepaid","",1,0,1]
,["affectation profil postpaid","",1,0,1]
,["affectation promotion/sécurité scratch","/gss2/nonactivpost.do?param=affpromoscratch",1,0,0]
,["Affectation Test","/gss2/preparTest.do",1,0,0]
,["Affectation Perdu","/gss2/preparPerdu.do",1,0,0]
,["Affectation Défecteux","/gss2/preparDefect.do",1,0,0]
]
 
HM_Array1_2_4_1 = [
[],
["Demande Swap/Postpaid","/gss2/preparSwpo.do",1,0,0]
,["Confirmation Swap/Postpaid","/gss2/confirmSwpo.do?param=confirmpostswap",1,0,0]
,["Demande Swap/Prepaid","/gss2/preparSwpr.do",1,0,0]
,["Confirmation Swap/Prepaid","/gss2/confirmSwpr.do",1,0,0]
]
 
HM_Array1_2_4_3 = [
[],
["Demande d'affectation","/gss2/nonactivpost.do?param=demandprofilpost",1,0,0]
,["Confirmation d'affectation","/gss2/confirmSwpo.do?param=confirmprofilpost",1,0,0]
]
 
HM_Array1_2_4_2 = [
[],
["Demande d'affectation","/gss2/nonactivpost.do?param=demandempromo",1,0,0]
,["Confirmation d'affectation","/gss2/confirmSwpo.do?param=confirmpromo",1,0,0]
]
 
HM_Array1_2_2 = [
[],
["Demande d'activation","/gss2/preparPre.do",1,0,0]
,["Confirmation d'activation","/gss2/confirmPrepaid.do?hidden=ouvrir",1,0,0]
]
 
HM_Array1_2_7 = [
[],
["annuler une transaction","/gss2/annuler.do?hidden=afficher",1,0,0]
]
 
HM_Array1_2_5 = [
[],
["demande de désactivation","/gss2/nonactivpost.do?param=demanddesactiv",1,0,0]
,["confirmation de désactivation","/gss2/nonactivpost.do?param=confirmdesactiv",1,0,0]
]
 
HM_Array1_4 = [
[],
["Paramètrage utilisateur","/gss2/preparparametre.do",1,0,0]
,["Paramètrage distributeur","/gss2/afficherparametre.do?param=DISTRIBUTEUR",1,0,0]
,["Paramètrage fournisseur","/gss2/afficherparametre.do?param=FOURNISSEUR",1,0,0]
,["Paramètrage partenaire","/gss2/afficherparametre.do?param=PARTENAIRE",1,0,0]
,["Paramètrage CDS","/gss2/afficherparametre.do?param=CDS",1,0,0]
,["Paramètrage SORTIE DIVERSE","/gss2/afficherparametre.do?param=SORTIE DIVERSE",1,0,0]
,["Paramètrage article","/gss2/parametre1.do?hidden=afficheraricle ",1,0,0]
,["Paramètrage warehouse","/gss2/parametre1.do?hidden=afficherwarehouse",1,0,0]
]
 
HM_Array1_3 = [
[],
["Rapport des transactions","/gss2/recherche.do",1,0,0]
,["Bon des transaction","javascript:window.open('rechedit.do','','location=250,status=0,scrollbars=0,width=350,height=250');void('');",1,0,0]
,["Etat de Stock","/gss2/preparStk.do",1,0,0]
,["Ready for distribution","/gss2/stock.do?hidden=ready",1,0,0]
,["Etat distribution","javascript:window.open('stock.do?hidden=preparetatdist','','location=250,status=0,scrollbars=0,width=350,height=350');void('');",1,0,0]
,["Rapport global","/gss2/rapport_global.do?hidden=initial_rapport",1,0,0]
,["Rapport réservation  global","/gss2/rapport_global.do?hidden=initial_rapport_reservation",1,0,0]
]
 
HM_Array1_1 = [
[],
["Réception","",1,0,1]
,["Packaging","",1,0,1]
,["Transfert","",1,0,1]
,["Sortie","",1,0,1]
,["Reintégration","",1,0,1]
]
 
HM_Array1_1_5 = [
[],
["Autorisation de reintégration","/gss2/autoreintegr.do",1,0,0]
,["Exécution reintégration","/gss2/afficher2.do",1,0,0]
]
 
HM_Array1_1_3 = [
[],
["Ordre de transfert","/gss2/ordretrans1.do?hidden=afficher",1,0,0]
,["Envoie transfert","/gss2/afficher.do",1,0,0]
,["Reception transfert","/gss2/afficher1.do",1,0,0]
]
 
HM_Array1_1_1 = [
[],
["Ajouter réception","/gss2/afficherecep.do",1,0,0]
]
 
HM_Array1_1_4 = [
[],
["Autorisation de sortie sans réservation","/gss2/autosorti.do?hidden=afficher",1,0,0]
,["Autorisation de sortie avec réservation","/gss2/autosorti.do?hidden=afficherreserv",1,0,0]
,["Exécution sortie","/gss2/afficher5.do",1,0,0]
]
 
HM_Array1_1_2 = [
[],
["Ordre de packaging","/gss2/package.do",1,0,0]
,["Envoie packaging","/gss2/afficher3.do",1,0,0]
,["Reception packaging","/gss2/afficher4.do",1,0,0]
]
 
</script>
<SCRIPT LANGUAGE="JavaScript1.2" SRC="/gss2/config/HM_Loader.js" TYPE='text/javascript'></SCRIPT>
  
 
 <hr>
 
    <form name="RecepLatestForm" method="post" action="/gss2/recepLatest.do" onsubmit="return false;">
<table cellspacing="0" cellpadding="0" border="0"><tr><td valign="top"><table cellspacing="1" cellpadding="1" border="0" width="100%">
<tr><td><table width="100%"	border="0">
<tr><td colspan="2">&nbsp;</td></tr>
 
    
      
     
      
       <tr><td colspan="2"><table border="0"><tr>
       
       
          
           <td colspan="2"><table border="0" cellspacing="0" cellpadding="0">      
              <tr><td>&nbsp;</td><td><input type="button" value="Annuler" onclick="activsubmit(document.recepForm,'annuler');"></td></tr>
 
            </table></td>
 
              <td>&nbsp;&nbsp;</td>
<td colspan="2"><table border="0" cellspacing="0" cellpadding="0">
    <tr><td>&nbsp;</td><td><input type="button" value="Valider" onclick="setHidden('valider2',document.forms[0]);document.forms[0].submit()"></td></tr>
 
            </table></td>
 
           <td>&nbsp;&nbsp;</td>
<td colspan="2"><table border="0" cellspacing="0" cellpadding="0">
                <tr><td>&nbsp;</td><td><input type="button" value="Exporter vers Excel" onclick="activsubmit(document.recepForm,'exporter');"></td></tr>
 
            
              </table></td>
 
            
            <td>&nbsp;&nbsp;</td>
<td colspan="2" width="70"><table border="0" cellspacing="0" cellpadding="0">
            </table></td>
 
            
      <td>&nbsp;&nbsp;</td>
<td colspan="2"><table border="0" cellspacing="0" cellpadding="0">  
      <h3 >
     RECEPTION
      </h3>
  </table></td>
 
        </tr></table></td></tr>
 
 <tr><td valign="top" colspan="2"><table cellspacing="0" cellpadding="0" border="0" width="600" class="FORM"><tr><td valign="top"><table cellspacing="1" cellpadding="1" border="0" width="100%">
<tr><th align="center" class="FORM">Informations de réception:</th></tr>
<tr><td class="FORM"><table width="100%"	border="0">
 
      
         
          <input type="hidden" name="hidden" value="default">
          <input type="hidden" name="hiddenTest" value="">
          <tr><th valign="top"><span>Fournisseur&nbsp;:</span></th><td valign="top" class="null" style=""><input type="text" name="frns" value="OBERTHUR"><img name="frnsrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
 
          <tr><th valign="top"><span>N°&nbsp;Ref&nbsp;Ext:</span></th><td valign="top" class="null" style=""><input type="text" name="ref" value=""><img name="refrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
 
          <tr><th valign="top"><span>N°&nbsp;PO&nbsp;:</span></th><td valign="top" class="null" style=""><input type="text" name="po_Num" value="099"><img name="po_Numrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
 
          <tr><th valign="top"><span>Emplacement&nbsp;:</span></th><td valign="top" class="null" style=""><textarea name="note">EMP1</textarea><img name="noterequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
 
          <tr><th valign="top"><span>Numero&nbsp;ligne&nbsp;:</span></th><td valign="top" class="null" style=""><select name="ligneRecepNumber" onchange="envoyer();">
          <option value=""></option>
<option value="3">3</option>
<option value="4" selected>4</option>
 
          
          </select><tr><th valign="top"><span>Article&nbsp;:</span></th><td valign="top" class="null" style=""><input type="text" name="art_id" value="SIM PREPAID DJEZZY" readonly="readonly"><img name="art_idrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
          <tr><th valign="top"><span>Magasin&nbsp;:</span></th><td valign="top" class="null" style=""><input type="text" name="magas" value="BLIDA" readonly="readonly"><img name="magasrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr> 
          <tr><th valign="top"><span>Quantite&nbsp;:</span></th><td valign="top" class="null" style=""><input type="text" name="qte" value="2" readonly="readonly"><img name="qterequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
          
          <img name="ligneRecepNumberrequired" src="/gss2/config/clearpixel.gif" alt="required"></td></tr>
 
          
      </table></td></tr>
</table></td></tr></table>
</td></tr>
 
      
        <tr><td colspan="2">&nbsp;</td></tr>
 
        
         
      
       <tr><td colspan="2"><table border="0" width="800"><tr>
         <table border="0">
  
   <tr>
       
              <td>  <th valign="top"><span>N°&nbsp;début</span></th><td valign="top" class="null" style=""><input type="text" name="ND" size="15" value="" onclick="activer3();" onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};" onkeydown="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onkeypress="if  ((event.keyCode!=13)&&(event.keyCode!=48)&&(event.keyCode!=49)&&(event.keyCode!=50)&&(event.keyCode!=51)&&(event.keyCode!=52)&&(event.keyCode!=53)&&(event.keyCode!=54)&&(event.keyCode!=55)&&(event.keyCode!=56)&&(event.keyCode!=57)) { event.returnValue = false;alert('vous ne pouvez utiliser que des touches numériques!');};if (event.keyCode==13){affPromptByPo(document.getElementById('ND'),document.getElementById('le_prompt'),document.getElementById('sup'))};" onblur="tester(document.getElementById('ND'));" onfocus="testArt();"><img name="NDrequired" src="/gss2/config/clearpixel.gif" alt="required"></td>
 </td>
 <td> <td>&nbsp;&nbsp;</td>
<th valign="top"><span>N°&nbsp;fin</span></th><td valign="top" class="null" style=""><input type="text" name="NF" size="15" value="" onclick="tester3(document.getElementById('ND'));" onmousedown="if (event.button==2){alert('Vous ne pouvez pas  copier le contenu du champ');};" onkeydown="if(event.ctrlKey){event.returnValue = false;alert('Vous ne pouvez pas  copier le contenu du champ');} ;" onkeypress="checkNFKeyPress()" onblur="tester2(document.getElementById('NF'));" onfocus="testArt2(document.getElementById('ND'));"><img name="NFrequired" src="/gss2/config/clearpixel.gif" alt="required"></td>
 </td> 
       <td><td>&nbsp;&nbsp;</td>
<td>&nbsp;</td><td><input type="button" value="Ajouter" onclick="testVid2new(document.RecepLatestForm);"></td>
 </td>
   </tr>
   <tr>
   
   
               <td> <div id="le_prompt" style="display:none;;position:absolute;left:300px;">
<input type="text" id="sup"  size="15" name="confirmer start" onblur="testersup();" onmousedown="if (event.button==2){alert('Vous ne pouvez pas  coller le contenu du champ');};" onkeydow
