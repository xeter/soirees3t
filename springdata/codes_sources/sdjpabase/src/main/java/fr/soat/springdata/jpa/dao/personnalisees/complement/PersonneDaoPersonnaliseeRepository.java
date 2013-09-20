package fr.soat.springdata.jpa.dao.personnalisees.complement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoPersonnaliseeRepository extends CrudRepository<Personne, Long>, PersonneDaoPersonnalisee {
	public List<Personne> uneMethodePersonnaliseeDeRechercheParNom(String nom);
}
