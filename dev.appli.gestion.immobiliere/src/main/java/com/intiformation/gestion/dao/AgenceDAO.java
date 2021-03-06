package com.intiformation.gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.BienAAcheter;
import com.intiformation.gestion.entity.BienALouer;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.entity.ClasseStd;
import com.intiformation.gestion.entity.Client;
import com.intiformation.gestion.entity.Contrat;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;

@Repository
public class AgenceDAO implements IAgenceDAO {

	// Entity manager pour utiliser les m�thodes jpa
	// Annotation pour que le serveur g�re l'instanciation de l'em sans qu'on
	// utilise l'entity manager factory
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	//CRUD Proprietaire

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
	
	public List<BienImmobilier> listBi() {

		Query query = em.createQuery("SELECT bi from bienImmobilier bi");
		return query.getResultList();
	}

	public void supprimerBi(int id) {
		BienImmobilier bi = em.find(BienImmobilier.class, id);

		em.remove(bi);

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
		
		Query query = em.createQuery("SELECT bi  from bienImmobilier bi where bi.classeStd.code= ?1");
		query.setParameter(1, code);
		return query.getResultList();
	}
	
	public List<BienImmobilier> getListBIvenduByAgent(int idAgent) {
		Query query = em.createQuery("select c.bienImmobilier from contrat c where c.agent.id=?1");
		query.setParameter(1,idAgent);
		return query.getResultList();
	}
	public List<BienImmobilier> getListdesBiendispoByClassSTD(String idClassSTD){
		Query query = em.createQuery("select b from bienImmobilier b where b.statut=true and classeStd.code= ?1");
		query.setParameter(1,idClassSTD);
		return query.getResultList();
	}
	// CRUD BIEN IMMOBILIER A ACHETER 
		public void ajouterBiAAcheter(BienAAcheter biA, int idProp) {
			Proprietaire p = em.find (Proprietaire.class, idProp);
			biA.setProprietaire(p);
			em.persist(biA);
			
		}

		public void modifierBiAAcheter(BienAAcheter biA) {
			em.merge(biA);
			
		}

		public List<BienAAcheter> getListBiAAcheter() {
			Query query=em.createQuery("select bi from bienImmobilier bi where bi.modeOffre='aacheter'");
			
			return query.getResultList();
		}
	
	//CRUD BI A LOUER 
		
		public void ajouterBiALouer(BienALouer biL, int idProp) {
			Proprietaire p = em.find (Proprietaire.class, idProp);
			biL.setProprietaire(p);
			em.persist(biL);
			
		}

		public void modifierBiALouer(BienALouer biL) {
			em.merge(biL);
			
		}

		public List<BienALouer> getListBiALouer() {
			Query query=em.createQuery("select bi from bienImmobilier bi where bi.modeOffre='alouer'");
			
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

	public List<Client> getClientByBienImmobilier(int idBien, String code) {
		ClasseStd classSTD= em.find(ClasseStd.class, code);
		Query query = em.createQuery("SELECT b.class.id from bienImmobilier b  where b.id=?1 ");
		query.setParameter(1, idBien);
		classSTD = (ClasseStd) query.getSingleResult();
		
		Query query2= em.createQuery("SELECT c.client from class c  where c.id=?1 ");
		query2.setParameter(1, classSTD);
		
		List<Client>listeClients=query2.getResultList();
		return listeClients;
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
	
	public Agent getUsernPass(String username, String password) {
		Query query= em.createQuery("select a.username, a.password from agent a where a.username=?1 and a.password=?2 ");
		query.setParameter(1,username);
		query.setParameter(2, password);
		
		return (Agent) query.getSingleResult();
		
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
	
	
	public void supprimerVisite(int idV) {
		Visite visite=em.find(Visite.class, idV);
		em.remove(visite);
		
	}


	public void modifierVisite(Visite v) {
		em.merge(v);
		
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
