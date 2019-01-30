package com.intiformation.gestion.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestion.dao.IAgenceDAO;
import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.BienAAcheter;
import com.intiformation.gestion.entity.BienALouer;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.entity.ClasseStd;
import com.intiformation.gestion.entity.Client;
import com.intiformation.gestion.entity.Contrat;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;

@Service("serviceBean")
public class AgenceMetier implements IAgenceMetier {

	@Autowired
	private IAgenceDAO agenceDAO;

	public void setAgenceDAO(IAgenceDAO agenceDAO) {
		this.agenceDAO = agenceDAO;
	}

	// crud proprietaire
	@Transactional
	public int ajouterProprietaire(Proprietaire p) {

		return agenceDAO.ajouterProprietaire(p);
	}

	@Transactional(readOnly = true)
	public List<Proprietaire> listProprietaires() {

		return agenceDAO.listProprietaires();
	}

	@Transactional(readOnly = true)
	public Proprietaire getProprietairebyId(int id) {

		return agenceDAO.getProprietairebyId(id);
	}

	@Transactional
	public void supprimerProprietaire(int id) {
		agenceDAO.supprimerProprietaire(id);

	}

	@Transactional
	public void modifierProprietaire(Proprietaire p) {
		agenceDAO.modifierProprietaire(p);

	}
	// CRUD bien immobilier

	
	@Transactional(readOnly = true)
	public BienImmobilier getBibyId(int id) {

		return agenceDAO.getBibyId(id);
	}

	@Transactional
	public void supprimerBi(int id) {
		agenceDAO.supprimerBi(id);

	}
	
	@Transactional(readOnly = true)
	public List<BienImmobilier> listBi() {
		
		return agenceDAO.listBi();
	}

	@Transactional(readOnly = true)
	public List<BienImmobilier> getListBIByIdPropietaire(int idProp) {

		return agenceDAO.getListBIByIdPropietaire(idProp);
	}

	@Transactional(readOnly = true)
	public List<BienImmobilier> getListBIByClassSt(String code) {

		return agenceDAO.getListBIByClassSt(code);
	}
	
	//CRUD bien à LOUER 
	@Transactional
	public void ajouterBiALouer(BienALouer biL, int idProp) {
		agenceDAO.ajouterBiALouer(biL, idProp);
		
	}
	@Transactional
	public void modifierBiALouer(BienALouer biL) {
		agenceDAO.modifierBiALouer(biL);
		
	}
	
	@Transactional(readOnly = true)
	public List<BienALouer> getListBiALouer() {
		
		return agenceDAO.getListBiALouer();
	}
	
	//CRUD bien à vendre 
	@Transactional
	public void ajouterBiAAcheter(BienAAcheter biA, int idProp) {
		agenceDAO.ajouterBiAAcheter(biA, idProp);
		
	}
	@Transactional
	public void modifierBiAAcheter(BienAAcheter biA) {
		agenceDAO.modifierBiAAcheter(biA);
		
	}
	@Transactional(readOnly = true)
	public List<BienAAcheter> getListBiAAcheter() {
		
		return agenceDAO.getListBiAAcheter();
	}
	// CRUD CLIENT

	@Transactional
	public int ajouterClient(Client c) {

		return agenceDAO.ajouterClient(c);
	}

	@Transactional(readOnly = true)
	public List<Client> listClients() {

		return agenceDAO.listClients();
	}

	@Transactional(readOnly = true)
	public Client getClientbyId(int id) {

		return agenceDAO.getClientbyId(id);
	}

	@Transactional
	public void supprimerClient(int id) {
		agenceDAO.supprimerClient(id);

	}

	@Transactional
	public void modifierClient(Client c) {
		agenceDAO.modifierClient(c);

	}

	// CRUD classe std
	@Transactional(readOnly = true)
	public List<ClasseStd> listCSByClient(int idClient) {

		return agenceDAO.listCSByClient(idClient);
	}

	@Transactional
	public void supprimerCS(String code) {
		agenceDAO.supprimerCS(code);

	}

	@Transactional(readOnly = true)
	public List<ClasseStd> getListCStdByRef(String code) {

		return agenceDAO.getListCStdByRef(code);
	}

	// CRUD AGENT

	@Transactional
	public int ajouterAI(Agent ai) {

		return agenceDAO.ajouterAI(ai);
	}

	@Transactional(readOnly = true)
	public List<Agent> getListAgentByBienImmobilier(int idBI) {

		return agenceDAO.getListAgentByBienImmobilier(idBI);
	}

	@Transactional
	public void supprimerAI(int id) {
		agenceDAO.supprimerAI(id);

	}

	@Transactional(readOnly = true)
	public Agent getAgentbyId(int id) {

		return agenceDAO.getAgentbyId(id);
	}

	@Transactional
	public void modifierAI(Agent ai) {
		agenceDAO.modifierAI(ai);

	}

	// CRUD visite
	@Transactional
	public int ajouterVisite(Visite v, int idBI, int idAgent, int idClient) {

		return agenceDAO.ajouterVisite(v, idBI, idAgent, idClient);
	}

	@Transactional(readOnly = true)
	public List<Visite> getVisiteByAgent(int idAgent) {

		return agenceDAO.getVisiteByAgent(idAgent);
	}

	@Transactional(readOnly = true)
	public List<Visite> getVisiteByBienImmo(int idBI) {

		return agenceDAO.getVisiteByBienImmo(idBI);
	}

	// CRUD CONTRAT
	@Transactional
	public String creerContrat(Contrat c, int idBI, int idAgent, int idClient) {

		return agenceDAO.creerContrat(c, idBI, idAgent, idClient);
	}

	@Transactional(readOnly = true)
	public List<Contrat> getContratByClientWithRef(int idAgent, String ref) {

		return agenceDAO.getContratByClientWithRef(idAgent, ref);
	}

	

	

	

}
