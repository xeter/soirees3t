package fr.soat.springdata.jpa.dao.personnalisees.supplementaire;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.dao.personnalisees.supplementaire.PersonneDaoPersonnaliseeRepository;
import fr.soat.springdata.jpa.entites.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager")
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonneDaoPersonnaliseeRepositoryTest {
	
	@Autowired
	private PersonneDaoPersonnaliseeRepository personneDaoPersonnaliseeRepository;
	private Personne personneSauvee;

	@Before
	public void setUp() {
//		personneDaoPersonnaliseeRepository.deleteAll();
//		this.personneSauvee = PersonneDataHelper.creePersonne();
//		personneDaoPersonnaliseeRepository.save(this.personneSauvee);
	}

	@Test
	public void test() {
//		List<Personne> personneList = 
//				personneDaoPersonnaliseeRepository.uneMethodePersonnaliseeDeRechercheParNom(this.personneSauvee.getNom());
//		Assert.assertEquals(1, personneList.size());
//		Assert.assertEquals(this.personneSauvee.getNom(), personneList.get(0).getNom());
	}

}
