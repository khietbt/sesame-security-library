package io.github.khietbt.configurations;

import io.github.khietbt.authorizors.Authorizor;
import io.github.khietbt.authorizors.DenyAllAuthorizor;
import io.github.khietbt.authorizors.PermitAllAuthorizor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AuthorizorConfiguration {
    @Bean("denyAllAuthorizor")
    @Primary
    public Authorizor denyAllAuthorizor() {
        return new DenyAllAuthorizor();
    }

    @Bean
    public Authorizor permitAllAuthorizor() {
        return new PermitAllAuthorizor();
    }
}
