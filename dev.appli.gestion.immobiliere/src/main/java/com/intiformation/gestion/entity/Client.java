package com.intiformation.gestion.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity(name="client")
@Table(name="clients")
@Proxy(lazy = false)
public class Client extends Personne{
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="clients_listeclasses", 
			   joinColumns = {@JoinColumn(name = "clients_id")},
			   inverseJoinColumns = {@JoinColumn(name = "classestd_id")})
	private List<ClasseStd> listeClasses;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<Visite> listeVisites;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="client")
	private Contrat contrat;

	/* CTOR */
	public Client() {
		super();
	}

	public Client(List<ClasseStd> listeClasses, List<Visite> listeVisites, Contrat contrat) {
		super();
		this.listeClasses = listeClasses;
		this.listeVisites = listeVisites;
		this.contrat = contrat;
	}

	public List<ClasseStd> getListeClasses() {
		return listeClasses;
	}

	public void setListeClasses(List<ClasseStd> listeClasses) {
		this.listeClasses = listeClasses;
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
		return "Client [listeClasses=" + listeClasses + ", listeVisites=" + listeVisites + ", contrat=" + contrat + "]";
	}
	
}