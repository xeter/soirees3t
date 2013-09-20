package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoPersonnaliseeBase<T, ID extends Serializable> extends JpaRepository<T, ID>{
	public Personne uneMethodeDeRechercheCommuneATousLesDaoParId(Long id);
}
