package staticList;

public class StaticList<T> implements List<T> {

    private Object[] list;
    private int next;
    private int size;

    public StaticList() {
        this(10);
    }

    public StaticList(int size) {
        this.next = 0;
        this.size = size;
        this.list = new Object[size];
    }

    @Override
    public void add(T obj) {

        if (next < size) {
            list[next] = obj;
            next += 1;
        } else {

            int newSize = size * 2;
            Object[] aux = new Object[newSize];

            for (int i = 0; i < size; i++) {
                aux[i] = list[i];
            }

            aux[next] = obj;

            list = aux.clone();
            size = newSize;
            next += 1;

        }

    }

    @Override
    public void set(int position, T obj) {

        if (position >= 0 && position < next) {
            list[position] = obj;
        }

    }

    @Override
    public void remove(T obj) {

        int index = 0;

        for (int i = 0; i < size; i++) {
            if (list[i].equals(obj)) {
                index = i;
                break;
            }
        }

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        next -= 1;

    }

    @Override
    public void remove(int position) {

        if (position >= 0 && position < next) {

            for (int i = position; i < size - 1; i++) {
                list[i] = list[i + 1];
            }

            next -= 1;
        }

    }

    @Override
    public T get(int position) {

        T result = null;

        if (position < size) {
            result = (T) list[position];
        }

        return result;
    }

    @Override
    public T first() {
        return (T) list[0];
    }

    @Override
    public T last() {
        if (next == 0)
            return null;
        else
            return (T) list[next - 1];
    }

    @Override
    public boolean isEmpty() {
        return (next == 0) ? true : false;
    }

    @Override
    public boolean contains(Object obj) {

        boolean result = false;

        for (int i = 0; i < size; i++) {
            if (list[i] == obj) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < next; i++) {

            if (list[i] != null)
                sb.append(list[i]);

            if (i != next - 1)
                sb.append(", ");

        }
        sb.append("]");

        return sb.toString();

    }
}