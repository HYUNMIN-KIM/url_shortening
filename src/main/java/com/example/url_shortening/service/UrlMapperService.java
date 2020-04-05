package com.example.url_shortening.service;



public interface UrlMapperService {

    String getOriginalURL(String shortURL);

    boolean isShortingURL(String longURL);

    void setMapURL(String shortUrl, String longUrl);

    void addRequestNum(String longUrl);

    int getRequestNum(String longUrl);

    boolean isValidUrl(String shortUrl);
}
