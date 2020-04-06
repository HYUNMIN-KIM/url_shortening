package com.example.url_shortening.service;

import com.example.url_shortening.vo.UrlVO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UrlMapperServiceImpl implements UrlMapperService {


    private List<UrlVO> urlVOList = new ArrayList<>();


    @Override
    public List<UrlVO> getAllList() {
        return urlVOList;
    }

    public String getOriginalURL(String shortURL){
        for(UrlVO uv : urlVOList){
            if(uv.getShortUrl().equalsIgnoreCase(shortURL))
                return uv.getLongUrl();
        }

        return null;
    }

    public boolean isShortingURL(String url){
        for(UrlVO uv : urlVOList){
            if(uv.getShortUrl().equalsIgnoreCase(url)) {
                    return true;
            }
        }

        return false;
    }

    public boolean isNull(){
        if(urlVOList.isEmpty())
            return true;
        return false;
    }


    public void setMapURL(String shortUrl, String longUrl) {
        for(UrlVO uv : urlVOList){
            if(uv.getLongUrl().equalsIgnoreCase(longUrl))
                return;
        }
        UrlVO urlVO = new UrlVO(shortUrl,longUrl);
        urlVOList.add(urlVO);

    }

    public void addRequestNum(String longUrl){
        for(UrlVO uv : urlVOList){
            if(uv.getLongUrl().equalsIgnoreCase(longUrl)) {
                int n = 1+ uv.getRequestNum();
                uv.setRequestNum(n);
            }
        }
    }

    public int getRequestNum(String longUrl){
        int num=0;
        for(UrlVO uv : urlVOList){
            if(uv.getLongUrl().equalsIgnoreCase(longUrl)) {
               return uv.getRequestNum();
            }
        }
        return num;
    }

    public boolean isValidUrl(String shortUrl) {
        if (shortUrl.contains("http://localhost/") || shortUrl.contains("https://localhost/")) {
            for (UrlVO uv : urlVOList) {
                if (uv.getShortUrl().equalsIgnoreCase(shortUrl))
                    return true;
            }
            return false;
        }

        return true;
    }
}
