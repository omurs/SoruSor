package com.sorusor.dao;

import java.util.Date;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sorusor.model.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class TokenRepositoryDaoImpl extends AbstractDao<String, PersistentLogin> implements PersistentTokenRepository 
{

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persist(persistentLogin);

	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		
		try {
			PersistentLogin persistentLogin = (PersistentLogin) getEntityManager()
		                .createQuery("SELECT p FROM PersistentLogin p WHERE p.series = :series ")
		                .setParameter("series", seriesId)
		                .getSingleResult();

			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public void removeUserTokens(String username) {
		
		PersistentLogin persistentLogin = (PersistentLogin) getEntityManager()
                .createQuery("SELECT p FROM PersistentLogin p WHERE p.username = :username ")
                .setParameter("username", username)
                .getSingleResult();
		delete(persistentLogin);
		if (persistentLogin != null) {
			delete(persistentLogin);
		}

	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        PersistentLogin persistentLogin = getByKey(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        update(persistentLogin);
		
	}



	

}
