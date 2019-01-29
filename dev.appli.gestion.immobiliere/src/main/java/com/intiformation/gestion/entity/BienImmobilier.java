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
	private ClasseStd classeStd;
	
	@ManyToOne
	@JoinColumn(name="personne_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;
	
	@OneToMany(mappedBy="bienImmobilier")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Date getDateSoumis() {
		return dateSoumis;
	}

	public void setDateSoumis(Date dateSoumis) {
		this.dateSoumis = dateSoumis;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Date getDateDisposition() {
		return dateDisposition;
	}

	public void setDateDisposition(Date dateDisposition) {
		this.dateDisposition = dateDisposition;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public String getCoordonneesClientAc() {
		return coordonneesClientAc;
	}

	public void setCoordonneesClientAc(String coordonneesClientAc) {
		this.coordonneesClientAc = coordonneesClientAc;
	}

	public double getPrixLoc() {
		return prixLoc;
	}

	public void setPrixLoc(double prixLoc) {
		this.prixLoc = prixLoc;
	}

	public Date getDateLoc() {
		return dateLoc;
	}

	public void setDateLoc(Date dateLoc) {
		this.dateLoc = dateLoc;
	}

	public int getRefContrat() {
		return refContrat;
	}

	public void setRefContrat(int refContrat) {
		this.refContrat = refContrat;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public ClasseStd getClasseStd() {
		return classeStd;
	}

	public void setClasseStd(ClasseStd classeStd) {
		this.classeStd = classeStd;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumis=" + dateSoumis + ", localisation="
				+ localisation + ", dateDisposition=" + dateDisposition + ", revenuCadastral=" + revenuCadastral
				+ ", coordonneesClientAc=" + coordonneesClientAc + ", prixLoc=" + prixLoc + ", dateLoc=" + dateLoc
				+ ", refContrat=" + refContrat + ", listeClients=" + listeClients + ", classeStd=" + classeStd
				+ ", proprietaire=" + proprietaire + ", listeVisites=" + listeVisites + ", contrat=" + contrat + "]";
	}

}