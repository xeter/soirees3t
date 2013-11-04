package fr.soat.springdata.proxy.proxylab.dao;

import fr.soat.springdata.proxy.proxylab.sd.InterfaceA;

/**
 * Interface utilisée par Client. Quand UnDao étend InterfaceA, le
 * client pourra appeler atchoum(). Mais si UnDao étend InterfaceB,
 * le client pourra appeler atchoum() ET bambiFaitDodo().
 */
public interface UnDao extends InterfaceA {

}
