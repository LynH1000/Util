package com.lyn.util.structure;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

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

    public void doclear() {
        theSize=0;
        ensureCapacity(DEFALUT_CAPACITY);
    }
    public int size(){
        return theSize;
    }

    public  boolean isEmpty(){
        return size()==0;
    }
    public void  tirmToSize(){
        ensureCapacity(size());
    }
    public AnyType get(int indx){
        if (indx<0||indx>=size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[indx-1];
    }
    public AnyType set(int indx,AnyType newVal){
        if (indx<0||indx>=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old=theItems[indx];
        theItems[indx]=newVal;
        return old;

    }
//   如果长度超过原本长度 重新创建
    public void ensureCapacity(int newCapacity) {
        if (newCapacity<theSize)
            return;
        AnyType[]old=theItems;
        theItems= (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i]=old[i];
        }
    }
    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }

    public void add(int indx, AnyType x) {
        if (theItems.length==size())
            ensureCapacity(size()*2+1);
        for (int i = theSize; i >indx ; i--) {
            theItems[i]=theItems[i-1];
        }
        theItems[indx]=x;
        theSize++;
    }

    public AnyType remove (int indx){
        AnyType removedItem=theItems[indx];
        for (int i = indx; i <size()-1 ; i++) {
            theItems[i]=theItems[i+1];
        }
        theSize--;
        return removedItem;
    }
    public java.util.Iterator<AnyType> iterator(){
        return new ArrayListItertor();
    }

    private class ArrayListItertor implements java.util.Iterator<AnyType> {
        private int current=0;
        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super AnyType> action) {

        }
    }
}
