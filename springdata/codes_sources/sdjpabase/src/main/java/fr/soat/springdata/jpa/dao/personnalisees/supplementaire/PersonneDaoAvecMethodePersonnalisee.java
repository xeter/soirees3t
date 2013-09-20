package fr.soat.springdata.jpa.dao.personnalisees.supplementaire;

import java.util.List;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoAvecMethodePersonnalisee {
	
	public List<Personne> uneMethodePersonnaliseeDeRechercheParNom(String nom);
}
