package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.multithread.MtrSearchByNameStrategy;

public class MtrSearchByName extends Handler{
    public MtrSearchByName() {
        this.responseStrategy = new MtrSearchByNameStrategy();
    }
}
