package com.github.gabriaum.inventory.listener;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.Plugin;

@Getter
@RequiredArgsConstructor
public class ListenerProctor {

    protected final Plugin plugin;

    public void registry(String packageName) {

    }
}
