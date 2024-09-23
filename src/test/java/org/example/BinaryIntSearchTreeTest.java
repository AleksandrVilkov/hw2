package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {

    @Test
    void add() {
        HomeWork tree = new HomeWork();
        tree.add(4);
        for (int i = 0; i < 6; i++) {
            tree.add(i);
        }

        var actual1 = tree.findMaxDigits(3, 4);
        Assertions.assertEquals(3, actual1.size());
        Assertions.assertEquals(4, actual1.get(0));
        Assertions.assertEquals(3, actual1.get(1));
        Assertions.assertEquals(2, actual1.get(2));

        var actual2 = tree.findMaxDigits(1, 4);
        Assertions.assertEquals(1, actual2.size());


        var actual3 = tree.findMaxDigits(5, 5);
        Assertions.assertEquals(5, actual3.size());
        Assertions.assertEquals(5, actual3.get(0));
        Assertions.assertEquals(4, actual3.get(1));
        Assertions.assertEquals(3, actual3.get(2));
        Assertions.assertEquals(2, actual3.get(3));
        Assertions.assertEquals(1, actual3.get(4));

        Assertions.assertThrows(RuntimeException.class, () -> tree.findMaxDigits(10, 5));
    }
}