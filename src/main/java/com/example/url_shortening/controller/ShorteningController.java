package com.example.url_shortening.controller;

import com.example.url_shortening.service.ShorteningService;
import com.example.url_shortening.service.UrlMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import java.util.Map;


@Controller
public class ShorteningController {
    private ShorteningService shorteningService;
    private UrlMapperService urlMapperService;

    @Autowired
    public ShorteningController(ShorteningService shorteningService, UrlMapperService urlMapperService){
        this.shorteningService = shorteningService;
        this.urlMapperService = urlMapperService;
    }

    @ResponseBody
    @RequestMapping(value = "/shortening", method = RequestMethod.POST)
    public Map<String, Object> urlShortening(@RequestBody Map<String, Object> param) throws NoSuchAlgorithmException{
        Map<String, Object> result = new HashMap<>();

        String inputUrl = (String) param.get("inputUrl");
        inputUrl = inputUrl.trim();
        String message = "";
        inputUrl = inputUrl.trim();

        if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://") ) {
            message = "올바른 url 형식이 아닙니다.(http:// or https:// 사용해주세요.)";
            result.put("msg",message);
            return result;

        }

        if(!urlMapperService.isValidUrl(inputUrl)){
           message="저장되지 않은 url이거나 올바른 url이 아닙니다.";
            result.put("msg",message);
            return result;
        }


       if(!urlMapperService.isShortingURL(inputUrl)) {
            String url = shorteningService.getShorteningURL(inputUrl);
            message = "http://localhost/" + url;
            urlMapperService.setMapURL(message,inputUrl);
            urlMapperService.addRequestNum(inputUrl);
            result.put("shortUrl",message);
            result.put("requestNum", urlMapperService.getRequestNum(inputUrl));

        }
        else{
            message = urlMapperService.getOriginalURL(inputUrl);
            urlMapperService.addRequestNum(inputUrl);

            result.put("longUrl",message);

        }
        return result;
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
