package com.prs.hibernateonetoone.dao;

import com.prs.hibernateonetoone.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class TestDao {

    public static final Logger log = LoggerFactory.getLogger(TestDao.class);
    @PersistenceContext
    private EntityManager em;
    public boolean saveData(Transaction txn){
        try {
            em.persist(txn);
            return true;
        }
        catch (Exception ex){
        log.debug(ex.getMessage());
        return false;
        }
    }
}
