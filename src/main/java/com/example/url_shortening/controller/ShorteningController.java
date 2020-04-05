package com.example.url_shortening.controller;

import com.example.url_shortening.service.ShorteningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ShorteningController {

    @Autowired
    ShorteningServiceImpl shorteningService;

    @ResponseBody
    @RequestMapping(value = "/shortening", method = RequestMethod.POST)
    public Map<String, Object> urlShortening(@RequestBody Map<String, Object> param) throws NoSuchAlgorithmException{
        Map<String, Object> result = new HashMap<>();

        String inputUrl = (String) param.get("inputUrl");

        if (inputUrl == null || "".equals(inputUrl) || inputUrl.trim().length() == 0) {

            return null;
        }
        inputUrl = inputUrl.trim();
        String message = "";
        if(shorteningService.isNull()){
            String url = shorteningService.getShorteningURL(inputUrl);
            message = "http://localhost/" + url;
            shorteningService.setMapURL(message,inputUrl);
            result.put("shortUrl",message);
        }
        else if(!shorteningService.isShortingURL(inputUrl)) {
            String url = shorteningService.getShorteningURL(inputUrl);
            message = "http://localhost/" + url;
            shorteningService.setMapURL(message,inputUrl);
            result.put("shortUrl",message);
        }else{
            message = shorteningService.getOriginalURL(inputUrl);
            result.put("longUrl",message);

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/redirect", method = RequestMethod.POST)
    public Map<String, Object> redirectUrl(@RequestBody Map<String, Object> param)  throws IOException {


        Iterator<String> paramIter = param.keySet().iterator();
        String result = "";
        while(paramIter.hasNext()){
            String key = paramIter.next();
            String val = (String) param.get(key);
            result = val;
        }
        result  = shorteningService.getOriginalURL(result);


        Map<String, Object> map = new HashMap<>();
        map.put("message",result);

        return map;

    }

    @RequestMapping(value="/redirectURL", method = RequestMethod.GET)
    public RedirectView goTo(HttpServletRequest httpServletRequest){
        String url = httpServletRequest.getParameter("url");
        System.out.println(url);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }

}
