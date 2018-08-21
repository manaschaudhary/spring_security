package com.eidelwiess.repository;
import org.springframework.data.repository.CrudRepository;

import com.eidelwiess.entity.UserDetails;
 
interface UserRepository extends CrudRepository<UserDetails, Long> {
}