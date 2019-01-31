package com.intiformation.gestion.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "bienAAcheter")
@DiscriminatorValue("aacheter")
public class BienAAcheter extends BienImmobilier {

	/* ATTRIBUTS */
	@Column(name = "prix_achat_demande")
	private double prixAchatDemande;

	@Column(name = "etat")
	private String etat;

	/* CTORS */
	public BienAAcheter(int id, boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse,
			String codePostal, String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat, double prixAchatDemande, String etat) {
		super(id, statut, classeStd, dateSoumission, adresse, codePostal, localite, dateDisposition, revenuCadastral,
				proprietaire, listeVisites, contrat);
		this.prixAchatDemande = prixAchatDemande;
		this.etat = etat;
	}

	public BienAAcheter(boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse, String codePostal,
			String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat, double prixAchatDemande, String etat) {
		super(statut, classeStd, dateSoumission, adresse, codePostal, localite, dateDisposition, revenuCadastral,
				proprietaire, listeVisites, contrat);
		this.prixAchatDemande = prixAchatDemande;
		this.etat = etat;
	}

	public BienAAcheter() {
		super();
	}

	public double getprixAchatDemandeDemande() {
		return prixAchatDemande;
	}

	public void setprixAchatDemandeDemande(double prixAchatDemande) {
		this.prixAchatDemande = prixAchatDemande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getPrixAchatDemande() {
		return prixAchatDemande;
	}

	public void setPrixAchatDemande(double prixAchatDemande) {
		this.prixAchatDemande = prixAchatDemande;
	}

	@Override
	public String toString() {
		return "BienAAcheter [prixAchatDemande=" + prixAchatDemande + ", etat=" + etat + "]";
	}

}
