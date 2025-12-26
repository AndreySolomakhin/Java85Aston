package example.gradle.bigproject.handlers.strategy;


public interface ResponseStrategy {
    // Этот метод ДОЛЖЕН быть здесь, чтобы @Override работал в других классах
    void handleResponse();
}