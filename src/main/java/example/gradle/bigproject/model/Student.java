package example.gradle.bigproject.model;

import example.gradle.bigproject.collection.CustomArrayList;
import java.util.Comparator;
import java.util.Objects;

public final class Student {
    public static CustomArrayList<Student> studentList = new CustomArrayList<>();

    private final String studentName;
    private final int gpa;
    private final int recordBookNumber;

    public static final Comparator<Student> BY_RECORD_BOOK = Comparator.comparingInt(Student::getRecordBookNumber);
    public static final Comparator<Student> BY_GPA = Comparator.comparingInt(Student::getGpa);
    public static final Comparator<Student> BY_STUDENT_NAME = Comparator.comparing(Student::getStudentName);

    private Student(StudentBuilder b) {
        this.studentName = b.studentName;
        this.gpa = b.gpa;
        this.recordBookNumber = b.recordBookNumber;
    }

    public static StudentBuilder builder() { return new StudentBuilder(); }

    public String getStudentName() { return studentName; }
    public int getGpa() { return gpa; }
    public int getRecordBookNumber() { return recordBookNumber; }
    
    public static final Comparator<Student> BY_ALL_FIELDS = Comparator
            .comparing(Student::getStudentName)
            .thenComparingInt(Student::getGpa)
            .thenComparingInt(Student::getRecordBookNumber);

    @Override
    public String toString() {
        return String.format("Студент: %-15s | Зачетка: %-5d | Балл: %d", studentName, recordBookNumber, gpa);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gpa == student.gpa && recordBookNumber == student.recordBookNumber &&
                Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() { return Objects.hash(studentName, gpa, recordBookNumber); }

    public static class StudentBuilder {
        private int gpa;
        private String studentName;
        private int recordBookNumber;

        public StudentBuilder setGpa(int gpa) { this.gpa = gpa; return this; }
        public StudentBuilder setStudentName(String studentName) { this.studentName = studentName; return this; }
        public StudentBuilder setRecordBookNumber(int recordBookNumber) { this.recordBookNumber = recordBookNumber; return this; }
        public Student build() { return new Student(this); }
    }
}