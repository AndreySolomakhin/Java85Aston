package example.gradle.bigproject.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class Student {

    private final String studentName;
    private final double gpa;
    private final int recordBookNumber;
    public static List<Student> studentList = new ArrayList<>();

    public static final Comparator<Student> BY_RECORD_BOOK = Comparator.comparingInt(Student::getRecordBookNumber);

    public static final Comparator<Student> BY_GPA = Comparator.comparingDouble(Student::getGpa);

    public static final Comparator<Student> BY_STUDENT_NAME = Comparator.comparing(Student::getStudentName);

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

    //наверное надо добавить статич метод для созд Builder
    //это для создания студентов через Student.builder()..build()

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
    //методы equals и  hashCode
    //зачем? дя сравнения объйтков в коллекциях
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return recordBookNumber == student.recordBookNumber &&
                Double.compare(student.gpa, gpa) == 0 &&
                Objects.equals(studentName, student.studentName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentName, gpa, recordBookNumber);
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
            //извините, тут я изменила int на double
            private double gpa;
            private String studentName;
            private int recordBookNumber;

            public StudentBuilder setGpa(double gpa) {
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