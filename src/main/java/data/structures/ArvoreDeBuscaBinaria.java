package data.structures;

public interface ArvoreDeBuscaBinaria<T extends Comparable<T>> {


    void inserir(T data);

    void preOrder();

    void inOrder();

    void posOrder();

    void bfs();
}
