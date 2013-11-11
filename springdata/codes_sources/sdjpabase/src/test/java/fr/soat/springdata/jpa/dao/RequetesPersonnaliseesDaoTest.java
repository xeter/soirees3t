package fr.soat.springdata.jpa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
		this.requetesPersonnaliseesDao.deleteAll();
		this.personneSauvee = PersonneDataHelper.creePersonne();
		this.requetesPersonnaliseesDao.save(this.personneSauvee);
	}

	@Test
	public void testFindByNom() {
		Personne personneTrouvee = this.requetesPersonnaliseesDao.findByNom(this.personneSauvee.getNom());
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());
	}

	@Test
	public void testFindByNomOrPrenom() {
		Personne personneTrouvee = this.requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom(), null);
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());

		personneTrouvee = this.requetesPersonnaliseesDao.findByNomOrPrenom(null, this.personneSauvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getPrenom(), personneTrouvee.getPrenom());

		personneTrouvee = this.requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom(), this.personneSauvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getPrenom(), personneTrouvee.getPrenom());
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());

		personneTrouvee = this.requetesPersonnaliseesDao.findByNomOrPrenom(this.personneSauvee.getNom() + "aaa", null);
		Assert.assertEquals(null, personneTrouvee);
	}

	@Test
	public void testFindByVelo() {
		Personne personneTrouvee = this.requetesPersonnaliseesDao.findByVelo(this.personneSauvee.getVelo());
		Assert.assertEquals(this.personneSauvee.getVelo(), personneTrouvee.getVelo());
		System.out.println(personneTrouvee.getVelo());
	}

	@Test
	public void testFindByVeloAndNom() {
		Personne personneTrouvee =
				this.requetesPersonnaliseesDao.findByVeloAndNom(this.personneSauvee.getVelo(),
						this.personneSauvee.getNom());
		Assert.assertEquals(this.personneSauvee.getVelo(), personneTrouvee.getVelo());
		Assert.assertEquals(this.personneSauvee.getNom(), personneTrouvee.getNom());
		System.out.println(personneTrouvee.getVelo());
		System.out.println(personneTrouvee.getNom());
	}

	@Test
	public void testMaMethodeNommeeDeRechercheParNom() {
		Personne personneTrouvee =
				this.requetesPersonnaliseesDao.maMethodeNommeeDeRechercheParNom(this.personneSauvee.getNom());
		Assert.assertEquals(this.personneSauvee, personneTrouvee);
	}

	@Test
	public void testMaRequêteAvecQueryDeRechercheParNomEtPrenom() {
		Personne personneTrouvee =
				this.requetesPersonnaliseesDao.maRequêteAvecQueryDeRechercheParNomEtPrenom(this.personneSauvee.getNom(),
						this.personneSauvee.getPrenom());
		Assert.assertEquals(this.personneSauvee, personneTrouvee);
	}

	@Test
	public void testMetAJourNom() {
		String nouveauNom = this.personneSauvee.getNom() + "aaa";
		this.requetesPersonnaliseesDao.save(new Personne());
		int nbPersonneModifiees =
				this.requetesPersonnaliseesDao.metAJourNom(nouveauNom,
						this.personneSauvee.getId());
		Assert.assertEquals(1, nbPersonneModifiees);
		Assert.assertEquals(2, this.requetesPersonnaliseesDao.count());
		Assert.assertEquals(nouveauNom, this.requetesPersonnaliseesDao.findOne(this.personneSauvee.getId()).getNom());
	}

	@Test
	public void testRecuperationParNomEtTri() {
		String baseNom = "aaa";
		for (int i = 0; i < 4; i++) {
			Personne p = new Personne();
			p.setNom(baseNom + i);
			this.requetesPersonnaliseesDao.save(p);
		}
		final List<Personne> listePersonnes = this.requetesPersonnaliseesDao.findByNomStartingWith(baseNom, new Sort(Direction.DESC, "nom"));
		int i = 3;
		for (Personne personne : listePersonnes) {
			System.out.println(personne.getNom());
			Assert.assertEquals(baseNom + i, personne.getNom());
			i--;
		}
	}
}
