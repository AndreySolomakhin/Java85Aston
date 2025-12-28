package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.multithread.MtrSearchByGpaFixStrategy;

public class MtrSearchByGpaFix extends Handler{
    public MtrSearchByGpaFix() {
        this.responseStrategy = new MtrSearchByGpaFixStrategy();
    }
}
