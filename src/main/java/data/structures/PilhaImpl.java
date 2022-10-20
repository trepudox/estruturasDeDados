package data.structures;

public class PilhaImpl<T> implements Pilha<T>{

    private final T[] elements;
    private int position;

    public PilhaImpl(int size) {
        if(size < 0)
            throw new RuntimeException("Tamanho nao pode ser menor que 0");

        this.elements = (T[]) new Object[size];
        this.position = -1;
    }

    @Override
    public void push(T data) {
        if (isFull())
            throw new RuntimeException("Pilha cheia");

        elements[++position] = data;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("Pilha vazia");

        T data = elements[position];
        elements[position--] = null;
        return data;
    }

    @Override
    public T top() {
        if (isEmpty())
            return null;

        return elements[position];
    }

    @Override
    public int size() {
        return elements.length;
    }

    public int currentSize() {
        return position + 1;
    }

    @Override
    public boolean isEmpty() {
        return position < 0;
    }

    @Override
    public boolean isFull() {
        return position == (elements.length - 1);
    }
}
