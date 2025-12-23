package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.FillCollectionStrategy;

public class FillCollection extends Handler{
    public FillCollection() {
        this.responseStrategy = new FillCollectionStrategy();
    }
}
