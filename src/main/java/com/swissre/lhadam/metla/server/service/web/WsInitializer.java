package com.swissre.lhadam.metla.server.service.web;

import jakarta.ws.rs.core.Application;

import java.util.Set;

public class WsInitializer extends Application {

    @Override
    public Set<Object> getSingletons() {
        return Set.of(new GreetingResource());
    }
}
