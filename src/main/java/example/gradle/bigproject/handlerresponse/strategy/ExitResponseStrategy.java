package example.gradle.bigproject.handlerresponse.strategy;

import example.gradle.bigproject.ui.UserInterface;

public class ExitResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        UserInterface.isWork = false;
        System.out.println("Вы прекратили работу приложения");
    }
}
