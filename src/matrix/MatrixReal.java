package matrix;

/**
 * Created by Weslley on 07-Aug-17.
 */
public class MatrixReal implements Matrix<Double>{


    private int rows;
    private int cols;
    private double[] elements;

    public MatrixReal(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new double[rows * cols];
    }

    private int getIndex(int i, int j) {
        return j + rows * i;
    }

    @Override
    public Double getElemento(int i, int j) {
        return elements[getIndex(i, j)];
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public void setElemento(int i, int j, Double value) {
        elements[getIndex(i,j)] = value;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public Matrix multiply(Matrix m2) {

        Matrix result = null;

        if (cols == m2.getRows()){
            result = new MatrixReal(rows, m2.getCols());

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    for (int k = 0; k < rows; k++) {
                        result.setElemento(i,j,getElemento(i,k)
                        + (double)m2.getElemento(k,j));
                    }
                }
            }
        }
        return null;
    }
}
