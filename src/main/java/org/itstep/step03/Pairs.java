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
    private int index;

    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    public Pairs() {
        pairs = new Pair[PAIRS_SIZE];
        index = 0;
    }

    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
        if (index != PAIRS_SIZE) {
            Pair<K, V> newPair = new Pair<>(first, second);
            pairs[index] = newPair;
            index++;
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
        int i = 0;
        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
//            if (i == pairs.length) {
//                throw new UnsupportedOperationException();
//            }
//            return true;
           return i < pairs.length && pairs[i] != null;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
//            if (i >= pairs.length) {
//                throw new UnsupportedOperationException();
//            }
            return (Pair<K, V>) pairs[i++];
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            int ind = --i;
            for (; ind < pairs.length - 1; ind++) {
                pairs[ind] = pairs[ind + 1];
            }
            pairs = Arrays.copyOf(pairs, pairs.length - 1);
            Pair[] tmpPairs = new Pair[PAIRS_SIZE];
            System.arraycopy(pairs,0, tmpPairs, 0, PAIRS_SIZE - 1);
            pairs = tmpPairs;
            i++;
            index--;
            //throw new UnsupportedOperationException();
        }
    }
}
