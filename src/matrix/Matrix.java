package matrix;

/**
 * Created by Weslley on 07-Aug-17.
 */

public interface Matrix<T extends Number> {

    T getElemento(int i, int j);

    int getRows();

    void setElemento(int i, int j, T value);

    int getCols();

    Matrix multiply(Matrix m2);
}
