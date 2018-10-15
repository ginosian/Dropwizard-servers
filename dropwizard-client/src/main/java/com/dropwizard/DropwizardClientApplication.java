package com.dropwizard;

import com.dropwizard.client.api.ApiClient;
import com.dropwizard.client.api.impl.ApiClientImpl;
import com.dropwizard.resource.impl.UserResourceImpl;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import zone.dragon.dropwizard.HK2Bundle;

import javax.ws.rs.client.Client;

public class DropwizardClientApplication extends Application<DropwizardClientConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardClientApplication().run(args);
    }

    @Override
    public String getName() {
        return "Swagger";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardClientConfiguration> bootstrap) {

        HK2Bundle.addTo(bootstrap);

        bootstrap.addBundle(new SwaggerBundle<DropwizardClientConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropwizardClientConfiguration config) {
                return config.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final DropwizardClientConfiguration configuration,
                    final Environment environment) {

        JerseyEnvironment jersey = environment.jersey();

        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClient()).build(getName());
        environment.jersey().register(new ApiClientImpl(client));

        jersey.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new ApiClientImpl(client)).to(ApiClient.class);
            }
        });
        jersey.register(UserResourceImpl.class);
    }
}
