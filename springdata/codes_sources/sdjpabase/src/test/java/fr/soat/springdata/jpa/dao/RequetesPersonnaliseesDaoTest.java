package fr.soat.springdata.jpa.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import fr.soat.springdata.jpa.dao.RequetesPersonnaliseesDao;
import fr.soat.springdata.jpa.entites.Personne;
import fr.soat.springdata.jpa.helpers.PersonneDataHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager")
@ContextConfiguration("classpath:/applicationContext.xml")
public class RequetesPersonnaliseesDaoTest {
	
	@Autowired
	private RequetesPersonnaliseesDao requetesPersonnaliseesDao;
	private Personne personneSauvee;

	@Before
	public void setUp() {
		requetesPersonnaliseesDao.deleteAll();
		personneSauvee = PersonneDataHelper.creePersonne();
		requetesPersonnaliseesDao.save(personneSauvee);
	}
	
	@Test
	public void testFindByNom() {
		Personne personneTrouvee = requetesPersonnaliseesDao.findByNom(this.personneSauvee.getNom());
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());
	}
	
	@Test
	public void testFindByNomOrPrenom() {
		Personne personneTrouvee = requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom(), null);
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());
		
		personneTrouvee = requetesPersonnaliseesDao.findByNomOrPrenom(null, this.personneSauvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getPrenom(), personneTrouvee.getPrenom());
		
		personneTrouvee = requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom(), this.personneSauvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getPrenom(), personneTrouvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());
		
		personneTrouvee = requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom() + "aaa", null);
		Assert.assertEquals(null, personneTrouvee);
	}

	@Test
	public void testFindByVelo() {
		Personne personneTrouvee = requetesPersonnaliseesDao.findByVelo(this.personneSauvee.getVelo());
		Assert.assertEquals(this.personneSauvee.getVelo(), personneTrouvee.getVelo());
		System.out.println(personneTrouvee.getVelo());
	}
	
	@Test
	public void testFindByVeloAndNom() {
		Personne personneTrouvee = 
				requetesPersonnaliseesDao.findByVeloAndNom(this.personneSauvee.getVelo(), 
						this.personneSauvee.getNom());
		Assert.assertEquals(personneSauvee.getVelo(), personneTrouvee.getVelo());
		Assert.assertEquals(personneSauvee.getNom(), personneTrouvee.getNom());
		System.out.println(personneTrouvee.getVelo());
		System.out.println(personneTrouvee.getNom());
	}
	
	@Test
	public void testMaMethodeNommeeDeRechercheParNom() {
		Personne personneTrouvee = 
				requetesPersonnaliseesDao.maMethodeNommeeDeRechercheParNom(this.personneSauvee.getNom());
		Assert.assertEquals(personneSauvee, personneTrouvee);
	}
	
	@Test
	public void testMaRequêteAvecQueryDeRechercheParNomEtPrenom() {
		Personne personneTrouvee = 
				requetesPersonnaliseesDao.maRequêteAvecQueryDeRechercheParNomEtPrenom(this.personneSauvee.getNom(), 
						this.personneSauvee.getPrenom());
		Assert.assertEquals(personneSauvee, personneTrouvee);
	}
	
	@Test
	public void testMetAJourNom() {
		String nouveauNom = this.personneSauvee.getNom() + "aaa";
		requetesPersonnaliseesDao.save(new Personne());
		int nbPersonneModifiees = 
				requetesPersonnaliseesDao.metAJourNom(nouveauNom, 
						this.personneSauvee.getId());
		Assert.assertEquals(1, nbPersonneModifiees);
		Assert.assertEquals(2, requetesPersonnaliseesDao.count());
		Assert.assertEquals(nouveauNom, requetesPersonnaliseesDao.findOne(this.personneSauvee.getId()).getNom());
	}
}
