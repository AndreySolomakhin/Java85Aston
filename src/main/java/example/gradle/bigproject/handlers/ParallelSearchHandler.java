package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.ParallelSearchResponseStrategy;

public class ParallelSearchHandler extends Handler{
    public ParallelSearchHandler(){
        this.responseStrategy = new ParallelSearchResponseStrategy();
    }
}
