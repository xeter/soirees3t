package fr.soat.springdata.neo4j.sdneo4j.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Neo4jTest {

	@Autowired
	private Neo4jOperations template;

	@Test
	public void test() {

	}

	//	@Test
	//	@Transactional
	//	public void sauvegardeEtChargementDeFilm() {
	//		Film filmSauvegarde = this.template.save(new Film("Rapide et pas content"));
	//		Film filmTrouve = this.template.findOne(filmSauvegarde.getIdNoeud(), Film.class);
	//
	//		Assert.assertEquals(filmSauvegarde.getTitre(), filmTrouve.getTitre());
	//	}
}
