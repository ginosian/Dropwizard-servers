package com.dropwizard.client.responce;

import lombok.Data;
import org.dropwizard.test.core.error.ApiError;

@Data
public class ApiErrorResponse {
    private ApiError error;
    private int responseStatusCode;
    private final String message;
}
