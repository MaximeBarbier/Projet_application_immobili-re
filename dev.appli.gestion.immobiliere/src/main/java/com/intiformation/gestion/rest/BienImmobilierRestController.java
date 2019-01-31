package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestion.entity.BienAAcheter;
import com.intiformation.gestion.entity.BienALouer;
import com.intiformation.gestion.entity.BienImmobilier;
import com.intiformation.gestion.metier.IAgenceMetier;

@RestController
@RequestMapping("/bienImmobilierWs")
public class BienImmobilierRestController {

	@Autowired
	IAgenceMetier agenceMetier;

	/**
	 * @return the agenceMetier
	 */
	public IAgenceMetier getAgenceMetier() {
		return agenceMetier;
	}

	/**
	 * @param agencemetier
	 *            the agenceMetier to set
	 */
	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}

	/*
	 * ____________________________________méthodes_________________________________________
	 */

	@RequestMapping(value = "/listBienImmobilier", method = RequestMethod.GET)
	public List<BienImmobilier> getListBi() {
		return agenceMetier.listBi();
	}

	@RequestMapping(value = "/listBienImmobilier/{BIById}", method = RequestMethod.DELETE)
	public void deleteBI(@PathVariable("BIById") int id) {
		agenceMetier.supprimerBi(id);
	}

	@RequestMapping(value = "/listBienImmobilier/{BIByIdProprietaire}", method = RequestMethod.GET)
	public List<BienImmobilier> getListBIByIdPropietaire(@PathVariable("BIByIdProprietaire") int idProp) {
		return agenceMetier.getListBIByIdPropietaire(idProp);
	}

	@RequestMapping(value = "/listBienImmobilier/{BIByIdClassStd}", method = RequestMethod.GET)
	public List<BienImmobilier> getListBIByClassStd(@PathVariable("BIByIdClassStd") String code) {
		return agenceMetier.getListBIByClassSt(code);
	}

	@RequestMapping(value = "/listBienImmobilier/{BIById}", method = RequestMethod.GET)
	public BienImmobilier getBibyId(@PathVariable("BIById") int id) {
		return agenceMetier.getBibyId(id);
	}

	// BI à ACHETER
	@RequestMapping(value = "/createBIAAcheter", method = RequestMethod.POST)
	public void addBIAA(@RequestBody BienAAcheter biAA) {
		agenceMetier.ajouterBiAAcheter(biAA, biAA.getProprietaire().getId());

	}

	@RequestMapping(value = "/listBienAAcheter/{immoId}", method = RequestMethod.PUT)
	public void updateBIAA(@RequestBody BienAAcheter biAA) {

		agenceMetier.modifierBiAAcheter(biAA);

	}

	@RequestMapping(value = "/listBienAAcheter", method = RequestMethod.GET)
	public List<BienAAcheter> getListBiAA() {
		return agenceMetier.getListBiAAcheter();
	}

	// BI à LOUER

	@RequestMapping(value = "/createBIALouer", method = RequestMethod.POST)
	public void addBIAL(@RequestBody BienALouer biAL) {
		agenceMetier.ajouterBiALouer(biAL, biAL.getProprietaire().getId());

	}

	@RequestMapping(value = "/listBienALouer/{immoId}", method = RequestMethod.PUT)
	public void updateBIAL(@RequestBody BienALouer biAL) {

		agenceMetier.modifierBiALouer(biAL);

	}

	@RequestMapping(value = "/listBienALouer", method = RequestMethod.GET)
	public List<BienALouer> getListBiAL() {
		return agenceMetier.getListBiALouer();
	}

}
