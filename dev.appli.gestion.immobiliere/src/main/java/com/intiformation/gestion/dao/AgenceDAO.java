package com.intiformation.gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.entity.ClasseStd;
import com.intiformation.gestion.entity.Client;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;

@Repository
public class AgenceDAO implements IAgenceDAO {

	// Entity manager pour utiliser les méthodes jpa
	// Annotation pour que le serveur gère l'instanciation de l'em sans qu'on
	// utilise l'entity manager factory
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public int ajouterProprietaire(Proprietaire p) {
		em.persist(p);
		return p.getId();
	}

	public List<Proprietaire> listProprietaires() {
		Query query = em.createQuery("SELECT p from Proprietaire p");
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
		return bi.getId();
	}

	public List<BienImmobilier> listBi() {

		Query query = em.createQuery("SELECT bi from BienImmobilier bi");
		return query.getResultList();
	}

	public void supprimerBi(int id) {
		BienImmobilier bi = em.find(BienImmobilier.class, id);

		em.remove(bi);

	}

	public void modifierBi(BienImmobilier bi) {
		em.merge(bi);

	}

	public List<BienImmobilier> getListBIByIdPropietaire(int idProp) {
		Query query = em.createQuery("SELECT bi from BienImmobilier bi where bi.Proprietaire.id= ?1");
		query.setParameter(1, idProp);
		return query.getResultList();
	}

	public int ajouterClient(Client c) {
		em.persist(c);
		return c.getId();
	}

	public List<Client> listClients() {
		Query query = em.createQuery("SELECT c from Client c");
		return query.getResultList();
	}

	public Client getClientbyId(int id) {

		return em.find(Client.class, id);
	}

	public void supprimerClient(int id) {
		Client c = em.find(Client.class, id);

	}

	public void modifierClient(Client c) {
		em.merge(c);

	}

	public String ajouterCS(ClasseStd cs) {
		em.persist(cs);
		return cs.getCode();
	}

	public List<ClasseStd> listCSByClient(int idClient) {
		Query query = em.createQuery("SELECT cs from ClasseStandard cs where cs.Client.id= ?1");
		query.setParameter(1, idClient);
		return query.getResultList();
	}

	public void supprimerCS(int id) {
		ClasseStd cs = em.find(ClasseStd.class, id);
		em.remove(cs);

	}

	public void modifierCS(ClasseStd cs) {
		em.merge(cs);

	}

	public int ajouterAI(Agent ai) {
		em.persist(ai);
		return ai.getId();
	}

	public List<Agent> getListAgentByBienImmobilier(int idBI) {
		Query query = em.createQuery("SELECT a from Agent a where a.BienImmobilier.id= ?1");
		query.setParameter(1, idBI);
		return query.getResultList();
	}

	public Agent getAgentbyId(int id) {

		return em.find(Agent.class, id);
	}

	public void supprimerAI(int id) {
		Agent agent = em.find(Agent.class, id);

		em.remove(agent);

	}

	public void modifierAI(Agent ai) {
		em.merge(ai);

	}

	public int ajouterVisite(Visite v, int idBi) {
		BienImmobilier bi = em.find(BienImmobilier.class, idBi);
		v.setBien(bi);
		em.persist(v);
		return v.getId();
	}

	public List<Visite> getVisiteByAgent(int idAgent) {
		Query query = em.createQuery("SELECT v  from Visite v where v.Agnet.id= ?1");
		query.setParameter(1, idAgent);
		return query.getResultList();
	}

	public List<Visite> getVisiteByBienImmo(int idBI) {
		Query query = em.createQuery("SELECT v  from Visite v where v.BienImmobilier.id= ?1");
		query.setParameter(1, idBI);
		return query.getResultList();
	}

	public BienImmobilier getBibyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
