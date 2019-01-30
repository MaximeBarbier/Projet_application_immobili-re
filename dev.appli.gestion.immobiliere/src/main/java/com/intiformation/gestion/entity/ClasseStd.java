package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Proxy;

@Entity(name="class")
@Table(name="classes_standards")
@Proxy(lazy = false)
public class ClasseStd implements Serializable{
	
	/*____________________________________________Attributs__________________________________________________*/
	
	@Id
	@Column(name="id_classestd")
	private String code;
	
	@Column(name="type_de_bien")
	private String typeDeBien;
	
	@Column(name="mode_offre")
	private String modeOffre;
	
	@Column(name="prix_maximum")
	private double prixMax; 
	
	@Column(name="superficie_minimum")
	private double superficieMin;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="classeStd")
	private List<BienImmobilier> listeBienImmobiliers;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="listeClasses")
	private List<Client> listeClients;
	
	/*____________________________________________ctor__________________________________________________*/
	
	/**
	 * ctor vide
	 */
	public ClasseStd() {
		super();
	}

	/**
	 * Constructeur chargé avec tout
	 * @param code
	 * @param typeDeBien
	 * @param modeOffre
	 * @param prixMax
	 * @param superficieMin
	 * @param listeBienImmobiliers
	 * @param listeClients
	 */
	public ClasseStd(String code, String typeDeBien, String modeOffre, double prixMax, double superficieMin,
			List<BienImmobilier> listeBienImmobiliers, List<Client> listeClients) {
		super();
		this.code = code;
		this.typeDeBien = typeDeBien;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
		this.listeBienImmobiliers = listeBienImmobiliers;
		this.listeClients = listeClients;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTypeDeBien() {
		return typeDeBien;
	}

	public void setTypeDeBien(String typeDeBien) {
		this.typeDeBien = typeDeBien;
	}

	public String isModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getSuperficieMin() {
		return superficieMin;
	}

	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}

	public List<BienImmobilier> getListeBienImmobiliers() {
		return listeBienImmobiliers;
	}

	public void setListeBienImmobiliers(List<BienImmobilier> listeBienImmobiliers) {
		this.listeBienImmobiliers = listeBienImmobiliers;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	@Override
	public String toString() {
		return "ClasseStd [code=" + code + ", typeDeBien=" + typeDeBien + ", modeOffre=" + modeOffre + ", prixMax="
				+ prixMax + ", superficieMin=" + superficieMin + ", listeBienImmobiliers=" + listeBienImmobiliers
				+ ", listeClients=" + listeClients + "]";
	}
	
}