package example.gradle.bigproject.ui;

import example.gradle.bigproject.handlers.*;
import javax.swing.*;

public class UserInterface {

    public static boolean isWork = true;

    // Массивы для меню
    private static final String[] OPTIONS_START_WINDOW = {
            "Заполнить список студентов",
            "Произвести сортировку списка",
            "Выгрузить список студентов в файл",
            "Подсчитать количество студентов по среднему баллу",
            "Показать список всех студентов",
            "Выйти из программы"};

    public static final String[] OPTIONS_LOAD_WINDOW = {
            "Вручную",
            "Из файла",
            "Рандомно",
            "Выйти из программы"};

    /**
     * Главное окно
     */
    public static int helloWindow() {
        return JOptionPane.showOptionDialog(null,
                "Добро пожаловать в систему управления студентами!\nВыберите действие:",
                "Главное меню",
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
            case 0 -> handleChooseLoadWindow(loadWindow());
            case 1 -> new EvenSortCollection().handleResponse();
            case 2 -> new OutputAllStudentsFile().handleResponse();
            case 3 -> new CounterStWithJPA().handleResponse();
            case 4 -> new OutputAllStudentsConsole().handleResponse();
            case 5 -> new Exit().handleResponse();
        }
    }

    public static void handleChooseLoadWindow(int indexChooseLoadWindow) {
        switch (indexChooseLoadWindow) {
            case 0 -> new FillManually().handleResponse();
            case 1 -> new FillFromFile().handleResponse();
            case 2 -> new FillRandom().handleResponse();
            case 3 -> new Exit().handleResponse();
        }
    }
}