/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author alfonso
 */
public class DbManager {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private DbManager() {
    }

    static {
        emf = Persistence.createEntityManagerFactory("pu");
    }

    public static EntityManager getEm() {
        if (em != null && em.isOpen()) {
            return em;
        }
        em = emf.createEntityManager();
        return em;
    }

    public static void closeEm() {
        if (em == null || !em.isOpen()) {
            return;
        }
        em.close();

    }

}
