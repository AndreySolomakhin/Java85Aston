package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import java.util.Scanner;

public class CounterStWithJPAStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        Scanner scanner = new Scanner(System.in);

        // 1. Проверяем, есть ли студенты в списке
        if (Student.studentList == null || Student.studentList.isEmpty()) {
            System.out.println(" Список пуст. Загрузите данные перед подсчетом.");
            return;
        }

        System.out.print("Введите минимальный средний балл для фильтрации: ");

        try {
            int threshold = Integer.parseInt(scanner.nextLine());
            int count = 0;

            // 2. Проходим циклом по нашему CustomArrayList итератором (for-each)
            for (Student s : Student.studentList) {
                if (s.getGpa() >= threshold) {
                    count++;
                }
            }

            // 3. Выводим результат
            System.out.println(" Результат: найдено " + count + " студентов с баллом >= " + threshold);

        } catch (NumberFormatException e) {
            System.out.println(" Ошибка: нужно ввести целое число.");
        }
    }
}