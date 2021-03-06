package com.example.url_shortening.controller;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class ShorteningControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ShorteningController shorteningController;

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(shorteningController).build();
    }

    @Test
    public void urlShortening() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("inputUrl", "hp://www.musinsa.com");
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "올바른 url을 입력해주세요.");
        given(this.shorteningController.urlShortening(map)).willReturn(result);


        Map<String, Object> parameterMap = new LinkedHashMap<>();
        parameterMap.put("inputUrl", "http://www.musinsa.com");
        Gson gson = new Gson();
        String json = gson.toJson(parameterMap);
        System.out.println(json);
        mockMvc.perform(post("/shortening")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }




}
