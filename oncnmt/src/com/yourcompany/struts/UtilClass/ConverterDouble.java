package com.yourcompany.struts.UtilClass;

import java.text.DecimalFormat;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
 
public class ConverterDouble implements Converter
{
    public Object convert(Class type, Object value) throws ConversionException
    {
        if (value == null) return null;
        
        if (value instanceof Double) return value;
        
        try
        {
            String _value = value.toString();
            _value = _value.replaceAll(" ", "");
            if (_value.length() == 0) return null;
 
            DecimalFormat df = new DecimalFormat("###.000000");
            int p = _value.indexOf(df.getDecimalFormatSymbols().getDecimalSeparator());
            /*
             * Troncature à 6 décimales (max)
             */
            if ( p != -1 && _value.length() - p > 6 ) _value = _value.substring(0, p) + df.getDecimalFormatSymbols().getDecimalSeparator() + _value.substring(p+1, p+7);
            
            Double ts = new Double(((Number)df.parse(_value)).doubleValue());
            return ts; 
        }
        catch (Throwable e)
        {
            throw new ConversionException("Erreur de conversion de " + value + " en nombre.<br>L'ancienne valeur a été restaurée");
        }
    }
}
 
