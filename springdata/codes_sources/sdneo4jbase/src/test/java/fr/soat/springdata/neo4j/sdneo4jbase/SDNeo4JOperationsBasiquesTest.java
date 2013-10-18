package fr.soat.springdata.neo4j.sdneo4jbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.soat.springdata.neo4j.sdneo4jbase.dao.FilmDao;
import fr.soat.springdata.neo4j.sdneo4jbase.modele.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SDNeo4JOperationsBasiquesTest {

	@Autowired
	private FilmDao dao;

	@Test
	public void test() {
		sauvegardeFilm("Strays");
		sauvegardeFilm("Il faut sauver le soldat Ryan");
		sauvegardeFilm("Les Initiés");
		final EndResult<Film> filmsTrouves = this.dao.findAll();
		for (Film film : filmsTrouves) {
			System.out.println(film.getTitre());
		}
	}

	private void sauvegardeFilm(final String titreFilm) {
		Film film = new Film();
		film.setTitre(titreFilm);
		this.dao.save(film);
	}
}
