package com.intiformation.gestion.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="bienImmobilier")
@Table(name="Bien_immobilier")
public class BienImmobilier {

	// Déclaration de client
	private Client client;
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	/* Déclaration des propriétés */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Bien")
	private int id;
	
	@Column(name="statut")
	private boolean statut;
	
	@Column(name="date_de_soumission")
	private Date date_soumis;
	
	@Column(name="localisation")
	private String localisation;
	
	@Column(name="date_de_mise_à_disposition")
	private Date date_disposition;
	
	@Column(name="revenu_cadastral")
	private double revenu_cadastral;
	
	@Column(name="coordonnées_de_acquereur")
	private String coordonnees_client_ac;
	
	@Column(name="prix_de_location")
	private double prix_loc;
	
	@Column(name="date_de_location")
	private Date date_loc;
	
	@Column(name="reference_contrat")
	private int ref_contrat;
	
	@Column(name="liste_des_clients")
	private List<Client> listeClients;
	
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
	public BienImmobilier(Client client, boolean statut, Date date_soumis, String localisation, Date date_disposition,
			double revenu_cadastral, String coordonnees_client_ac, double prix_loc, Date date_loc, int ref_contrat,
			List<Client> listeClients) {
		super();
		this.client = client;
		this.statut = statut;
		this.date_soumis = date_soumis;
		this.localisation = localisation;
		this.date_disposition = date_disposition;
		this.revenu_cadastral = revenu_cadastral;
		this.coordonnees_client_ac = coordonnees_client_ac;
		this.prix_loc = prix_loc;
		this.date_loc = date_loc;
		this.ref_contrat = ref_contrat;
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
		this.date_soumis = date_soumis;
		this.localisation = localisation;
		this.date_disposition = date_disposition;
		this.revenu_cadastral = revenu_cadastral;
		this.coordonnees_client_ac = coordonnees_client_ac;
		this.prix_loc = prix_loc;
		this.date_loc = date_loc;
		this.ref_contrat = ref_contrat;
	}

	/* Getters et setters */
	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}




	public Date getDate_soumis() {
		return date_soumis;
	}


	public void setDate_soumis(Date date_soumis) {
		this.date_soumis = date_soumis;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public Date getDate_disposition() {
		return date_disposition;
	}


	public void setDate_disposition(Date date_disposition) {
		this.date_disposition = date_disposition;
	}


	public double getRevenu_cadastral() {
		return revenu_cadastral;
	}


	public void setRevenu_cadastral(double revenu_cadastral) {
		this.revenu_cadastral = revenu_cadastral;
	}


	public String getCoordonnees_client_ac() {
		return coordonnees_client_ac;
	}


	public void setCoordonnees_client_ac(String coordonnees_client_ac) {
		this.coordonnees_client_ac = coordonnees_client_ac;
	}


	public double getPrix_loc() {
		return prix_loc;
	}


	public void setPrix_loc(double prix_loc) {
		this.prix_loc = prix_loc;
	}


	public Date getDate_loc() {
		return date_loc;
	}


	public void setDate_loc(Date date_loc) {
		this.date_loc = date_loc;
	}


	public int getRef_contrat() {
		return ref_contrat;
	}


	public void setRef_contrat(int ref_contrat) {
		this.ref_contrat = ref_contrat;
	}




	/* Méthode toString() */
	@Override
	public String toString() {
		return "BienImmobilier [client=" + client + ", statut=" + statut + ", id_classe_std=" + 
				 ", date_soumis=" + date_soumis + ", localisation=" + localisation + ", date_disposition="
				+ date_disposition + ", revenu_cadastral=" + revenu_cadastral + ", coordonnees_client_ac="
				+ coordonnees_client_ac + ", prix_loc=" + prix_loc + ", date_loc=" + date_loc + ", ref_contrat="
				+ ref_contrat + "]";
	}
	
	
	
}