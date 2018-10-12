package org.dropwizard.test.core.request;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private long id;
    private String name;
}
