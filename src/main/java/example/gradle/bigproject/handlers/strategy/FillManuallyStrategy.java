package example.gradle.bigproject.handlers.strategy;

public class FillManuallyStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация ручного заполнения коллекции");
    }
}
