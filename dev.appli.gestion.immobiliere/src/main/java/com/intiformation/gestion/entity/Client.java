package com.intiformation.gestion.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="client")
@Table(name="client")
public class Client extends Personne{
	
	@OneToMany
	private List<ClasseStd> listeClasses;
	
	@OneToOne(mappedBy="client")
	private Contrat contrat;

	/* Import des champs hérités de la classe Personne */
	@Override
	public int getId() {
		return super.getId();
	}

	@Override
	public void setId(int id) {
		super.setId(id);
	}

	@Override
	public String getNom() {
		return super.getNom();
	}


	@Override
	public String getAdresse() {
		return super.getAdresse();
	}

	@Override
	public void setAdresse(String adresse) {
		super.setAdresse(adresse);
	}

	@Override
	public String getTelephone() {
		return super.getTelephone();
	}

	@Override
	public void setTelephone(String telephone) {
		super.setTelephone(telephone);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	/* ctors hérités de la classe Personne */
	/**
	 * ctor vide
	 */
	public Client() {
		super();
	}

	/**
	 * ctor chargé
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Client(int id, String nom, String adresse, String telephone) {
		super(id, nom, adresse, telephone);
	}

	/**
	 * ctor chargé sans l'ID
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Client(String nom, String adresse, String telephone) {
		super(nom, adresse, telephone);
	}
	
	

}