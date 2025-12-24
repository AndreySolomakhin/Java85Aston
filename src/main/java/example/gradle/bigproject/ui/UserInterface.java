package example.gradle.bigproject.ui;


import example.gradle.bigproject.handlers.*;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.sorting.collection.CustomArrayList;
import example.gradle.bigproject.sorting.collection.BubbleSortStrategy;
import example.gradle.bigproject.model.Student;
import sorting.collection.EvenRecordBookSorter;
import sorting.collection.StudentSorter;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class UserInterface {
    // Наша коллекция
    public static CustomArrayList<Student> currentList = new CustomArrayList<>();

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

            case 0 ->
                    handleChooseLoadWindow(loadWindow());                                        //Заполнить список студентов
            case 1 ->
                    sortCollection();                                                            //Произвести сортировку списка
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
        if (Student.studentList.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Список студентов пуст. Сначала заполните его.",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        StudentSorter sorter = new EvenRecordBookSorter();
        sorter.sort(Student.studentList);

        JOptionPane.showMessageDialog(null,
                "Сортировка выполнена.\n" +
                        "Студенты с чётным номером зачетки отсортированы по возрастанию.",
                "Успех",
                JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Выгрузка текущего списка в текстовый файл
     */
    private static void unloadingToFile() {
        if (currentList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Нечего сохранять. Список пуст.");
            return;
        }

        try (FileWriter writer = new FileWriter("output_students.txt", true)) { //В режиме добавления
            for (Student s : currentList) {
                writer.write(s.toString() + "\n");
            }
            JOptionPane.showMessageDialog(null, "Данные успешно сохранены в файл output_students.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка при записи в файл: " + e.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Вывод всех студентов.
     * Теперь выводит не только в консоль, но и в красивое окно.
     */
    private static void getAllStudents() {
        if (currentList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Список студентов пуст.");
            return;
        }

        StringBuilder sb = new StringBuilder("Список студентов:\n\n");
        for (Student s : currentList) {
            sb.append(s.toString()).append("\n");
            System.out.println(s); // Оставляем вывод в консоль для отладки
        }

        // Создаем прокручиваемую область для большого списка
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Текущая база студентов", JOptionPane.PLAIN_MESSAGE);
    }
}