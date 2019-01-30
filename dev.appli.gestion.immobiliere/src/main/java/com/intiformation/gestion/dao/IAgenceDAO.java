package com.intiformation.gestion.dao;

import java.util.List;

import javax.persistence.Query;

import com.intiformation.gestion.entity.Acheter;
import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.entity.ClasseStd;
import com.intiformation.gestion.entity.Client;
import com.intiformation.gestion.entity.Louer;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;

public interface IAgenceDAO {

	// CRUD proprietaire

	public int ajouterProprietaire(Proprietaire p);

	public List<Proprietaire> listProprietaires();

	public Proprietaire getProprietairebyId(int id);

	public void supprimerProprietaire(int id);

	public void modifierProprietaire(Proprietaire p);

	// CRUD bien immobilier

	public int ajouterBI(BienImmobilier bi, int idProp);

	public BienImmobilier getBibyId(int id);

	public void supprimerBi(int id);

	public void modifierBi(BienImmobilier bi);

	public List<BienImmobilier> getListBIByIdPropietaire(int idProp);
	
	public List<BienImmobilier> getListBIByClassSt(String code);

	// CRUD Client

	public int ajouterClient(Client c);

	public List<Client> listClients();

	public Client getClientbyId(int id);

	public void supprimerClient(int id);

	public void modifierClient(Client c);

	// CRUD Classe Standard acheter

	public String ajouterCSAcheter(Acheter csAcheter);

	public void modifierCSAcheter(Acheter csAcheter) ;

	
	
	// CRUD Classe Standard louer
	
	public String ajouterCSLouer(Louer csLouer);

	public void modifierCSLouer(Louer csLouer);

	//CRUD Classe Standard 
	public List<ClasseStd> listCSByClient(int idClient);
		

	public void supprimerCS(String code) ;
	
	public List<ClasseStd> getListCStdByRef(String code);


	// CRUD Classe Agent immobilier

	public int ajouterAI(Agent ai);

	public List<Agent> getListAgentByBienImmobilier(int idBI);

	public void supprimerAI(int id);

	public Agent getAgentbyId(int id);

	public void modifierAI(Agent ai);

	// CRUD Visite

	public int ajouterVisite(Visite v, int idBi);

	public List<Visite> getVisiteByAgent(int idAgent);

	public List<Visite> getVisiteByBienImmo(int idBI);

	// CRUD Contrat

}
