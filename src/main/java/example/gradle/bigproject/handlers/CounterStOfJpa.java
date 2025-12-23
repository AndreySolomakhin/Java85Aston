package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.CounterStOfJpaStrategy;

public class CounterStOfJpa extends Handler {
    public CounterStOfJpa() {
        this.responseStrategy = new CounterStOfJpaStrategy();
    }
}
