package com.dropwizard.test.core.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{
    private String name;

    public User(final Long id, final Boolean deleted, final String name) {
        super(id, deleted);
        this.name = name;
    }
}
