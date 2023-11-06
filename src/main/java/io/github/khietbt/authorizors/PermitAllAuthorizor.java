package io.github.khietbt.authorizors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class PermitAllAuthorizor implements Authorizor {

    @Override
    public boolean authorize(String jwt, String resource, String scope) {
        return true;
    }
}
