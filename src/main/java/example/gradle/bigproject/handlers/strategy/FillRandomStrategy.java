package example.gradle.bigproject.handlers.strategy;


import example.gradle.bigproject.model.Student;
import java.util.Random;
import java.util.stream.Stream;

public class FillRandomStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        Random rnd = new Random();
        String[] names = {"Алексей", "Мария", "Иван", "Елена", "Дмитрий", "Анна"};

        System.out.println(" Генерируем случайных студентов...");

        // Используем Stream API для генерации 5 студентов
        Stream.generate(() -> {
                    String randomName = names[rnd.nextInt(names.length)];
                    int randomGpa = rnd.nextInt(101); // 0-100
                    int randomRecord = 10000 + rnd.nextInt(90000); // Пятизначный номер


                    return new Student.StudentBuilder()
                            .setStudentName(randomName)
                            .setGpa(randomGpa)
                            .setRecordBookNumber(randomRecord)
                            .build();
                })
                .limit(5) // Создаем ровно 5 объектов
                .forEach(student -> {
                    Student.studentList.add(student);
                    System.out.println(" Сгенерирован: " + student);
                });

        System.out.println(" Список успешно заполнен!");
    }
}