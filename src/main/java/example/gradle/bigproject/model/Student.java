package example.gradle.bigproject.model;

import example.gradle.bigproject.collection.CustomArrayList;
import java.util.Comparator;
import java.util.Objects;

public final class Student {
    public static CustomArrayList<Student> studentList = new CustomArrayList<>();

    private final String studentName;
    private final double gpa;
    private final int recordBookNumber;

    // Компараторы
    public static final Comparator<Student> BY_RECORD_BOOK = Comparator.comparingInt(Student::getRecordBookNumber);
    public static final Comparator<Student> BY_GPA = Comparator.comparingDouble(Student::getGpa);
    public static final Comparator<Student> BY_STUDENT_NAME = Comparator.comparing(Student::getStudentName);

    private Student(StudentBuilder b) {
        this.studentName = b.studentName;
        this.gpa = b.gpa;
        this.recordBookNumber = b.recordBookNumber;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public String getStudentName() { return studentName; }
    public double getGpa() { return gpa; }
    public int getRecordBookNumber() { return recordBookNumber; }

    @Override
    public String toString() {
        return String.format("Студент: %-15s | Зачетка: %-5d | Балл: %.1f", studentName, recordBookNumber, gpa);
    }

    // Необходимы для работы MultithreadedCounter (поиск элемента)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 &&
                recordBookNumber == student.recordBookNumber &&
                Objects.equals(studentName, studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, gpa, recordBookNumber);
    }

    public static class StudentBuilder {
        private double gpa;
        private String studentName;
        private int recordBookNumber;

        public StudentBuilder setGpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setRecordBookNumber(int recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}