package heap;

public interface Heap<T extends Number> {

    public void inserir(T obj);

    public T remover();

    public void imprimir();

    public void imprimirIdentado();

}

