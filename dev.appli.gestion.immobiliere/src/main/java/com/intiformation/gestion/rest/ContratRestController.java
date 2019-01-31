package com.intiformation.gestion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.BienALouer;
import com.intiformation.gestion.entity.Contrat;
import com.intiformation.gestion.metier.IAgenceMetier;

@RestController
@RequestMapping("/contratWs")
public class ContratRestController {
	@Autowired
    IAgenceMetier agenceMetier;
	//setter du service

	public IAgenceMetier getAgenceMetier() {
		return agenceMetier;
	}

	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}
	@RequestMapping(value = "/createContrat", method = RequestMethod.POST)
	public void addContrat(@RequestBody Contrat contrat) {
		agenceMetier.creerContrat(contrat, contrat.getBienImmobilier().getId(), contrat.getAgent().getId(), contrat.getClient().getId());

	}

}
