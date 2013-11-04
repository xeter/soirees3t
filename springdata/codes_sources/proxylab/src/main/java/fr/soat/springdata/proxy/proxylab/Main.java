package fr.soat.springdata.proxy.proxylab;

import fr.soat.springdata.proxy.proxylab.Client;
import fr.soat.springdata.proxy.proxylab.sd.SimulateurSpring;

/**
 * Classe principale. S'occupe d'orchestrer l'"injection de dépendance" et
 * l'appel au dao via le client.
 */
public class Main {

	public static void main(final String[] args) {
		// Initialisation
		Client client = new Client();
		SimulateurSpring simulateurSpring = new SimulateurSpring();
		simulateurSpring.injecteDansClient(client);

		// Appel
		client.appelleUnDao();
	}
}
