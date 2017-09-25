package Fila;

/**
 * Tipo Abstrato de Dados de uma DoubleLinkedList
 *
 * @param <T> O tipo que será trabalhado na List via API de generics do Java
 */
public interface List<T> {

    /**
     * Adicionar um elemento a DoubleLinkedList
     *
     * @param obj O elemento a ser inserido
     */
    void add(T obj);

    /**
     * Remover um elemento da DoubleLinkedList
     *
     */
    void remove();

    void imprimir();


}