package example.gradle.bigproject.handlers.strategy;

public class FillFromFileStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация заполнения коллекции из файла");
    }
}
