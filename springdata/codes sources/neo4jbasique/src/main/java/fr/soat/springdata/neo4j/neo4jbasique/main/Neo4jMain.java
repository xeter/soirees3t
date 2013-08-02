package fr.soat.springdata.neo4j.neo4jbasique.main;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4jMain {
	private final static String DB_PATH = "bdd_neo4j";
	
	public static void main(String[] args) {
		GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
		registerShutdownHook(graphDb);
		GestionGraphe cr = new GestionGraphe(graphDb);
		cr.creeGraphe();
		cr.afficheGraphe();
		cr.exempleCypher();
		System.out.println("Terminé");
	}

	private static void registerShutdownHook(final GraphDatabaseService graphDb) {
		/*
		 * Pour que Neo4j s'arrête correctement, même en cas de Ctrl-C
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		} );
	}
}
