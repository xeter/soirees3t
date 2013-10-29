package fr.soat.springdata.neo4j.sdneo4jbase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.kernel.Traversal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.soat.springdata.neo4j.sdneo4jbase.dao.ActeurDao;
import fr.soat.springdata.neo4j.sdneo4jbase.dao.FilmDao;
import fr.soat.springdata.neo4j.sdneo4jbase.modele.Acteur;
import fr.soat.springdata.neo4j.sdneo4jbase.modele.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SDNeo4JOperationsBasiquesTest {

	@Autowired
	private FilmDao filmDao;

	@Autowired
	private ActeurDao acteurDao;

	private Long identifiantVinDiesel;

	@Before
	public void setup() {
		this.filmDao.deleteAll();
		this.acteurDao.deleteAll();

		Acteur vinDiesel = new Acteur();
		vinDiesel.setNom("Diesel");
		vinDiesel.setPrenom("Vin");

		vinDiesel.aJoueDans(leFilm("Strays"));
		vinDiesel.aJoueDans(leFilm("Il faut sauver le soldat Ryan"));
		vinDiesel.aJoueDans(leFilm("Les Initiés"));

		final Film multiFacial = leFilm("Multi-Facial");
		this.filmDao.save(multiFacial);
		vinDiesel.aRealise(multiFacial).en(1994);

		this.acteurDao.save(vinDiesel);

		this.identifiantVinDiesel = vinDiesel.getIdNoeud();

		System.out.println("");
	}

	@Test
	public void testFindAll() {

		System.out.println("On récupère tous les films :");
		final EndResult<Film> filmsTrouves = this.filmDao.findAll();
		for (Film film : filmsTrouves) {
			System.out.println(film.getTitre());
		}
	}

	@Test
	public void testFindAllByPropertyValue() {

		System.out.println("On récupère tous les films dont le titre est \"Strays\" :");
		final EndResult<Film> filmsTrouves = this.filmDao.findAllByPropertyValue("titre", "Strays");
		for (Film film : filmsTrouves) {
			System.out.println(film.getTitre());
		}
	}

	@Test
	public void testFindByPropertyValue() {

		System.out.println("On récupère le film dont le titre est \"Les Initiés\" :");
		final Film filmTrouve = this.filmDao.findByPropertyValue("titre", "Les Initiés");
		System.out.println(filmTrouve.getTitre());
	}

	@Test
	public void testAffichageFilmsJoues() {
		final Acteur vinDiesel = this.acteurDao.findOne(this.identifiantVinDiesel);
		System.out.println(vinDiesel + " a joué dans les films suivants (on teste la recherche avec un algorithme de parcours) :");
		TraversalDescription traversalDescription = Traversal.description().breadthFirst().evaluator(Evaluators.atDepth(1));
		final Iterable<Film> filmsJouesParVinDiesel = this.filmDao.findAllByTraversal(vinDiesel, traversalDescription);
		for (Film film : filmsJouesParVinDiesel) {
			System.out.println(film.getTitre());
		}
	}

	/**
	 * Test des méthodes-requêtes ("query methods")
	 */
	@Test
	public void testMethodesRequetes() {
		System.out.println("Films trouvés contenant le mot \"Il\" :");
		final Iterable<Film> filmsTrouves = this.filmDao.findByTitreContaining("Il");
		for (Film film : filmsTrouves) {
			System.out.println(film.getTitre());
		}
	}

	/**
	 * Test de l'annotation @Query dans les entités-relation
	 */
	@Test
	public void testAnnotationQueryDansDao() {
		System.out.println("Tous les films réalisés par Vin Diesel :");
		final Acteur vinDiesel = this.acteurDao.findOne(this.identifiantVinDiesel);
		final Iterable<Film> filmsTrouves = this.acteurDao.recupereMoiTousLesFilmsRealisesPar(vinDiesel);
		for (Film film : filmsTrouves) {
			System.out.println(film.getTitre());
		}
	}

	private Film leFilm(final String titreFilm) {
		Film film = new Film();
		film.setTitre(titreFilm);
		return film;
	}
}
