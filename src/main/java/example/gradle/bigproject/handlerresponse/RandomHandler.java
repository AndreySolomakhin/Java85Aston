package example.gradle.bigproject.handlerresponse;

import example.gradle.bigproject.handlerresponse.strategy.RandomResponseStrategy;

public class RandomHandler extends Handler{
    public RandomHandler() {
        this.responseStrategy = new RandomResponseStrategy();
    }
}
