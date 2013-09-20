package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class DaoCommunAuxAutresDaoFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
extends JpaRepositoryFactoryBean<R, T, I> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
		return new DaoCommunAuxAutresDaoFactory<T, I>(entityManager);
	}

	private static class DaoCommunAuxAutresDaoFactory<T, I extends Serializable> extends JpaRepositoryFactory {

		private EntityManager entityManager;

		public DaoCommunAuxAutresDaoFactory(final EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@Override
		@SuppressWarnings("unchecked")
		protected Object getTargetRepository(final RepositoryMetadata metadata) {
			return new DaoCommunAuxAutresDaoImpl<T, I>((Class<T>) metadata.getDomainType(), this.entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {
			/*
			 * On peut ignorer metadata qui sert à JpaRepositoryFactory
			 */
			return DaoCommunAuxAutresDao.class;
		}
	}
}

