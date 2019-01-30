package com.intiformation.gestion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="proprietaire")
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	/* Déclaration des champs de la classe */
	@Column(name="telephone_travail")
	private long telephoneTravail;
	
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeBiens;

	/* CTORS */
	public Proprietaire(long telephoneTravail, List<BienImmobilier> listeBiens) {
		super();
		this.telephoneTravail = telephoneTravail;
		this.listeBiens = listeBiens;
	}
	
	public Proprietaire() {
		super();
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
