package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.ExitResponseStrategy;

public class ExitHandler extends Handler{
    public ExitHandler() {
        this.responseStrategy = new ExitResponseStrategy();
    }
}
