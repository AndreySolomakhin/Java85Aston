package example.gradle.bigproject.sorting;

import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;

public interface StudentSorter {

    void sort(CustomArrayList<Student> students);
}