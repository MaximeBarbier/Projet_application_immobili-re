package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="bienImmobilier")
@Table(name="biens_immobiliers")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="mode_offre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BienImmobilier implements Serializable{

	/* Déclaration des propriétés */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bien")
	private int id;
	
	@Column(name="mode_offre", insertable = false, updatable = false)
	private String modeOffre;
	
	@Column(name="statut")
	private boolean statut;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="classestd_id", referencedColumnName="id_classestd")
	private ClasseStd classeStd;
	
	@Column(name="date_de_soumission")
	private Date dateSoumission;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="code_postal")
	private String codePostal;
	
	@Column(name="localite")
	private String localite;
	
	@Column(name="date_disposition")
	private Date dateDisposition;
	
	@Column(name="revenu_cadastral")
	private double revenuCadastral;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;
	
	@OneToMany(mappedBy="bienImmobilier", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Visite> listeVisites;
	
	@OneToOne(mappedBy="bienImmobilier", fetch=FetchType.EAGER)
	private Contrat contrat;
	
	/* ctors */
	
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse, String codePostal,
			String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat) {
		super();
		this.statut = statut;
		this.classeStd = classeStd;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.localite = localite;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
		this.proprietaire = proprietaire;
		this.listeVisites = listeVisites;
		this.contrat = contrat;
	}

	public BienImmobilier(int id, boolean statut, ClasseStd classeStd, Date dateSoumission, String adresse,
			String codePostal, String localite, Date dateDisposition, double revenuCadastral, Proprietaire proprietaire,
			List<Visite> listeVisites, Contrat contrat) {
		super();
		this.id = id;
		this.statut = statut;
		this.classeStd = classeStd;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.localite = localite;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
		this.proprietaire = proprietaire;
		this.listeVisites = listeVisites;
		this.contrat = contrat;
	}

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

	public ClasseStd getClasseStd() {
		return classeStd;
	}

	public void setClasseStd(ClasseStd classeStd) {
		this.classeStd = classeStd;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
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
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", classeStd=" + classeStd + ", dateSoumission="
				+ dateSoumission + ", adresse=" + adresse + ", codePostal=" + codePostal + ", localite=" + localite
				+ ", dateDisposition=" + dateDisposition + ", revenuCadastral=" + revenuCadastral + ", proprietaire="
				+ proprietaire + ", listeVisites=" + listeVisites + ", contrat=" + contrat + "]";
	}
	
}