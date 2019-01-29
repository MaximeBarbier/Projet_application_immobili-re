package com.intiformation.gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class AgenceDAO implements IAgenceDAO {

	//Entity manager pour utiliser les méthodes jpa
	//Annotation pour que le serveur gère l'instanciation de l'em sans qu'on utilise l'entity manager factory
	@PersistenceContext
	private EntityManager em;

	public int ajouterProprietaire(Proprietaire p) {
		em.persist(p);
		return p.getId;
	}

	public List<Proprietaire> listProprietaires() {
		Query query=em.createQuery("SELECT p from Proprietaire p");
		return query.getResultList();
	}

	public Proprietaire getProprietairebyId(int id) {
		
		return em.find(Proprietaire.class, id);
	}

	public void supprimerProprietaire(int id) {
		Proprietaire p = em.find(Proprietaire.class, id);
		em.remove(p);
		
	}

	public void modifierProprietaire(Proprietaire p) {
		em.merge(p);
		
	}

	public int ajouterBI(BienImmobilier bi, int idProp) {
		Proprietaire p = getProprietairebyId(idProp);
		bi.setProprietaire(p);
		em.persist(bi);
		return bi.getId;
	}

	public List<BienImmobilier> listBi() {
		
		return null;
	}

	

	public void supprimerBi(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modifierBi(BienImmobilier bi) {
		// TODO Auto-generated method stub
		
	}

	public List<BienImmobilier> getListBIByIdPropietaire(int idProp) {
		// TODO Auto-generated method stub
		return null;
	}

	public int ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return null;
	}

	public Client getClientbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modifierClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	public int ajouterCS(ClasseStandard cs) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ClasseStandard> listCSByClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	public void supprimerCS(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modifierCS(ClasseStandard cs) {
		// TODO Auto-generated method stub
		
	}

	public int ajouterAI(AgentImmobilier ai) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<AgentImmobilier> getListAgentByBienImmobilier(int idBI) {
		// TODO Auto-generated method stub
		return null;
	}

	public void supprimerAI(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modifierAI(AgentImmobilier ai) {
		// TODO Auto-generated method stub
		
	}

	public int ajouterVisite(Visite v, int idBi) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Visite> getVisiteByAgent(int idAgent) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Visite> getVisiteByBienImmo(int idBI) {
		// TODO Auto-generated method stub
		return null;
	}
}
