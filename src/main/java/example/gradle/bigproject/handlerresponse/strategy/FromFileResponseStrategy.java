package example.gradle.bigproject.handlerresponse.strategy;

public class FromFileResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация заполнения коллекции из файла");
    }
}
