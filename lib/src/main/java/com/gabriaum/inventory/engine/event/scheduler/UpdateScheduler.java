package com.gabriaum.inventory.engine.event.scheduler;

import com.gabriaum.inventory.engine.event.UpdateEvent;
import com.gabriaum.inventory.engine.event.type.UpdateType;

public class UpdateScheduler implements Runnable {

    private long totalTicks;

    @Override
    public void run() {
        totalTicks++;

        if (totalTicks % 20 == 0)
            new UpdateEvent(UpdateType.SECOND, totalTicks).push();
    }
}
