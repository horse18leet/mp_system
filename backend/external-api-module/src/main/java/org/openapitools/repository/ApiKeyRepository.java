package org.openapitools.repository;

import org.openapitools.entity.ApiKey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiKeyRepository extends MongoRepository<ApiKey, String> {
}
