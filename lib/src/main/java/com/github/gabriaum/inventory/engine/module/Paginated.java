package com.github.gabriaum.inventory.engine.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public abstract class Paginated<T> {

    private final String title;
    private final int size;

    public Paginated(String title, int size) {
        this.title = title;
        this.size = 9 * size;
    }
}
