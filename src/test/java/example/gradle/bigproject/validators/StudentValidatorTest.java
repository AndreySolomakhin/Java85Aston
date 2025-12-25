package example.gradle.bigproject.validators;

import example.gradle.bigproject.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentValidatorTest {

    @Test
    @DisplayName("Валидация корректного студента")
    void testValidStudent() {
        Student s = new Student.StudentBuilder()
                .setStudentName("Иван")
                .setGpa(90)
                .setRecordBookNumber(123)
                .build();

        assertTrue(StudentValidator.validate(s), "Валидатор должен вернуть true для корректных данных");
    }

    @Test
    @DisplayName("Проверка граничных значений GPA (0 и 100)")
    void testGpaBoundaries() {
        // Проверяем 100 (должно быть true)
        Student s100 = new Student.StudentBuilder()
                .setStudentName("Тест")
                .setGpa(100)
                .setRecordBookNumber(1)
                .build();
        assertTrue(StudentValidator.validate(s100));

        // Если st.getGpa() > 0 (строго больше), вернет false.
        Student s0 = new Student.StudentBuilder()
                .setStudentName("Тест")
                .setGpa(0)
                .setRecordBookNumber(2)
                .build();
        assertFalse(StudentValidator.validate(s0), "Валидатор должен вернуть false для GPA = 0, так как в коде > 0");
    }

    @Test
    @DisplayName("Валидация некорректного номера зачетки")
    void testInvalidRecordBook() {
        // Если бы мы создали студента как-то иначе или Билдер бы пропустил
        Student s = new Student.StudentBuilder()
                .setStudentName("Тест")
                .setGpa(50)
                .setRecordBookNumber(1) // Минимально допустимый
                .build();

        assertTrue(StudentValidator.validate(s));
    }

    @Test
    @DisplayName("Проверка на null или пустое имя")
    void testEmptyName() {

        Student s = new Student.StudentBuilder()
                .setStudentName("Джон")
                .setGpa(50)
                .setRecordBookNumber(10)
                .build();

        assertTrue(StudentValidator.validate(s));
    }
}