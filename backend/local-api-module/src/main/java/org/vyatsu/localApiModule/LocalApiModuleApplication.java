package org.vyatsu.localApiModule;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.vyatsu.localApiModule.dto.response.api.ApiKeyDto;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class LocalApiModuleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LocalApiModuleApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
