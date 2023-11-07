package io.github.khietbt.configurations;

import io.github.khietbt.authorizors.Authorizor;
import io.github.khietbt.managers.SesameReactiveAuthorizationManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;

public class SesameKeycloakSecurityConfiguration {
    private final RequestMappingHandlerMapping handlers;

    private final Authorizor authorizor;

    public SesameKeycloakSecurityConfiguration(
            RequestMappingHandlerMapping handlers,
            @Qualifier("keycloakAuthorizor") Authorizor authorizor
    ) {
        this.handlers = handlers;
        this.authorizor = authorizor;
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(
            ServerHttpSecurity http
    ) {
        http.authorizeExchange(
                c -> c.pathMatchers("/**")
                        .access(new SesameReactiveAuthorizationManager(handlers, authorizor))
                        .anyExchange()
                        .authenticated()
        );
        http.oauth2ResourceServer(c -> c.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
