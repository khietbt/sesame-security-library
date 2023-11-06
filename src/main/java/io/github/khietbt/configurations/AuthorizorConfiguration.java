package io.github.khietbt.configurations;

import io.github.khietbt.authorizors.Authorizor;
import io.github.khietbt.authorizors.DefaultAuthorizor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AuthorizorConfiguration {
    @Bean("defaultAuthorizor")
    @Primary
    public Authorizor defaultAuthorizor() {
        return new DefaultAuthorizor();
    }
}
