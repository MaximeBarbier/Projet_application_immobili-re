package com.intiformation.gestion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="louer")
@Table(name="louer")
//@NamedQueries({@NamedQuery(name="Louer.findAll",query="SELECT l FROM louer l")})
public class Louer extends ClasseStd{
	
	/*____________________________________________Attributs__________________________________________________*/
	
	@Column(name="caution_locative")
	private double cautionLocative;
	@Column(name="loyer_mensuel")
	private double loyerMensuel;
	@Column(name="charges_mensuelle")
	private double chargesMensuelles;
	@Column(name="type_bail")
	private String typeBail;
	@Column(name="garniture")
	private boolean garniture;
	@Column(name="revenu_cadastral")
	private double revenuCadastral;
	
	/*____________________________________________ctor__________________________________________________*/
	
	/**
	 * ctor vide
	 */
	public Louer() {
		super();
	}
	
	/**
	 * ctor chargé
	 * @param cautionLocative
	 * @param loyerMensuel
	 * @param chargesMensuelles
	 * @param typeBail
	 * @param garniture
	 * @param revenuCadastral
	 */
	public Louer(double cautionLocative, double loyerMensuel, double chargesMensuelles, String typeBail,
			boolean garniture, double revenuCadastral) {
		super();
		this.cautionLocative = cautionLocative;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuelles = chargesMensuelles;
		this.typeBail = typeBail;
		this.garniture = garniture;
		this.revenuCadastral = revenuCadastral;
	}

	/*____________________________________________get/set/string__________________________________________________*/
	
	/**
	 * @return the cautionLocative
	 */
	public double getCautionLocative() {
		return cautionLocative;
	}

	/**
	 * @param cautionLocative the cautionLocative to set
	 */
	public void setCautionLocative(double cautionLocative) {
		this.cautionLocative = cautionLocative;
	}

	/**
	 * @return the loyerMensuel
	 */
	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	/**
	 * @param loyerMensuel the loyerMensuel to set
	 */
	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	/**
	 * @return the chargesMensuelles
	 */
	public double getChargesMensuelles() {
		return chargesMensuelles;
	}

	/**
	 * @param chargesMensuelles the chargesMensuelles to set
	 */
	public void setChargesMensuelles(double chargesMensuelles) {
		this.chargesMensuelles = chargesMensuelles;
	}

	/**
	 * @return the typeBail
	 */
	public String getTypeBail() {
		return typeBail;
	}

	/**
	 * @param typeBail the typeBail to set
	 */
	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	/**
	 * @return the garniture
	 */
	public boolean isGarniture() {
		return garniture;
	}

	/**
	 * @param garniture the garniture to set
	 */
	public void setGarniture(boolean garniture) {
		this.garniture = garniture;
	}

	/**
	 * @return the revenuCadastral
	 */
	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	/**
	 * @param revenuCadastral the revenuCadastral to set
	 */
	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Louer [cautionLocative=" + cautionLocative + ", loyerMensuel=" + loyerMensuel + ", chargesMensuelles="
				+ chargesMensuelles + ", typeBail=" + typeBail + ", garniture=" + garniture + ", revenuCadastral="
				+ revenuCadastral + "]";
	}
	
	

}
