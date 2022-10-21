package data.structures;

// implementacao de fila circular
public class FilaImpl<T> implements Fila<T> {

    private final T[] elements;
    private int front;
    private int rear;

    public FilaImpl(int size) {
        if(size < 0)
            throw new RuntimeException("Size nao pode ser menor que 0");

        this.elements = (T[]) new Object[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if(isFull())
            throw new RuntimeException("Fila cheia");

        if(front == -1)
            front = 0;

        if(++rear == size())
            rear = 0;

        elements[rear] = data;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new RuntimeException("Fila vazia");

        T data = elements[front];
        elements[front] = null;

        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            if(++front == size()) {
                front = 0;
            }
        }

        return data;
    }

    @Override
    public T front() {
        if(front == -1)
            return null;

        return elements[front];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return front == -1 ;
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == size() - 1) || front - rear == 1;
    }
}

class Test {
    public static void main(String[] args) {
        Fila<Integer> fila = new FilaImpl<>(5);

        System.out.println(fila.isEmpty()); // true

        fila.enqueue(10);
        System.out.println(fila.isEmpty()); // false

        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);
        fila.enqueue(50);
//        fila.enqueue(60); // throws RuntimeException

        System.out.println(fila.isEmpty()); // false
        System.out.println(fila.isFull()); // true

        System.out.println(fila.front()); // 10
        System.out.println(fila.front()); // 10
        System.out.println(fila.dequeue()); // 10
        System.out.println(fila.front()); // 20
        System.out.println(fila.isFull()); // false

        fila.enqueue(70);
        System.out.println(fila.isFull()); // true
        System.out.println(fila.dequeue()); // 20

        System.out.println(fila.dequeue()); // 30
        System.out.println(fila.dequeue()); // 40
        System.out.println(fila.dequeue()); // 50
        System.out.println(fila.dequeue()); // 70
//        System.out.println(fila.dequeue()); // throws RuntimeException
        System.out.println(fila.front()); // null
    }
}
