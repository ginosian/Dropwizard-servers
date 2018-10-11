package com.dropwizard.test.core.responce;

public class ApiResponse<T>  {
    ApiErrorResponse errorResponce;
    T apiResponse;

    public ApiErrorResponse getErrorResponce() {
        return errorResponce;
    }

    public void setErrorResponce(ApiErrorResponse errorResponce) {
        this.errorResponce = errorResponce;
    }

    public T getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(T apiResponse) {
        this.apiResponse = apiResponse;
    }
}
