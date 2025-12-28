package example.gradle.bigproject.handlers.strategy.fill;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.validators.StudentValidator;
import java.util.Scanner;

public class FillManuallyStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("--- Ввод данных студента вручную ---");

            System.out.print("Введите имя: ");
            String name = sc.nextLine();

            System.out.print("Введите балл (0-100): ");
            int gpa = Integer.parseInt(sc.nextLine());

            System.out.print("Введите номер зачетки: ");
            int rec = Integer.parseInt(sc.nextLine());

            Student s = Student.builder()
                    .setStudentName(name)
                    .setGpa(gpa)
                    .setRecordBookNumber(rec)
                    .build();


            if (StudentValidator.validate(s)) {
                Student.studentList.add(s);
                System.out.println(" Студент успешно добавлен в список.");
            } else {
                System.out.println(" Студент не прошел валидацию и не был добавлен.");
            }

        } catch (NumberFormatException e) {
            System.out.println(" Ошибка: балл и номер зачетки должны быть целыми числами!");
        } catch (Exception e) {
            System.out.println(" Произошла ошибка при вводе: " + e.getMessage());
        }
    }
}