package org.openapitools.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "apiKey")
public class ApiKey {
    @Id
    private String id;
    private String key;
    private String clientId;
    private String type;
    private int userId;
}
