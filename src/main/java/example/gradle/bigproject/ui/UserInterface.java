package example.gradle.bigproject.ui;

import example.gradle.bigproject.handlers.*;
import example.gradle.bigproject.handlers.strategy.sort.EvenSortCollectionStrategy;

import javax.swing.*;

public class UserInterface {

    // Главное меню
    private static final String[] OPTIONS_START_WINDOW = {
            "Заполнить список студентов",
            "Произвести сортировку списка",
            "Выгрузить список студентов в файл",
            "Многопоточный поиск",
            "Показать список всех студентов",
            "Выйти из программы"};

    private static final String[] OPTIONS_LOAD_WINDOW = {
            "Вручную",
            "Из файла",
            "Рандомно",
            "Выйти из программы"};

    private static final String[] OPTIONS_MULTITHREAD = {
            "По имени",
            "По конкретному GPA",
            "По GPA >= установленному"};

    private static final String[] OPTIONS_SORT = {
            "По имени",
            "По номеру зачетки",
            "По GPA",
            "По всем полям",
            "Сортировка четных номеров"};

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

    private static int multithreadWindow() {

        return JOptionPane.showOptionDialog(null,
                "Какой вариант поиска выберете?",
                "Варианты поиска",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_MULTITHREAD, null);
    }

    private static int sortVarWindow() {

        return JOptionPane.showOptionDialog(null,
                "Какой вариант сортировки выберете?",
                "Варианты сортировки",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, OPTIONS_SORT, null);
    }

    public static void handleChooseStarWindow(int indexChooseStartWindow) {
        switch (indexChooseStartWindow) {

            case 0 -> handleChooseLoadWindow(loadWindow());
            case 1 -> sortChooseWindow(sortVarWindow());
            case 2 -> new OutputAllStudentsFile().handleResponse();
            case 3 -> multithreadOperationsWindow(multithreadWindow());
            case 4 -> new OutputAllStudentsConsole().handleResponse();
            case 5 -> new Exit().handleResponse();
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

    private static void multithreadOperationsWindow(int indexChooseOperation) {

        switch (indexChooseOperation) {
            case 0 -> new MtrSearchByName().handleResponse();
            case 1 -> new MtrSearchByGpaFix().handleResponse();
            case 2 -> new MtrSearchByGpaAsc().handleResponse();
        }
    }

    private static void sortChooseWindow(int indexChooseOperation) {

        switch (indexChooseOperation) {
            case 0 -> new SortName().handleResponse();
            case 1 -> new SortRec().handleResponse();
            case 2 -> new SortGpa().handleResponse();
            case 3 -> new SortAllField().handleResponse();
            case 4 -> new EvenSortCollectionStrategy().handleResponse();
        }
    }
}