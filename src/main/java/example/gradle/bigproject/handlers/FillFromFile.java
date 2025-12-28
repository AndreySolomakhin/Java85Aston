package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.fill.FillFromFileStrategy;

public class FillFromFile extends Handler{
    public FillFromFile() {
        this.responseStrategy = new FillFromFileStrategy();
    }
}
