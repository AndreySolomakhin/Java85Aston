package example.gradle.bigproject.multithreading;

import com.example.sorting.collection.CustomArrayList;
import java.util.concurrent.atomic.AtomicInteger;




public class MultithreadedCounter {
    public static <T> int countOccurrences(com.example.sorting.collection.CustomArrayList<T> list, T element, int threadCount){
        if (list == null || element ==null || threadCount<=0) {
            throw new IllegalArgumentException("Некорректные параметры");
        }

        int size = list.size();
        if (size==0){
            return 0;
        }

        //атомарный счетчик для потокобезопасности
        AtomicInteger totalCount = new AtomicInteger(0);
        Thread[] threads = new Thread[threadCount];


        int chunkSize = size / threadCount;
        int remainder = size % threadCount;


        int startIndex = 0;
        for (int i = 0; i< threadCount; i++){
            int endIndex = startIndex + chunkSize + (i < remainder ? 1:0);
            final int threadStart = startIndex;
            final int threadEnd = Math.min(endIndex, size);
            final int threadId = i;

            threads[i] = new Thread(() -> {
                int localCount = 0;
                for (int j = threadStart; j<threadEnd; j++){
                    T current = list.get(j);
                    if (current !=null && current.equals(element)){
                        localCount++;
                    }
                }
                synchronized (totalCount){
                    totalCount.addAndGet(localCount);
                    System.out.println("Thread "+ threadId + " found" + localCount + " occurrences");
                }
            });

            threads[i].start();
            startIndex = endIndex;
        }

        for (Thread thread : threads ){
            try{
                thread.join();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }
        return totalCount.get();
    }

    public static <T> void countAndPrint(com.example.sorting.collection.CustomArrayList<T>list, T element) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(availableProcessors, Math.max(1,list.size() / 1000));
        threadCount = Math.max(1, threadCount);

        System.out.println("Искомый элемент" + element);
        System.out.println("Размер коллекции" + list.size());
        System.out.println("Юзается потоков" + threadCount);


        long startTime = System.nanoTime();
        int count = countOccurrences (list, element, threadCount);
        long endTime = System.nanoTime();

        System.out.println("Общее колличество вхождений: " + count);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }
}
