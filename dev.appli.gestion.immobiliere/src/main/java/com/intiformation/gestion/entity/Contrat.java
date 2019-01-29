package com.intiformation.gestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="contrat")
@Table(name="Contrat")
public class Contrat implements Serializable {

	/* Déclaration des champs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reference_contrat")
	private int ref_contrat;
	
	@OneToOne
	private BienImmobilier bien;
	
	/* ctors */
	/**
	 * ctor vide
	 */
	public Contrat() {
		super();
	}

	/**
	 * ctor chargé
	 * @param ref_contrat
	 */
	public Contrat(int ref_contrat) {
		super();
		this.ref_contrat = ref_contrat;
	}


	/* Getters et setters */
	public int getRef_contrat() {
		return ref_contrat;
	}

	public void setRef_contrat(int ref_contrat) {
		this.ref_contrat = ref_contrat;
	}

	/*  Méthode toString() */
	@Override
	public String toString() {
		return "Contrat [ref_contrat=" + ref_contrat + "]";
	}
	
	
	
}