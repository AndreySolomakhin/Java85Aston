package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.FillRandomStrategy;

public class FillRandom extends Handler{
    public FillRandom() {
        this.responseStrategy = new FillRandomStrategy();
    }
}
