package com.eidelwiess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eidelwiess.entity.TokenEntity;
import com.eidelwiess.service.TokenValidationService;

@RestController
public class TokenAPIController {

	@Autowired
	TokenValidationService tokenValidationService;
	
	@GetMapping(value="/checkTokenValidity")
	public boolean checkTokenValidity(@RequestParam(value="token") String token , @RequestParam(value="userName")String userName, @RequestParam(value="api")String api) {
		try {
			//String userName = SecurityContextHolder.getContext().getAuthentication().getName();  // or this will be supplied from the requesting application
			boolean check;
			check = tokenValidationService.checkIfTokenExists(userName, token);
			
			if(check==true) {
				TokenEntity tokenEntity = new TokenEntity();
				tokenEntity.setUserName(userName);
				//tokenEntity.setApiUrl(api);
				tokenEntity.setToken(token);
				tokenEntity.setFlag(false);
				
				//tokenValidationService.save(tokenEntity);
				return true;
			}
			else {return false;}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
