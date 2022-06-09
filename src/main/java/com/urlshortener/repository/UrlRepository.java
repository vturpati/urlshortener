package com.urlshortener.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.urlshortener.model.Url;



@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	@Query("SELECT t FROM Url t WHERE t.hashValue = ?1")
    Url findByHashValue(String hash);

}