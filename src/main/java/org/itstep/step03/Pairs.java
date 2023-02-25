package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

///**
// * Итерируемая коллекция объектов Pair.
// *
// * @author Michael S. Kirkpatrick and Nathan Sprague
// * @version V1, 8/2017
// */
public class Pairs<K extends Comparable<K>, V extends Comparable<V>> implements Iterable<Pair<K, V>> {

    //TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair
    final int PAIRS_SIZE = 10;

    private Pair[] pairs;
    private int size;

    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    public Pairs() {
        pairs = new Pair[PAIRS_SIZE];
        size = 0;
    }

    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
        if (size != PAIRS_SIZE) {
            Pair<K, V> newPair = new Pair<>(first, second);
            pairs[size] = newPair;
            size++;
            return true;
        }
        return false;
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    /*
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
//            if (cursor == pairs.length) {
//                throw new UnsupportedOperationException();
//            }
//            return true;
           return cursor < pairs.length && pairs[cursor] != null;
//           return cursor != pairs.length;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            int i = cursor;
            if (i >= pairs.length) throw new UnsupportedOperationException();
            cursor = i + 1;
            return (Pair<K, V>) pairs[lastRet = i];
//            if (i >= pairs.length) {
//                throw new UnsupportedOperationException();
//            }
//            return (Pair<K, V>) pairs[cursor++];
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            int ind = lastRet;
            for (; ind < pairs.length - 1; ind++) {
                pairs[ind] = pairs[ind + 1];
            }
            pairs = Arrays.copyOf(pairs, pairs.length - 1);
            Pair[] tmpPairs = new Pair[PAIRS_SIZE];
            System.arraycopy(pairs,0, tmpPairs, 0, PAIRS_SIZE - 1);
            pairs = tmpPairs;

            cursor = lastRet;
            lastRet = -1;
            size--;
        }
    }
}
