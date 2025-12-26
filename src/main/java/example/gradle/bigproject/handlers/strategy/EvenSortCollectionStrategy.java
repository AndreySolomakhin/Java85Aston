package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;

public class EvenSortCollectionStrategy implements ResponseStrategy {

    @Override
    public void handleResponse() {
        if (Student.studentList.isEmpty()) {
            System.out.println(" Список пуст. Нечего сортировать.");
            return;
        }

        System.out.println(" Сортировка списка по среднему баллу (по возрастанию)...");

        // Сортировка пузырьком для CustomArrayList
        int n = Student.studentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Student s1 = Student.studentList.get(j);
                Student s2 = Student.studentList.get(j + 1);

                if (s1.getGpa() > s2.getGpa()) {
                    // Меняем местами через метод set, который есть в твоем CustomArrayList
                    Student.studentList.set(j, s2);
                    Student.studentList.set(j + 1, s1);
                }
            }
        }

        System.out.println(" Сортировка завершена! Выберите 'Показать список', чтобы увидеть результат.");
    }
}