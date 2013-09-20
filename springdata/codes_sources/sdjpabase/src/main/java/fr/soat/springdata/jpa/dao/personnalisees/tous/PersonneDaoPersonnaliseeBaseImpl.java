package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import fr.soat.springdata.jpa.entites.Personne;
public class PersonneDaoPersonnaliseeBaseImpl{}
//public class PersonneDaoBaseImpl<T, ID extends Serializable> extends
//		SimpleJpaRepository<T, ID> implements PersonneDaoBase<T, ID> {
//	private EntityManager entityManager;
//
//	public PersonneDaoBaseImpl(Class<T> domainClass, EntityManager entityManager) {
//		super(domainClass, entityManager);
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public Personne uneMethodeDeRechercheCommuneATousLesDaoParId(Long id) {
//		return (Personne) entityManager.
//				createQuery("from Personne p where p.id = ?1").
//				setParameter(1, id).
//				getSingleResult();
//	}
//}
