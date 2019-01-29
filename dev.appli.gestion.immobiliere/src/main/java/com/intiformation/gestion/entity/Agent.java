package com.intiformation.gestion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="agent")
@Table(name="agents")
//@NamedQueries({@NamedQuery(name="Agent.findAll",query="SELECT a FROM agent a")})
public class Agent {
	
	/*____________________________________________Attributs_____________________________________________*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agent")
	private int id;
	
	@Column(name="nom_agent")
	private String nom;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	/*____________________________________________ctor__________________________________________________*/
	
	/**
	 * ctor vide
	 */
	public Agent() {
		super();
	}
	
	/**
	 * ctor chargé sans l'id
	 * @param nom
	 * @param telephone
	 * @param mail
	 * @param username
	 * @param password
	 */
	public Agent(String nom, String telephone, String mail, String username, String password) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * ctor chargé avec l'id
	 * @param id
	 * @param nom
	 * @param telephone
	 * @param mail
	 * @param username
	 * @param password
	 */
	public Agent(int id, String nom, String telephone, String mail, String username, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	
	/*____________________________________________get/set/string__________________________________________________*/
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", mail=" + mail + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
}
