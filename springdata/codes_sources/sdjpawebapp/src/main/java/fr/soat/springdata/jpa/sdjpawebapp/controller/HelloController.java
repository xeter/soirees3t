package fr.soat.springdata.jpa.sdjpawebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String printWelcome(final Model modele) {
		modele.addAttribute("velosTrouves", this.veloDao.findAll());
		return "hello";
	}

	@RequestMapping("/ajout")
	public String ajoutVelo(final Model modele) {
		modele.addAttribute("velo", new Velo());
		modele.addAttribute("velosTrouves", this.veloDao.findAll());
		return "ajout";
	}

	@RequestMapping("/sauv")
	public String sauvegarderVelo(@ModelAttribute final Velo velo, final Model modele) {
		this.veloDao.save(velo);
		modele.addAttribute("message", "Velo sauvegardé !");
		modele.addAttribute("velosTrouves", this.veloDao.findAll());
		return "ajout";
	}

	@RequestMapping("/voir/{id}")
	public String voirVelo(@PathVariable("id") final Long id, final Model modele) {
		Velo veloTrouve = this.veloDao.findOne(id);
		modele.addAttribute("message", "Modèle de vélo : " + veloTrouve.getModele() + " (" + veloTrouve.getId() + ")");
		return "fiche";
	}
}