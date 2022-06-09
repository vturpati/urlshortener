package com.urlshortener.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Url")
public class Url {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "actualUrl")
    private String actualUrl;
    
	@Column(name = "hashValue")
    private String hashValue;
	
    
	public Url() {

	}
	
	public Url(Long id, String actualUrl) throws NoSuchAlgorithmException {
		this.id = id;
		this.actualUrl = actualUrl;

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActualUrl() {
		return actualUrl;
	}
	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}
	public String getHashValue() {
		return hashValue;
	}
	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}
	
	
}