package com.intiformation.gestion.metier;

import java.util.List;

import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.BienAAcheter;
import com.intiformation.gestion.entity.BienALouer;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.entity.ClasseStd;
import com.intiformation.gestion.entity.Client;
import com.intiformation.gestion.entity.Contrat;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;

public interface IAgenceMetier {

	// CRUD proprietaire

		public int ajouterProprietaire(Proprietaire p);

		public List<Proprietaire> listProprietaires();

		public Proprietaire getProprietairebyId(int id);

		public void supprimerProprietaire(int id);

		public void modifierProprietaire(Proprietaire p);

		//CRUD bien immo � acheter
		
		public void ajouterBiAAcheter(BienAAcheter biA, int idProp);
		public void modifierBiAAcheter(BienAAcheter biA);
		public List<BienAAcheter> getListBiAAcheter();
		
		
		//CRUD bien immo � louer 
		
		public void ajouterBiALouer(BienALouer biL, int idProp);
		public void modifierBiALouer(BienALouer biL);
		public List<BienALouer> getListBiALouer();
		
		
		// CRUD bien immobilier

		public void supprimerBi(int id);
		
		public List <BienImmobilier> listBi();
		
		public BienImmobilier getBibyId(int id);
		
		public List<BienImmobilier> getListBIByIdPropietaire(int idProp);
		
		public List<BienImmobilier> getListBIByClassSt(String code);

		// CRUD Client

		public int ajouterClient(Client c);

		public List<Client> listClients();

		public Client getClientbyId(int id);

		public void supprimerClient(int id);

		public void modifierClient(Client c);

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

		public int ajouterVisite(Visite v, int idBI, int idAgent, int idClient);

		public List<Visite> getVisiteByAgent(int idAgent);

		public List<Visite> getVisiteByBienImmo(int idBI);

		// CRUD Contrat
		
		public String creerContrat(Contrat c, int idBI, int idAgent, int idClient );
		
		public List<Contrat> getContratByClientWithRef(int idAgent, String ref);

}
