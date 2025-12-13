package example.gradle.bigproject.handlerresponse;

import example.gradle.bigproject.handlerresponse.strategy.ManuallyResponseStrategy;

public class ManuallyHandler extends Handler{
    public ManuallyHandler() {
        this.responseStrategy = new ManuallyResponseStrategy();
    }
}
