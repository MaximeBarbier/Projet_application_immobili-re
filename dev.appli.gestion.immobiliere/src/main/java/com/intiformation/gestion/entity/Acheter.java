package com.intiformation.gestion.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "buy")
@Table(name = "acheter")
@DiscriminatorValue("acheter")
// @NamedQueries({@NamedQuery(name="Acheter.findAll",query="SELECT b FROM buy
// b")})
public class Acheter extends ClasseStd {

	/*
	 * ____________________________________________Attributs__________________________________________________
	 */

	@Column(name = "prix_achat")
	private double prixAchat;

	@Column(name = "etat")
	private String etat;

	/*
	 * ____________________________________________ctor__________________________________________________
	 */

	/**
	 * 
	 */
	public Acheter() {
		super();
	}

	/**
	 * @param prixAchat
	 * @param etat
	 */
	public Acheter(double prixAchat, java.lang.String etat) {
		super();
		this.prixAchat = prixAchat;
		this.etat = etat;
	}

	/*
	 * ____________________________________________get/set/
	 * string__________________________________________________
	 */

	/**
	 * @return the prixAchat
	 */
	public double getPrixAchat() {
		return prixAchat;
	}

	/**
	 * @param prixAchat
	 *            the prixAchat to set
	 */
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Acheter [prixAchat=" + prixAchat + ", etat=" + etat + "]";
	}

}
