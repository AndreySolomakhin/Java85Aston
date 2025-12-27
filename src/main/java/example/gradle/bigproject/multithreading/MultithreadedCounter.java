package example.gradle.bigproject.multithreading;

import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadedCounter {

    public static <T> int countOccurrences(CustomArrayList<T> list, T element, int threadCount) {
        if (list == null || element == null || threadCount <= 0) {
            throw new IllegalArgumentException("Некорректные параметры");
        }

        int size = list.size();
        if (size == 0) {
            return 0;
        }

        AtomicInteger totalCount = new AtomicInteger(0);
        Thread[] threads = new Thread[threadCount];

        int chunkSize = size / threadCount;
        int remainder = size % threadCount;

        int startIndex = 0;
        for (int i = 0; i < threadCount; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    T current = list.get(j);
                    if (current != null && current.equals(element)) {
                        localCount++;
                    }
                }
                synchronized (totalCount) {
                    totalCount.addAndGet(localCount);
                    System.out.println("Поток " + threadId + " нашел " + localCount + " вхождений");
                }
            });

            threads[i].start();
            startIndex = endIndex;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }
        return totalCount.get();
    }

    public static <T> void countAndPrint(CustomArrayList<T> list, T element) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(availableProcessors, Math.max(1, list.size() / 1000));
        threadCount = Math.max(1, threadCount);

        System.out.println("Искомый элемент: " + element);
        System.out.println("Размер коллекции: " + list.size());
        System.out.println("Используется потоков: " + threadCount);

        long startTime = System.nanoTime();
        int count = countOccurrences(list, element, threadCount);
        long endTime = System.nanoTime();

        System.out.println("Общее количество вхождений: " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    // по гпа
    public static int countStudentsByGPA(CustomArrayList<Student> list, int targetGPA, int threadCount) {
        if (list == null || threadCount <= 0) {
            throw new IllegalArgumentException("Некорректные параметры");
        }

        int size = list.size();
        if (size == 0) {
            return 0;
        }

        AtomicInteger totalCount = new AtomicInteger(0);
        Thread[] threads = new Thread[threadCount];

        int chunkSize = size / threadCount;
        int remainder = size % threadCount;

        int startIndex = 0;
        for (int i = 0; i < threadCount; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    Student student = list.get(j);
                    if (student != null && student.getGpa() == targetGPA) {
                        localCount++;
                    }
                }
                synchronized (totalCount) {
                    totalCount.addAndGet(localCount);
                    System.out.println("Поток " + threadId + " нашел " + localCount + " студентов с GPA=" + targetGPA);
                }
            });

            threads[i].start();
            startIndex = endIndex;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }
        return totalCount.get();
    }

    public static void countAndPrintByGPA(CustomArrayList<Student> list, int targetGPA) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(availableProcessors, Math.max(1, list.size() / 1000));
        threadCount = Math.max(1, threadCount);

        System.out.println("Поиск студентов с GPA = " + targetGPA);
        System.out.println("Размер коллекции: " + list.size());
        System.out.println("Используется потоков: " + threadCount);

        long startTime = System.nanoTime();
        int count = countStudentsByGPA(list, targetGPA, threadCount);
        long endTime = System.nanoTime();

        System.out.println("Всего студентов с GPA = " + targetGPA + ": " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    // по минимальному гпа
    public static int countStudentsByMinGPA(CustomArrayList<Student> list, int minGPA, int threadCount) {
        if (list == null || threadCount <= 0) {
            throw new IllegalArgumentException("Некорректные параметры");
        }

        int size = list.size();
        if (size == 0) {
            return 0;
        }

        AtomicInteger totalCount = new AtomicInteger(0);
        Thread[] threads = new Thread[threadCount];

        int chunkSize = size / threadCount;
        int remainder = size % threadCount;

        int startIndex = 0;
        for (int i = 0; i < threadCount; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    Student student = list.get(j);
                    if (student != null && student.getGpa() >= minGPA) {
                        localCount++;
                    }
                }
                synchronized (totalCount) {
                    totalCount.addAndGet(localCount);
                    System.out.println("Поток " + threadId + " нашел " + localCount + " студентов с GPA>=" + minGPA);
                }
            });

            threads[i].start();
            startIndex = endIndex;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }
        return totalCount.get();
    }

    public static void countAndPrintByMinGPA(CustomArrayList<Student> list, int minGPA) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(availableProcessors, Math.max(1, list.size() / 1000));
        threadCount = Math.max(1, threadCount);

        System.out.println("Поиск студентов с GPA >= " + minGPA);
        System.out.println("Размер коллекции: " + list.size());
        System.out.println("Используется потоков: " + threadCount);

        long startTime = System.nanoTime();
        int count = countStudentsByMinGPA(list, minGPA, threadCount);
        long endTime = System.nanoTime();

        System.out.println("Всего студентов с GPA >= " + minGPA + ": " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }
}
