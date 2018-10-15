package org.dropwizard.test.service.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserCreationRequest {
    @NotEmpty
    private String name;
}
