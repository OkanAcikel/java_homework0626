public class Y<A extends Object & IntPredicate> 
        implements X<A>, Consumer<A> {

    BiFunction<A, Integer, Double> op;

    double fct(BiFunction<A, Integer, Double> op, A a) {
        return op.apply(a, 2);
    }
}

public class Z<A extends Object & IntPredicate> extends Y<A> {
    private A a;

    public Z(A a) {
        this.a = a;
    }
}
