package fr.soat.springdata.neo4j.sdneo4j.modele;

import org.springframework.data.neo4j.annotation.RelationshipEntity;

@RelationshipEntity
public class JoueDans {
	private Film film;
	private Acteur acteur;
	
	public Film getFilm() {
		return this.film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Acteur getActeur() {
		return this.acteur;
	}
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}
}
