package example.gradle.bigproject.handlers.strategy.multithread;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.multithreading.MultithreadedCounter;

import javax.swing.*;

public class MtrSearchByGpaFixStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        try {
            searchByExactGPA(Integer.parseInt(JOptionPane.showInputDialog("Введите GPA")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Введите корректные данные");
        }

    }

    private static void searchByExactGPA(int gpa) {

        new MultithreadedCounter().countAndPrintByGPA(gpa);
    }
}
