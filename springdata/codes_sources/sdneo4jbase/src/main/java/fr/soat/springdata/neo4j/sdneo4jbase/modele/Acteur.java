package fr.soat.springdata.neo4j.sdneo4jbase.modele;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Acteur {

	@GraphId
	private Long idNoeud;
	private String nom, prenom;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getIdNoeud() {
		return this.idNoeud;
	}

	public void setIdNoeud(Long idNoeud) {
		this.idNoeud = idNoeud;
	}
}
