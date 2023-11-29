package org.openapitools.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;

public class HelperUtil {
    public static String urlWB = "https://suppliers-api.wildberries.ru/";
    public static String urlLocalModule = "http://localhost:8080";
    public static String getJwtToken(HttpServletRequest req){
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
}
