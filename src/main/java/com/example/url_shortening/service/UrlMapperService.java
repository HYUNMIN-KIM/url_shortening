package com.example.url_shortening.service;


import com.example.url_shortening.vo.UrlVO;

import java.util.List;

public interface UrlMapperService {


    List<UrlVO> getAllList();

    String getOriginalURL(String shortURL);

    boolean isShortingURL(String url);

    void setMapURL(String shortUrl, String longUrl);

    void addRequestNum(String longUrl);

    int getRequestNum(String longUrl);

    boolean isValidUrl(String shortUrl);
}
