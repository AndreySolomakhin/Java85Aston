package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.OutputToFileStrategy;

public class OutputToFile extends Handler{
    public OutputToFile() {
        this.responseStrategy = new OutputToFileStrategy();
    }
}
