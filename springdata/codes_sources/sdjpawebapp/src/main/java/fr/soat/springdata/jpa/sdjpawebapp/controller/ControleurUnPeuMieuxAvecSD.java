package fr.soat.springdata.jpa.sdjpawebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.soat.springdata.jpa.sdjpawebapp.dao.VeloDao;
import fr.soat.springdata.jpa.sdjpawebapp.entite.Velo;

/**
 * Contrôleur avec l'intégration de Spring Data avec Spring MVC.
 */
@Controller
@RequestMapping("/sdtouch/")
public class ControleurUnPeuMieuxAvecSD {

	@Autowired
	private VeloDao veloDao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(final Model modele, @PageableDefaults(pageNumber = 0, value = 2)final Pageable pageable) {
		final Page<Velo> resultatRecherche = this.veloDao.findAll(pageable);
		modele.addAttribute("velosTrouves", resultatRecherche.getContent());
		modele.addAttribute("pagination", resultatRecherche);
		return "sdtouch/hello";
	}

	@RequestMapping("/ajout")
	public String ajoutVelo(final Model modele) {
		modele.addAttribute("velo", new Velo());
		modele.addAttribute("velosTrouves", this.veloDao.findAll());
		return "sdtouch/ajout";
	}

	@RequestMapping("/sauv")
	public String sauvegarderVelo(@ModelAttribute final Velo velo, final Model modele) {
		this.veloDao.save(velo);
		modele.addAttribute("message", "Velo sauvegardé !");
		modele.addAttribute("velosTrouves", this.veloDao.findAll());
		return "sdtouch/ajout";
	}

	@RequestMapping("/voir/{id}")
	public String voirVelo(@PathVariable("id") final Velo veloTrouve, final Model modele) {
		modele.addAttribute("message", "Modèle de vélo : " + veloTrouve.getModele() + " (" + veloTrouve.getId() + ")");
		return "sdtouch/fiche";
	}
}