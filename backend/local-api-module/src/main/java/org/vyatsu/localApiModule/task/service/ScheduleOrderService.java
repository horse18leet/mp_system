package org.vyatsu.localApiModule.task.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.vyatsu.localApiModule.util.HelperUtil.urlExternalModule;


@Service
public class ScheduleOrderService {

    public ArrayList<ArrayList<ArrayList<LinkedHashMap<String, String>>>> GetOrdersByApiKeys(List<ApiKeyDto> apiKeys, String flag){
        RestTemplate restTemplate = new RestTemplate();

        LocalDate currentLocalDate = LocalDate.now();

        ParameterizedTypeReference<ArrayList<ArrayList<LinkedHashMap<String, String>>>> typeReference = new ParameterizedTypeReference<>() {
        };

        ArrayList<ArrayList<ArrayList<LinkedHashMap<String, String>>>> orders = new ArrayList<>();

        for (ApiKeyDto apiKey : apiKeys){
            String getAllApiKeyUrl = urlExternalModule + "/stats/orders/?dateFrom=" + currentLocalDate + "&flag=" + flag + "&apiKey=" + apiKey.getKey();
            orders.add(restTemplate.exchange(
                    getAllApiKeyUrl,
                    HttpMethod.GET,
                    null,
                    typeReference
            ).getBody());
        }

        return orders;
    }

}
