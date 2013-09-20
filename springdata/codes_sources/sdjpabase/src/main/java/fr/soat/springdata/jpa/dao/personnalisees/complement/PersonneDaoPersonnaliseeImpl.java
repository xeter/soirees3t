package fr.soat.springdata.jpa.dao.personnalisees.complement;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import fr.soat.springdata.jpa.entites.Personne;

public class PersonneDaoPersonnaliseeImpl implements PersonneDaoPersonnalisee {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> uneMethodePersonnaliseeDeRechercheParNom(String nom) {
		return entityManager.createQuery("from Personne p where p.nom = ?1").setParameter(1, nom).getResultList();
	}

}
