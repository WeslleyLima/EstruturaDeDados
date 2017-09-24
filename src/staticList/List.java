package staticList;

/**
 * Tipo Abstrato de Dados de uma staticList
 *
 * @param <T> O tipo que será trabalhado na staticList via API de generics do Java
 */
public interface List<T> {

    /**
     * Adicionar um elemento a staticList
     *
     * @param obj O elemento a ser inserido
     */
    void add(T obj);

    /**
     * Substituir um elemento de uma dada posição da staticList
     *
     * @param position A posição do elemento
     * @param obj      O novo elemento
     */
    void set(int position, T obj);

    /**
     * Remover um elemento da staticList
     *
     * @param obj O elemento a ser removido
     */
    void remove(T obj);

    /**
     * Remover um elemento de uma dada posição da staticList
     *
     * @param position A posição que deve-se remover o elemento
     */
    void remove(int position);

    /**
     * Recuperar um elemento de uma dada posição da staticList
     *
     * @param position A posição que deve-se recuperar o elemento
     * @return O elemento recuperado da staticList
     */
    T get(int position);

    /**
     * Recupera o primeiro elemento da staticList
     *
     * @return O elemento que está na primeira posição
     */
    T first();

    /**
     * Recupera o ultimo elemento da staticList
     *
     * @return O elemento que está na ultima posição da staticList
     */
    T last();

    /**
     * Verifica se a staticList é vazia
     *
     * @return verdadeiro caso a staticList seja vazia e falso caso contrário.
     */
    boolean isEmpty();

    /**
     * Verifica se contém o elemento na staticList
     *
     * @param obj Elemento utilizado na verificação
     * @return Verdadeiro se o elemento está contido na staticList e falso caso contrário
     */
    boolean contains(T obj);

    /**
     * String amigavel da staticList
     *
     * @return Uma string amigavel da staticList de elementos
     */
    String toString();

}