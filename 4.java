public abstract class Y implements X<Object>, java.awt.event.ItemListener {

    public boolean vrfy(BiPredicate<Double, Object> pred,
                        Double d,
                        Object o) {
        return pred.test(d, o);
    }
}
