package br.edu.ifsul.testes.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
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
 * @Projeto: aeroporto_de_mosquitos
 */
public class TestePersistPassagem {

    public TestePersistPassagem() {
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
            Classe c = em.find(Classe.class, 21);
            Pessoa p = em.find(Pessoa.class, 17);
            VooAgendado v = em.find(VooAgendado.class, 13);
            
            Passagem pas = new Passagem();
            pas.setClasse(c);
            pas.setPessoa(p);
            pas.setDataCompra(Calendar.getInstance());
            
            
            pas.setVooAgendado(v);
            em.getTransaction().begin();
            em.persist(pas);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
