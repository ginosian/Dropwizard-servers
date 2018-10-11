package com.dropwizard.test;

import com.dropwizard.test.config.DataSourceConfiguration;
import com.dropwizard.test.resource.impl.UserResourceImpl;
import com.dropwizard.test.service.UserService;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class DropwizardApplication  extends Application<DataSourceConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public void run(DataSourceConfiguration config, Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");

        // Register resources
        environment.jersey().register(new UserResourceImpl(jdbi.onDemand(UserService.class)));
    }
}
