package io.github.khietbt.authorizors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.authorization.client.AuthorizationDeniedException;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;

@RequiredArgsConstructor
@Slf4j
public class KeycloakAuthorizor implements Authorizor {
    private final AuthzClient authzClient;

    @Override
    public boolean authorize(String jwt, String resource, String scope) {
        try {
            var request = new AuthorizationRequest();
            request.addPermission(resource, scope);

            authzClient.authorization(jwt).authorize(request);
        } catch (AuthorizationDeniedException ignored) {
            return false;
        }

        return true;
    }
}
