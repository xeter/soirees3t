package fr.soat.springdata.neo4j.sdneo4jbase.modele;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Film {

	@GraphId
	private Long idNoeud;

	@Indexed
	private String titre;

	public Film() {
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public Long getIdNoeud() {
		return this.idNoeud;
	}

	public void setIdNoeud(final Long idNoeud) {
		this.idNoeud = idNoeud;
	}
}
