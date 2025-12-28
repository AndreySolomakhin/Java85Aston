package example.gradle.bigproject.handlers.strategy.multithread;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.multithreading.MultithreadedCounter;

import javax.swing.*;

public class MtrSearchByGpaAscStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        try {
            searchByMinGPA(Integer.parseInt(JOptionPane.showInputDialog("Введите GPA")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Введите корректные данные");
        }

    }

    private static void searchByMinGPA(int minGPA) {
        new MultithreadedCounter().countAndPrintByMinGPA(minGPA);
    }
}
