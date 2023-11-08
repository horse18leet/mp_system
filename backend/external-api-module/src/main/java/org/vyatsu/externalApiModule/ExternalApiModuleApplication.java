package org.vyatsu.externalApiModule;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExternalApiModuleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ExternalApiModuleApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
