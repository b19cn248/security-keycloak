package com.openlearnhub.ptit.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {


    @Bean
    public Keycloak getKeycloakInstance() {
        return KeycloakBuilder.builder()
                .realm("OpenLearnHub")
                .serverUrl("http://localhost:7080/")
                .clientId("open-learn-hub")
                .clientSecret("qlqavnwtaRpKwpsu3dL2oRllPNUobuv2")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();

    }
}
