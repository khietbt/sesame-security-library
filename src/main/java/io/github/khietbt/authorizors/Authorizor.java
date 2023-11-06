package io.github.khietbt.authorizors;

public interface Authorizor {
    boolean authorize(String jwt, String resource, String scope);
}
