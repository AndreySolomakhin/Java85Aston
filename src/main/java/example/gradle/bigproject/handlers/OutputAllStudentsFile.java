package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.output.OutputAllStudentsFileStrategy;

public class OutputAllStudentsFile extends Handler{
    public OutputAllStudentsFile() {
        this.responseStrategy = new OutputAllStudentsFileStrategy();
    }
}
