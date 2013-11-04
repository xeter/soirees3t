package fr.soat.springdata.proxy.proxylab.sd;

/**
 * Classe implémentant toutes les méthodes proposées par InterfaceB
 * (et par extension, InterfaceA). Vous noterez que cette classe n'est
 * jamais utilisée par Client.
 */
class ClasseNonAppeleeParClient implements InterfaceA, InterfaceB {

	public void bambiFaitDodo() {
		System.out.println("[ClasseNonAppeleeParClient.bambiFaitDodo] Chuut ! Y a Bambi qui fait dodo !");
	}

	public void atchoum() {
		System.out.println("[ClasseNonAppeleeParClient.atchoum] Tiens ! Salut Atchoum !");
	}

}
