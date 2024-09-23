package org.example;

import java.util.*;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        Set<Integer> result = recursiveFindMaxDigits(upperBound, root);
        try {
            return new ArrayList<>(result).subList(0, count);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Найденое количество элементов меньше чем " + count);
        }
    }

    private Set<Integer> recursiveFindMaxDigits(int upperBound, Node node) {
        if (Objects.isNull(node)) return new TreeSet<>();

        Set<Integer> result = new TreeSet<>(Comparator.reverseOrder());

        if (node.value <= upperBound) result.add(node.value);

        result.addAll(recursiveFindMaxDigits(upperBound, node.left));
        result.addAll(recursiveFindMaxDigits(upperBound, node.right));
        return result;
    }
}
