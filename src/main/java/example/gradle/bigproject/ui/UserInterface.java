package example.gradle.bigproject.ui;


import example.gradle.bigproject.handlers.*;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.collection.CustomArrayList;

import javax.swing.*;

public class UserInterface {

    // Главное меню
    private static final String[] OPTIONS_START_WINDOW = {
            "Заполнить список студентов",
            "Произвести сортировку списка",
            "Выгрузить список студентов в файл",
            "Подсчитать количество студентов по среднему баллу",
            "Показать список всех студентов",
            "Выйти из программы"};

    private static final String[] OPTIONS_LOAD_WINDOW = {
            "Вручную",
            "Из файла",
            "Рандомно",
            "Выйти из программы"};


    public static boolean isWork = true;

    /**
     * Отображает главное окно приветствия
     */
    public static int helloWindow() {

        return JOptionPane.showOptionDialog(null,
                "Добрый день. Что будем делать?",
                "Добро пожаловать",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_START_WINDOW, null);
    }

    private static int loadWindow() {

        return JOptionPane.showOptionDialog(null,
                "Какой вариант заполнения списка выберите?",
                "Варианты заполнения списка",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_LOAD_WINDOW, null);
    }

    public static void handleChooseStarWindow(int indexChooseStartWindow) {
        switch (indexChooseStartWindow) {

            case 0 -> handleChooseLoadWindow(loadWindow());                                        //Окно выбора варианта заполнения списка студентов
            case 1 -> new EvenSortCollection().handleResponse();                                   //Произвести сортировку списка по четным значениям поля (Задание 1)
            case 2 -> new OutputAllStudentsFile().handleResponse();                                 //Выгрузить список студентов в файл",
            case 3 -> new CounterStWithJPA().handleResponse();                //Подсчитать количество студентов по среднему баллу",
            case 4 -> new OutputAllStudentsConsole().handleResponse();        //Показать список всех студентов",
            case 5 -> new Exit().handleResponse();                                        //Выйти из программы"
        }
    }

    private static void handleChooseLoadWindow(int indexChooseLoadWindow) {
        switch (indexChooseLoadWindow) {

            case 0 -> new FillManually().handleResponse(); //Ручной ввод
            case 1 -> new FillFromFile().handleResponse(); //Ввод из файла
            case 2 -> new FillRandom().handleResponse();   //Случайный набор
            case 3 -> new Exit().handleResponse();     //Выйти из программы
        }
    }
    /**
     * Вывод всех студентов.
     * Теперь выводит не только в консоль, но и в красивое окно.
     */

}