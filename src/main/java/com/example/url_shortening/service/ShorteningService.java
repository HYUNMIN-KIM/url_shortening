package com.example.url_shortening.service;




import java.security.NoSuchAlgorithmException;


public interface ShorteningService {

    String getShorteningURL(String url) throws NoSuchAlgorithmException;



}
