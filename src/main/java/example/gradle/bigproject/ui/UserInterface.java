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

    private static final String[] OPTIONS_LOAD_WINDOW = {
            "Вручную",
            "Из файла",
            "Рандомно",
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

            case 0 ->
                    handleChooseLoadWindow(loadWindow());                                        //Заполнить список студентов
            case 1 ->
                    System.out.println("Здесь сортировка списка");                               //Произвести сортировку списка
            case 2 ->
                    System.out.println("Здесь выгрузка в файл");                                 //Выгрузить список студентов в файл",
            case 3 ->
                    System.out.println("Здесь подсчет кол-ва студентов по gpa");                 //Подсчитать количество студентов по среднему баллу",
            case 4 ->
                    System.out.println("Здесь вывод полного списка студентов в консоль");        //Показать список всех студентов",
            case 5 -> new ExitHandler().handleResponse();                                        //Выйти из программы"
        }
    }

    private static void handleChooseLoadWindow(int indexChooseLoadWindow) {
        switch (indexChooseLoadWindow) {

            case 0 -> new ManuallyHandler().handleResponse(); //Ручной ввод
            case 1 -> new FromFileHandler().handleResponse(); //Ввод из файла
            case 2 -> new RandomHandler().handleResponse();   //Случайный набор
            case 3 -> new ExitHandler().handleResponse();     //Выйти из программы
        }
    }

    private static void sortCollection() {

    }

    private static void unloadingToFile() {

    }

    private static void getCountByGpa() {

    }

    private static void getAllStudents() {

    }


}
