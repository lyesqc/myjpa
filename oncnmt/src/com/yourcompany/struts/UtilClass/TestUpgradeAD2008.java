package com.yourcompany.struts.UtilClass;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.InitialDirContext;

public class TestUpgradeAD2008 {

	public static void main(String[] args) {
		TestUpgradeAD2008 test = new TestUpgradeAD2008();
		// args[] : username pswd ldap_url domain
		// "ldap://otadebad01.otalgerie.com:389"
		System.out.println(test.Authentif(args[0], args[1], args[2], args[3]));
	}

	public String Authentif(String user, String pwd, String ip, String domain) {
		String explan;
		String result = " Authentification with Success";
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, ip);
			env.put(Context.SECURITY_PRINCIPAL, user + "@" + domain);
			env.put(Context.SECURITY_CREDENTIALS, pwd);
			InitialDirContext ctx = new InitialDirContext(env);

		} catch (NamingException e) {
			explan = e.getExplanation();
			if (explan.indexOf("LDAP: error code 49") != -1)
				result = "Erreur d'authentification. Vrifiez votre Username/Password.";
			else
				result = e.toString();
		}
		return result;
	}
}