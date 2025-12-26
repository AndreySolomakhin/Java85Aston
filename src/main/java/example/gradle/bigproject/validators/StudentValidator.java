package example.gradle.bigproject.validators;

import example.gradle.bigproject.model.Student;

public class StudentValidator {

    /**
     * Проверяет объект студента на соответствие всем правилам.
     * @return true, если данные корректны.
     */
    public static boolean validate(Student s) {
        String name = s.getStudentName();
        double gpa = s.getGpa();
        int recordNumber = s.getRecordBookNumber();

        // 1. Проверка имени
        if (name == null || name.isBlank()) {
            System.out.println(" Ошибка валидации: имя не может быть пустым.");
            return false;
        }
        if (name.matches(".*\\d.*")) {
            System.out.println(" Ошибка валидации: имя '" + name + "' содержит цифры.");
            return false;
        }

        // 2. Проверка балла
        if (gpa < 0.0 || gpa > 100.0) {
            System.out.println(" Ошибка валидации: балл " + gpa + " вне диапазона [0-100].");
            return false;
        }

        // 3. Проверка зачетки
        if (recordNumber <= 0) {
            System.out.println(" Ошибка валидации: номер зачетки должен быть > 0.");
            return false;
        }

        return true; // Если все проверки пройдены
    }
}