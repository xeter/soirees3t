package fr.soat.springdata.jpa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.dao.PersonneDao;
import fr.soat.springdata.jpa.entites.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataJPATest {
	
	@Autowired
	private PersonneDao personneDao;
	
	@Before
	public void setup() {
		personneDao.deleteAll();
	}

	@Test
	public void testSave() {
		Personne personne = PersonneDataHelper.creePersonne();

		Personne personneSauvee = personneDao.save(personne);
		Assert.assertNotNull(personneSauvee);
		Assert.assertEquals(personne.getNom(), personneSauvee.getNom());
		Assert.assertEquals(personne.getPrenom(), personneSauvee.getPrenom());
	}
	
	@Test
	public void testCrudDao() {
		Personne personne = PersonneDataHelper.creePersonne();

		Personne personneSauvee = personneDao.save(personne);
		Assert.assertNotNull(personneSauvee);
		Assert.assertEquals(personne.getNom(), personneSauvee.getNom());
		Assert.assertEquals(personne.getPrenom(), personneSauvee.getPrenom());
		Assert.assertEquals(1, personneDao.count());
		Assert.assertEquals(true, personneDao.exists(personneSauvee.getId()));
		for (Personne personneDeLaListe : personneDao.findAll()) {
			Assert.assertEquals(personneSauvee.getNom(), personneDeLaListe.getNom());
		}
		Personne personneTrouvee = personneDao.findOne(personneSauvee.getId());
		Assert.assertEquals(personneSauvee.getId(), personneTrouvee.getId());
		Assert.assertEquals(personneSauvee.getNom(), personneTrouvee.getNom());
		personneDao.delete(personneSauvee);
		Assert.assertEquals(0, personneDao.count());
	}

}
