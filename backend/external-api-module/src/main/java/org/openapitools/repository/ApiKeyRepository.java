package org.openapitools.repository;

import org.openapitools.entity.ApiKey;
import org.springframework.data.mongodb.repository.MongoRepository;

<<<<<<< Updated upstream
public interface ApiKeyRepository extends MongoRepository<ApiKey, String> {
=======
import java.util.List;

public interface ApiKeyRepository extends MongoRepository<ApiKey, String> {
    boolean existsByKey(String key);
    List<ApiKey> findByType(String type);
>>>>>>> Stashed changes
}
