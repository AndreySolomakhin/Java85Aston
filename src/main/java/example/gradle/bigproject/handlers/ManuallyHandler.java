package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.ManuallyResponseStrategy;

public class ManuallyHandler extends Handler{
    public ManuallyHandler() {
        this.responseStrategy = new ManuallyResponseStrategy();
    }
}
