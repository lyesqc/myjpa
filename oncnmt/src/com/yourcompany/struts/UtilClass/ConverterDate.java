package com.yourcompany.struts.UtilClass;


import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class ConverterDate implements Converter
{
    public Object convert(Class type, Object value) throws ConversionException
    {
        if (value == null) return null;
        
        if (value instanceof Date) return value;
            
        String _value = ((String)value).trim();
        if ( _value.length() == 0 ) return null;
 
        SimpleDateFormat sdf = null;
 
        if ( _value.length() > 14 ) sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        else if ( _value.length() > 10 && _value.length() <= 14 ) sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
        else if ( _value.length() >= 8 && _value.length() <= 10 ) sdf = new SimpleDateFormat("dd/MM/yyyy");
        else if ( _value.length() >= 7 && _value.length() <= 8 ) sdf = new SimpleDateFormat("dd/MM/yy");
        else if ( _value.length() > 0 && _value.length() <= 5 )
        {
            if (_value.indexOf("/") != -1) sdf = new SimpleDateFormat("dd/MM");
            else sdf = new SimpleDateFormat("HH:mm");
        }
        
 
        try
        {
            sdf.setLenient(false);
            Date dt = sdf.parse((String)value);
            return dt; 
        }
        catch (Throwable t) 
        {
            throw new ConversionException("Erreur de conversion de " + value + " en date.<br>L'ancienne valeur a été restaurée");
        }
    }
}

