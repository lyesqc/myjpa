package com.myjpa.services;



import java.util.List;

import org.hibernate.SessionFactory;

import com.myjpa.model.Commite;


 
public interface CommiteService {
	
 
    void saveCommite(Commite commite);
 
    List<Commite> findAllCommites();
 
    void deleteCommiteBySsn(String ssn);
 
    Commite findBySsn(String ssn);
    Commite getCommiteById(long id);
    void deleteFromCache(Commite comite);
 
    void updateCommite(Commite commite);
    SessionFactory mySessionFact();
}