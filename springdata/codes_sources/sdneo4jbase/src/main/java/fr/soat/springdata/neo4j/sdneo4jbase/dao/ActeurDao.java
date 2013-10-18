package fr.soat.springdata.neo4j.sdneo4jbase.dao;

import org.springframework.data.neo4j.repository.GraphRepository;

import fr.soat.springdata.neo4j.sdneo4jbase.modele.Acteur;

public interface ActeurDao extends GraphRepository<Acteur> {
	//findByTitre(String titre);
}
