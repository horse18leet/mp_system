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
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

//    @GetMapping("/categories/all")
//    private ResponseEntity<List<Object>> getIntervalOrders(HttpServletRequest req,
//                                                          @RequestParam(required = false) LocalDateTime dateFrom,
//                                                          @RequestParam(required = false) Integer flag){
//        String url = HelperUtil.url + "api/v1/supplier/orders?name=" + name + "&top=" + top;
//        String token = HelperUtil.getJwtToken(req);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token);
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Object> responseCategories;
//        Object categories;
//        try{
//            responseCategories = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
//            categories = responseCategories.getBody();
//        }
//        catch(HttpClientErrorException e){
//            return ResponseEntity.status(e.getStatusCode()).body(Collections.singletonList("Не авторизован"));
//        }
//
//        return ResponseEntity.ok(Collections.singletonList(categories));
//    }
}
