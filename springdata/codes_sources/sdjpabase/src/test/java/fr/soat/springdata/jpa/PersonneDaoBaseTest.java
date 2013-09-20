package fr.soat.springdata.jpa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.dao.personnalisees.base.PersonneDaoBase;
import fr.soat.springdata.jpa.entites.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager")
public class PersonneDaoBaseTest {
//	@Autowired
//	private PersonneDaoBase<Personne, Long> personneDaoBase;
	private Personne personneSauvee;

	@Before
	public void setUp() {
//		personneDaoBase.deleteAll();
//		this.personneSauvee = PersonneDataHelper.creePersonne();
//		personneDaoBase.save(this.personneSauvee);
	}

	@Test
	public void test() {
//		Personne personneTrouvee = 
//				personneDaoBase.uneMethodeDeRechercheCommuneATousLesDaoParId(this.personneSauvee.getId());
//		Assert.assertNotNull(personneTrouvee);
//		Assert.assertNotNull(personneTrouvee.getId());
//		Assert.assertEquals(this.personneSauvee.getId(), personneTrouvee.getId());
	}

}
