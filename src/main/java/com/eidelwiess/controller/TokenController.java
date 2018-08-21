package com.eidelwiess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eidelwiess.entity.TokenEntity;
import com.eidelwiess.repository.TokenValidityRepository;

@Controller
public class TokenController {
	
	@Autowired
	@Qualifier(value="tokenGenerator")
	PasswordEncoder passwordEncoder;
	
	@Autowired
	TokenValidityRepository tokenValidityRepository;
	
	@GetMapping("/requestToken")
    public String requestToken(Model model) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		String token = passwordEncoder.encode(userName);
        model.addAttribute("token", token);
        
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUserName(userName);
        //tokenEntity.setApiUrl("requestToken");
        tokenEntity.setToken(token);
        tokenEntity.setFlag(false);
        
        tokenValidityRepository.save(tokenEntity);
        return "user";
    }
}