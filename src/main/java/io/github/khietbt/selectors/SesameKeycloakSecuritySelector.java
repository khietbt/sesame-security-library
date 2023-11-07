package io.github.khietbt.selectors;

import io.github.khietbt.configurations.SesameKeycloakSecurityConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class SesameKeycloakSecuritySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                SesameKeycloakSecurityConfiguration.class.getCanonicalName()
        };
    }
}
