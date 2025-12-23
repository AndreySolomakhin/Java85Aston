package example.gradle.bigproject.ui;

import example.gradle.bigproject.handlers.*;

import javax.swing.*;

public class UserInterface {

    private static final String[] OPTIONS_START_WINDOW = {
            "Заполнить список студентов",
            "Произвести сортировку списка",
            "Выгрузить список студентов в файл",
            "Подсчитать количество студентов по среднему баллу",
            "Показать список всех студентов",
            "Выйти из программы"};

    public static boolean isWork = true;

    public static int helloWindow() {

        return JOptionPane.showOptionDialog(null,
                "Добрый день. Что будем делать?",
                "Добро пожаловать",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_START_WINDOW, null);
    }

    public static void handleChooseStarWindow(int indexChooseStartWindow) {
        switch (indexChooseStartWindow) {

            case 0 ->
                    new FillCollection().handleResponse();                                        //Заполнить список студентов
            case 1 ->
                    new SortCollection().handleResponse();                                //Произвести сортировку списка
            case 2 ->
                    new OutputToFile().handleResponse();                                 //Выгрузить список студентов в файл",
            case 3 ->
                    new CounterStOfJpa().handleResponse();                //Подсчитать количество студентов по среднему баллу",
            case 4 ->
                    new OutputToConsole().handleResponse();        //Показать список всех студентов",
            case 5 ->
                    new Exit().handleResponse();                                        //Выйти из программы"
        }
    }
}
