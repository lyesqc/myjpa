package com.yourcompany.struts.UtilClass;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
 
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;


public class ConverterTimestamp implements Converter
{
    public Object convert(Class type, Object value) throws ConversionException
    {
        if (value == null) return null;
        
        if (value instanceof Timestamp) return value;
        
        try
        {
            String _value = ((String)value).trim();
            if ( _value.length() == 0 ) return null;
 
            SimpleDateFormat sdf = null;
            
            if ( _value.length() >= 3 && _value.length() <= 5 ) sdf = new SimpleDateFormat("HH:mm");
            else if ( _value.length() > 5 && _value.length() <= 8 ) sdf = new SimpleDateFormat("HH:mm:ss");
            else if ( _value.length() > 8 && _value.length() <= 16 ) sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            else if ( _value.length() > 16 && _value.length() <= 19 ) sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            Time ts = new Time(sdf.parse((String)value).getTime());
            return ts;                 
        }
        catch (Throwable e)
        {
            throw new ConversionException("Erreur de conversion de " + value + " en date/heure.<br>L'ancienne valeur a été restaurée");
        }
    }
}
