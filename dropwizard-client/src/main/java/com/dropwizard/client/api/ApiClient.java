package com.dropwizard.client.api;


import com.dropwizard.client.UserApiResource;

import java.io.Closeable;

public interface ApiClient extends Closeable {
    UserApiResource user();
}
