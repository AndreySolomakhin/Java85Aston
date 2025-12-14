package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.RandomResponseStrategy;

public class RandomHandler extends Handler{
    public RandomHandler() {
        this.responseStrategy = new RandomResponseStrategy();
    }
}
