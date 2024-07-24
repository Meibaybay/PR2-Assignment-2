package a2_2201040174;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Vector;

public class Set<T> extends AbstractCollection<T> {
    private Vector<T> elements; // use generic syntax


    public Set() {
        elements = new Vector<>();
    }


    public void insert(T x) {
        if (getIndex(x) < 0)
            elements.add(x); // auto-boxing
    }


    public boolean remove(Object x) {
        int i = getIndex(x);
        if (i < 0)
            return false;
        elements.set(i, elements.lastElement());
        elements.remove(elements.size() - 1);
        return true;
    }


    public boolean isIn(T x) {
        return (getIndex(x) >= 0);
    }


    public int size() {
        return elements.size();
    }


    public Vector<T> getElements() {
        if (size() == 0)
            return null;
        else {
            Vector<T> els = new Vector<>();
            for (T e : elements)
                els.add(e);
            return els;
        }
    }


    public T choose() throws IllegalStateException {
        if (size() == 0)
            throw new IllegalStateException("Set.choose: set is empty");
        return elements.lastElement();
    }


    private int getIndex(Object x) {
        for (int i = 0; i < elements.size(); i++) {
            if (x.equals(elements.get(i)))
                return i;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "Set { }";

        String s = "Set {" + elements.elementAt(0).toString();
        for (int i = 1; i < size(); i++) {
            s = s + ", " + elements.elementAt(i).toString();
        }

        return s + "}";
    }


    public boolean repOK() {
        if (elements == null)
            return false;

        for (int i = 0; i < elements.size(); i++) {
            T x = elements.get(i);
            for (int j = i + 1; j < elements.size(); j++) {
                if (elements.get(j).equals(x))
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;
        Set<?> set = (Set<?>) o;
        return getElements().equals(set.getElements());
    }
}
