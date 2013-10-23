package fr.soat.springdata.neo4j.sdneo4jbase.dao;

import org.springframework.data.neo4j.repository.GraphRepository;

import fr.soat.springdata.neo4j.sdneo4jbase.modele.Film;

public interface FilmDao extends GraphRepository<Film> {
	Iterable<Film> findByTitreContaining(String titre);
}
