package org.me.models;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.AttributeAccessor;

@Entity
@Table(name="membrecomite")

public class MembreComite {
	
	@Id
	@GeneratedValue
	Long idmembre;
	String login;
	String compagnie;
	String email;
	
	String motpass;
	String nommembre;
	

}
