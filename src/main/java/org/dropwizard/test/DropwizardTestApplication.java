package org.dropwizard.test;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.dropwizard.test.dao.UserDAO;
import org.dropwizard.test.resource.impl.UserResourceImpl;
import org.dropwizard.test.service.UserService;
import org.dropwizard.test.service.impl.UserServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jdbi.v3.core.Jdbi;
import zone.dragon.dropwizard.HK2Bundle;

public class DropwizardTestApplication extends Application<DropwizardTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "Swagger";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardTestConfiguration> bootstrap) {

        HK2Bundle.addTo(bootstrap);

        bootstrap.addBundle(new SwaggerBundle<DropwizardTestConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropwizardTestConfiguration config) {
                return config.getSwaggerBundleConfiguration();
            }
        });
        bootstrap.addBundle(new MigrationsBundle<DropwizardTestConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DropwizardTestConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
    }

    @Override
    public void run(final DropwizardTestConfiguration configuration,
                    final Environment env) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(env, configuration.getDatabase(), "postgresql");
        JerseyEnvironment jersey = env.jersey();

        jersey.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new UserServiceImpl(jdbi.onDemand(UserDAO.class))).to(UserService.class);
            }
        });

        jersey.register(UserResourceImpl.class);

    }

}
