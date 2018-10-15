package com.dropwizard.client.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserCreationRequestDto {
    @NotEmpty
    private String name;
}
