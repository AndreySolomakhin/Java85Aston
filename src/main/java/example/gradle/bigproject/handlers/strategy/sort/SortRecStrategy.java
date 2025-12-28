package example.gradle.bigproject.handlers.strategy.sort;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.sorting.BubbleSortStrategy;

public class SortRecStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        new BubbleSortStrategy<Student>().sort(Student.studentList, Student.BY_RECORD_BOOK);
    }
}
