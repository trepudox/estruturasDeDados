package data.structures;

public interface Fila<T> {

    void enqueue(T data);

    T dequeue();

    T front();

    T size();

    boolean isEmpty();

    boolean isFull();
}
