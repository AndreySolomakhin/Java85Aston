package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.ui.UserInterface;
import example.gradle.bigproject.validators.StudentValidator;
import java.util.Scanner;

public class FillManuallyStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Режим ручного ввода ---");

        try {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите средний балл (0-100): ");
            int gpa = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите номер зачетки: ");
            int recordNumber = Integer.parseInt(scanner.nextLine());

            // Создаем студента через Builder
            Student student = new Student.StudentBuilder()
                    .setStudentName(name)
                    .setGpa(gpa)
                    .setRecordBookNumber(recordNumber)
                    .build();

            // Проверяем валидатором
            if (StudentValidator.validate(student)) {
                Student.studentList.add(student);
                System.out.println(" Студент добавлен.");
            } else {
                System.out.println("⚠ Студент не прошел валидацию.");
            }

        } catch (Exception e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }
    }
}