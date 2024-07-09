package org.openapitools.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openapitools.dto.messaging.receive.MessageOrderReceiveDTO;
import org.openapitools.dto.messaging.receive.MessageReportDetailReceiveDTO;
import org.openapitools.dto.messaging.receive.MessageSaleReceiveDTO;

import java.net.URISyntaxException;

public interface OrderService {

    void getOrdersPerDay(MessageOrderReceiveDTO message) throws JsonProcessingException, URISyntaxException;
    void getSalesPerDay(MessageOrderReceiveDTO message) throws URISyntaxException, JsonProcessingException;

    void getReportDetail(MessageReportDetailReceiveDTO message) throws URISyntaxException, JsonProcessingException;
}
