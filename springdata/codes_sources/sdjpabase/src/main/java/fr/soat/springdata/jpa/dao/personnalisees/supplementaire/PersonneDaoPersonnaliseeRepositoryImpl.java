package fr.soat.springdata.jpa.dao.personnalisees.supplementaire;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.soat.springdata.jpa.entites.Personne;

public class PersonneDaoPersonnaliseeRepositoryImpl implements PersonneDaoAvecMethodePersonnalisee {

	@PersistenceContext
	private EntityManager entityManager;

//   @PersistenceUnit //en cas d'accès concurrents à l'EntityManager
//   private EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> uneMethodePersonnaliseeDeRechercheParNom(String nom) {
		return this.entityManager.createQuery("from Personne p where p.nom = ?1").setParameter(1, nom).getResultList();
//		EntityManager entityManager = emf.createEntityManager(); //en cas d'accès concurrents à l'EntityManager
//		return entityManager.createQuery("from Personne p where p.nom = ?1").setParameter(1, nom).getResultList();
	}

}
