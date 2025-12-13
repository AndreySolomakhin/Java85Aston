package example.gradle.bigproject.handlerresponse;

import example.gradle.bigproject.handlerresponse.strategy.FromFileResponseStrategy;

public class FromFileHandler extends Handler{
    public FromFileHandler() {
        this.responseStrategy = new FromFileResponseStrategy();
    }
}
