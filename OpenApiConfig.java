package com.example.hospital.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI hospitalOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital Management API")
                        .version("1.0.0")
                        .description("REST API for patients, doctors and appointments. "
                                + "Call POST /api/auth/login first - the session cookie is then sent automatically by Swagger UI."))
                .components(new Components().addSecuritySchemes("sessionCookie",
                        new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.COOKIE).name("JSESSIONID")))
                .addSecurityItem(new SecurityRequirement().addList("sessionCookie"));
    }
}
