package fr.soat.springdata.neo4j.sdneo4j.modele;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Film {

	@GraphId
	private Long idNoeud;
	private String titre;

	public Film(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Long getIdNoeud() {
		return this.idNoeud;
	}

	public void setIdNoeud(Long idNoeud) {
		this.idNoeud = idNoeud;
	}
}
