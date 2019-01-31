package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="visite")
@Table(name="visites")
public class Visite implements Serializable{
	
	/*____________________________________________Attributs__________________________________________________*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_visite")
	private int id;
	
	@Column(name="date_visite")
	private Date dateVisite;
	
	@Column(name="horaire_visite")
	private Date horaireVisite;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="agent_id", referencedColumnName="id_agent")
	private Agent agent;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id", referencedColumnName="id_personne")
	private Client client;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private BienImmobilier bienImmobilier;
	
	/* CTOR */
	
	public Visite() {
		super();
	}

	public Visite(Date dateVisite, Date horaireVisite, Agent agent, Client client, BienImmobilier bienImmobilier) {
		super();
		this.dateVisite = dateVisite;
		this.horaireVisite = horaireVisite;
		this.agent = agent;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
	}

	public Visite(int id, Date dateVisite, Date horaireVisite, Agent agent, Client client,
			BienImmobilier bienImmobilier) {
		super();
		this.id = id;
		this.dateVisite = dateVisite;
		this.horaireVisite = horaireVisite;
		this.agent = agent;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
	}

	/* GETTERS AND SETTERS */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Date getHoraireVisite() {
		return horaireVisite;
	}

	public void setHoraireVisite(Date horaireVisite) {
		this.horaireVisite = horaireVisite;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
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

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateVisite=" + dateVisite + ", horaireVisite=" + horaireVisite + ", agent="
				+ agent + ", client=" + client + ", bienImmobilier=" + bienImmobilier + "]";
	}
	
}