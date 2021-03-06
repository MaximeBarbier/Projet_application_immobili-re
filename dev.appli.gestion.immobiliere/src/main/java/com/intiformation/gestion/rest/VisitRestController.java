package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.entity.Visite;
import com.intiformation.gestion.metier.IAgenceMetier;


@RestController
@RequestMapping("/visitWs")
public class VisitRestController {
	

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
	
	@RequestMapping(value ="/listeVisite/{visiteByAgent}", method = RequestMethod.GET)
	
	public List<Visite>getVisiteByAgent(@PathVariable("visiteByAgent")int id){
		return agenceMetier.getVisiteByAgent(id);
	}//fin getAllClients
	
	/**
	 * getClientsById
	 * @return
	 */
	@RequestMapping(value="/listeVisite/{visiteByBienImmo}",method=RequestMethod.GET)
	public List<Visite>getVisiteByBienImmo (@PathVariable("visiteByBienImmo")int id) {
		return agenceMetier.getVisiteByBienImmo(id);	
		
	}
	
	/**
	 * addClasseStd
	 */
    @RequestMapping(value = "/createVisit", method = RequestMethod.POST)
	public void addVisit( @RequestBody Visite visite  ) {
	agenceMetier.ajouterVisite(visite, visite.getBienImmobilier().getId(), visite.getAgent().getId(), visite.getClient().getId());
		
		
	}
    

    @RequestMapping(value="/listeVisite/{visiteId}",method = RequestMethod.PUT)
    public void updateVisite (@RequestBody Visite visite) {
    	
    	agenceMetier.modifierVisite(visite);
		
    	
    }

    
    
    @RequestMapping(value="/listeVisite/{visiteId}",method = RequestMethod.DELETE)
    public void deleteProprio(@PathVariable("visiteId")int id){
    	
    agenceMetier.supprimerVisite(id);
    }
    

	

}//end class


