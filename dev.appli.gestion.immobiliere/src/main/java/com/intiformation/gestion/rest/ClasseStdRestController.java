package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.ClasseStd;

import com.intiformation.gestion.metier.IAgenceMetier;

@RestController
@RequestMapping("/classeStdWs")
public class ClasseStdRestController {
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
	
	@RequestMapping(value ="/listeClasseStd/{classeStdByClient}", method = RequestMethod.GET)
	
	public List<ClasseStd>getAllClasseStdByClient(@PathVariable("classeStdByClient")int id){
		return agenceMetier.listCSByClient(id);
	}//fin getAllClients
	
	
	
	/**
	 * addClasseStd
	 */
//    @RequestMapping(value = "/createClasseStd", method = RequestMethod.POST)
//	public void addClasseStd(@RequestBody ClasseStd classeStd ) {
//		agenceMetier.ajouterCS(classeStd);
//		
//		
//	}//fin addClient
	
	/**
	 * updateClasseStd
	 */

//    @RequestMapping(value="/listeClasseStd/{classeStdByClient}",method = RequestMethod.PUT)
//    public void updateClasseStd (@RequestBody ClasseStd classeStd) {
//    	
//    	agenceMetier.modifierCS(classeStd);
//		
//    	
//    }//fin de modifierClient

    
    /**
     * deleteClient
     */
    @RequestMapping(value="/listeClasseStd/{classeStdById}}",method = RequestMethod.DELETE)
    public void deleteProprio(@PathVariable("classeStdById")String code){
    	
    agenceMetier.supprimerCS(code);
    }//fin deleteClient
    


}//end class



