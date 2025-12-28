package example.gradle.bigproject.validators;


import example.gradle.bigproject.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentValidatorTest {

    @Test
    void testValidStudent() {
        Student s = Student.builder()
                .setStudentName("Ivan")
                .setGpa(90)
                .setRecordBookNumber(1)
                .build();
        assertTrue(StudentValidator.validate(s));
    }

    @Test
    void testInvalidNameWithDigits() {
        Student s = Student.builder()
                .setStudentName("Ivan123")
                .setGpa(50)
                .setRecordBookNumber(2)
                .build();
        assertFalse(StudentValidator.validate(s));
    }

    @Test
    void testInvalidGpa() {
        Student s = Student.builder()
                .setStudentName("Oleg")
                .setGpa(150)
                .setRecordBookNumber(3)
                .build();
        assertFalse(StudentValidator.validate(s));
    }

    @Test
    void testEmptyName() {
        Student s = Student.builder()
                .setStudentName("")
                .setGpa(70)
                .setRecordBookNumber(4)
                .build();
        assertFalse(StudentValidator.validate(s));
    }
}