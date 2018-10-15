package org.dropwizard.test;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
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
public class DropwizardTestConfiguration extends Configuration {
    @NotNull
    @Valid
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotNull
    @Valid
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @NotEmpty
    @JsonProperty("template")
    private String template;

    @NotEmpty
    @JsonProperty("defaultName")
    private String defaultName = "Marta";
}
