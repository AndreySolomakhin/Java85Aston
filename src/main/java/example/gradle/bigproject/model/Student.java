package example.gradle.bigproject.model;

import java.util.ArrayList;
import java.util.List;

public final class Student {

    private final String studentName;
    private final int gpa;
    private final int recordBookNumber;
    public static List<Student> studentList = new ArrayList<>();

    public Student(StudentBuilder b) {
        this.studentName = b.studentName;
        this.gpa = b.gpa;
        this.recordBookNumber = b.recordBookNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getGpa() {
        return gpa;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", gpa=" + gpa +
                ", recordBookNumber=" + recordBookNumber +
                '}';
    }

    public static class StudentBuilder{

            private int gpa;
            private String studentName;
            private int recordBookNumber;

            public StudentBuilder setGpa(int gpa) {
                this.gpa= gpa;
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