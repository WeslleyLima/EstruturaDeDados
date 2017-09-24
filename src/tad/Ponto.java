package tad;

/**
 * Created by Weslley on 07-Aug-17.
 */
public interface Ponto <T extends Number> {

    T getX();

    T getY();

    void setX(double value);

    void setY(double value);

    T distancia(Ponto p2);
}
