package example.gradle.bigproject;

import java.util.ArrayList;
import java.util.List;

public class Student {

    static List<Student> studentsList = new ArrayList<>();

    private int groupNumber;

    private int averageScore;

    private int NumberOfCreditBook;

    public Student(int groupNumber, int averageScore, int numberOfCreditBook) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        NumberOfCreditBook = numberOfCreditBook;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfCreditBook() {
        return NumberOfCreditBook;
    }

    public void setNumberOfCreditBook(int numberOfCreditBook) {
        NumberOfCreditBook = numberOfCreditBook;
    }
}
