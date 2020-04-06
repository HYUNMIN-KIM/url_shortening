package com.example.url_shortening.service;

import com.example.url_shortening.service.util.*;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;


@Service
public class ShorteningServiceImpl implements ShorteningService {


    public String getShorteningURL(String url) throws NoSuchAlgorithmException{
        SHA256 sha256 = new SHA256();
        BASE62 base62 = new BASE62();
        String result = "";
        String sha256Hash = sha256.encode(url.getBytes());


        String digits = sha256Hash.substring(0, 12);

        long urlKey = Long.parseLong(digits, 16);

        result = base62.encode(urlKey);

        if(result.length()>8)
            return result.substring(0,8);

        return result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ShorteningService shorteningService = new ShorteningServiceImpl();
        System.out.println(shorteningService.getShorteningURL("http://www.naver.com"));

    }

}
