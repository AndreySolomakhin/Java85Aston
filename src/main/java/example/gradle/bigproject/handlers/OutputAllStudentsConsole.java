package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.output.OutputAllStudentsConsoleStrategy;

public class OutputAllStudentsConsole extends Handler{
    public OutputAllStudentsConsole() {
        this.responseStrategy = new OutputAllStudentsConsoleStrategy();
    }
}
