package example.gradle.bigproject.handlers.strategy.output;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputAllStudentsFileStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        unloadingToFile();
    }

    private static void unloadingToFile() {
        if (Student.studentList.size() == 0) {
            JOptionPane.showMessageDialog(null, "Нечего сохранять. Список пуст.");
            return;
        }
        File file = new File("src/main/resources/output_students.txt");
        file.delete();
        try (FileWriter writer = new FileWriter(file, true)) { //В режиме добавления
            for (Student s : Student.studentList) {
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
}
