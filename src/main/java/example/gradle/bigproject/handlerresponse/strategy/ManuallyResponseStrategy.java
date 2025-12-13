package example.gradle.bigproject.handlerresponse.strategy;

public class ManuallyResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация ручного заполнения коллекции");
    }
}
