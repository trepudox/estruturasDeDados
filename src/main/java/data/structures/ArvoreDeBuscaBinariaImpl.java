package data.structures;

public class ArvoreDeBuscaBinariaImpl<T extends Comparable<T>> implements ArvoreDeBuscaBinaria<T> {

    private T value;
    private ArvoreDeBuscaBinariaImpl<T> left;
    private ArvoreDeBuscaBinariaImpl<T> right;

    public ArvoreDeBuscaBinariaImpl() {}

    @Override
    public void inserir(T data) {
        if(value == null) {
            value = data;
            left = new ArvoreDeBuscaBinariaImpl<>();
            right = new ArvoreDeBuscaBinariaImpl<>();
        } else if(data.compareTo(value) <= 0) {
            left.inserir(data);
        } else {
            right.inserir(data);
        }
    }

    @Override
    public boolean exists(T data) {
        return retrieve(data).getValue() != null;
    }

    @Override
    public ArvoreDeBuscaBinaria<T> retrieve(T data) {
        if(value == null || data.compareTo(value) == 0)
            return this;

        if(data.compareTo(value) < 0)
            return left.retrieve(data);
        else
            return right.retrieve(data);
    }

    @Override
    public void preOrder() {
        System.out.print(this.value + " ");

        if(left.getValue() != null) {
            left.preOrder();
        }

        if(right.getValue() != null) {
            right.preOrder();
        }
    }

    @Override
    public void inOrder() {
        if(left.getValue() != null) {
            left.inOrder();
        }

        System.out.print(this.value + " ");

        if(right.getValue() != null) {
            right.inOrder();
        }
    }

    @Override
    public void posOrder() {
        if(left.getValue() != null) {
            left.posOrder();
        }

        if(right.getValue() != null) {
            right.posOrder();
        }

        System.out.print(this.value + " ");
    }

    @Override
    public void bfs() {
        // TODO: Implementar BFS
    }

    @Override
    public void readValue() {
        System.out.println(value);
    }

    @Override
    public T getValue() {
        return value;
    }

}

class ArvoreTest {
    public static void main(String[] args) {
        ArvoreDeBuscaBinaria<Integer> arvore = new ArvoreDeBuscaBinariaImpl<>();

        arvore.inserir(10);
        arvore.inserir(7);
        arvore.inserir(13);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(15);
        arvore.inserir(11);
        arvore.inserir(10);

        arvore.retrieve(13).readValue();
        System.out.println(arvore.exists(13)); // true
        System.out.println(arvore.exists(99)); // false

        System.out.print("Pre-order: ");
        arvore.preOrder(); // 10 7 5 9 10 13 11 15
        System.out.println();

        System.out.print("In-order: ");
        arvore.inOrder(); // 5 7 9 10 10 11 13 15
        System.out.println();

        System.out.print("Pos-order: ");
        arvore.posOrder(); // 5 10 9 7 11 15 13 10
        System.out.println();
    }
}
