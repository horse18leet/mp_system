package org.openapitools.controller;

import org.openapitools.util.HelperUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @GetMapping("/categories/all")
    private ResponseEntity<List<Object>> getAllCategories(HttpServletRequest req,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) Integer top){
        String url = HelperUtil.url + "content/v1/object/all?name=" + name + "&top=" + top;
        String token = HelperUtil.getJwtToken(req);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseCategories;
        Object categories;
        try{
            responseCategories = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
            categories = responseCategories.getBody();
        }
        catch(HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(Collections.singletonList("Не авторизован"));
        }

        return ResponseEntity.ok(Collections.singletonList(categories));
    }
}
