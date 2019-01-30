package com.intiformation.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	 * @param agencemetier the agenceMetier to set
	 */
	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}
	
	/*____________________________________méthodes_________________________________________*/
	
	@RequestMapping(value="/listBienImmobilier/{BIById}",method=RequestMethod.DELETE)
	public void deleteBI(@PathVariable("BIById") int id) {
		
		agenceMetier.supprimerBi(id);
		
	}
	
	@RequestMapping(value="/listBienImmobilier/{BIByIdProprietaire}",method=RequestMethod.GET)
	public List<BienImmobilier> getListBIByIdPropietaire(@PathVariable("BIByIdProprietaire")int idProp){
		return agenceMetier.getListBIByIdPropietaire(idProp);
	}
	
	@RequestMapping(value="/listBienImmobilier/{BIByIdClassStd}",method=RequestMethod.GET)
	public List<BienImmobilier> getListBIByClassStd(@PathVariable("BIByIdClassStd")String code){
		return agenceMetier.getListBIByClassSt(code);
	}
	
	@RequestMapping(value="/listBienImmobilier/{BIById}",method=RequestMethod.GET)
	public BienImmobilier getBibyId(@PathVariable("BIById")int id) {
		return agenceMetier.getBibyId(id);
	}
	
	@RequestMapping(value="/listBienImmobilier/{BIByIdProprietaire}",method=RequestMethod.POST)
	public int addBI(@RequestBody BienImmobilier bi,@PathVariable("BIByIdProprietaire") int idProp) {
		return agenceMetier.ajouterBI(bi, idProp);
	}
	
	@RequestMapping(value="/listBienImmobilier/{BIById}",method=RequestMethod.PUT)
	public void updateBi(@RequestBody BienImmobilier bi) {
		agenceMetier.modifierBi(bi);
	}

}
