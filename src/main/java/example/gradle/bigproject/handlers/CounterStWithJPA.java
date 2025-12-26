package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.CounterStWithJPAStrategy;

public class CounterStWithJPA extends Handler{
    public CounterStWithJPA() {
        this.responseStrategy = new CounterStWithJPAStrategy();
    }
}
