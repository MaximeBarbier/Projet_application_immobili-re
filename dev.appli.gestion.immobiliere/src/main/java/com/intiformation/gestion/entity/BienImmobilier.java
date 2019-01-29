package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="bienImmobilier")
@Table(name="Bien_immobilier")
public class BienImmobilier implements Serializable{

	/* Déclaration des propriétés */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Bien")
	private int id;
	
	@Column(name="statut")
	private boolean statut;
	
	@Column(name="date_de_soumission")
	private Date dateSoumis;
	
	@Column(name="localisation")
	private String localisation;
	
	@Column(name="date_de_mise_à_disposition")
	private Date dateDisposition;
	
	@Column(name="revenu_cadastral")
	private double revenuCadastral;
	
	@Column(name="coordonnées_client_acquereur")
	private String coordonneesClientAc;
	
	@Column(name="prix_de_location")
	private double prixLoc;
	
	@Column(name="date_de_location")
	private Date dateLoc;
	
	@Column(name="reference_contrat")
	private int refContrat;
		
	@Column(name="liste_des_clients")
	private List<Client> listeClients;
	
	@ManyToOne
	@JoinColumn(name="classestd_id", referencedColumnName="id_classestd")
	private ClasseStd typeDeBien;
	
	@ManyToOne
	@JoinColumn(name="personne_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;
	
	@OneToMany(mappedBy="bienImmobilier")
	@JoinColumn(name="bien_id")
	private List<Visite> listeVisites;
	
	@OneToOne(mappedBy="bienImmobilier")
	private Contrat contrat;
	
	/* ctors */
	/**
	 * ctor vide
	 */
	public BienImmobilier() {
		super();
	}

	/**
	 * ctor chargé sans id
	 * @param client
	 * @param statut
	 * @param date_soumis
	 * @param localisation
	 * @param date_disposition
	 * @param revenu_cadastral
	 * @param coordonnees_client_ac
	 * @param prix_loc
	 * @param date_loc
	 * @param ref_contrat
	 * @param listeClients
	 */
	public BienImmobilier(boolean statut, Date date_soumis, String localisation, Date date_disposition,
			double revenu_cadastral, String coordonnees_client_ac, double prix_loc, Date date_loc, int ref_contrat,
			List<Client> listeClients) {
		super();
		this.statut = statut;
		this.dateSoumis = date_soumis;
		this.localisation = localisation;
		this.dateDisposition = date_disposition;
		this.revenuCadastral = revenu_cadastral;
		this.coordonneesClientAc = coordonnees_client_ac;
		this.prixLoc = prix_loc;
		this.dateLoc = date_loc;
		this.refContrat = ref_contrat;
		this.listeClients = listeClients;
	}


	/**
	 * ctor chargé
	 * @param statut
	 * @param id_classe_std
	 * @param date_soumis
	 * @param localisation
	 * @param date_disposition
	 * @param revenu_cadastral
	 * @param coordonnees_client_ac
	 * @param prix_loc
	 * @param date_loc
	 * @param ref_contrat
	 * @param listeClients
	 */
	public BienImmobilier(boolean statut, int id_classe_std, Date date_soumis, String localisation,
			Date date_disposition, double revenu_cadastral, String coordonnees_client_ac, double prix_loc,
			Date date_loc, int ref_contrat, List<Client> listeClients) {
		super();
		this.statut = statut;
		this.dateSoumis = date_soumis;
		this.localisation = localisation;
		this.dateDisposition = date_disposition;
		this.revenuCadastral = revenu_cadastral;
		this.coordonneesClientAc = coordonnees_client_ac;
		this.prixLoc = prix_loc;
		this.dateLoc = date_loc;
		this.refContrat = ref_contrat;
	}

	/* Getters et setters */
	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Date getDate_soumis() {
		return dateSoumis;
	}


	public void setDate_soumis(Date date_soumis) {
		this.dateSoumis = date_soumis;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public Date getDate_disposition() {
		return dateDisposition;
	}


	public void setDate_disposition(Date date_disposition) {
		this.dateDisposition = date_disposition;
	}


	public double getRevenu_cadastral() {
		return revenuCadastral;
	}


	public void setRevenu_cadastral(double revenu_cadastral) {
		this.revenuCadastral = revenu_cadastral;
	}


	public String getCoordonnees_client_ac() {
		return coordonneesClientAc;
	}


	public void setCoordonnees_client_ac(String coordonnees_client_ac) {
		this.coordonneesClientAc = coordonnees_client_ac;
	}


	public double getPrix_loc() {
		return prixLoc;
	}


	public void setPrix_loc(double prix_loc) {
		this.prixLoc = prix_loc;
	}


	public Date getDate_loc() {
		return dateLoc;
	}


	public void setDate_loc(Date date_loc) {
		this.dateLoc = date_loc;
	}


	public int getRef_contrat() {
		return refContrat;
	}


	public void setRef_contrat(int ref_contrat) {
		this.refContrat = ref_contrat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public ClasseStd getTypeDeBien() {
		return typeDeBien;
	}

	public void setTypeDeBien(ClasseStd typeDeBien) {
		this.typeDeBien = typeDeBien;
	}

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumis=" + dateSoumis + ", localisation="
				+ localisation + ", dateDisposition=" + dateDisposition + ", revenuCadastral=" + revenuCadastral
				+ ", coordonneesClientAc=" + coordonneesClientAc + ", prixLoc=" + prixLoc + ", dateLoc=" + dateLoc
				+ ", refContrat=" + refContrat + ", listeClients=" + listeClients + ", typeDeBien=" + typeDeBien
				+ ", proprietaire=" + proprietaire + ", listeVisites=" + listeVisites + ", contrat=" + contrat + "]";
	}
	
}