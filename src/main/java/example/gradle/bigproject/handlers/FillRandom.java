package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.fill.FillRandomStrategy;

public class FillRandom extends Handler{
    public FillRandom() {
        this.responseStrategy = new FillRandomStrategy();
    }
}
