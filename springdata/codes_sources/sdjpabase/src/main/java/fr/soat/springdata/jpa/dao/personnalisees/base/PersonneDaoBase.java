package fr.soat.springdata.jpa.dao.personnalisees.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonneDaoBase<T, ID extends Serializable> extends JpaRepository<T, ID>{
	public Personne uneMethodeDeRechercheCommuneATousLesDaoParId(Long id);
}
