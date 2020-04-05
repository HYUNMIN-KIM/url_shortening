package com.example.url_shortening.service;




import java.security.NoSuchAlgorithmException;


public interface ShorteningService {

    public String getShorteningURL(String url) throws NoSuchAlgorithmException;


}
