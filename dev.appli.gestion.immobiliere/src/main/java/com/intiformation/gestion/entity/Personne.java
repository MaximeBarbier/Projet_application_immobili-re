package com.intiformation.gestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne implements Serializable{
	
	/* Déclaration des propriétés */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="code_postal")
	private String codePostal;
	
	@Column(name="localite")
	private String localite;
	
	@Column(name="telephone_prive")
	private String telephonePrive;
	
	/* ctors */
	/**
	 * ctor vide
	 */
	public Personne() {
		super();
	}

	public Personne(String nom, String adresse, String codePostal, String localite, String telephonePrive) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.localite = localite;
		this.telephonePrive = telephonePrive;
	}

	public Personne(int id, String nom, String adresse, String codePostal, String localite, String telephonePrive) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.localite = localite;
		this.telephonePrive = telephonePrive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(String telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", localite=" + localite + ", telephonePrive=" + telephonePrive + "]";
	}

}