package io.github.khietbt.annotations;

import io.github.khietbt.selectors.SesameKeycloakSecuritySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SesameKeycloakSecuritySelector.class)
public @interface EnableSesameKeycloakSecurityConfiguration {
    boolean value() default true;
}
