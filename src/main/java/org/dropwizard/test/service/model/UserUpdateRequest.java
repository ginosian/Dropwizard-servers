package org.dropwizard.test.service.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

@Data
public class UserUpdateRequest {
    @NotEmpty
    private String name;

    @Min(1)
    private long id;
}
