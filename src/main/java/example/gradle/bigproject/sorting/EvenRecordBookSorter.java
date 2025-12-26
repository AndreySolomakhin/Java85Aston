package example.gradle.bigproject.sorting;

import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;

import java.util.ArrayList;
import java.util.List;

public class EvenRecordBookSorter implements StudentSorter {

    @Override
    public void sort(CustomArrayList<Student> students) {
        List<Integer> evenIndexes = new ArrayList<>();
        List<Student> evenStudents = new ArrayList<>();

        // 1. Собираем чётные элементы и их позиции
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRecordBookNumber() % 2 == 0) {
                evenIndexes.add(i);
                evenStudents.add(students.get(i));
            }
        }

        // 2. Сортируем чётные
        if (!evenStudents.isEmpty()) {
            quickSortByRecordBook(evenStudents, 0, evenStudents.size() - 1);
        }

        // 3. Возвращаем на исходные позиции
        for (int i = 0; i < evenIndexes.size(); i++) {
            students.set(evenIndexes.get(i), evenStudents.get(i));
        }
    }

    private void quickSortByRecordBook(List<Student> students, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(students, left, right);
            quickSortByRecordBook(students, left, pivotIndex - 1);
            quickSortByRecordBook(students, pivotIndex + 1, right);
        }
    }

    private int partition(List<Student> students, int left, int right) {
        int pivot = students.get(right).getRecordBookNumber();
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (students.get(j).getRecordBookNumber() <= pivot) {
                i++;
                swap(students, i, j);
            }
        }

        swap(students, i + 1, right);
        return i + 1;
    }

    private void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }
}