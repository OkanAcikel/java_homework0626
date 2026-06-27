import java.util.ArrayList;
import java.util.function.BiPredicate;

public interface X<O> {

    /*
     * BiPredicate<T,U>
     * erwartet zwei Parameter und liefert einen boolean zurück.
     *
     * Hier:
     * erster Parameter  -> Double
     * zweiter Parameter -> O
     */
    boolean verify(BiPredicate<Double, O> pred,
                   Double d,
                   O o);

    /*
     * Default-Methode:
     * Interfaces dürfen seit Java 8 Methoden mit Implementierung besitzen.
     */
    default <T extends Number> void def(ArrayList<T> alon, T t) {

        /*
         * size() liefert die Anzahl der Elemente.
         */
        if (alon.size() >= 4) {

            /*
             * add(index,element)
             * fügt das Element an Position 4 ein.
             */
            alon.add(4, t);

        } else {

            /*
             * add(index,element)
             * fügt das Element am Anfang ein.
             */
            alon.add(0, t);
        }
    }
}
