package fr.soat.springdata.jpa.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Personne.maMethodeNommeeDeRechercheParNom",
			query="select p from Personne p where p.nom=?1")
public class Personne {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@OneToOne(
			cascade=CascadeType.PERSIST,
			fetch = FetchType.EAGER
			)
	private Velo velo;


	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public Velo getVelo() {
		return velo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setVelo(Velo velo) {
		this.velo = velo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((velo == null) ? 0 : velo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (velo == null) {
			if (other.velo != null)
				return false;
		} else if (!velo.equals(other.velo))
			return false;
		return true;
	}
}
