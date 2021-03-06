package com.esprit.clinique.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="medecins")
public class Medecin implements Serializable {
	
	@Id
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private long id;
	
	private String nom;
	
	private String prenom;
	
	private String specialite;
	
	private String EmplacementCabinet;
	
	


	public Medecin() {
		//super();
	}

	public Medecin(long id, String nom, String prenom, String specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getEmplacementCabinet() {
		return EmplacementCabinet;
	}

	public void setEmplacementCabinet(String emplacementCabinet) {
		EmplacementCabinet = emplacementCabinet;
	}
	

	

}
