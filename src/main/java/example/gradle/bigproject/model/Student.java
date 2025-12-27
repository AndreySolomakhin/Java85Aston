package example.gradle.bigproject.model;


import example.gradle.bigproject.collection.CustomArrayList;

import java.util.Objects;
import java.util.Comparator;

public final class Student {
    public static CustomArrayList<Student> studentList = new CustomArrayList<>();
    private final String studentName;
    private final int gpa;
    private final int recordBookNumber;

    // Компараторы для основной сортировки
    public static final Comparator<Student> BY_RECORD_BOOK = Comparator.comparingInt(Student::getRecordBookNumber);
    public static final Comparator<Student> BY_GPA = Comparator.comparingInt(Student::getGpa);
    public static final Comparator<Student> BY_STUDENT_NAME = Comparator.comparing(Student::getStudentName);

      public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    private Student(StudentBuilder b) {
        this.studentName = b.studentName;
        this.gpa = b.gpa;
        this.recordBookNumber = b.recordBookNumber;
    }

    public String getStudentName() { return studentName; }
    public int getGpa() { return gpa; }
    public int getRecordBookNumber() { return recordBookNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gpa == student.gpa &&
                recordBookNumber == student.recordBookNumber &&
                Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, gpa, recordBookNumber);
    }

    @Override
    public String toString() {
        return String.format("Студент: %-15s | Зачетка: %-5d | Балл: %d", studentName, recordBookNumber, gpa);
    }

    public static class StudentBuilder {
        private int gpa;
        private String studentName;
        private int recordBookNumber;

        public StudentBuilder setGpa(int gpa) {
            if (gpa < 0 || gpa > 100) throw new IllegalArgumentException("Балл должен быть 0-100");
            this.gpa = gpa;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            if (studentName == null || studentName.isBlank()) throw new IllegalArgumentException("Имя пустое");
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setRecordBookNumber(int recordBookNumber) {
            if (recordBookNumber <= 0) throw new IllegalArgumentException("Номер зачетки > 0");
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
