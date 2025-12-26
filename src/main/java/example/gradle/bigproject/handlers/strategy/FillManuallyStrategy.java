package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.validators.StudentValidator;
import java.util.Scanner;

public class FillManuallyStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        Scanner scanner = new Scanner(System.in);
        boolean isAdded = false;

        while (!isAdded) {
            try {
                System.out.println("\n--- Режим ручного ввода ---");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();

                System.out.print("Введите средний балл (0-100): ");

                double gpa = Double.parseDouble(scanner.nextLine());

                System.out.print("Введите номер зачетки: ");
                int recordNumber = Integer.parseInt(scanner.nextLine());


                Student student = Student.builder()
                        .setStudentName(name)
                        .setGpa(gpa)
                        .setRecordBookNumber(recordNumber)
                        .build();

                if (StudentValidator.validate(student)) {
                    Student.studentList.add(student);
                    System.out.println(" Студент добавлен успешно.");
                    isAdded = true;
                }

            } catch (NumberFormatException e) {
                System.out.println(" Ошибка: Балл может быть числом (можно с точкой), а зачетка — целым числом.");
            } catch (Exception e) {
                System.out.println(" Ошибка: " + e.getMessage());
            }
        }
    }
}