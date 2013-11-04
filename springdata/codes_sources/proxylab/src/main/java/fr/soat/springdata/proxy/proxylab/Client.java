package fr.soat.springdata.proxy.proxylab;

import fr.soat.springdata.proxy.proxylab.dao.UnDao;

/**
 * Classe cliente du dao de type UnDao. SimulteurSpring y "injectera" un
 * UnDao. Ensuite, cette classe étant prête, Main appellera appelleUnDao().
 */
public class Client {

	private UnDao dao;

	/**
	 * Définit le "dao" de cette classe. Sert à faire de l'"injection de
	 * dépendance".
	 * 
	 * @param dao
	 */
	public void setDao(final UnDao dao) {
		this.dao = dao;
	}

	/**
	 * Appelle la ou les méthodes de dao. Vous noterez que si UnDao étend
	 * InterfaceB, vous pourrez appeler bambiFaitDodo().
	 */
	public void appelleUnDao() {
		this.dao.atchoum();
	}
}
