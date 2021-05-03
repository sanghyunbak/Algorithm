package com.shbak.study.stack;

//import org.apache.commons.lang.ArrayUtils;
//import org.apache.commons.lang.StringUtils;

/**
 * LIFO (Last In First Out)
 * <p>
 * 1. major methods
 * - push
 * - pop
 * - top
 * - bottom
 * <p>
 * 2. Sub Classes
 * - IntStack
 * <p>
 * 3. Example
 * - function call stack
 */
public class IntStack {

    int[] values;
    final int max; // max index of the values array
    int ptr = 0;

    IntStack(int capacity) {
        max = capacity - 1;
        values = new int[capacity];
    }

    /**
     * RuntimeException occur when program run, Exception occur, when program compile.
     * RuntimeException : Unchecked Exception
     * Exception : Checked Exception
     */
    public class OverCapacityIntStackException extends RuntimeException {
        OverCapacityIntStackException() {

        }

        OverCapacityIntStackException(String msg) {
            super(msg);
        }
    }

    public void push(int value) {
        if (ptr == max) {
            throw new OverCapacityIntStackException();
        }

        values[ptr++] = value;
    }

    public class NoDataException extends RuntimeException {
        NoDataException() {

        }

        NoDataException(String msg) {
            super(msg);
        }
    }

    public void pop() {
        if (ptr == 0) {
            throw new NoDataException();
        }

        ptr--;
    }

    public String toString() {
//        return StringUtils.join(ArrayUtils.toObject(values), ",");
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<ptr; i++) {
            sb.append(values[i]);
            if (i + 1 != ptr) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public int peek() {
        if (ptr <= 0) {
            /**
             * throws is unexpected token: token is syntax
             */
            throw new NoDataException("no data during call peek() method");
        }
        return values[ptr - 1];
    }

    public class IndexNotFoundException extends RuntimeException {

    }

    public int indexOf (int value) {
        for (int i = ptr - 1; i >= 0 ; i--) {
            if (values[i] == value) {
                return i;
            }
        }

        throw new IndexNotFoundException();
    }

    public static void main(String[] args) {
        int MAX_NUM = 10;
        /**
         * java: non-static variable this cannot be referenced from a static context
         * why? :
         * I use subclass and call in super class's static method main
         */

        IntStack intStack = new IntStack(MAX_NUM);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);
        System.out.println(intStack);
        intStack.pop();
        intStack.pop();
        System.out.println("two pop result : " + intStack);
        System.out.println("peek() : " + intStack.peek());
        System.out.println("indexOf(4) : " + intStack.indexOf(4));
        System.out.println("indexOf(7) : " + intStack.indexOf(7));

    }
}
