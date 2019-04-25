package org.me.services;

import java.util.List;

import org.me.models.Commite;
import org.me.repositorys.getOnlyName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConferenceService {
	List<String> getconferneceList(Long idConfo);
	Boolean getCommiteOfConference(Long idConf);
	 getOnlyName getCommiteByNameWithDefinedReturn(String name);
	 Commite getCommiteByName(String name);
	 Commite getCommiteById(Long id);
	public Page<Commite> getCommitePage(String desc ,int startPage, int amount);
}
