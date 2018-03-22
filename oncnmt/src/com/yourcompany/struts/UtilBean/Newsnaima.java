package com.yourcompany.struts.UtilBean;


import java.io.Serializable;
import java.util.Date;

public class Newsnaima implements Serializable{
	protected String title;
	//protected Subject subject;
	protected String body;
	protected String id;
	protected Date date;	

    public Newsnaima()
    {
    }

    public String getTitle()
    {
        return title;
    }

   /* public Subject getSubject()
    {
        return subject;
    }*/

    public String getBody()
    {
        return body;
    }

    public void setTitle(String in_title)
    {
        title = in_title;
    }
/*
    public void setSubject(Subject in_subject)
    {
        subject = in_subject;
    }
*/
    public void setBody(String in_body)
    {
        body = in_body;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public Date getDate() {
    	return date;	
    }
    
    public void setDate(Date in_date) {
    	this.date = in_date;
    }   
}