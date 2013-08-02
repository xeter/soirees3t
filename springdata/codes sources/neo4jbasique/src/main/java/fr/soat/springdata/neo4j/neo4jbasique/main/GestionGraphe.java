package fr.soat.springdata.neo4j.neo4jbasique.main;

import static fr.soat.springdata.neo4j.neo4jbasique.graphe.JoueDansRelationEnum.JOUE_DANS;

import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.Traversal;

import fr.soat.springdata.neo4j.neo4jbasique.entite.Film;

public class GestionGraphe {

	private GraphDatabaseService graphDb;
	private Node acteur;
	private ExecutionEngine engine;

	public GestionGraphe(GraphDatabaseService graphDb) {
		this.graphDb = graphDb;
		this.engine = new ExecutionEngine(this.graphDb);
	}

	public void creeGraphe() {
		Transaction tx = this.graphDb.beginTx();

		try {
			this.acteur = this.graphDb.createNode();
			this.acteur.setProperty("nom", "Diesel");
			this.acteur.setProperty("prenom", "Vin");

			Node noeudFilm = this.graphDb.createNode();
			noeudFilm.setProperty(Film.TITRE, "Rapide et pas content");
			this.acteur.createRelationshipTo(noeudFilm, JOUE_DANS);

			noeudFilm = this.graphDb.createNode();
			noeudFilm.setProperty(Film.TITRE, "Trop rapide et trop pas content");
			this.acteur.createRelationshipTo(noeudFilm, JOUE_DANS);
			
			Film film = new Film(this.graphDb.createNode());
			film.setTitre("Il faut sauver le soldat Ryan");
			this.acteur.createRelationshipTo(film.getNoeud(), JOUE_DANS);

			tx.success();
		} finally {
			tx.finish();
		}
	}


	public void afficheGraphe() {
		Traverser traverseurDeFilms = getTraverseursFilms();
		for (Path path : traverseurDeFilms) {
			if (path.length() == 0) {
				System.out.println(path.endNode().getProperty("prenom") + 
						" " +
						path.endNode().getProperty("nom") +
						" a joué dans les films suivants :");
			} else {
				System.out.println(path.endNode().getProperty(Film.TITRE));
			}
		}

		System.out.println("Autre façon d'afficher le graphe :");
		for (Relationship film: this.acteur.getRelationships()) {
			System.out.println(film.getEndNode().getProperty(Film.TITRE));
		}
	}

	private Traverser getTraverseursFilms() {
		TraversalDescription td = 
				Traversal.description().
				breadthFirst().
				relationships(JOUE_DANS).
				evaluator(Evaluators.all());
		return td.traverse(this.acteur);
	}

	public void exempleCypher() {
		System.out.println("Un exemple d'utilisation de Cyper, le langage de requêtage de Neo4j :");
		String requete = 
				"start n=node("+this.acteur.getId()+") " +
						"match n-[:JOUE_DANS]->films " +
						"where films." + Film.TITRE + " =~ 'Trop.*' " +
						"return n, n.nom, n.prenom, films." + Film.TITRE;
		ExecutionResult result = this.engine.execute(requete);
		
		String rows = "";
		for ( Map<String, Object> row : result) {
			for ( Entry<String, Object> column : row.entrySet() ) {
				rows += column.getKey() + ": " + column.getValue() + "; ";
			}
			rows += "\n";
		}
		System.out.println(rows);
	}
}
