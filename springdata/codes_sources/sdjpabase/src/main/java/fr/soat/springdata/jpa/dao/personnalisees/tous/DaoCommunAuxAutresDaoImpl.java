package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class DaoCommunAuxAutresDaoImpl<T, ID extends Serializable>
extends SimpleJpaRepository<T, ID>
implements DaoCommunAuxAutresDao<T, ID> {

	private EntityManager entityManager;

	public DaoCommunAuxAutresDaoImpl(final Class<T> domainClass, final EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> uneMethodeDeRechercheCommuneATousLesDaoParLExemple(final T exemple) {
		Session session = (Session) this.entityManager.getDelegate();
		Example hibernateExample = Example.create(exemple).ignoreCase().enableLike(MatchMode.ANYWHERE);
		Criteria criteria = session.createCriteria(exemple.getClass()).add(hibernateExample);
		return criteria.list();
	}
}
