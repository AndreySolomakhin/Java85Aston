package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.validators.StudentValidator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FillFromFileStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        String fileName = "output_students.txt";
        int count = 0;

        System.out.println("\n--- Загрузка студентов из файла ---");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;


                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    try {
                        // Чистим данные от меток "Студент:", "Зачетка:", "Балл:"
                        String name = parts[0].replace("Студент:", "").trim();
                        int recordNumber = Integer.parseInt(parts[1].replace("Зачетка:", "").trim());


                        double gpa = Double.parseDouble(parts[2].replace("Балл:", "").trim());

                        Student student = Student.builder()
                                .setStudentName(name)
                                .setGpa(gpa)
                                .setRecordBookNumber(recordNumber)
                                .build();

                        // Валидация всех негативных сценариев
                        if (StudentValidator.validate(student)) {
                            Student.studentList.add(student);
                            count++;

                            System.out.println("Добавлен: " + student.toString());
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(" Ошибка формата в строке: " + line);
                    }
                }
            }
            System.out.println("\n--- Загрузка завершена! Успешно добавлено студентов: " + count + " ---");

        } catch (IOException e) {
            System.out.println(" Ошибка: Файл '" + fileName + "' не найден. Сначала выгрузите данные в файл.");
        }
    }
}