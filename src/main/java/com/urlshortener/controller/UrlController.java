package com.urlshortener.controller;



import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortener.model.Url;
import com.urlshortener.repository.UrlRepository;



@RestController
@RequestMapping("/api/v1")
public class UrlController {
	
	@Autowired
	private UrlRepository urlRepository;
	/*
	@GetMapping("/urls")
	public List<Url> getAllUrls(){
		return urlRepository.findAll();
	}*/
	
	@PostMapping("/urls")
	public Url createUrl(@RequestBody Url url) throws NoSuchAlgorithmException {
		String hashStr = toHexString(getSHA(url.getActualUrl()));
		Url existing =  urlRepository.findByHashValue(hashStr);
		if(existing.getActualUrl().length() > 0 ) {
			url.setHashValue(hashStr);
			return urlRepository.save(url);
		}else {
			return existing;
		}
	}
	
	@GetMapping("/urls/{hash}")
	public Url getUrl(@PathVariable(value="hash") String hash) {
		return urlRepository.findByHashValue(hash);
	}
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash)
    {
        
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(62));
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

	    
}