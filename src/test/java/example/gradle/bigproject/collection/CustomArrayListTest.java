package example.gradle.bigproject.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    private CustomArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    @DisplayName("Добавление элементов и проверка размера")
    void testAddAndSize() {
        list.add(10);
        list.add(20);
        assertEquals(2, list.size(), "Размер должен быть 2 после добавления двух элементов");
    }

    @Test
    @DisplayName("Получение элементов по индексу")
    void testGet() {
        list.add(100);
        assertEquals(100, list.get(0));
    }

    @Test
    @DisplayName("Изменение элемента через set")
    void testSet() {
        list.add(10);
        list.set(0, 50);
        assertEquals(50, list.get(0), "Метод set должен изменять значение по индексу");
    }

    @Test
    @DisplayName("Проверка автоматического расширения массива (Arrays.copyOf)")
    void testExpansion() {
        // Начальный размер 10, добавляем 15 элементов, чтобы вызвать расширение
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.size());
        assertEquals(14, list.get(14));
    }

    @Test
    @DisplayName("Ошибка при неверном индексе (IndexOutOfBoundsException)")
    void testException() {
        // Проверяем, что get и set бросают ошибку, если индекс пустой
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 10));
    }

    @Test
    @DisplayName("Проверка работы итератора (Iterable)")
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer item : list) {
            count++;
        }
        assertEquals(3, count, "Итератор должен пройти по всем 3 элементам");
    }
}