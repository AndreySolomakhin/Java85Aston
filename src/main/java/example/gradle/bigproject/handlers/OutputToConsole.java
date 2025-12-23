package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.OutputToConsoleStrategy;

public class OutputToConsole extends Handler{
    public OutputToConsole() {
        this.responseStrategy = new OutputToConsoleStrategy();
    }
}
