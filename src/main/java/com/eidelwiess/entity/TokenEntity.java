package com.eidelwiess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
@Table(name = "TokenEntity" , indexes = { @Index(name = "TOKEN_INDEX", columnList = "token") })
public class TokenEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "userName", nullable = false)
    private String userName;
	
	@Column(name = "token", nullable = false)
    private String token;
	
	/*@Column(name = "apiUrl", nullable = false)
    private String apiUrl;*/
	
	@Column(name = "flag", columnDefinition="boolean default 'false'")
    private Boolean flag;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
/*
	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}*/

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
}
