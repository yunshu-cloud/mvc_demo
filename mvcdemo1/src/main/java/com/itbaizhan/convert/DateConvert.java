package com.itbaizhan.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter<String, Date>
{
    @Override
    public Date convert(String s)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
            date = sdf.parse(s);
        } catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
        return date;
    }
}
