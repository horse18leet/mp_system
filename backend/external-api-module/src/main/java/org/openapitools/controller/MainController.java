package org.openapitools.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.vyatsu.localApiModule.security.JwtAuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private String url = "https://suppliers-api.wildberries.ru/";

    @GetMapping
    private List<Object> getAllCategories(HttpServletRequest req){
        String token = getJwtToken(req);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        url += "content/v1/object/all";
        ResponseEntity<Object> responseCategories = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        Object categories = responseCategories.getBody();

        assert categories != null;
        return Arrays.asList(categories);
    }

    private String getJwtToken(HttpServletRequest req){
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null) return null;
        jwt = authHeader;
        return jwt;
    }
}
