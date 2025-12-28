package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.sort.SortAllFieldStrategy;

public class SortAllField extends Handler{
    public SortAllField() {
        this.responseStrategy = new SortAllFieldStrategy();
    }
}
