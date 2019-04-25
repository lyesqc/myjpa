package org.me.models;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.hibernate.sql.Select;

@Entity
@Table(name="comite")
@Cacheable
@Cache(region="org.comite", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Commite {

	@Column(name="id_comite")
	@Id 
	@GeneratedValue
	private Long idCommite;
	@Column(name="nom_comite")
	private String name;
	@Column(name="descriptioncomite")
	private String description;
	public Long getIdCommite() {
		return idCommite;
	}
	public void setIdCommite(Long idCommite) {
		this.idCommite = idCommite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ElementCollection(fetch=FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@CollectionTable(name="commite_adress",joinColumns=@JoinColumn(name="commite_id"))
	List<String> adress = new ArrayList<String>();
	
	public List<MembreComite> getComite_mbr() {
		return comite_mbr;
	}
	public void setComite_mbr(List<MembreComite> comite_mbr) {
		this.comite_mbr = comite_mbr;
	}
	@ManyToMany
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="comite_mbr",joinColumns={@JoinColumn(name="id_comite")},
	                             inverseJoinColumns = { @JoinColumn(name ="idmembre")} )
	List <MembreComite> comite_mbr = new ArrayList();
	
	
	public List<String> getAdress() {
		return adress;
	}
	public void setAdress(List<String> adress) {
		this.adress = adress;
	}
}
