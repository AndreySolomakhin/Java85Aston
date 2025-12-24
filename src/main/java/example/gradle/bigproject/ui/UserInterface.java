package example.gradle.bigproject.ui;


import example.gradle.bigproject.handlers.*;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.sorting.collection.CustomArrayList;
import example.gradle.bigproject.sorting.collection.BubbleSortStrategy;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class UserInterface {
    // Наша коллекция
    public static CustomArrayList<Student> currentList = new CustomArrayList<>();

    // Главное меню
    private static final String[] OPTIONS_START_WINDOW = {
            "Заполнить список", "Сортировать", "В файл", "Показать всех", "Выход"};

    public static boolean isWork = true;

    /**
     * Отображает главное окно приветствия
     */
    public static int helloWindow() {
        return JOptionPane.showOptionDialog(null,
                "Добро пожаловать в систему управления студентами!\nВыберите действие:",
                "Главное меню",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                OPTIONS_START_WINDOW,
                null);
    }

    /**
     * Обрабатывает выбор пользователя из главного меню
     */
    public static void handleChooseStarWindow(int index) {
        switch (index) {
            case 0 -> showFillMenu();     // Открываем подменю выбора способа заполнения
            case 1 -> sortCollection();   // Сортировка
            case 2 -> unloadingToFile();  // Сохранение в файл
            case 3 -> getAllStudents();   // Вывод списка
            case 4 -> isWork = false;     // Выход
        }
    }

    /**
     * Подменю для выбора стратегии заполнения (Ручной, Случайно, Файл)
     */
    private static void showFillMenu() {
        String[] fillOptions = {"Случайно", "Вручную", "Из файла", "Назад"};
        int choice = JOptionPane.showOptionDialog(null,
                "Каким способом заполнить список студентов?",
                "Выбор способа заполнения",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                fillOptions,
                fillOptions[0]);

        switch (choice) {
            case 0 -> new RandomHandler().handleResponse();   // Использует RandomResponseStrategy
            case 1 -> new ManuallyHandler().handleResponse(); // Использует ManuallyResponseStrategy
            case 2 -> new FromFileHandler().handleResponse(); // Использует FromFileResponseStrategy
        }
    }

    /**
     * Сортировка коллекции по GPA
     */
    private static void sortCollection() {
        if (currentList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Список пуст! Сначала добавьте студентов.");
            return;
        }
        new BubbleSortStrategy<Student>().sort(currentList, Student.BY_GPA);
        JOptionPane.showMessageDialog(null, "Список успешно отсортирован по среднему баллу (GPA)!");
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