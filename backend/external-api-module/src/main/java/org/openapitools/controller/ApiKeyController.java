package org.openapitools.controller;

import lombok.AllArgsConstructor;
import org.openapitools.dto.ApiKeyDto;
import org.openapitools.entity.ApiKey;
import org.openapitools.mapper.ApiKeyMapper;
import org.openapitools.service.ApiKeyService;
<<<<<<< Updated upstream
=======
import org.springframework.amqp.rabbit.annotation.RabbitListener;
>>>>>>> Stashed changes
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiKey")
@AllArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    private final ApiKeyMapper apiKeyMapper;

    @GetMapping
<<<<<<< Updated upstream
    public ResponseEntity<List<ApiKeyDto>> getAllApiKey(){
        List<ApiKey> apiKeys = apiKeyService.getAllApiKey();
        return ResponseEntity.ok(apiKeyMapper.toDtoList(apiKeys));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiKeyDto> addApiKeyUser(@RequestBody ApiKeyDto apiKeyDto){
        ApiKey apiKey = apiKeyMapper.toEntity(apiKeyDto);
        apiKey = apiKeyService.saveApiKey(apiKey);
        return ResponseEntity.ok(apiKeyMapper.toDto(apiKey));
    }
=======
    public ResponseEntity<List<ApiKeyDto>> getAllApiKeyWB(){
        List<ApiKey> apiKeys = apiKeyService.getAllApiKeyByType("WB");
        return ResponseEntity.ok(apiKeyMapper.toDtoList(apiKeys));
    }

    @RabbitListener(queues = "queue.ApiKeyWB")
    public void addApiKeyUser(@RequestBody ApiKeyDto apiKeyDto){
        ApiKey apiKey = apiKeyMapper.toEntity(apiKeyDto);
        apiKeyService.saveApiKey(apiKey);
    }

>>>>>>> Stashed changes
}
