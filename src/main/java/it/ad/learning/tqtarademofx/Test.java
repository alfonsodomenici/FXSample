/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx;

import it.ad.learning.tqtarademofx.entity.Apparecchiature;
import it.ad.learning.tqtarademofx.services.DbManager;
import it.ad.learning.tqtarademofx.services.DbService;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author alfonso
 */
public class Test {
    public static void main(String[] args) {
        
        EntityManager em = DbManager.getEm();
        
        List<Apparecchiature> resultList = 
                em.createQuery("select e from Apparecchiature e where e.id < 10", 
                Apparecchiature.class)
                .getResultList();
        resultList.forEach(System.out::println);
        System.exit(0);
    }
}
