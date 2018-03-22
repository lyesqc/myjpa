package com.yourcompany.struts.UtilClass;



import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.jsp.PageContext;
import org.apache.struts.Globals;
import fr.improve.struts.taglib.layout.formatter.DispatchFormatter;
 
public class LocalFormatter extends DispatchFormatter
{
    // Formatage d'une date
    // ====================
    public String date(Object value, PageContext context)
    {
        if ( value == null ) return "";
        
        Date _value = (Date)value;
        String format = "dd/MM/yyyy";
        Locale locale = findLocale(context);
        if ( locale.getCountry().equals("US") ) format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(_value);
    }
    
    public String dateTime (Object value, PageContext context)
    {
        if ( value == null ) return "";
        
        Date _value = null;
        if ( value instanceof Timestamp ) _value = new Date(((Timestamp)value).getTime());
        if ( value instanceof Date ) _value = (Date)value;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format( _value );
    }
    
    public String dateTime14 (Object value, PageContext context)
    {
        if ( value == null ) return "";
        
        Date _value = null;
        if ( value instanceof Timestamp ) _value = new Date(((Timestamp)value).getTime());
        if ( value instanceof Date ) _value = (Date)value;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
        return sdf.format( _value );
    }
 
    // Formatage d'une heure
    // =====================
    public String time5(Object value, PageContext context)
    {
        if ( value == null ) return "";
        
        Date _value = (Date)value;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(_value);
    }
    
    // Formatage d'une heure
    // =====================
    public String time8(Object value, PageContext context)
    {
        if ( value == null ) return "";
        
        Date _value = (Date)value;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(_value);
    }
 
 
    // Formatage d'un entier
    // =====================
    public String integer(Object value, PageContext context)
    {
        if ( value == null ) return null;
        
        Integer _value = (Integer)value;
        DecimalFormat f = new DecimalFormat("##0");
        f.setMinimumIntegerDigits(0);
        f.setMaximumFractionDigits(0);
        return f.format(_value);
    }
 
    // Formatage d'un entier
    // =====================
    public String integerNoZero(Object value, PageContext context)
    {
        if ( value == null ) return null;
        
        Integer _value = (Integer)value;
        if ( _value.intValue() == 0 ) return "";
        DecimalFormat f = new DecimalFormat("###");
        f.setMinimumIntegerDigits(0);
        f.setMaximumFractionDigits(0);
        return f.format(_value);
    }
    
    // Formatage d'un numérique 2 décimales
    // ====================================
    public String numeric2(Object value, PageContext context)
    {
        if ( value == null ) return null;
 
        double _value = 0;
        
        if ( value instanceof BigDecimal) _value = ((BigDecimal)value).doubleValue(); 
        else if ( value instanceof Double ) _value = ((Double)value).doubleValue();
        
        DecimalFormat f = new DecimalFormat("##0.00");
        return f.format(_value);
    }
    
    protected Locale findLocale(PageContext pageContext) 
    {
        Locale lc_locale = (Locale) pageContext.findAttribute(Globals.LOCALE_KEY);
        if (lc_locale==null) 
        {
            lc_locale = pageContext.getRequest().getLocale();    
        }
        return lc_locale;
    }
}
