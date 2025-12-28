package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.validators.StudentValidator;
import java.io.*;

public class FillFromFileStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        // Путь к файлу в корне проекта
        File file = new File("output_students.txt");

        if (!file.exists()) {
            System.out.println(" Ошибка: Файл 'output_students.txt' не найден!");
            return;
        }

        Student.studentList = new CustomArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;

            System.out.println(" ⏳ Чтение файла...");

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                try {

                    String[] parts = line.split("\\|");
                    if (parts.length < 3) continue;

                    String name = parts[0].replace("Студент:", "").trim();
                    String recStr = parts[1].replace("Зачетка:", "").trim();
                    String gpaStr = parts[2].replace("Балл:", "").trim();

                    int recordNumber = Integer.parseInt(recStr);
                    int gpa = Integer.parseInt(gpaStr);

                    Student student = Student.builder()
                            .setStudentName(name)
                            .setGpa(gpa)
                            .setRecordBookNumber(recordNumber)
                            .build();

                    // Валидация и добавление
                    if (StudentValidator.validate(student)) {
                        Student.studentList.add(student);
                        count++;
                    }
                } catch (Exception e) {

                }
            }

            System.out.println(" Загрузка завершена! Найдено студентов: " + count);
            System.out.println(" -------------------------------------------");

            // --- БЛОК ВЫВОДА СПИСКА НА ЭКРАН ---
            if (Student.studentList.size() == 0) {
                System.out.println(" Список пуст (возможно, студенты не прошли валидацию).");
            } else {
                for (int i = 0; i < Student.studentList.size(); i++) {
                    System.out.println((i + 1) + ". " + Student.studentList.get(i));
                }
            }
            System.out.println(" -------------------------------------------");

        } catch (IOException e) {
            System.out.println(" Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
