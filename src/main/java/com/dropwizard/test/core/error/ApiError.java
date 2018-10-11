package com.dropwizard.test.core.error;

import lombok.Data;

@Data
public class ApiError {
    private Throwable throwable;
}
