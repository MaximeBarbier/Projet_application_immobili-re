package com.intiformation.gestion.rest;

import com.intiformation.gestion.metier.IAgenceMetier;
import com.intiformation.gestion.entity.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@RequestMapping(value="/clients/{clientId}",method=RequestMethod.GET)
	public ResponseEntity<Client> getClientById (@PathVariable("clientId")int id) {
		Client client=agenceMetier.getClientbyId(id);
		
		if (client != null) {
			//renvoie de la classeStd avec un code 200
			return new ResponseEntity<>(client,HttpStatus.OK );              
		
		}//fin de if 
		//ds le cas ou l'id de la classe n'existe pas renvoie d'un statut 404 NOT-FOUND
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
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

    @RequestMapping(value="/client/{clientId}",method = RequestMethod.PUT)
    public void updateClient (@RequestBody Client client) {
    	
    	agenceMetier.modifierClient(client);
		
    	
    }//fin de modifierClient

    
    /**
     * deleteClient
     */
    
    public ResponseEntity<Boolean> deleteClient(@PathVariable("client")int id){
    	agenceMetier.supprimerClient(id);
    return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }//fin deleteClient
    


}//end class

	


