package fr.soat.springdata.jpa.sdjpawebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.soat.springdata.jpa.sdjpawebapp.dao.VeloDao;
import fr.soat.springdata.jpa.sdjpawebapp.entite.Velo;

/**
 * Contrôleur sans l'intégration de Spring Data avec Spring MVC (du moins pas beaucoup).
 */
@Controller
@RequestMapping("/welcome")
public class HelloController {

	@Autowired
	private VeloDao veloDao;

	@RequestMapping(value="/{page}/{pageSize}", method = RequestMethod.GET)
	public String printWelcome(final Model modele, @PathVariable("page") final int page, @PathVariable("pageSize") final int pageSize) {
		metStockDansModele(modele, page, pageSize);
		return "hello";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(final Model modele) {
		metStockDansModele(modele, 0, 2);
		return "hello";
	}

	private void metStockDansModele(final Model modele, final int page,
			final int pageSize) {
		Pageable pageable = new PageRequest(page, pageSize);

		Page<Velo> resultat = this.veloDao.findAll(pageable);
		int totalPages = (resultat.getTotalPages() - 1 >= 0 ) ? resultat.getTotalPages() - 1 : 0;

		modele.addAttribute("velosTrouves", resultat.getContent());
		modele.addAttribute("pagePrec", (page <= 0) ? 0 : resultat.getNumber() - 1);
		modele.addAttribute("pageSuiv", (page >= totalPages) ? totalPages : resultat.getNumber() + 1);
		modele.addAttribute("pageSize", pageSize);
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