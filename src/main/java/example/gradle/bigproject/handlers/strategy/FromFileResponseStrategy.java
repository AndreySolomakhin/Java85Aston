package example.gradle.bigproject.handlers.strategy;

public class FromFileResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация заполнения коллекции из файла");
    }
}
