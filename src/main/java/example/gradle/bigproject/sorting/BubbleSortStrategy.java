package example.gradle.bigproject.sorting;


import example.gradle.bigproject.collection.CustomArrayList;

import java.util.Comparator;

public class BubbleSortStrategy<T> {

    public void sort(CustomArrayList<T> list, Comparator<? super T> comparator) {
        // Проверка на пустой список или 1 элемент
        if (list == null || list.size() < 2) {
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Твоя строка с проверкой
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Логика замены элементов через промежуточную переменную
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}