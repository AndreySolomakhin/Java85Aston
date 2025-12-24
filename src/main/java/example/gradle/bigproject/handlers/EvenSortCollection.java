package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.EvenSortCollectionStrategy;

public class EvenSortCollection extends Handler {
    public EvenSortCollection() {
        this.responseStrategy = new EvenSortCollectionStrategy();
    }
}
