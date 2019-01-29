package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
		
	}//getClasseStdById
	
	/**
	 * addClasseStd
	 */
    @RequestMapping(value = "/createVisit/{visiteByAgent}", method = RequestMethod.POST)
	public void addVisit(@PathVariable("visiteByAgent")int id, @RequestBody Visite visite  ) {
		agenceMetier.ajouterVisite(visite, id);
		
		
	}//fin addClient
	

}//end class


