package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.Agent;
import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.metier.IAgenceMetier;

@RestController
@RequestMapping("/agentImmobilierWs")

public class AgentImmobilierRestController {

	/**
	 * déclaration et injection du ws
	 */
	@Autowired
	IAgenceMetier agenceMetier;
	
	// setter du service
	public IAgenceMetier getAgenceMetier() {
		return agenceMetier;
	}

	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}

	/*
	 * _______________________________________
	 * Methodes_____________________________________________
	 */
	/**
	 * getAllClients
	 */

	@RequestMapping(value = "/listeAgents/{agentByBienImmobilier}", method = RequestMethod.GET)

	public List<Agent> getAllAgents(@PathVariable("agentByBienImmobilier") int id) {
		return agenceMetier.getListAgentByBienImmobilier(id);
	}

	/**
	 * getClientsById
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listeAgents/{agentById}", method = RequestMethod.GET)
	public Agent getAgentById(@PathVariable("agentById") int id) {
		return agenceMetier.getAgentbyId(id);

	}// getClasseStdById

	/**
	 * addClasseStd
	 */
	@RequestMapping(value = "/createAgent", method = RequestMethod.POST)
	public void addAgent(@RequestBody Agent agent) {
		agenceMetier.ajouterAI(agent);

	}// fin addClient

	/**
	 * updateClasseStd
	 */

	@RequestMapping(value = "/listeAgents/{agentById}", method = RequestMethod.PUT)
	public void updateAgent(@RequestBody Agent agent) {

		agenceMetier.modifierAI(agent);

	}// fin de modifierClient

	/**
	 * deleteClient
	 */
	@RequestMapping(value = "/listeAgents/{agentById}", method = RequestMethod.DELETE)
	public void deleteAgent(@PathVariable("agentById") int id) {

		agenceMetier.supprimerAI(id);
	}// fin deleteClient
	
	@RequestMapping(value = "/listeAgents/{agentByusername}/{agentBypassword}", method = RequestMethod.GET)
	public Agent getAgentByPassnuser(@PathVariable("agentByusername") String username, @PathVariable("agentBypassword") String password) {
		return agenceMetier.getUsernPass(username, password);

	}// getAgentpassnUserna

}// end class
