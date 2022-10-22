package data.structures;

public interface ArvoreDeBuscaBinaria<T extends Comparable<T>> {

    void inserir(T data);

    boolean exists(T data);

    ArvoreDeBuscaBinaria<T> retrieve(T data);

    void preOrder();

    void inOrder();

    void posOrder();

    void bfs();

    void readValue();

    T getValue();
}
