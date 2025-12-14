package example.gradle.bigproject.handlers.strategy;

public class ManuallyResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация ручного заполнения коллекции");
    }
}
