package example.gradle.bigproject.sorting;


import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    @DisplayName("Пузырьковая сортировка целых чисел")
    void testBubbleSortIntegers() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(2);

        BubbleSortStrategy<Integer> sorter = new BubbleSortStrategy<>();
        sorter.sort(list, Integer::compare);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));
    }

    @Test
    @DisplayName("Сортировка студентов по GPA через BubbleSort")
    void testBubbleSortStudents() {
        CustomArrayList<Student> students = new CustomArrayList<>();
        students.add(new Student.StudentBuilder().setStudentName("Иван").setGpa(70).setRecordBookNumber(1).build());
        students.add(new Student.StudentBuilder().setStudentName("Анна").setGpa(95).setRecordBookNumber(2).build());
        students.add(new Student.StudentBuilder().setStudentName("Борис").setGpa(80).setRecordBookNumber(3).build());

        BubbleSortStrategy<Student> sorter = new BubbleSortStrategy<>();
        sorter.sort(students, Student.BY_GPA);

        assertEquals(70, students.get(0).getGpa());
        assertEquals(80, students.get(1).getGpa());
        assertEquals(95, students.get(2).getGpa());
    }

    @Test
    @DisplayName("Сортировка только студентов с четными номерами зачеток")
    void testEvenRecordBookSorter() {
        CustomArrayList<Student> students = new CustomArrayList<>();
        // Зачетка 10 (четная)
        students.add(new Student.StudentBuilder().setStudentName("Четный 2").setGpa(50).setRecordBookNumber(10).build());
        // Зачетка 5 (нечетная) — должна остаться на месте
        students.add(new Student.StudentBuilder().setStudentName("Нечетный").setGpa(99).setRecordBookNumber(5).build());
        // Зачетка 2 (четная)
        students.add(new Student.StudentBuilder().setStudentName("Четный 1").setGpa(50).setRecordBookNumber(2).build());

        EvenRecordBookSorter sorter = new EvenRecordBookSorter();
        sorter.sort(students);

        // После сортировки: на индексе 0 должен быть студент с зачеткой 2 (так как 2 < 10)
        assertEquals(2, students.get(0).getRecordBookNumber());
        // На индексе 1 должен остаться "Нечетный" (зачетка 5), он не двигался
        assertEquals(5, students.get(1).getRecordBookNumber());
        // На индексе 2 теперь студент с зачеткой 10
        assertEquals(10, students.get(2).getRecordBookNumber());
    }
    @Test
    void testSortByAllFields() {
        Student s1 = Student.builder().setStudentName("Иван").setGpa(4).setRecordBookNumber(102).build();
        Student s2 = Student.builder().setStudentName("Иван").setGpa(4).setRecordBookNumber(101).build();
        // У них одинаковые имена и баллы, но у s2 номер зачетки меньше

        CustomArrayList<Student> list = new CustomArrayList<>();
        list.add(s1);
        list.add(s2);

        BubbleSortStrategy<Student> sorter = new BubbleSortStrategy<>();
        sorter.sort(list, Student.BY_ALL_FIELDS);

        // После сортировки s2 должен быть первым, так как 101 < 102
        assertEquals(101, list.get(0).getRecordBookNumber());
    }
}