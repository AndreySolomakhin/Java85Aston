package example.gradle.bigproject.handlers;


import example.gradle.bigproject.handlers.strategy.ResponseStrategy;
import example.gradle.bigproject.model.Student;
import example.gradle.bigproject.multithreading.MultithreadedCounter;

public class ParallelSearchHandler extends Handler{
    private com.example.sorting.collection.CustomArrayList<Student> students;

    public ParallelSearchHandler(com.example.sorting.collection.CustomArrayList<Student>students){
        this.students = students;
        this.responseStrategy = new ParallelSearchResponseStrategy();
    }


    //не особо помнится для чего вн кл , но скажем как поле для класса в котором он описан
    //внутр класс для статегии
    private class ParallelSearchResponseStrategy implements ResponseStrategy{
        @Override
        public void handleResponse(){
            System.out.println("Тута поиск");

            if (students == null || students.size()==0){
                System.out.println("Список пуст, заполни сначала)");
                return;
            }


            //тут поиск элемента коллекции
            Student searchElement = students.get(0);
            System.out.println("Ищем элемент:" + searchElement);

            MultithreadedCounter.countAndPrint(students, searchElement);


            System.out.println("вот вам пример поиска элемента (которого нет в коллекции)");
            Student nonExistingStudent = Student.builder()
                    .setStudentName("PUPUPUUUU")
                    .setGpa(5.0)
                    .setRecordBookNumber(99999999)
                    .build();
            MultithreadedCounter.countAndPrint(students, nonExistingStudent);
        }
    }
}
