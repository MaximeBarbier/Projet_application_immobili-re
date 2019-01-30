package com.intiformation.gestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="contrat")
@Table(name="Contrat")
public class Contrat implements Serializable {

	/* Déclaration des champs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reference_contrat")
	private String refContrat;
	
	@OneToOne
	private Client client;
	
	@OneToOne
	private BienImmobilier bienImmobilier;
	
	@JoinColumn(name="agent_id", referencedColumnName="id_agent")
	private Agent agent;
	
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
	public Contrat(String refContrat) {
		super();
		this.refContrat = refContrat;
	}


	/* Getters et setters */
	public String getRefContrat() {
		return refContrat;
	}

	public void setRefContrat(String refContrat) {
		this.refContrat = refContrat;
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

	/*  Méthode toString() */
	@Override
	public String toString() {
		return "Contrat [refContrat=" + refContrat + ", client=" + client + ", bienImmobilier=" + bienImmobilier + "]";
	}
	
	
}