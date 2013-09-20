package fr.soat.springdata.jpa.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import fr.soat.springdata.jpa.entites.Personne;

public class PersonneSpecifications {
	public static Specification<Personne> nomSuperieurAB() {
		return new Specification<Personne>() {

			@Override
			public Predicate toPredicate(Root<Personne> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder builder) {
				return builder.equal(root.get("nom").as(Personne.class), "aaa");
			}
			
		};
	}

}
