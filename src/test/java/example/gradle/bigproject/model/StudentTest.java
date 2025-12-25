package example.gradle.bigproject.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Проверка создания студента через Builder")
    void testStudentCreation() {
        Student student = new Student.StudentBuilder()
                .setStudentName("Алексей")
                .setGpa(85)
                .setRecordBookNumber(101)
                .build();

        assertAll("Проверка полей студента",
                () -> assertEquals("Алексей", student.getStudentName()),
                () -> assertEquals(85, student.getGpa()),
                () -> assertEquals(101, student.getRecordBookNumber())
        );
    }

    @Test
    @DisplayName("Билдер должен выбрасывать исключение при некорректном GPA")
    void testInvalidGpa() {
        Student.StudentBuilder builder = new Student.StudentBuilder();

        // Проверяем верхнюю и нижнюю границы
        assertThrows(IllegalArgumentException.class, () -> builder.setGpa(-1));
        assertThrows(IllegalArgumentException.class, () -> builder.setGpa(101));
    }

    @Test
    @DisplayName("Билдер должен выбрасывать исключение при пустом имени")
    void testInvalidName() {
        Student.StudentBuilder builder = new Student.StudentBuilder();

        assertThrows(IllegalArgumentException.class, () -> builder.setStudentName(""));
        assertThrows(IllegalArgumentException.class, () -> builder.setStudentName(null));
    }

    @Test
    @DisplayName("Проверка работы компараторов")
    void testComparators() {
        Student s1 = new Student.StudentBuilder().setStudentName("А").setGpa(50).setRecordBookNumber(2).build();
        Student s2 = new Student.StudentBuilder().setStudentName("Б").setGpa(90).setRecordBookNumber(1).build();

        // Сравниваем по GPA (s1 < s2, так как 50 < 90)
        assertTrue(Student.BY_GPA.compare(s1, s2) < 0);

        // Сравниваем по номеру зачетки (s1 > s2, так как 2 > 1)
        assertTrue(Student.BY_RECORD_BOOK.compare(s1, s2) > 0);
    }
}