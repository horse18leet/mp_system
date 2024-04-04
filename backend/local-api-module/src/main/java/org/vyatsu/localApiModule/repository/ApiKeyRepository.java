package org.vyatsu.localApiModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.user.ApiKey;

import java.util.List;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {
    ApiKey findByKey(String key);

    @Query("SELECT a FROM ApiKey a WHERE a.user.id = ?1")
    List<ApiKey> findByUserId(Long id);

    @Query("SELECT a FROM ApiKey a WHERE a.type = ?1 AND a.user.id  = ?2")
    ApiKey findByTypeAndUser(ApiKeyType type, Long id);

}
