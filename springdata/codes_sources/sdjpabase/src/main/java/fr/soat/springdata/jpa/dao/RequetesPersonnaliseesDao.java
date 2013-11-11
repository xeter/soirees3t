package fr.soat.springdata.jpa.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.soat.springdata.jpa.entites.Personne;
import fr.soat.springdata.jpa.entites.Velo;

@Transactional(readOnly=true) //readOnly = true : La plupart des méthodes ici ne sont qu'en lecture seule
public interface RequetesPersonnaliseesDao extends CrudRepository<Personne, Long> {
	public Personne findByNom(String nom);

	public Personne findByNomOrPrenom(String nom, String prenom);

	public Personne findByVelo(Velo velo);

	public Personne findByVeloAndNom(Velo velo, String nom);

	public List<Personne> findByNomStartingWith(String nom, Sort ordreTri);

	public Personne maMethodeNommeeDeRechercheParNom(String nom);

	@Query("from Personne p where p.nom = ?1 and p.prenom = ?2") // on peut nommer les paramètres avec @Param
	public Personne maRequêteAvecQueryDeRechercheParNomEtPrenom(String nom, String prenom);

	@Query("update Personne p set p.nom = :nom where p.id = :id")
	@Modifying //rend obsolète le readOnly=true dans l'annotation de la classe
	public int metAJourNom(@Param("nom")String nom, @Param("id") Long id);
}
