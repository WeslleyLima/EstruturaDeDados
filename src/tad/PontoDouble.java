package tad;

/**
 * Created by Weslley on 07-Aug-17.
 */

public class PontoDouble implements Ponto<Double> {

    private Double x;
    private Double y;

    public PontoDouble() {

    }

    public PontoDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double getX() {
        return this.x;
    }

    @Override
    public Double getY() {
        return this.y;
    }

    @Override
    public void setX(double value) {
        this.x = value;
    }

    @Override
    public void setY(double value) {
        this.y = value;
    }

    @Override
    public Double distancia(Ponto p2) {
        return Math.sqrt(Math.pow(x.doubleValue() - (double) p2.getX(), 2)
             + Math.pow(y - (double) p2.getY(), 2));
    }
}