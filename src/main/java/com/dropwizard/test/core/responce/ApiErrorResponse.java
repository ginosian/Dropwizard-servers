package com.dropwizard.test.core.responce;

import com.dropwizard.test.core.error.ApiError;
import lombok.Data;

@Data
public class ApiErrorResponse {
    private ApiError error;
    private int responseStatusCode;
    private String message;
}
