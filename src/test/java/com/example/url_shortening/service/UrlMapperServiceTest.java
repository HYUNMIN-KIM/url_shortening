package com.example.url_shortening.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlMapperServiceTest {

    @Autowired
    UrlMapperService urlMapperService;

    @Test
    public void getOriginalURLTest(){
        urlMapperService.setMapURL("http://localhost/Ki084g","http://www.musinsa.com");

        String orignalUrl = urlMapperService.getOriginalURL("http://localhost/Ki084g");
        assertEquals("same",orignalUrl,"http://www.musinsa.com");

    }

    @Test
    public void isShortingURLTest(){
        urlMapperService.setMapURL("http://localhost/Ki084g","http://www.musinsa.com");

        boolean isExist = urlMapperService.isShortingURL("http://localhost/Ki084g");
        assertEquals("correct",isExist,true);
        isExist = urlMapperService.isShortingURL("http://www.musinsa.com");
        assertFalse("incorrect",isExist);

    }


    @Test
    public void getRequestNumTest(){
        urlMapperService.setMapURL("http://localhost/Ki084g","http://www.musinsa.com");
        urlMapperService.addRequestNum("http://www.musinsa.com");
        int number = urlMapperService.getRequestNum("http://www.musinsa.com");
        assertEquals("number",number,1);

    }

    @Test
    public void isValidUrlTest(){
        urlMapperService.setMapURL("http://localhost/Ki084g","http://www.musinsa.com");
        boolean flag = urlMapperService.isValidUrl("http://localhost/Ki084g");
        assertEquals("correct",flag,true);
        flag = urlMapperService.isValidUrl("http://localhost/Ki08sf4g");
        assertFalse("incorrect",flag);

    }


}
