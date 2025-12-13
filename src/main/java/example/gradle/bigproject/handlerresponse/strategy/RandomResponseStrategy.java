package example.gradle.bigproject.handlerresponse.strategy;

public class RandomResponseStrategy implements ResponseStrategy{
    @Override
    public void handleResponse() {
        System.out.println("Здесь будет реализация рандомного заполнения коллекции");
    }
}
