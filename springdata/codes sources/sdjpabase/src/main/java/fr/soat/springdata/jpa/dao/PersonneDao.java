package fr.soat.springdata.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDao extends CrudRepository<Personne, Long> {

}
