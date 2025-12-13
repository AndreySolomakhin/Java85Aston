package example.gradle.bigproject;

import example.gradle.bigproject.ui.ChooseHandler;

public class Main {
    public static void main(String[] args){

        while (ChooseHandler.isWork){
            ChooseHandler.handleChoose(ChooseHandler.getChoose());
        }

    }
}
