package com.dropwizard.test.core.responce;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenericListResponse<T> {
    private long totalItems;
    private List<T> items = new ArrayList<>();
}
