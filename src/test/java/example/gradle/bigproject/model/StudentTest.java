package example.gradle.bigproject.model;

import example.gradle.bigproject.validators.StudentValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Проверка создания студента через Builder")
    void testStudentCreation() {

        Student student = Student.builder()
                .setStudentName("Алексей")
                .setGpa(85.5)
                .setRecordBookNumber(101)
                .build();

        assertAll("Проверка полей студента",
                () -> assertEquals("Алексей", student.getStudentName()),
                () -> assertEquals(85.5, student.getGpa(), 0.001),
                () -> assertEquals(101, student.getRecordBookNumber())
        );
    }

    @Test
    @DisplayName("Валидатор должен возвращать false при некорректном GPA")
    void testInvalidGpa() {
        Student invalidStudent = Student.builder()
                .setStudentName("Тест")
                .setGpa(150.0) // Некорректный балл
                .setRecordBookNumber(10)
                .build();

        // Проверяем, что ВАЛИДАТОР поймал ошибку
        assertFalse(StudentValidator.validate(invalidStudent),
                "Валидатор должен отклонить балл 150.0");
    }

    @Test
    @DisplayName("Валидатор должен возвращать false при пустом имени или цифрах в имени")
    void testInvalidName() {
        // Студент с пустым именем
        Student emptyNameStudent = Student.builder()
                .setStudentName("")
                .setGpa(50.0)
                .setRecordBookNumber(10)
                .build();

        // Студент с цифрами в имени
        Student digitNameStudent = Student.builder()
                .setStudentName("Иван123")
                .setGpa(50.0)
                .setRecordBookNumber(10)
                .build();

        assertAll("Проверка валидации имен",
                () -> assertFalse(StudentValidator.validate(emptyNameStudent)),
                () -> assertFalse(StudentValidator.validate(digitNameStudent))
        );
    }

    @Test
    @DisplayName("Проверка работы компараторов")
    void testComparators() {
        Student s1 = Student.builder().setStudentName("А").setGpa(50.0).setRecordBookNumber(2).build();
        Student s2 = Student.builder().setStudentName("Б").setGpa(90.0).setRecordBookNumber(1).build();

        // Сравниваем по GPA (50.0 < 90.0)
        assertTrue(Student.BY_GPA.compare(s1, s2) < 0);

        // Сравниваем по номеру зачетки (2 > 1)
        assertTrue(Student.BY_RECORD_BOOK.compare(s1, s2) > 0);
    }
}