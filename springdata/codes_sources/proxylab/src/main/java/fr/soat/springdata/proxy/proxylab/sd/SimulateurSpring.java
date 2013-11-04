package fr.soat.springdata.proxy.proxylab.sd;

import java.lang.reflect.Proxy;

import fr.soat.springdata.proxy.proxylab.Client;
import fr.soat.springdata.proxy.proxylab.dao.UnDao;

/**
 * Classe simulant le comportement de Spring. Elle s'occupe de
 * l'"injection de dépendance" dans le client donné en paramètre.
 * 
 * Vous noterez qu'on n'injecte pas exactement un objet implémentant
 * UnDao, mais un proxy. Vous le verrez bien en mettant un point
 * d'arrêt sur l'instruction client.setDao(dao).
 * 
 * @see Proxy
 */
public class SimulateurSpring {

	public void injecteDansClient(final Client client) {
		UnDao dao = (UnDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { UnDao.class },
				new ProxyInjecte());
		client.setDao(dao);
	}
}
