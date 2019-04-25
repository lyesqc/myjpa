package org.me.repositorys;


import org.me.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CommitieRepository extends CrudRepository<Commite,Long>,QueryDslPredicateExecutor<Commite> {
	
	public getOnlyName findByName(String name);
	@Query("select c from Commite c where c.name= ?1")
	Commite findByNameOf(String name);
	Page<Commite> findByDescription(String desc,Pageable pageable);
	
	


}
