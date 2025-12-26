package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.OutputAllStudentsConsoleStrategy;

public class OutputAllStudentsConsole extends Handler{
    public OutputAllStudentsConsole() {
        this.responseStrategy = new OutputAllStudentsConsoleStrategy();
    }
}
