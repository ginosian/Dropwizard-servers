package org.dropwizard.test.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{
    private String name;

    public User(final Long id, final Boolean deleted, final String name) {
        super(id, deleted);
        this.name = name;
    }
}
