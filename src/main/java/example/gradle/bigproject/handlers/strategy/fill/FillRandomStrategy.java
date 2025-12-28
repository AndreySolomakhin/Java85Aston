package example.gradle.bigproject.handlers.strategy.fill;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.validators.StudentValidator;
import java.util.Random;
import java.util.stream.Stream;

public class FillRandomStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        Random rnd = new Random();
        String[] names = {"Алексей", "Мария", "Иван", "Елена", "Дмитрий", "Анна"};
        System.out.println(" --- Генерация студентов ---");

        Stream.generate(() -> Student.builder()
                        .setStudentName(names[rnd.nextInt(names.length)])
                        .setGpa(rnd.nextInt(101))
                        .setRecordBookNumber(10000 + rnd.nextInt(90000))
                        .build())
                .filter(StudentValidator::validate)
                .limit(10000)
                .forEach(s -> {
                    Student.studentList.add(s);
                    System.out.println(" Добавлен: " + s);
                });
    }
}