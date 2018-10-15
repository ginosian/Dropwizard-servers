package com.dropwizard.client.api.impl;

import com.dropwizard.client.UserApiResource;
import com.dropwizard.client.api.ApiClient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.message.GZipEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

public class ApiClientImpl implements ApiClient {

    private static final String BASE_URL = "https://localhost:8081";

    private final UserApiResource userApiResource;

    public ApiClientImpl(final Client client) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        client.register(new JacksonJsonProvider(mapper));
        client.property(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);
        client.register(GZipEncoder.class);
        client.register(EncodingFilter.class);

        final WebTarget rootTarget = client.target(BASE_URL);

        userApiResource = new UserApiResource(client, rootTarget);
    }

    @Override
    public UserApiResource user() {
        return userApiResource;
    }

    @Override
    public void close() throws IOException {
    }
}
