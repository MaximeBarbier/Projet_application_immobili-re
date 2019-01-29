package com.intiformation.gestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne implements Serializable{
	
	/* D�claration des propri�t�s */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;
	
	/* ctors */
	/**
	 * ctor vide
	 */
	public Personne() {
		super();
	}
	
	/**
	 * ctor charg�
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Personne(int id, String nom, String adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	/**
	 * ctor charg� sans l'id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Personne(String nom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	/* Getters et setters */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public String setNom(String nom) {
		this.nom = nom;
		return "";
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/* M�thode toString() */
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}
	

}