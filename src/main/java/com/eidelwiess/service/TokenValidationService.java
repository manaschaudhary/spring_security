package com.eidelwiess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidelwiess.entity.TokenEntity;
import com.eidelwiess.repository.TokenValidityRepository;

@Service
public class TokenValidationService {

	@Autowired
	TokenValidityRepository tokenValidityRepository;
	
	public TokenEntity save(TokenEntity inputEntity) {
		return tokenValidityRepository.save(inputEntity);
	}
	
	public boolean checkIfTokenExists(String userName, String token) throws Exception{
		try {
			int count= tokenValidityRepository.checkIfTokenExists(token);
			if(count==0) {
				throw new Exception("Token not valid");
			}
			
			int updateCount = tokenValidityRepository.setFlagForValidToken(token);
			if(updateCount==0) {
				return false;
			}else {return true;}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
