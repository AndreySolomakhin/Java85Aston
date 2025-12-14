package example.gradle.bigproject;

import example.gradle.bigproject.ui.UserInterface;

public class Main {
    public static void main(String[] args){

        while (UserInterface.isWork){
            UserInterface.handleChooseStarWindow(UserInterface.helloWindow());
        }

    }
}
