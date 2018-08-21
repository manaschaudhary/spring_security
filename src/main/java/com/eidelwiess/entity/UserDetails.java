package com.eidelwiess.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "user_master")
public class UserDetails {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name = "userName", nullable = false)
    private String userName;
 
    @Column(name = "password", nullable = false, length =5)
    private String password;
}