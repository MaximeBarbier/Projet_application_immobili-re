package com.intiformation.gestion.dao;

import java.util.List;



public interface IAgenceDAO {
	
	//CRUD proprietaire

	public int ajouterProprietaire(Proprietaire p);
	
	public List<Proprietaire> listProprietaires();
	
	public Proprietaire getProprietairebyId(int id);	
	
	public void supprimerProprietaire(int id);
	
	public void modifierProprietaire(Proprietaire p);
	
	//CRUD bien immobilier 
	
	public int ajouterBI(BienImmobilier bi, int idProp);
	
	
	
	public BienImmobilier getBibyId(int id);	
	
	public void supprimerBi(int id);
	
	public void modifierBi(BienImmobilier bi);
	
	public List<BienImmobilier> getListBIByIdPropietaire (int idProp);
	
	//CRUD Client 
	
	public int ajouterClient(Client c);
	
	public List<Client> listClients();
	
	public Client getClientbyId(int id);	
	
	public void supprimerClient(int id);
	
	public void modifierClient(Client c);
	
	//CRUD Classe Standard 
	
	public int ajouterCS(ClasseStandard cs);
	
	public List<ClasseStandard> listCSByClient(int idClient);
	
	public void supprimerCS(int id);
	
	public void modifierCS(ClasseStandard cs);
	
	
	//CRUD Classe Agent immobilier 
	
	public int ajouterAI(Agent ai);
	public List<Agent> getListAgentByBienImmobilier(int idBI);
	public void supprimerAI (int id);
	public Agent getAgentbyId(int id);
	public void modifierAI (Agent ai);
	
	
	
	//CRUD Visite
	
	public int ajouterVisite(Visite v, int idBi);
	public List<Visite> getVisiteByAgent (int idAgent);
	public List<Visite> getVisiteByBienImmo (int idBI);
	
	
	//CRUD Contrat
	
	
	
	
	
	
	
	
	
}
