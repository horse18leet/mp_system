package org.openapitools.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HelperUtil {
    public static String urlWB = "https://suppliers-api.wildberries.ru/";
    public static String urlStatsWB = "https://statistics-api.wildberries.ru/";
    public static String urlLocalModule = "http://localhost:8080";
    public static String GetJwtToken(HttpServletRequest req){
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null) return null;
        jwt = authHeader;
        return jwt;
    }

    public static HttpEntity<String> GetHttpEntity(String authorization){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        return new HttpEntity<>(headers);
    }

    public static ArrayList<LinkedHashMap<String, String>> GetApiKeysUser(HttpServletRequest req) {
        String localToken = GetJwtToken(req);
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = GetHttpEntity(localToken);

        String getAllApiKeyUrl = urlLocalModule + "/api-key?type=" + "WB";
        ParameterizedTypeReference<ArrayList<LinkedHashMap<String, String>>> typeReference = new ParameterizedTypeReference<ArrayList<LinkedHashMap<String, String>>>() {};
        ArrayList<LinkedHashMap<String, String>> userApiKeysMp = restTemplate.exchange(
                getAllApiKeyUrl,
                HttpMethod.GET,
                entity,
                typeReference
        ).getBody();

        return userApiKeysMp;
    }

    public static String createWBRequest(String url, HttpMethod httpMethod, String apiKeyWb, @Nullable String body) throws JsonProcessingException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKeyWb);

        RequestEntity<String> entity = new RequestEntity<>(
                body,
                headers,
                httpMethod,
                new URI(url)
        );

        Object result = null;

        try {
            ResponseEntity<Object> responseEntity = restTemplate.exchange(entity, Object.class);
            result = responseEntity.getBody();

        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println("Error response body: " + ex.getResponseBodyAsString());
            } else {
                System.out.println("Error status code: " + ex.getStatusCode());
            }
        }

        return new ObjectMapper().writeValueAsString(result);
    }
}
