package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.metier.IAgenceMetier;


@RestController
@RequestMapping("/propriotWs")
public class ProprioRestController {

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
	
	@RequestMapping(value ="/listeProprio", method = RequestMethod.GET)
	
	public List<Proprietaire>getAllProprio(){
		return agenceMetier.listProprietaires();
	}//fin getAllClients
	
	/**
	 * getClientsById
	 * @return
	 */
	@RequestMapping(value="/listeProprio/{proprioId}",method=RequestMethod.GET)
	public Proprietaire getProprioById (@PathVariable("proprioId")int id) {
		return agenceMetier.getProprietairebyId(id);	
		
	}//getClasseStdById
	
	/**
	 * addClasseStd
	 */
    @RequestMapping(value = "/createProprio", method = RequestMethod.POST)
	public void addProprio(@RequestBody Proprietaire proprietaire  ) {
		agenceMetier.ajouterProprietaire(proprietaire);
		
		
	}//fin addClient
	
	/**
	 * updateClasseStd
	 */

    @RequestMapping(value="/listeProprio/{proprioId}",method = RequestMethod.PUT)
    public void updateProprio (@RequestBody Proprietaire proprietaire) {
    	
    	agenceMetier.modifierProprietaire(proprietaire);;
		
    	
    }//fin de modifierClient

    
    /**
     * deleteClient
     */
    @RequestMapping(value="/listeProprio/{proprioId}",method = RequestMethod.DELETE)
    public void deleteProprio(@PathVariable("proprioId")int id){
    	
    agenceMetier.supprimerProprietaire(id);
    }//fin deleteClient
    


}//end class
