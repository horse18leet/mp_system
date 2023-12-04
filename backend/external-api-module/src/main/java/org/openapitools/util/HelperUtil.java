package org.openapitools.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
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
}
