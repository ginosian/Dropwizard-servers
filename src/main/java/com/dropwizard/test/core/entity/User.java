package com.dropwizard.test.core.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{
    private String name;

    public User(String id, String name) {
        super(id);
        this.name = name;
    }
}
