package com.myjpa;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myjpa.model.Commite;
import com.myjpa.services.CommiteService;



public class MainAppSecondCache {
	public static void main(String[] args){
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"myhibernatebeans.xml"});
		CommiteService myservice = (CommiteService) context.getBean("comiteService");
		SessionFactory sessionFactory =  myservice.mySessionFact();
		Statistics stat = sessionFactory.getStatistics();
		stat.setStatisticsEnabled(true);
		displayStat(stat,"00");
		Commite comite= myservice.getCommiteById(1);
		System.out.println("Commite is "+comite.getName());
		displayStat(stat,"1");
		comite = myservice.getCommiteById(1);
		displayStat(stat,"2");
		
		comite = myservice.getCommiteById(2);
		System.out.println("Commite is "+comite.getName());
		displayStat(stat,"3");
		
		myservice.deleteFromCache(comite);
		comite = myservice.getCommiteById(1);
		System.out.println("Commite after evict is "+comite.getName());
		displayStat(stat,"4");
		myservice.getCommiteById(1);
		displayStat(stat,"5");



	}
	
	static void  displayStat(Statistics stat,String level){
		System.out.println("***** "+level+" ******");
		System.out.println("Hit Count :"+stat.getEntityFetchCount());
		System.out.println("Second Level Hit count :"+stat.getSecondLevelCacheHitCount());
		System.out.println("Second Level Missed count :"+stat.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put count :"+stat.getSecondLevelCachePutCount());
		System.out.println("***** "+level+" ******");
		System.out.println(" ");
	}

}
