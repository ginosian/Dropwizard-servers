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

    public User(Long id, Boolean deleted, String name) {
        super(id, deleted);
        this.name = name;
    }
}
