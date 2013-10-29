package fr.soat.springdata.neo4j.sdneo4jbase.modele;

import java.util.Calendar;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="aRealise")
public class Realisation {

	@GraphId
	private Long id;

	private Calendar dateRealisation;

	@StartNode
	private Acteur acteur;

	@EndNode
	private Film film;

	public Film getFilm() {
		return this.film;
	}
	public void setFilm(final Film film) {
		this.film = film;
	}
	public Acteur getActeur() {
		return this.acteur;
	}
	public void setActeur(final Acteur acteur) {
		this.acteur = acteur;
	}
	public Calendar getDateRealisation() {
		return this.dateRealisation;
	}
	public void setDateRealisation(final Calendar dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public void en(final int annee) {
		this.dateRealisation = Calendar.getInstance();
		this.dateRealisation.set(Calendar.YEAR, annee);
	}
}
