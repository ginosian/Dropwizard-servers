package com.dropwizard.client.api;

import com.dropwizard.client.UserResource;

import java.io.Closeable;

public interface ApiClient  extends Closeable {
    UserResource user();
}
