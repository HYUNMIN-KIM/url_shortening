package com.example.url_shortening.service;

import com.example.url_shortening.service.util.Aes128;
import com.example.url_shortening.service.util.Base62;

import com.example.url_shortening.service.util.SHA256;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShorteningServiceImpl implements ShorteningService {


    private Map<String,String> mapURL = new ConcurrentHashMap<>();

    public ShorteningServiceImpl(){

    }

    public String getShorteningURL(String url) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SHA256 sha256 = new SHA256();
        Base62 base62 = new Base62();
        String result = "";
        String sha256Hash = sha256.encode(url.getBytes());

            String digits = sha256Hash.substring(0, 12);
            long longKey = Long.parseLong(digits, 16);


            result = base62.encodeToLong(longKey);


        return result;
    }

    public String getOriginalURL(String shortURL){
       for(Map.Entry<String, String> entry : this.mapURL.entrySet()){
           if(entry.getKey().equalsIgnoreCase(shortURL))
               return entry.getValue();
       }

       return null;
    }




    public Map<String, String> getMapURL() {
        return mapURL;
    }

    public void setMapURL(String url, String inputUrl) {
        if(mapURL.keySet().contains(url))
            return;
        else
            mapURL.put(url,inputUrl);

    }
}
