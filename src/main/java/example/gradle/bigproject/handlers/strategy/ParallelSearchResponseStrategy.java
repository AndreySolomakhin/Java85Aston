
package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.multithreading.MultithreadedCounter;
import java.util.Scanner;

public class ParallelSearchResponseStrategy implements ResponseStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void handleResponse() {
        System.out.println("Поиск по GPA ");

        if (Student.studentList == null || Student.studentList.size() == 0) {
            System.out.println("список пуст, заполни сначала");
            return;
        }

        System.out.println("Выберите тип поиска:");
        System.out.println("1. Поиск конкретного студента");
        System.out.println("2. Поиск студентов с определенным GPA");
        System.out.println("3. Поиск студентов с GPA >= заданного");
        System.out.print("Ваш выбор: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> searchConcreteStudent();
                case 2 -> searchByExactGPA();
                case 3 -> searchByMinGPA();
                default -> System.out.println("неверный выбор)))");
            }
        } catch (NumberFormatException e) {
            System.out.println("ошиибка: введи число!");
        }
    }

    private void searchConcreteStudent() {
        System.out.println("Поиск конкретного студента");

        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();

        System.out.print("Введите GPA (0-100): ");
        int gpa = Integer.parseInt(scanner.nextLine());
        if (gpa < 0 || gpa > 100) {
            System.out.println("GPA должен быть от 0 до 100!");
            return;
        }

        System.out.print("введите номер зачетки: ");
        int recordBook = Integer.parseInt(scanner.nextLine());

        Student searchStudent = Student.builder()
                .setStudentName(name)
                .setGpa(gpa)
                .setRecordBookNumber(recordBook)
                .build();

        System.out.println("запуск многопоточного поиска...");
        MultithreadedCounter.countAndPrint(Student.studentList, searchStudent);
    }

    private void searchByExactGPA() {
        System.out.println("поиск студентов с определенным GPA");

        System.out.print("Введите GPA для поиска (0-100): ");
        int gpa = Integer.parseInt(scanner.nextLine());
        if (gpa < 0 || gpa > 100) {
            System.out.println("GPA должен быть от 0 до 100!");
            return;
        }

        System.out.println("запуск многопоточного поиска...");
        MultithreadedCounter.countAndPrintByGPA(Student.studentList, gpa);
    }

    private void searchByMinGPA() {
        System.out.println("поиск студентов с GPA >= заданного");

        System.out.print("Введите минимальный GPA (0-100): ");
        int minGPA = Integer.parseInt(scanner.nextLine());
        if (minGPA < 0 || minGPA > 100) {
            System.out.println("GPA должен быть от 0 до 100!");
            return;
        }

        System.out.println("запуск многопоточного поиска...");
        MultithreadedCounter.countAndPrintByMinGPA(Student.studentList, minGPA);
    }
}
