package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.FillFromFileStrategy;

public class FillFromFile extends Handler{
    public FillFromFile() {
        this.responseStrategy = new FillFromFileStrategy();
    }
}
