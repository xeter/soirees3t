package fr.soat.springdata.neo4j.sdneo4jbase.modele;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class Acteur {

	@GraphId
	private Long idNoeud;

	@Indexed(indexType = IndexType.FULLTEXT, indexName="nom")
	private String nom;

	private String prenom;

	@RelatedTo(direction=Direction.BOTH, type="aJoueDans")
	private Set<Film> films;

	@RelatedToVia
	private Set<Realisation> realisations;

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public Long getIdNoeud() {
		return this.idNoeud;
	}

	public void setIdNoeud(final Long idNoeud) {
		this.idNoeud = idNoeud;
	}

	public Set<Film> getFilms() {
		return this.films;
	}

	public void aJoueDans(final Film film) {
		if (this.films == null) {
			this.films = new HashSet<Film>();
		}
		this.films.add(film);
	}

	public Realisation aRealise(final Film film) {
		if (this.realisations == null) {
			this.realisations = new HashSet<Realisation>();
		}
		Realisation realisation = new Realisation();
		realisation.setActeur(this);
		realisation.setFilm(film);
		this.realisations.add(realisation);
		return realisation;
	}

	@Override
	public String toString() {
		return this.prenom + " " + this.nom;
	}
}
