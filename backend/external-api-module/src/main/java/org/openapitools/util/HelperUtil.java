package org.openapitools.util;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

public class HelperUtil {
    public static String url = "https://suppliers-api.wildberries.ru/";
    public static String getJwtToken(HttpServletRequest req){
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null) return null;
        jwt = authHeader;
        return jwt;
    }
}
