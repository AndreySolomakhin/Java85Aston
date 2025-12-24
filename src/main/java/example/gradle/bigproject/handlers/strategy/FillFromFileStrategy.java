package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.ui.UserInterface;
import example.gradle.bigproject.validators.StudentValidator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FillFromFileStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        // Указываем твой файл
        String filePath = "output_students.txt";
        System.out.println(" Начинаем чтение данных из файла: " + filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                // Пропускаем пустые строки, если они есть
                if (line.trim().isEmpty()) continue;

                // Разделяем строку по символу "|"
                // Используем \\|, так как | — это спецсимвол в регулярных выражениях
                String[] parts = line.split("\\|");

                if (parts.length >= 3) {
                    try {
                        /* ПАРСИНГ: убираем названия полей, оставляем только суть
                           parts[0] это "Студент: Имя" -> делим по ":" и берем вторую часть [1]
                        */
                        String name = parts[0].split(":")[1].trim();// Берем то, что после "Студент:"
                        String recordStr = parts[1].split(":")[1].trim();// Берем то, что после "Зачетка:"
                        String gpaStr = parts[2].split(":")[1].trim();// Берем то, что после "Балл:"

                        // Преобразуем строки в числа
                        int recordNumber = Integer.parseInt(recordStr);
                        int gpa = Integer.parseInt(gpaStr);

                        // Создаем объект через Builder
                        Student student = new Student.StudentBuilder()
                                .setStudentName(name)
                                .setRecordBookNumber(recordNumber)
                                .setGpa(gpa)
                                .build();

                        // ВАЛИДАЦИЯ
                        if (StudentValidator.validate(student)) {
                            Student.studentList.add(student);
                            count++;
                        } else {
                            System.out.println(" Студент не прошел валидацию: " + name);
                        }

                    } catch (Exception e) {
                        System.out.println(" Не удалось обработать строку: " + line);
                    }
                }
            }
            System.out.println(" Загрузка успешно завершена! Добавлено студентов: " + count);

        } catch (IOException e) {
            System.out.println(" Ошибка: Файл '" + filePath + "' не найден.");
        }
    }
}