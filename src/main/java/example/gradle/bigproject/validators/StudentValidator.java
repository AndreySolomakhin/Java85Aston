package example.gradle.bigproject.validators;

import example.gradle.bigproject.model.Student;

public class StudentValidator {
    public static boolean validate(Student s) {
        if (s == null) return false;
        String name = s.getStudentName();
        int gpa = s.getGpa();
        int recordNumber = s.getRecordBookNumber();

        if (name == null || name.isBlank() || name.matches(".*\\d.*")) {
            System.out.println(" Ошибка валидации имени: " + name);
            return false;
        }
        if (gpa < 0 || gpa > 100) {
            System.out.println(" Ошибка: балл " + gpa + " вне [0-100]");
            return false;
        }
        if (recordNumber <= 0) {
            System.out.println(" Ошибка: номер зачетки " + recordNumber + " некорректен");
            return false;
        }
        return true;
    }
}