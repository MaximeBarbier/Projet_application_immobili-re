package com.intiformation.gestion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="class")
@Table(name="classesStd")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_Classe")
//@NamedQueries({@NamedQuery(name="ClasseStd.findAll",query="SELECT c from class c")})
public class ClasseStd implements Serializable{
	
	/*____________________________________________Attributs__________________________________________________*/
	
	@Id
	@Column(name="id_classestd")
	private String Code;
	
	@Column(name="type")
	private String type;
	
	@Column(name="mode_offre")
	private boolean modeOffre;
	
	@Column(name="prix_maximum")
	private double prixMax; 
	
	@Column(name="superficie_minimum")
	private double superficieMin;
	
	@Column(name="type_Classe", insertable = false, updatable = false)
	private String typeClasse;
	
	@OneToMany(mappedBy="classeStd")
	private List<BienImmobilier> listeBienImmobiliers;
	
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
	
	public ClasseStd(String type, boolean modeOffre, double prixMax, double superficieMin,
			List<BienImmobilier> listeBienImmobiliers) {
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
	
	public ClasseStd(String code, String type, boolean modeOffre, double prixMax,
			double superficieMin, List<BienImmobilier> listeBienImmobiliers) {
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
	public List<BienImmobilier> getListeBienImmobiliers() {
		return listeBienImmobiliers;
	}

	/**
	 * @param listeBienImmobiliers the listeBienImmobiliers to set
	 */
	public void setListeBienImmobiliers(List<BienImmobilier> listeBienImmobiliers) {
		this.listeBienImmobiliers = listeBienImmobiliers;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeClasse() {
		return typeClasse;
	}

	public void setTypeClasse(String typeClasse) {
		this.typeClasse = typeClasse;
	}

	@Override
	public String toString() {
		return "ClasseStd [Code=" + Code + ", type=" + type + ", modeOffre=" + modeOffre + ", prixMax=" + prixMax
				+ ", superficieMin=" + superficieMin + ", typeClasse=" + typeClasse + ", listeBienImmobiliers="
				+ listeBienImmobiliers + "]";
	}
	
}