package com.myjpa;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myjpa.model.Commite;
import com.myjpa.services.CommiteService;
import com.myjpa.services.CommiteServiceImpl;

import net.sf.ehcache.CacheManager;


public class AppMain {

	public enum myEnum{
		GRISE("GRISE"),
		BLUE("BLUE");
		 myEnum(String iname1){
			this.iname = iname1;
		};
		 private final String iname;
	}
	
	public static void put(CommiteService ser){
		
	}
	public static void main(String[] args){
		  Logger log = LoggerFactory.getLogger(AppMain.class);
		try{
			
			System.out.println(new String("A")=="A");
			System.out.print("Enum : "+myEnum.GRISE.ordinal());
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"myhibernatebeans.xml"});
		CommiteService myservice = (CommiteService) context.getBean("comiteService");
		
		
		List<Commite> list = myservice.findAllCommites();
		String g="ملك";
		log.info("It is Interceptor Logger1 : "+g +", ");
		System.out.println("La taille "+list.size()+"; adress ");
		System.out.println("///////////////////////");
		Commite c1 = (Commite)list.get(0);
		//int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("org.comite").;;
		System.out.println("CommiteMember are : "+c1.getComite_mbr().size()+" , second level cache size is ");
		List<String> c = list.get(0).getAdress();
		System.out.println(" Adress is : "+c.get(0));
		
		
		System.out.println(" --------------------");
		System.out.println(" Adress is : "+c.get(1));
		/*Commite mycomite = myservice.findBySsn("commite_1_name");
		System.out.println("Comite Name "+mycomite.getName()+", Description : "+mycomite.getDescription());*/
		}catch(Exception e){
			e.printStackTrace();
		}
		}
}
