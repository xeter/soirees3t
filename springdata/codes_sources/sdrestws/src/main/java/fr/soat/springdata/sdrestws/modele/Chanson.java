package fr.soat.springdata.sdrestws.modele;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chanson {

	@Id
	private Long id;

	private String titre;

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}
}
