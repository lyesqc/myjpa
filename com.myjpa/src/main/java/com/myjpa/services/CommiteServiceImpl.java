package com.myjpa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjpa.dao.CommiteDao;
import com.myjpa.model.Commite;

@Service("comiteService")
@Transactional
public class CommiteServiceImpl implements CommiteService{

	@Autowired
	CommiteDao dao;
	
	public int i = 2;

	public void saveCommite(Commite commite) {
		// TODO Auto-generated method stub
		dao.saveCommite(commite);
		
	}

	public List<Commite> findAllCommites() {
		// TODO Auto-generated method stub
		 ;
		
		System.out.println("i is : "+i++ );
		return dao.findAllCommites();
	}

	public void deleteCommiteBySsn(String ssn) {
		// TODO Auto-generated method stub
		dao.deleteCommiteBySsn(ssn);
	}

	public Commite findBySsn(String ssn) {
		// TODO Auto-generated method stub
		System.out.print("coucou");
		return dao.findBySsn(ssn);
	}
	
	public void updateCommite(Commite commite) {
		// TODO Auto-generated method stub
		dao.updateCommite(commite);
	}
	public SessionFactory mySessionFact() {
		// TODO Auto-generated method stub
		return dao.getMySessionFactory();
	}

	public Commite getCommiteById(long id) {
		return dao.getCommiteById(id);
	}
	public void deleteFromCache(Commite comite) {
		// TODO Auto-generated method stub
		dao.deletefromCache(comite);
	}

}
