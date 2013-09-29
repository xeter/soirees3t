package fr.soat.springdata.jpa.sdjpawebapp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.soat.springdata.jpa.sdjpawebapp.entite.Velo;

public interface VeloDao extends PagingAndSortingRepository<Velo, Long>{

}
