package com.lyn.util;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DEFALUT_CAPACITY=10;
    private int theSize;
    private AnyType[] theItems;


    public MyArrayList(){
        doclear();
    }
    public void clear(){
        doclear();
    }

    private void doclear() {
        theSize=0;ensureCapacity(DEFALUT_CAPACITY);
    }
    public int size(){
        return theSize;
    }


    private void ensureCapacity(int defalutCapacity) {
    }


}
