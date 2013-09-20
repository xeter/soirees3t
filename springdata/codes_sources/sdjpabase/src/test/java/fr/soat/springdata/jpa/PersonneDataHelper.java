package fr.soat.springdata.jpa;

import fr.soat.springdata.jpa.entites.Personne;
import fr.soat.springdata.jpa.entites.Velo;

public class PersonneDataHelper {

	public static Personne creePersonne() {
		Personne personne = new Personne();
		personne.setNom("nom");
		personne.setPrenom("prenom");
		Velo velo = new Velo();
		velo.setCouleur("Couleur de feu");
		personne.setVelo(velo);
		return personne;
	}
}