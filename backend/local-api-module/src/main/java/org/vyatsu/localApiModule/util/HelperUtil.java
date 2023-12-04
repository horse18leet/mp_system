package org.vyatsu.localApiModule.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class HelperUtil {
    public static String urlExternalModule = "http://localhost:8081";
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
}
