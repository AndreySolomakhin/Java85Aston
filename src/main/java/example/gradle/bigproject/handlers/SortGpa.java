package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.sort.SortGpaStrategy;

public class SortGpa extends Handler{
    public SortGpa() {
        this.responseStrategy = new SortGpaStrategy();
    }
}
