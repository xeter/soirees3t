package fr.soat.springdata.jpa.dao.personnalisees.tous;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.entites.Personne;
import fr.soat.springdata.jpa.helpers.PersonneDataHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_daoCommun.xml")
@TransactionConfiguration(transactionManager="transactionManager")
public class PersonneDaoPersonnaliseeBaseImplTest {
	@Autowired
	private AutrePersonneDao autrePersonneDao;
	private Personne personneSauvee;

	@Before
	public void setUp() {
		this.autrePersonneDao.deleteAll();
		this.personneSauvee = PersonneDataHelper.creePersonne();
		this.autrePersonneDao.save(this.personneSauvee);
	}

	@Test
	public void test() {
		List<Personne> personnesTrouvees =
				this.autrePersonneDao.uneMethodeDeRechercheCommuneATousLesDaoParLExemple(this.personneSauvee);
		Assert.assertNotNull(personnesTrouvees);
		Assert.assertTrue(personnesTrouvees.size() == 1);
		Assert.assertNotNull(personnesTrouvees.get(0).getId());
		Assert.assertEquals(this.personneSauvee.getId(), personnesTrouvees.get(0).getId());
	}

}
