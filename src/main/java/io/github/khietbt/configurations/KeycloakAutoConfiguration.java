package io.github.khietbt.configurations;

import io.github.khietbt.authorizors.Authorizor;
import io.github.khietbt.authorizors.KeycloakAuthorizor;
import org.keycloak.authorization.client.AuthzClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@ConditionalOnProperty(prefix = "keycloak", name = "enabled", havingValue = "true")
public class KeycloakAutoConfiguration {
    @Value("${keycloak.enabled}")
    private boolean enabled;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Bean
    public AuthzClient authzClient() {
        return AuthzClient.create(
                new org.keycloak.authorization.client.Configuration(
                        authServerUrl,
                        realm,
                        clientId,
                        Collections.singletonMap("secret", clientSecret),
                        null
                )
        );
    }

    @Bean("keycloakAuthorizor")
    public Authorizor keycloakAuthorizor() {
        return new KeycloakAuthorizor(authzClient());
    }
}
