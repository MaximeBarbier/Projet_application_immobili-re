package com.intiformation.gestion.entity;

import javax.persistence.Entity;

@Entity
public class Proprietaire extends Personne {

	/* Déclaration des champs de la classe */
	private long tel_travail;

	/* Import des champs hérités de la classe Personne */
	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public void setId(int id) {
		super.setId(id);
	}

	@Override
	public String getNom() {
		return super.getNom();
	}

	@Override
	public String setNom(String nom) {
		return super.setNom(nom);
	}

	public long getTel_travail() {
		return tel_travail;
	}

	public void setTel_travail(long tel_travail) {
		this.tel_travail = tel_travail;
	}

	@Override
	public String getAdresse() {
		return super.getAdresse();
	}

	@Override
	public void setAdresse(String adresse) {
		super.setAdresse(adresse);
	}

	@Override
	public String getTelephone() {
		return super.getTelephone();
	}

	@Override
	public void setTelephone(String telephone) {
		super.setTelephone(telephone);
	}

	/*  Méthode toString() */
	@Override
	public String toString() {
		return "Proprietaire [tel_travail=" + tel_travail + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getAdresse()=" + getAdresse() + ", getTelephone()=" + getTelephone() + "]";
	}

	/* ctors */
	/**
	 * ctor vide
	 */
	public Proprietaire() {
		super();
	}

	/**
	 * ctor chargé
	 * @param tel_travail
	 */
	public Proprietaire(long tel_travail) {
		super();
		this.tel_travail = tel_travail;
	}

	/* Import des ctors hérités de la classe Personne */
	/**
	 * ctor chargé
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Proprietaire(int id, String nom, String adresse, String telephone) {
		super(id, nom, adresse, telephone);
	}

	/**
	 * ctor chargé sans l'Id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Proprietaire(String nom, String adresse, String telephone) {
		super(nom, adresse, telephone);
	}
	
	
	
}
