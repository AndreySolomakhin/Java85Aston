package example.gradle.bigproject.handlerresponse;

import example.gradle.bigproject.handlerresponse.strategy.ResponseStrategy;

public class Handler {

    ResponseStrategy responseStrategy;

    public void handleResponse(){
        responseStrategy.handleResponse();
    }
}
