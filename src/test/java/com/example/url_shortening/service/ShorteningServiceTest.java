package com.example.url_shortening.service;

import com.example.url_shortening.controller.ShorteningController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ShorteningServiceTest {


    @Autowired
    ShorteningService shorteningService;

    @Test
    public void getShorteningURLTest() throws NoSuchAlgorithmException {

        String shorturl = shorteningService.getShorteningURL("http://www.musinsa.commmm");
        assertTrue(shorturl,shorturl.length()<=8);

    }
}
