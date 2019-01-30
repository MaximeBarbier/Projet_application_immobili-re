package com.intiformation.gestion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="proprietaire")
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	/* Déclaration des champs de la classe */
	@Column(name="telephone_travail")
	private long telephoneTravail;
	
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<BienImmobilier> listeBiens;

	/* CTORS */
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String adresse, String codePostal, String localite, String telephonePrive,
			long telephoneTravail, List<BienImmobilier> listeBiens) {
		super(nom, adresse, codePostal, localite, telephonePrive);
		this.telephoneTravail = telephoneTravail;
		this.listeBiens = listeBiens;
	}

	public Proprietaire(int id, String nom, String adresse, String codePostal, String localite, String telephonePrive,
			long telephoneTravail, List<BienImmobilier> listeBiens) {
		super(id, nom, adresse, codePostal, localite, telephonePrive);
		this.telephoneTravail = telephoneTravail;
		this.listeBiens = listeBiens;
	}

	/* GETTERS AND SETTERS */
	public long getTelephoneTravail() {
		return telephoneTravail;
	}

	public void setTelephoneTravail(long telephoneTravail) {
		this.telephoneTravail = telephoneTravail;
	}

	public List<BienImmobilier> getListeBiens() {
		return listeBiens;
	}

	public void setListeBiens(List<BienImmobilier> listeBiens) {
		this.listeBiens = listeBiens;
	}

	@Override
	public String toString() {
		return "Proprietaire [telephoneTravail=" + telephoneTravail + ", listeBiens=" + listeBiens + "]";
	}
	
}
