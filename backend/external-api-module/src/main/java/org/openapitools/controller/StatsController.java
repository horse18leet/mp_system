package org.openapitools.controller;

import org.openapitools.util.HelperUtil;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @GetMapping("/orders")
    private ResponseEntity<List<Object>> getIntervalOrders(@RequestParam(required = false) HttpServletRequest req,
                                                          @RequestParam(required = false) String dateFrom,
                                                          @RequestParam(required = false) Integer flag,
                                                          @RequestParam(required = false) String apiKey
    ) throws URISyntaxException {
        String getOrdersUrl = HelperUtil.urlStatsWB + "api/v1/supplier/orders?dateFrom=" + dateFrom + "&flag=" + flag;

        if(apiKey == null){
            ArrayList<LinkedHashMap<String, String>> userApiKeysMp = HelperUtil.GetApiKeysUser(req);
            apiKey = userApiKeysMp.get(0).get("key");
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);

        RequestEntity<String> entity = new RequestEntity<>(
                null,
                headers,
                HttpMethod.GET,
                new URI(getOrdersUrl)
        );

        Object orders = null;

        try {
            orders = restTemplate.exchange(getOrdersUrl, HttpMethod.GET, entity, Object.class).getBody();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println("Error response body: " + ex.getResponseBodyAsString());
            } else {
                System.out.println("Error status code: " + ex.getStatusCode());
            }
        }

        return ResponseEntity.ok(Collections.singletonList(orders));
    }
}
