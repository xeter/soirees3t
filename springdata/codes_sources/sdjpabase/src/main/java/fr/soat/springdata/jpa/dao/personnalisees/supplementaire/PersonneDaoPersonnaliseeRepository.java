package fr.soat.springdata.jpa.dao.personnalisees.supplementaire;

import org.springframework.data.repository.CrudRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoPersonnaliseeRepository extends CrudRepository<Personne, Long>, PersonneDaoAvecMethodePersonnalisee {
}
