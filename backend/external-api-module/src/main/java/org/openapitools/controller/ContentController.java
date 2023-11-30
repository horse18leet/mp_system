package org.openapitools.controller;

import org.openapitools.model.*;
import org.openapitools.util.HelperUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/content")
public class ContentController {

    @GetMapping("/cards")
    private ResponseEntity<List<Object>> getAllCardsByVendorCodes(HttpServletRequest req){
        List<String> vendorCodes = getAllVendorCode(req).getBody();
        return getAllCardsByVendorCodes(req, vendorCodes);
    }
    @PostMapping("/cards")
    private ResponseEntity<List<Object>> getAllCardsByVendorCodes(HttpServletRequest req,
                                                                  @RequestBody List<String> vendorCodes) {
        String getCardsUrl = HelperUtil.urlWB + "content/v1/cards/filter";
        ArrayList<LinkedHashMap<String, String>> userApiKeysMp = HelperUtil.GetApiKeysUser(req);
        RestTemplate restTemplate = new RestTemplate();

        Object cards = null;
        try {
            String tokenMp = userApiKeysMp.get(0).get("key");

            ContentV1CardsFilterPostRequest requestBody = new ContentV1CardsFilterPostRequest();
            requestBody.setVendorCodes(vendorCodes);
            requestBody.setAllowedCategoriesOnly(true);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", tokenMp);

            RequestEntity<ContentV1CardsFilterPostRequest> requestEntity1 = new RequestEntity<>(
                    requestBody,
                    headers,
                    HttpMethod.POST,
                    new URI(getCardsUrl)
            );
            ParameterizedTypeReference<ContentV1CardsFilterPost200Response> typeReference1 =
                    new ParameterizedTypeReference<ContentV1CardsFilterPost200Response>() {
                    };
            ResponseEntity<ContentV1CardsFilterPost200Response> responseEntity1 =
                    restTemplate.exchange(requestEntity1, typeReference1);

            cards = responseEntity1.getBody();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                System.out.println("Error response body: " + ex.getResponseBodyAsString());
            } else {
                System.out.println("Error status code: " + ex.getStatusCode());
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(Collections.singletonList(cards));

    }

    @GetMapping("/vendor-code")
    private ResponseEntity<List<String>> getAllVendorCode(HttpServletRequest req) {

        ArrayList<LinkedHashMap<String, String>> userApiKeysMp = HelperUtil.GetApiKeysUser(req);

        List<String> vendorCodes = null;
        assert userApiKeysMp != null;
        if ((long) userApiKeysMp.size() > 0) {
            String tokenMp = userApiKeysMp.get(0).get("key");

            String getCardsUrl = HelperUtil.urlWB + "content/v1/cards/cursor/list";
            RestTemplate restTemplate1 = new RestTemplate();

            String requestBody = "   {\n" +
                    "          \"sort\": {\n" +
                    "              \"cursor\": {\n" +
                    "                  \"limit\": 1000\n" +
                    "              },\n" +
                    "              \"filter\": {\n" +
                    "                  \"withPhoto\": -1\n" +
                    "              }\n" +
                    "          }\n" +
                    "        }";

            HttpHeaders headers1 = new HttpHeaders();
            headers1.setContentType(MediaType.APPLICATION_JSON);
            headers1.set("Authorization", tokenMp);
            try {
                RequestEntity<String> requestEntity1 = new RequestEntity<>(
                        requestBody,
                        headers1,
                        HttpMethod.POST,
                        new URI(getCardsUrl)
                );
                ParameterizedTypeReference<ContentV1CardsCursorListPost200Response> typeReference1 =
                        new ParameterizedTypeReference<ContentV1CardsCursorListPost200Response>() {
                        };

                ResponseEntity<ContentV1CardsCursorListPost200Response> responseEntity1 =
                        restTemplate1.exchange(requestEntity1, typeReference1);

                vendorCodes = Objects.requireNonNull(responseEntity1.getBody())
                        .getData()
                        .getCards()
                        .stream()
                        .map(ContentV1CardsCursorListPost200ResponseDataCardsInner::getVendorCode)
                        .collect(Collectors.toList());

            } catch (HttpClientErrorException ex) {
                if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
                    System.out.println("Error response body: " + ex.getResponseBodyAsString());
                } else {
                    System.out.println("Error status code: " + ex.getStatusCode());
                }
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        return ResponseEntity.ok(vendorCodes);
    }

    @GetMapping("/categories/all")
    private ResponseEntity<List<Object>> getAllCategories(HttpServletRequest req,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) Integer top){
        String url = HelperUtil.urlWB + "content/v1/object/all?name=" + name + "&top=" + top;
        String localToken = HelperUtil.GetJwtToken(req);

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
