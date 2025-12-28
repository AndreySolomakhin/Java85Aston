package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.MtrSearchByGpaAscStrategy;

public class MtrSearchByGpaAsc extends Handler{
    public MtrSearchByGpaAsc() {
        this.responseStrategy = new MtrSearchByGpaAscStrategy();
    }
}
