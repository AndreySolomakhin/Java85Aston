package example.gradle.bigproject.validators;

import example.gradle.bigproject.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentValidatorTest {

    @Test
    @DisplayName("Валидация корректного студента")
    void testValidStudent() {
        Student s = Student.builder()
                .setStudentName("Иван")
                .setGpa(90.5)
                .setRecordBookNumber(123)
                .build();

        assertTrue(StudentValidator.validate(s), "Валидатор должен вернуть true для корректных данных");
    }

    @Test
    @DisplayName("Проверка граничных значений GPA (0 и 100)")
    void testGpaBoundaries() {
        // Проверяем 100.0 (должно быть true)
        Student s100 = Student.builder()
                .setStudentName("Тест")
                .setGpa(100.0)
                .setRecordBookNumber(1)
                .build();
        assertTrue(StudentValidator.validate(s100), "100.0 — допустимый балл");

        // Проверяем 0.0 (должно быть true, так как в коде gpa < 0 — ошибка)
        Student s0 = Student.builder()
                .setStudentName("Тест")
                .setGpa(0.0)
                .setRecordBookNumber(2)
                .build();
        assertTrue(StudentValidator.validate(s0), "0.0 — допустимый балл");

        // Проверяем выход за границы (100.1 — должно быть false)
        Student sOver = Student.builder()
                .setStudentName("Тест")
                .setGpa(100.1)
                .setRecordBookNumber(3)
                .build();
        assertFalse(StudentValidator.validate(sOver), "100.1 — недопустимый балл");
    }

    @Test
    @DisplayName("Валидация некорректного номера зачетки (<= 0)")
    void testInvalidRecordBook() {
        Student sInvalid = Student.builder()
                .setStudentName("Тест")
                .setGpa(50.0)
                .setRecordBookNumber(0) // В коде ошибка если <= 0
                .build();

        assertFalse(StudentValidator.validate(sInvalid), "Зачетка 0 должна быть невалидной");
    }

    @Test
    @DisplayName("Проверка имени на цифры и пустоту")
    void testNameValidation() {
        // Пустое имя
        Student empty = Student.builder().setStudentName(" ").setGpa(50).setRecordBookNumber(1).build();
        // Имя с цифрой
        Student withDigit = Student.builder().setStudentName("Иван2").setGpa(50).setRecordBookNumber(2).build();

        assertAll("Отрицательные сценарии для имени",
                () -> assertFalse(StudentValidator.validate(empty), "Пустое имя недопустимо"),
                () -> assertFalse(StudentValidator.validate(withDigit), "Имя с цифрами недопустимо")
        );
    }
}