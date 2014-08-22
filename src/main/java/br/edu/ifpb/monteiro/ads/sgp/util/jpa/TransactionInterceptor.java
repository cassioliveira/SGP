/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.sgp.util.jpa;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author WitaloCarlos
 */
@Priority(Interceptor.Priority.APPLICATION)
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger log = LogManager.getLogger(TransactionInterceptor.class);

    private @Inject
    EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = manager.getTransaction();
        boolean owner = false;

        try {
            if (!transaction.isActive()) {
				// truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem
                // transação)
                transaction.begin();
                log.info("Transação Iniciada");
                transaction.rollback();
                log.info("Rollback intencional");

                transaction.begin();
                log.info("Transação Reiniciada");

                owner = true;
            }

            return context.proceed();
        } catch (Exception e) {
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
