package com.example.url_shortening.service;

import com.example.url_shortening.service.util.*;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShorteningServiceImpl implements ShorteningService {


    private Map<String,String> mapURL = new ConcurrentHashMap<>();

    public ShorteningServiceImpl(){

    }

    public String getShorteningURL(String url) throws NoSuchAlgorithmException{
        SHA256 sha256 = new SHA256();
        BASE62 base62 = new BASE62();
        String result = "";
        String sha256Hash = sha256.encode(url.getBytes());

            String digits = sha256Hash.substring(0, 12);
            long urlKey = Long.parseLong(digits, 16);


            result = base62.encode(urlKey);


        return result;
    }

//    public String getOriginalURL(String shortURL){
//       for(Map.Entry<String, String> entry : this.mapURL.entrySet()){
//           if(entry.getKey().equalsIgnoreCase(shortURL))
//               return entry.getValue();
//       }
//
//       return null;
//    }
//
//    public boolean isShortingURL(String longURL){
//        for(Map.Entry<String, String> entry : this.mapURL.entrySet()){
//            if(entry.getKey().equalsIgnoreCase(longURL))
//                return true;
//        }
//
//        return false;
//    }
//
//    public boolean isNull(){
//        if(this.mapURL.isEmpty())
//            return true;
//        return false;
//    }
//
//
//    public void setMapURL(String shortUrl, String longUrl) {
//        if(mapURL.keySet().contains(shortUrl))
//            return;
//        else
//            mapURL.put(shortUrl,longUrl);
//
//    }
}
