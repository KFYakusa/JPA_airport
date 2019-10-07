package br.edu.ifsul.testes.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Voo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author danie
 */
public class TestePersistAeroportoVoo {

    public TestePersistAeroportoVoo() {
    }

    EntityManagerFactory emf = null;
    EntityManager em = null;

    @Before
    public void setUp() {  // executa antes de iniciar o teste
        emf = Persistence.createEntityManagerFactory("aeroPersist");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() { // finalizar conexao com o banco e tudo mais que acontece após o teste
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Aeroporto a = em.find(Aeroporto.class, 22);
            Voo v = em.find(Voo.class,13);
            
            v.getEscalas().add(a);
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
