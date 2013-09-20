package fr.soat.springdata.jpa.dao.personnalisees.complement;

import java.util.List;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoPersonnalisee {
	
	public List<Personne> uneMethodePersonnaliseeDeRechercheParNom(String nom);
}
