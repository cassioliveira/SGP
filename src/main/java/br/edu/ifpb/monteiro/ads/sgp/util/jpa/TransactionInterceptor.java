/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.util.jpa;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 *
 * @author WitaloCarlos
 */
@Priority(Interceptor.Priority.APPLICATION)
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getGlobal();

    private @Inject
    EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        logger.info("Método Transação");
        EntityTransaction transaction = manager.getTransaction();
        boolean owner = false;

        try {
            
            if (!transaction.isActive()) {
                logger.info("Começando Transação");
				// truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem
                // transação)
                transaction.begin();
                logger.info("Transação Iniciada");
                transaction.rollback();
                logger.info("Rollback intencional");

                transaction.begin();
                logger.info("Transação Reiniciada");

                owner = true;
            }

            return context.proceed();
        } catch (Exception e) {
            logger.info("Transação Interrompida");
            if (transaction != null && owner) {
                System.out.println("catch Rollback ");
                transaction.rollback();

            }

            throw e;
        } finally {
            if (transaction != null && transaction.isActive() && owner) {
                transaction.commit();
                System.out.println("Operação Comitada");
            }
        }
    }

}
