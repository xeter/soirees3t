package fr.soat.springdata.sdrestws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import fr.soat.springdata.sdrestws.modele.Chanson;

@RestResource(path="chanson") //pour personnaliser un peu la façon dont le service web est appelé
public interface ChansonDao extends CrudRepository<Chanson, Long> {

}
