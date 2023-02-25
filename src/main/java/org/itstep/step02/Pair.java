package org.itstep.step02;

import java.util.HashMap;
import java.util.Map;

// TODO: Реализуйте здесь обобщенный класс Pari
public class Pair<T extends Comparable<T>, V extends Comparable<V>> implements Comparable<Pair<T, V>> {
    private final T first;
    private final V second;

    Map<String, String> map = new HashMap<String, String>() {
        {
            put("test", "test123");
            put("test2", "test456");
        }
    };

    /**
     * Создаем объект ObjectTuple на базе двух объектов.
     *  @param first  первый объект
     * @param second второй объект
     * @param first
     * @param second
     */
    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }


    @Override
    public int compareTo(Pair<T, V> that) {
        return this.getSecond().compareTo(that.getSecond());
    }


}