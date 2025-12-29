package example.gradle.bigproject.multithreading;

import example.gradle.bigproject.model.Student;

import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadedCounter {

    private final int size;
    private final int threadCount;
    private final int chunkSize;
    private final int remainder;
    private final AtomicInteger totalCount;
    private final Thread[] threads;

    public MultithreadedCounter() {
        size = Student.studentList.size();
        threadCount = Runtime.getRuntime().availableProcessors();
        chunkSize = size / threadCount;
        remainder = size % threadCount;
        totalCount = new AtomicInteger(0);
        threads = new Thread[threadCount];
    }

    public int countOccurrences(String name) {

        int startIndex = 0;
        for (int i = 0; i < threads.length; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    String current = Student.studentList.get(j).getStudentName();
                    if (current != null && current.equals(name)) {
                        totalCount.incrementAndGet();
                        localCount++;
                    }
                }
                System.out.println("Поток " + threadId + " нашел " + localCount + " вхождений");

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

    public void countAndPrint(String name) {

        long startTime = System.nanoTime();
        int count = countOccurrences(name);
        long endTime = System.nanoTime();

        System.out.println("Общее количество вхождений: " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    public int countStudentsByGPA(int targetGPA) {

        int startIndex = 0;
        for (int i = 0; i < threadCount; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    Student student = Student.studentList.get(j);
                    if (student != null && student.getGpa() == targetGPA) {
                        totalCount.incrementAndGet();
                        localCount++;
                    }
                }
                System.out.println("Поток " + threadId + " нашел " + localCount + " студентов с GPA=" + targetGPA);
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

    public void countAndPrintByGPA(int targetGPA) {

        System.out.println("Поиск студентов с GPA = " + targetGPA);
        System.out.println("Размер коллекции: " + size);

        long startTime = System.nanoTime();
        int count = countStudentsByGPA(targetGPA);
        long endTime = System.nanoTime();

        System.out.println("Всего студентов с GPA = " + targetGPA + ": " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    // по минимальному гпа
    public int countStudentsByMinGPA(int minGPA) {

        int startIndex = 0;
        for (int i = 0; i < threadCount; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, Student.studentList.size());
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j < threadEnd; j++) {
                    Student student = Student.studentList.get(j);
                    if (student != null && student.getGpa() >= minGPA) {
                        totalCount.incrementAndGet();
                        localCount++;
                    }
                }
                System.out.println("Поток " + threadId + " нашел " + localCount + " студентов с GPA>=" + minGPA);
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

    public void countAndPrintByMinGPA(int minGPA) {

        System.out.println("Поиск студентов с GPA >= " + minGPA);
        System.out.println("Размер коллекции: " + Student.studentList.size());

        long startTime = System.nanoTime();
        int count = countStudentsByMinGPA(minGPA);
        long endTime = System.nanoTime();

        System.out.println("Всего студентов с GPA >= " + minGPA + ": " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }
}
