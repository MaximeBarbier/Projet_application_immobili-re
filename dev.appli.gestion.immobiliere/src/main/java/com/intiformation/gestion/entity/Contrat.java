package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="contrat")
@Table(name="contrats")
public class Contrat implements Serializable {

	/* Déclaration des champs */
	@Id
	@Column(name="reference_contrat")
	private String refContrat;
	
	@Column(name="prix_achat")
	private double prixAchat;
	
	@Column(name="date_achat")
	private Date dateAchat;
	
	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id_personne")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private BienImmobilier bienImmobilier;
	
	@JoinColumn(name="agent_id", referencedColumnName="id_agent")
	private Agent agent;
	
	/* ctors */
	public Contrat(String refContrat, double prixAchat, Date dateAchat, Client client, BienImmobilier bienImmobilier,
			Agent agent) {
		super();
		this.refContrat = refContrat;
		this.prixAchat = prixAchat;
		this.dateAchat = dateAchat;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.agent = agent;
	}

	public Contrat() {
		super();
	}
	
	/* Getters et setters */
	public String getRefContrat() {
		return refContrat;
	}

	public void setRefContrat(String refContrat) {
		this.refContrat = refContrat;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "Contrat [refContrat=" + refContrat + ", prixAchat=" + prixAchat + ", dateAchat=" + dateAchat
				+ ", client=" + client + ", bienImmobilier=" + bienImmobilier + ", agent=" + agent + "]";
	}
	
}