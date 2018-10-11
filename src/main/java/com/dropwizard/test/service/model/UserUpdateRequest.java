package com.dropwizard.test.service.model;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private long id;
    private String name;
}
