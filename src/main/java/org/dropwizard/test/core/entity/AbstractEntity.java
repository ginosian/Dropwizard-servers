package org.dropwizard.test.core.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AbstractEntity {
    private Long id;
    private Boolean deleted;
}
