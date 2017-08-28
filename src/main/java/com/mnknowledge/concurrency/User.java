package com.mnknowledge.concurrency;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stanislav Petrov
 */
public final class User {
    private final String name;
    private List<String> orders;

    public User(String name) {
        this.name = name;
    }

    public User(String name, List<String> orders) {
        this.name = name;
        this.orders = new ArrayList<>(orders);
    }

    public List<String> getOrders() {
        return new ArrayList<>(orders);
    }

    public String getName() {
        return name;
    }
}
