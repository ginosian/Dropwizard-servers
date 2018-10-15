package com.dropwizard.client.responce;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenericListResponse<T> {
    private long totalItems;
    private List<T> items = new ArrayList<>();
}
