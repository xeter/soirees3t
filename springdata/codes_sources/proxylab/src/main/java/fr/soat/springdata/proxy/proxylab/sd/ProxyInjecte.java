package fr.soat.springdata.proxy.proxylab.sd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy qui sera injecté dans le client. Ici, on se contente de relayer
 * l'appel aux méthodes de UnDao (ici implémentées par {@link
 * ClasseNonAppeleeParClient}.
 * 
 * Néanmoins, on peut effectuer des opérations autour de la méthode
 * appelée. Ce qui se rapproche trèèès fortement de l'AOP ;).
 */
class ProxyInjecte implements InvocationHandler {
	private ClasseNonAppeleeParClient classeNonAppeleeParClient = new ClasseNonAppeleeParClient();

	public Object invoke(final Object proxy, final Method method, final Object[] args)
			throws Throwable {

		System.out.println("[ProxyInjecte.invoke] On est dans le proxy et on va appeler la méthode qu'il faut...");

		if (method.getName().equals("bambiFaitDodo")) {
			this.classeNonAppeleeParClient.bambiFaitDodo();
		} else if (method.getName().equals("atchoum")) {
			this.classeNonAppeleeParClient.atchoum();
		} else {
			System.out.println("[ProxyInjecte.invoke] methode inconnue");
		}

		System.out.println("[ProxyInjecte.invoke] On quitte le proxy");
		/*
		 * Ci-après, on aurait pu renvoyer le retour de la méthode appelée
		 * Comme on est fainéants, on a fait en sorte que les méthodes
		 * appelées ne retournent rien.
		 */
		return null;
	}

}
