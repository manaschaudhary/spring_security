package com.eidelwiess.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eidelwiess.entity.TokenEntity;

public interface TokenValidityRepository extends CrudRepository<TokenEntity, Long> {

	/*@Query(value="from TokenEntity t where t.userName =:userName AND t.token=:token and t.flag=false")
	TokenEntity findByUserNameAndTokenAndApiUrl (@Param("userName")String userName, @Param("token")String token);*/
	
	@Query("select count(*)  from TokenEntity t where t.token = :token")
	int checkIfTokenExists(@Param("token") String token);

	@Modifying
	@Transactional(readOnly=false)
	@Query(value="update token_entity set flag = TRUE where flag = FALSE and token = :token", nativeQuery=true)
	Integer setFlagForValidToken(@Param("token")String token);
	
}