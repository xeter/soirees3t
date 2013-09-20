package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DaoCommunAuxAutresDao<T, ID extends Serializable> extends JpaRepository<T, ID>{
	
	List<T> uneMethodeDeRechercheCommuneATousLesDaoParLExemple(T exemple);
}
