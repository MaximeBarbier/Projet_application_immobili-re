package com.intiformation.gestion.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="bienAlouer")
@DiscriminatorValue("alouer")
public class BienALouer extends BienImmobilier{
	
	/* CHAMPS */	
	@Column(name="montant_caution")
	private double montantCaution;
	
	@Column(name="loyer_mensuel")
	private double loyerMensuel;
	
	@Column(name="charges_mensuelles")
	private double chargesMensuelles;
	
	@Column(name="type_bail")
	private String typeBail;
	
	@Column(name="garniture")
	private boolean garniture;

	/* CTOR */
	public BienALouer(int id, boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse,
			String codePostal, String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat, double montantCaution, double loyerMensuel,
			double chargesMensuelles, String typeBail, boolean garniture) {
		super(id, statut, classeStd, dateSoumission, adresse, codePostal, localite, dateDisposition, revenuCadastral,
				proprietaire, listeVisites, contrat);
		this.montantCaution = montantCaution;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuelles = chargesMensuelles;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}

	public BienALouer(boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse, String codePostal,
			String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat, double montantCaution, double loyerMensuel,
			double chargesMensuelles, String typeBail, boolean garniture) {
		super(statut, classeStd, dateSoumission, adresse, codePostal, localite, dateDisposition, revenuCadastral,
				proprietaire, listeVisites, contrat);
		this.montantCaution = montantCaution;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuelles = chargesMensuelles;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}

	public double getMontantCaution() {
		return montantCaution;
	}

	public void setMontantCaution(double montantCaution) {
		this.montantCaution = montantCaution;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public double getChargesMensuelles() {
		return chargesMensuelles;
	}

	public void setChargesMensuelles(double chargesMensuelles) {
		this.chargesMensuelles = chargesMensuelles;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public boolean isGarniture() {
		return garniture;
	}

	public void setGarniture(boolean garniture) {
		this.garniture = garniture;
	}

	@Override
	public String toString() {
		return "BienaLouer [montantCaution=" + montantCaution + ", loyerMensuel=" + loyerMensuel
				+ ", chargesMensuelles=" + chargesMensuelles + ", typeBail=" + typeBail + ", garniture=" + garniture
				+ "]";
	}
	
}
