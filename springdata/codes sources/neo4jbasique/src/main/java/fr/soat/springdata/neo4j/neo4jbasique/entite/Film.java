package fr.soat.springdata.neo4j.neo4jbasique.entite;

import org.neo4j.graphdb.Node;

public class Film {

	public static final String TITRE = "TITRE";
	private Node noeud;

	public Film(Node noeud) {
		this.noeud = noeud;
	}
	
	public Node getNoeud() {
		return this.noeud;
	}

	public String getTitre() {
		return (String) this.noeud.getProperty(TITRE);
	}

	public void setTitre(String nom) {
		this.noeud.setProperty(TITRE, nom);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.noeud == null) ? 0 : this.noeud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		if (this.noeud == null) {
			if (other.noeud != null) {
				return false;
			}
		} else if (!this.noeud.equals(other.noeud)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Film [titre=" + getTitre() + "]";
	}
	
}
