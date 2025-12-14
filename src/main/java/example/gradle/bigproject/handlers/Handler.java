package example.gradle.bigproject.handlers;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;

public class Handler {

    ResponseStrategy responseStrategy;

    public void handleResponse(){
        responseStrategy.handleResponse();
    }
}
