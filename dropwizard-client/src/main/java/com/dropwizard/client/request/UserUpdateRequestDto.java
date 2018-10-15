package com.dropwizard.client.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

@Data
public class UserUpdateRequestDto {

    @Min(1)
    private long id;

    @NotEmpty
    private String name;
}
