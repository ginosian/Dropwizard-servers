package com.dropwizard.client.responce;

import lombok.Data;

@Data
public class Response<T>  {
    private ApiErrorResponse errorResponse;
    private T apiResponse;
}
