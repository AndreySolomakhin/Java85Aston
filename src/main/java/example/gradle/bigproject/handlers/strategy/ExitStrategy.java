package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.ui.UserInterface;

public class ExitStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        UserInterface.isWork = false;
        System.out.println("Вы прекратили работу приложения");
    }
}
