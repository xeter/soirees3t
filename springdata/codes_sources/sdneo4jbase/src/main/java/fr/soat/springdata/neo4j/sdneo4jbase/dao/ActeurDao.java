package fr.soat.springdata.neo4j.sdneo4jbase.dao;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import fr.soat.springdata.neo4j.sdneo4jbase.modele.Acteur;
import fr.soat.springdata.neo4j.sdneo4jbase.modele.Film;

public interface ActeurDao extends GraphRepository<Acteur> {
	@Query("start acteur=node({0}) match (acteur)-[:realise]-> (film) return film")
	Iterable<Film> recupereMoiTousLesFilmsRealisesPar(Acteur acteur);
}
