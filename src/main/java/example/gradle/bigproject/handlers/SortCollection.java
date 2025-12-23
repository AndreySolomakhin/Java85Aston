package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.SortCollectionStrategy;

public class SortCollection extends Handler{
    public SortCollection() {
        this.responseStrategy = new SortCollectionStrategy();
    }
}
