package com.yourcompany.struts;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.yourcompany.struts.UtilClass.ConverterDate;
import com.yourcompany.struts.UtilClass.ConverterDouble;
import com.yourcompany.struts.UtilClass.ConverterFloat;
import com.yourcompany.struts.UtilClass.ConverterInteger;
import com.yourcompany.struts.UtilClass.ConverterTime;
import com.yourcompany.struts.UtilClass.ConverterTimestamp;




public class StrutsBootstrapPlugin implements PlugIn
{
 
    public void destroy()
    {
    }
 
    public void init(ActionServlet arg0, ModuleConfig arg1)    throws ServletException
    {
        ConvertUtils.register( new ConverterDate(), java.util.Date.class);
        ConvertUtils.register( new ConverterTimestamp(), java.sql.Timestamp.class);
        ConvertUtils.register( new ConverterTime(), java.sql.Time.class);
        ConvertUtils.register( new ConverterFloat(), java.lang.Float.class);
        ConvertUtils.register( new ConverterDouble(), java.lang.Double.class);
        ConvertUtils.register( new ConverterInteger(), java.lang.Integer.class);
    }

	
 
}

