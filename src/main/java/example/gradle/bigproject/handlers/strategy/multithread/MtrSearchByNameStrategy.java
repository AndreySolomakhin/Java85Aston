package example.gradle.bigproject.handlers.strategy.multithread;

import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.multithreading.MultithreadedCounter;

import javax.swing.*;

public class MtrSearchByNameStrategy implements ResponseStrategy {
    @Override
    public void handleResponse() {
        searchByName(JOptionPane.showInputDialog("Введите имя:"));
    }

    private static void searchByName(String name) {
        new MultithreadedCounter().countAndPrint(name);
    }
}
