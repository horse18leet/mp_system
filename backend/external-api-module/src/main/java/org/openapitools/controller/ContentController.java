package org.openapitools.controller;

import org.openapitools.util.HelperUtil;
import org.springframework.core.ParameterizedTypeReference;
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
import java.util.Objects;

@RestController
@RequestMapping("/content")
public class ContentController {

    @GetMapping("/items/all")
    private ResponseEntity<List<Object>> getAllItems(HttpServletRequest req,
                                                     @RequestParam(required = false) String typeApiKeyMP,
                                                     @RequestParam(required = false) String apiKeyMP){
        String getCardsUrl = HelperUtil.url + "content/v1/cards/cursor/list";
        String localToken = HelperUtil.getJwtToken(req);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = HelperUtil.GetHttpEntity(localToken);

        Object items = null;
        if(apiKeyMP.isEmpty() && typeApiKeyMP.isEmpty()){
            try{
                String[] userApiKeysMp = restTemplate.exchange(getCardsUrl, HttpMethod.GET, entity, String[].class).getBody();

                assert userApiKeysMp != null;
                if(userApiKeysMp.length > 0){
                    for(String userApiKey : userApiKeysMp){{
                        String[] typeAndApiKey = userApiKey.split(" ");
                        if(Objects.equals(typeAndApiKey[0], "WB")){
                            entity = HelperUtil.GetHttpEntity(typeAndApiKey[1]);
                            items = restTemplate.exchange(getCardsUrl, HttpMethod.GET, entity, Object.class).getBody();
                        }
                    }}
                }
            }
            catch (HttpClientErrorException e){
                return ResponseEntity.status(e.getStatusCode()).body(Collections.singletonList("Не авторизован"));
            }
        }
        return ResponseEntity.ok(Collections.singletonList(items));
    }

    @GetMapping("/categories/all")
    private ResponseEntity<List<Object>> getAllCategories(HttpServletRequest req,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) Integer top){
        String url = HelperUtil.url + "content/v1/object/all?name=" + name + "&top=" + top;
        String localToken = HelperUtil.getJwtToken(req);

        HttpEntity<String> entity = HelperUtil.GetHttpEntity(localToken);

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
