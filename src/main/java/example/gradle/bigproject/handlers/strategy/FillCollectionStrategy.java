package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.handlers.Exit;
import example.gradle.bigproject.handlers.FillFromFile;
import example.gradle.bigproject.handlers.FillManually;
import example.gradle.bigproject.handlers.FillRandom;

import javax.swing.*;

public class FillCollectionStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        handleChooseLoadWindow(loadWindow());
    }

    private static final String[] OPTIONS_LOAD_WINDOW = {
            "Вручную",
            "Из файла",
            "Рандомно",
            "Выйти из программы"};

    private static void handleChooseLoadWindow(int indexChooseLoadWindow) {
        switch (indexChooseLoadWindow) {

            case 0 -> new FillManually().handleResponse(); //Ручной ввод
            case 1 -> new FillFromFile().handleResponse(); //Ввод из файла
            case 2 -> new FillRandom().handleResponse();   //Случайный набор
            case 3 -> new Exit().handleResponse();     //Выйти из программы
        }
    }

    private static int loadWindow() {

        return JOptionPane.showOptionDialog(null,
                "Какой вариант заполнения списка выберите?",
                "Варианты заполнения списка",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_LOAD_WINDOW, null);
    }
}
