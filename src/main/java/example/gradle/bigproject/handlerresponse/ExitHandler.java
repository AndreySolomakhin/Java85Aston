package example.gradle.bigproject.handlerresponse;

import example.gradle.bigproject.handlerresponse.strategy.ExitResponseStrategy;

public class ExitHandler extends Handler{
    public ExitHandler() {
        this.responseStrategy = new ExitResponseStrategy();
    }
}
