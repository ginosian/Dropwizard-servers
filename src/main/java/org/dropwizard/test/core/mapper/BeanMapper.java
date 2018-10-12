package org.dropwizard.test.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.dropwizard.test.core.entity.User;
import org.dropwizard.test.service.model.UserCreationRequest;

public class BeanMapper extends ConfigurableMapper {

    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(UserCreationRequest.class, User.class)
                .constructorA()
                .exclude("id")
                .exclude("deleted")
                .constructorB()
                .byDefault()
                .register();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
    }
}
