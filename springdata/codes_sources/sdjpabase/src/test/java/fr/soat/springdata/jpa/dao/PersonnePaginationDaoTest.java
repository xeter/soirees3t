package fr.soat.springdata.jpa.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.dao.PersonnePaginationDao;
import fr.soat.springdata.jpa.entites.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager")
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonnePaginationDaoTest {

	private static final String NOM = "nom_";
	private static final String PRENOM = "prenom_";
	@Autowired
	private PersonnePaginationDao personnePaginationDao;

	@Before
	public void creePleinDePersonnes() {
		personnePaginationDao.deleteAll();
		for (int i = 0; i < 10; i++) {
			Personne personne = new Personne();
			personne.setNom(NOM + i);
			personne.setPrenom(PRENOM + i);
			personnePaginationDao.save(personne);
		}
	}

	@Test
	public void testTriDesc() {
		Assert.assertEquals(10, personnePaginationDao.count());
		Iterable<Personne> personnesTrouvees = personnePaginationDao.findAll(new Sort(Sort.Direction.DESC, "nom"));
		int i = 9;
		for (Personne personne : personnesTrouvees) {
			System.out.println(personne.getNom());
			Assert.assertEquals(NOM + i, personne.getNom());
			i--;
		}
	}

	@Test
	public void testTriAsc() {
		String [] nomsAttendus = {"nom_0", 
				"nom_1", 
				"nom_2", 
				"nom_3", 
				"nom_4", 
				"nom_5", 
				"nom_6", 
				"nom_7", 
				"nom_8", 
		"nom_9"};
		Assert.assertEquals(nomsAttendus.length, personnePaginationDao.count());
		Iterable<Personne> personnesTrouvees = personnePaginationDao.findAll(new Sort(Sort.Direction.ASC, "nom"));
		int i = 0;
		for (Personne personne : personnesTrouvees) {
			System.out.println(personne.getNom());
			Assert.assertEquals(nomsAttendus[i], personne.getNom());
			i++;
		}
	}

	@Test
	public void testPagination() {
		Assert.assertEquals(10, personnePaginationDao.count());
		Page<Personne> personnes = personnePaginationDao.findAll(new PageRequest(1, 3));
		Assert.assertEquals(1, personnes.getNumber());
		Assert.assertEquals(3, personnes.getSize());           // la taille de la pagination
		Assert.assertEquals(10, personnes.getTotalElements()); //le nombre total d'éléments récupérables
		Assert.assertEquals(4, personnes.getTotalPages());     // nombre de pages
		personnePaginationDao.findAll();
		Assert.assertTrue(personnes.hasContent());
		int i = 3;
		for (Personne personne : personnes) {
			System.out.println(personne.getNom());
			Assert.assertEquals(NOM + i, personne.getNom());
			i++;
		}
	}
}
