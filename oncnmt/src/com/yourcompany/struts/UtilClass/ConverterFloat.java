package com.yourcompany.struts.UtilClass;

import java.text.DecimalFormat;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;



public class ConverterFloat implements Converter
{
    public Object convert(Class type, Object value) throws ConversionException
    {
        if (value == null) return null;
        
        if (value instanceof Float) return value;
 
        
        try
        {
            String _value = value.toString();
            _value = _value.replaceAll(" ", "");
            if (_value.length() == 0) return null;
 
            DecimalFormat df = new DecimalFormat("###.00");
            Float ts = new Float(((Number)df.parse(_value)).floatValue());
            return ts; 
        }
        catch (Throwable e)
        {
            throw new ConversionException("Erreur de conversion de " + value + " en nombre.<br>L'ancienne valeur a été restaurée");
        }
    }
}

