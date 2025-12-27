package example.gradle.bigproject.test;

import example.gradle.bigproject.collection.CustomArrayList;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.multithreading.MultithreadedCounter;

public class MultithreadedCounterTest {
    //если не ошибаюст надо было создать тест
    public static void main(String[] args) {
        System.out.println("Тут тестирование 4 задания:");

        //1 пустой
        System.out.println("С пустой коллекцией: ");
        CustomArrayList<Student> emptyList = new CustomArrayList<>();
        Student testStudent = Student.builder()
                .setStudentName("Test")
                .setGpa(39)
                .setRecordBookNumber(66)
                .build();
        MultithreadedCounter.countAndPrint(emptyList, testStudent);

        //2 с элементом
        System.out.println("Тест с одним элементом: ");
        CustomArrayList<Student> singleList = new CustomArrayList<>();
        singleList.add(testStudent);
        MultithreadedCounter.countAndPrint(singleList, testStudent);

        //3 с несколькими вхождениями
        System.out.println("Тест с несколькими вхожд: ");
        CustomArrayList<Student> multiList = new CustomArrayList<>();
        Student student1= Student.builder()
                .setStudentName("Javisto")
                .setGpa(49)
                .setRecordBookNumber(1234)
                .build();

        Student student2= Student.builder()
                .setStudentName("Zhargalisto")
                .setGpa(42)
                .setRecordBookNumber(56789)
                .build();

        multiList.add(student1);
        multiList.add(student2);
        multiList.add(student1);
        multiList.add(student2);
        multiList.add(student1);

        System.out.println("find student1 (should be 3):");
        MultithreadedCounter.countAndPrint(multiList, student1);

        System.out.println("find student2 (sh be 2):");
        MultithreadedCounter.countAndPrint(multiList, student2);

        //4 с большим колвом элементов
        System.out.println("Тест 1000 элем:");
        CustomArrayList<Student> largeList = new CustomArrayList<>();
        Student targetStudent = Student.builder()
                .setStudentName("Target")
                .setGpa(36)
                .setRecordBookNumber(99999)
                .build();
        for (int i=0; i<1000; i++){
            if (i % 100 == 0){
                largeList.add(targetStudent);//это мы тут добавляем targetStudent каждые 100 элементов
            }else{
                largeList.add(Student.builder()
                        .setStudentName("Group" + i)
                        .setGpa(3 + (i % 3))
                        .setRecordBookNumber(i)
                        .build());
            }
        }
        System.out.println("find targetStudent (should be 10)");
        MultithreadedCounter.countAndPrint(largeList, targetStudent);

        System.out.println("все, тесты завершены)");
    }
}
