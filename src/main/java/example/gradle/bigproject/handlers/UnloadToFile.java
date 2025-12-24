package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.UnloadToFileStrategy;

public class UnloadToFile extends Handler{
    public UnloadToFile() {
        this.responseStrategy = new UnloadToFileStrategy();
    }
}
