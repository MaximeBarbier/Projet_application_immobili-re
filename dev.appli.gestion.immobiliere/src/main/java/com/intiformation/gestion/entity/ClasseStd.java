package com.intiformation.gestion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity(name="class")
@Table(name="classesStd")
//@NamedQueries({@NamedQuery(name="ClasseStd.findAll",query="SELECT c from class c")})
public class ClasseStd {
	
	/*____________________________________________Attributs__________________________________________________*/
	
	@Id
	@Column(name="code")
	private String Code;
	@Column(name="type")
	private String type;
	@Column(name="mode_offre")
	private boolean modeOffre;
	@Column(name="prix_maximum")
	private double prixMax; 
	@Column(name="superficie_minimum")
	private double superficieMin;
	private List<String> listeBienImmobiliers;
	
	/*____________________________________________ctor__________________________________________________*/
	
	/**
	 * ctor vide
	 */
	public ClasseStd() {
		super();
	}

	/**
	 * ctor chargé sans l'id Code
	 * @param string
	 * @param modeOffre
	 * @param prixMax
	 * @param superficieMin
	 * @param listeBienImmobiliers
	 */
	
	public ClasseStd(java.lang.String type, boolean modeOffre, double prixMax, double superficieMin,
			List<java.lang.String> listeBienImmobiliers) {
		super();
		this.type=type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
		this.listeBienImmobiliers = listeBienImmobiliers;
	}

	/**
	 * ctor chargé avec l'id Code
	 * @param code
	 * @param string
	 * @param modeOffre
	 * @param prixMax
	 * @param superficieMin
	 * @param listeBienImmobiliers
	 */
	
	/*____________________________________________get/set/string__________________________________________________*/
	
	public ClasseStd(java.lang.String code, java.lang.String string, boolean modeOffre, double prixMax,
			double superficieMin, List<java.lang.String> listeBienImmobiliers) {
		super();
		Code = code;
		this.type=type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
		this.listeBienImmobiliers = listeBienImmobiliers;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		Code = code;
	}

	/**
	 * @return the string
	 */
	public String getString() {
		return type;
	}

	/**
	 * @param string the string to set
	 */
	public void setString(String type) {
		this.type=type;
	}

	/**
	 * @return the modeOffre
	 */
	public boolean isModeOffre() {
		return modeOffre;
	}

	/**
	 * @param modeOffre the modeOffre to set
	 */
	public void setModeOffre(boolean modeOffre) {
		this.modeOffre = modeOffre;
	}

	/**
	 * @return the prixMax
	 */
	public double getPrixMax() {
		return prixMax;
	}

	/**
	 * @param prixMax the prixMax to set
	 */
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	/**
	 * @return the superficieMin
	 */
	public double getSuperficieMin() {
		return superficieMin;
	}

	/**
	 * @param superficieMin the superficieMin to set
	 */
	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}

	/**
	 * @return the listeBienImmobiliers
	 */
	public List<String> getListeBienImmobiliers() {
		return listeBienImmobiliers;
	}

	/**
	 * @param listeBienImmobiliers the listeBienImmobiliers to set
	 */
	public void setListeBienImmobiliers(List<String> listeBienImmobiliers) {
		this.listeBienImmobiliers = listeBienImmobiliers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClasseStd [Code=" + Code + ", String=" + type + ", modeOffre=" + modeOffre + ", prixMax=" + prixMax
				+ ", superficieMin=" + superficieMin + ", listeBienImmobiliers=" + listeBienImmobiliers + "]";
	}

}