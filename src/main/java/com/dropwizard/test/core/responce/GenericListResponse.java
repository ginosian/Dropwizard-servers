package com.dropwizard.test.core.responce;

import java.util.ArrayList;
import java.util.List;

public class GenericListResponse<T> {

    private long totalItems;

    private List<T> items = new ArrayList<>();

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
