package fr.soat.springdata.jpa.sdjpawebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.soat.springdata.jpa.sdjpawebapp.dao.VeloDao;
import fr.soat.springdata.jpa.sdjpawebapp.entite.Velo;
 
@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@Autowired
	private VeloDao veloDao;
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("titre", "Ma superbe application web avec Spring Data \\o/");
		return "hello";
	}
	
	@RequestMapping("/ajout")
	public String ajoutVelo(ModelMap modele) {
		Velo velo = new Velo();
		velo.setModele("Muscle powaa");
		veloDao.save(velo);
		modele.addAttribute("message", "Velo sauvegardé !");
		return "hello";
	}
	
	@RequestMapping("/voir/{id}")
	public String voirVelo(@PathVariable("id") Long id, Model modele) {
		Velo veloTrouve = veloDao.findOne(id);
		modele.addAttribute("message", "Velo trouvé : " + veloTrouve.getModele() + " (" + veloTrouve.getId() + ")");
		return "hello";
	}
}