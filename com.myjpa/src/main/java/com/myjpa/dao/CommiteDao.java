package com.myjpa.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.myjpa.model.Commite;



 
public interface CommiteDao {
 
    void saveCommite(Commite commite);
     
    List<Commite> findAllCommites();
     
    void deleteCommiteBySsn(String ssn);
     void deletefromCache(Commite id);
    Commite findBySsn(String ssn);
     
    void updateCommite(Commite commite);
    Commite getCommiteById(long id);
    SessionFactory  getMySessionFactory();
}