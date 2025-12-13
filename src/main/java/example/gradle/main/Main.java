package example.gradle.main;

import example.gradle.bigproject.ui.UserInterface;

public class Main {
    public static void main(String[] args){

        while (UserInterface.isWork){
            UserInterface.handleChoose(UserInterface.getChoose());
        }

    }
}
