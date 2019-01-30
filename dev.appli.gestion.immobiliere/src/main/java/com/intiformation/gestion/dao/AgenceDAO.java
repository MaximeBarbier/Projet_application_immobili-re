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
import com.intiformation.gestion.entity.Contrat;
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
	
	//CRUD Proprietire

	public int ajouterProprietaire(Proprietaire p) {
		em.persist(p);
		return p.getId();
	}

	public List<Proprietaire> listProprietaires() {
		Query query = em.createQuery("SELECT p from proprietaire p");
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

	//CRUD BI
	public int ajouterBI(BienImmobilier bi, int idProp) {
		Proprietaire p = getProprietairebyId(idProp);
		bi.setProprietaire(p);
		em.persist(bi);
		return bi.getId();
	}

	public List<BienImmobilier> listBi() {

		Query query = em.createQuery("SELECT bi from bienImmobilier bi");
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
		Query query = em.createQuery("SELECT bi from bienImmobilier bi where bi.proprietaire.id= ?1");
		query.setParameter(1, idProp);
		return query.getResultList();
	}
	
	public BienImmobilier getBibyId(int id) {
		
		return em.find(BienImmobilier.class, id);
	}

	public List<BienImmobilier> getListBIByClassSt(String code) {
		
		Query query = em.createQuery("SELECT bi  from bienImmobilier bi where bi.class.code= ?1");
		query.setParameter(1, code);
		return query.getResultList();
	}

	//CRUD Client 
	
	public int ajouterClient(Client c) {
		em.persist(c);
		return c.getId();
	}

	public List<Client> listClients() {
		Query query = em.createQuery("SELECT c from client c");
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

	

	//CRUD Agent 
	public int ajouterAI(Agent ai) {
		em.persist(ai);
		return ai.getId();
	}

	public List<Agent> getListAgentByBienImmobilier(int idBI) {
		Query query = em.createQuery("SELECT a from agent a where a.bienImmobilier.id= ?1");
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
	//CRUD visite 

	

	public List<Visite> getVisiteByAgent(int idAgent) {
		Query query = em.createQuery("SELECT v  from visite v where v.agent.id= ?1");
		query.setParameter(1, idAgent);
		return query.getResultList();
	}

	public List<Visite> getVisiteByBienImmo(int idBI) {
		Query query = em.createQuery("SELECT v  from visite v where v.bienImmobilier.id= ?1");
		query.setParameter(1, idBI);
		return query.getResultList();
	}
	public int ajouterVisite(Visite v, int idBI, int idAgent, int idClient) {
		BienImmobilier bi = em.find(BienImmobilier.class, idBI);
		v.setBienImmobilier(bi);
		Agent agent=em.find(Agent.class, idAgent);
		v.setAgent(agent);
		Client client=em.find(Client.class, idClient);
		v.setClient(client);
		em.persist(v);
		return v.getId();
	}	
	
	//CRUD Class std
	public List<ClasseStd> listCSByClient(int idClient) {
		Query query = em.createQuery("SELECT cs from class cs where cs.client.id= ?1");
		query.setParameter(1, idClient);
		return query.getResultList();
	}

	public void supprimerCS(String code) {
		ClasseStd cs = em.find(ClasseStd.class, code);
		em.remove(cs);

	}
	

	public List<ClasseStd> getListCStdByRef(String code) {
		Query query = em.createQuery("SELECT c  from class c where c.code=?1");
		query.setParameter(1, code);
		return query.getResultList();
	}

	
	public String creerContrat(Contrat c, int idBI, int idAgent, int idClient) {
		BienImmobilier bi = em.find(BienImmobilier.class, idBI);
		c.setBienImmobilier(bi);
		Agent agent=em.find(Agent.class, idAgent);
		c.setAgent(agent);
		Client client=em.find(Client.class, idClient);
		c.setClient(client);
		em.persist(c);
		return c.getRefContrat();
	}

	public List <Contrat> getContratByClientWithRef(int idAgent, String motClef) {
		Query query = em.createQuery("SELECT c from contrat c where c.agent.id=?1 and c.refContrat LIKE :motClef");
		query.setParameter(1, idAgent);
		query.setParameter("motClef", "%"+motClef+"%");
		return query.getResultList();
		
	}


}
