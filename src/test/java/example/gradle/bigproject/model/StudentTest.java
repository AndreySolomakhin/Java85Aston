package example.gradle.bigproject.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testStudentBuilderAndGetters() {
        Student student = Student.builder()
                .setStudentName("Test Student")
                .setGpa(85)
                .setRecordBookNumber(12345)
                .build();

        assertEquals("Test Student", student.getStudentName());
        assertEquals(85, student.getGpa());
        assertEquals(12345, student.getRecordBookNumber());
    }

    @Test
    void testEqualsAndHashCode() {
        Student s1 = Student.builder().setStudentName("A").setGpa(90).setRecordBookNumber(1).build();
        Student s2 = Student.builder().setStudentName("A").setGpa(90).setRecordBookNumber(1).build();

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }
}