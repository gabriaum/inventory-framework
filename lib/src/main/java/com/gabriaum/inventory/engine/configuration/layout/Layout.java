package com.gabriaum.inventory.engine.configuration.layout;

import com.gabriaum.inventory.engine.configuration.layout.frame.Frame;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Layout {

    private final int slot;
    private final Frame frame;
}
