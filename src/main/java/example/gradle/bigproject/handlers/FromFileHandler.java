package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.FromFileResponseStrategy;

public class FromFileHandler extends Handler{
    public FromFileHandler() {
        this.responseStrategy = new FromFileResponseStrategy();
    }
}
