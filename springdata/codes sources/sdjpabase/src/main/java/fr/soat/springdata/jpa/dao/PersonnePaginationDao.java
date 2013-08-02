package fr.soat.springdata.jpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.soat.springdata.jpa.entites.Personne;

public interface PersonnePaginationDao extends PagingAndSortingRepository<Personne, Long>{

}
