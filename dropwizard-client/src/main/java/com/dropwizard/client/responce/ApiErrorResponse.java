package com.dropwizard.client.responce;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private int responseStatusCode;
    private final String message;
}
