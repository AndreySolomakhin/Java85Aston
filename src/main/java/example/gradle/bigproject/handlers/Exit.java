package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.ExitStrategy;

public class Exit extends Handler{
    public Exit() {
        this.responseStrategy = new ExitStrategy();
    }
}
