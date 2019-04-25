package org.me.services;

import java.util.List;

import javax.persistence.criteria.Predicate;

import org.me.models.Commite;
import org.me.repositorys.CommitieRepository;
import org.me.repositorys.getOnlyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImp implements ConferenceService{

	@Autowired
	CommitieRepository commiteRepository;
	
	@Override
	public List<String> getconferneceList(Long idConfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getCommiteOfConference(Long idConf) {
		// TODO Auto-generated method stub
		System.out.println("In Service ");
		List<Commite>  listOfCommite = (List<Commite>) commiteRepository.findAll();
		for(Commite commite : listOfCommite){
			System.out.println("Commite is "+commite.getName()+","+commite.getDescription());
		}
		return true;
	}
	
	public Commite getCommiteByName(String name){
		//getOnlyName dtr = commiteRepository.findByName("commite_2_name");
		//System.out.println("Name By Only Namse is" +dtr.getfullName());
		
		Commite com = commiteRepository.findByNameOf(name);
		
		return com;
	}

	@Override
	public Commite getCommiteById(Long id) {
		// TODO Auto-generated method stub
		
		return commiteRepository.findOne(id);
	}

	@Override
	public getOnlyName getCommiteByNameWithDefinedReturn(String name) {
		// TODO Auto-generated method stub
		return commiteRepository.findByName(name);
	}

	@Override
	public Page<Commite> getCommitePage(String desc,int startPage, int amount) {
		// TODO Auto-generated method stub
		Commite commite = new Commite();
		//Predicate p = commite.getName().equalsIgnoreCase("commite_1");
		//commiteRepository.findAll(arg0);
		
		
		Page<Commite> commitePage = commiteRepository.findByDescription(desc,  new PageRequest(startPage, amount, new Sort(Sort.Direction.ASC,"description")));
		return commitePage;
	}

}
