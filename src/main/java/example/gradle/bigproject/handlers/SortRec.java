package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.sort.SortRecStrategy;

public class SortRec extends Handler{
    public SortRec() {
        this.responseStrategy = new SortRecStrategy();
    }
}
