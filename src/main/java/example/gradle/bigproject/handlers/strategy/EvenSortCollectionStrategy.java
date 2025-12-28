package example.gradle.bigproject.handlers.strategy;

import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.sorting.EvenRecordBookSorter;
import example.gradle.bigproject.sorting.StudentSorter;

import javax.swing.*;

public class EvenSortCollectionStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        sortCollection();
    }
    private static void sortCollection() {
        if (Student.studentList.size() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Список студентов пуст. Сначала заполните его.",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        StudentSorter sorter = new EvenRecordBookSorter();
        sorter.sort(Student.studentList);

        JOptionPane.showMessageDialog(null,
                "Сортировка выполнена.\n" +
                        "Студенты с чётным номером зачетки отсортированы по возрастанию.",
                "Успех",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
