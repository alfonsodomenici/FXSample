/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx.services;

import it.ad.learning.tqtarademofx.entity.Apparecchiature;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alfonso
 */
public class DbService {

    private static EntityManager em;

    public static void salva(Apparecchiature ap) {
        em.getTransaction().begin();
        em.merge(ap);
        em.getTransaction().commit();
    }

    private DbService() {
    }

    static {
        em = DbManager.getEm();
    }

    public static List<Apparecchiature> findAll() {
        return em.createNamedQuery(Apparecchiature.FIND_ALL)
                .getResultList();
    }

    public static void elimina(Apparecchiature ap) {

        if (!exists(ap)) {
            throw new IllegalArgumentException("L'apparecchiatura non esiste");
        }

        em.getTransaction().begin();
        em.remove(ap);
        em.getTransaction().commit();

    }

    public static boolean exists(Apparecchiature ap) {
        return em.createQuery("select e from Apparecchiature e where e.id= :id ")
                .setParameter("id", ap.getId())
                .getResultList().size() == 1;
    }
}
