package com.dropwizard.test.core.responce;

import lombok.Data;

@Data
public class ApiResponse<T>  {
    private ApiErrorResponse errorResponse;
    private T apiResponse;
}
