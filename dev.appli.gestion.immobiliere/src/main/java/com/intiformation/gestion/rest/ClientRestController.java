package com.intiformation.gestion.rest;

import com.intiformation.gestion.metier.IAgenceMetier;
import com.intiformation.gestion.entity.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientWs")
public class ClientRestController {
	
	/**
	 * déclaration et injection du ws 
	 */
	@Autowired
    IAgenceMetier agenceMetier;
	//setter du service

	public IAgenceMetier getAgenceMetier() {
		return agenceMetier;
	}

	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}
	/*_______________________________________   Methodes_____________________________________________*/
	/**
	 * getAllClients
	 */
	
	@RequestMapping(value ="/listeClient", method = RequestMethod.GET)
	
	public List<Client>getAllClients(){
		return agenceMetier.listClients();
	}//fin getAllClients
	
	/**
	 * getClientsById
	 * @return
	 */
	@RequestMapping(value="/listeClient/{clientId}",method=RequestMethod.GET)
	public Client getClientById (@PathVariable("clientId")int id) {
		agenceMetier.getClientbyId(id);
		
		             
		
	
		return agenceMetier.getClientbyId(id);
		
	}//getClasseStdById
	
	/**
	 * addClasseStd
	 */
    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
	public void addClient(@RequestBody Client client  ) {
		agenceMetier.ajouterClient(client);
		
		
	}//fin addClient
	
	/**
	 * updateClasseStd
	 */

    @RequestMapping(value="/listeClient/{clientId}",method = RequestMethod.PUT)
    public void updateClient (@RequestBody Client client) {
    	
    	agenceMetier.modifierClient(client);
		
    	
    }//fin de modifierClient

    
    
    /**
     * deleteClient
     */
    @RequestMapping(value="/listeClient/{clientId}",method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable("clientId")int id){
    	
    agenceMetier.supprimerClient(id);
    }//fin deleteClient
    


}//end class

	


