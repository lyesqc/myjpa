package com.myjpa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;



import org.springframework.stereotype.Repository;

import com.myjpa.model.Commite;


@Repository("commiteDao")
public class CommiteDaoImpl extends AbstractDao implements CommiteDao {

	public void saveCommite(Commite commite) {
		// TODO Auto-generated method stub
		getSession().save(commite);
	}

	public List<Commite> findAllCommites() {
		// TODO Auto-generated method stub
		try{
			
		Criteria myCreteria =getSession().createCriteria(Commite.class);
		
		List<Commite> commiteList = ( List<Commite>)myCreteria.list();
		System.out.println("Inside allCommites "+commiteList.size() );
		
		return commiteList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void deleteCommiteBySsn(String ssn) {
		// TODO Auto-generated method stub
		Query myQuery = getSession().createSQLQuery("delete from commite c where c.nom_comite= :ssn");
		myQuery.setParameter("ssn", ssn);
		myQuery.executeUpdate();
	}

	public Commite findBySsn(String ssn) {
		// TODO Auto-generated method stub
		Commite commite = null;
		try{
		Criteria myCreteria =getSession().createCriteria(Commite.class);
		
		myCreteria.add(Restrictions.eq("name", ssn));
		 commite = (Commite)myCreteria.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		 return commite;
	}
	
	public Commite getCommiteById(long id){
		return  (Commite) getSession().load(Commite.class, id);
	}

	public void updateCommite(Commite commite) {
		// TODO Auto-generated method stub
		getSession().update(commite);
		
	}

	public void deletefromCache(Commite comite) {
		// TODO Auto-generated method stub
		getSession().evict(comite);
	}

	

}
