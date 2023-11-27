package org.vyatsu.localApiModule.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.user.ApiKey;
import org.vyatsu.localApiModule.mapper.ApiKeyMapper;
import org.vyatsu.localApiModule.service.ApiKeyService;

import java.util.List;

@RestController
@RequestMapping("/api-key")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;
    private final ApiKeyMapper apiKeyMapper;

    @GetMapping
    public ResponseEntity<?> GetAllApiKey(HttpServletRequest request,
                                          @RequestParam(name = "type", required = false) String type) {
        List<ApiKey> apiKeys = apiKeyService.getAllApiKey(request, type);
        return ResponseEntity.ok(apiKeyMapper.toDtoList(apiKeys));
    }

    @PostMapping
    public ResponseEntity<?> CreateApiKey(HttpServletRequest request, @RequestBody ApiKeyDto apiKeyDto) {
        ApiKey createdApiKey = apiKeyService.CreateApiKey(request, apiKeyMapper.toEntity(apiKeyDto));
        return ResponseEntity.ok(apiKeyMapper.toDto(createdApiKey));
    }
}
