package org.me.repositorys;

import org.springframework.beans.factory.annotation.Value;

public interface getOnlyName {
	String getName();
	@Value("#{target.name + ' :' + target.description}")
	String getfullName();

}
