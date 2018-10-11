package com.dropwizard.test;

import com.dropwizard.test.config.DataSourceConfiguration;
import com.dropwizard.test.resource.impl.UserResourceImpl;
import com.dropwizard.test.service.UserService;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class DropwizardApplication  extends Application<DataSourceConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void run(final DataSourceConfiguration config, final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");

        // Register resources
        environment.jersey().register(new UserResourceImpl(jdbi.onDemand(UserService.class)));
    }

    @Override
    public void initialize(final Bootstrap<DataSourceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<DataSourceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DataSourceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }
}
