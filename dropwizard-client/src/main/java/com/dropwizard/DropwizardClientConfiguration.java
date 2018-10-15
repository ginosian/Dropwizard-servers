package com.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
public class DropwizardClientConfiguration extends Configuration {

    @NotNull
    @Valid
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotEmpty
    @JsonProperty("template")
    private String template;

    @NotEmpty
    @JsonProperty("defaultName")
    private String defaultName = "Marta";
}
