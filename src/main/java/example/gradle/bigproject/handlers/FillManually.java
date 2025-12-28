package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.fill.FillManuallyStrategy;

public class FillManually extends Handler{
    public FillManually() {
        this.responseStrategy = new FillManuallyStrategy();
    }
}
