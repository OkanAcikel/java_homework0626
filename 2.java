import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntPredicate;

/*
 * Interface X mit dem Typparameter A.
 * Der Typparameter macht das Interface generisch,
 * sodass später beliebige Datentypen verwendet werden können.
 */
interface X<A> {
    // Hier könnten Methoden definiert werden.
}

/*
 * Klasse Y besitzt einen generischen Typ A.
 *
 * A muss IntPredicate implementieren.
 * Dadurch ist garantiert, dass auf Objekten vom Typ A
 * die Methode test(int) verwendet werden kann.
 */
public class Y<A extends IntPredicate>
        implements X<A>, Consumer<A> {

    /*
     * BiFunction<T,U,R>
     * T = erster Parameter
     * U = zweiter Parameter
     * R = Rückgabewert
     *
     * Hier:
     * T = A
     * U = Integer
     * R = Double
     */
    private final BiFunction<A, Integer, Double> operation;

    /*
     * Konstruktor.
     * Beim Erzeugen der Klasse wird die Funktion gespeichert.
     */
    public Y(BiFunction<A, Integer, Double> operation) {
        this.operation = operation;
    }

    /*
     * Führt die gespeicherte Funktion aus.
     *
     * apply(a,2)
     * bedeutet:
     * erster Parameter = a
     * zweiter Parameter = 2
     *
     * Ergebnis ist ein Double.
     */
    public double fct(A a) {
        return operation.apply(a, 2);
    }

    /*
     * Da Consumer<A> implementiert wird,
     * MUSS diese Methode überschrieben werden.
     *
     * accept() besitzt keinen Rückgabewert (void).
     */
    @Override
    public void accept(A a) {

        double ergebnis = fct(a);

        System.out.println("Ergebnis = " + ergebnis);
    }
}

/*
 * Z erweitert Y.
 *
 * Dadurch erbt Z alle Methoden aus Y
 * (z.B. fct() und accept()).
 */
public class Z<A extends IntPredicate> extends Y<A> {

    /*
     * Eigenes Attribut der Klasse Z.
     */
    private final A a;

    /*
     * Konstruktor.
     *
     * super(...) ruft den Konstruktor der Oberklasse Y auf.
     * Danach wird das eigene Attribut gespeichert.
     */
    public Z(A a,
             BiFunction<A, Integer, Double> operation) {

        super(operation);

        this.a = a;
    }

    /*
     * Getter.
     * Liefert das gespeicherte Objekt zurück.
     */
    public A getA() {
        return a;
    }
}
