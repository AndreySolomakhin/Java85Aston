package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.sort.SortNameStrategy;

public class SortName extends Handler{
    public SortName() {
        this.responseStrategy = new SortNameStrategy();
    }
}
