package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    private T[] aDeque;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int space;


    public ArrayDeque(){
        space = 8;
        aDeque = (T[])new Object[space];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public void addFirst(T item){
        if(aDeque[nextFirst] == null){
            aDeque[nextFirst] = item;
            size += 1;
            if(nextFirst==0){
                nextFirst = space - 1;
            }
            else{
                nextFirst -= 1;
            }
        }
        else{
            resize(2 * aDeque.length);
            addFirst(item);
        }
    }
    @Override
    public void addLast(T item){
        if(aDeque[nextLast] == null){
            aDeque[nextLast] = item;
            size += 1;
            if(nextLast == aDeque.length - 1){
                nextLast = 0;
            }
            else{
                nextLast += 1;
            }
        }
        else{
            resize(2*aDeque.length);
            addLast(item);
        }
    }
    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        System.arraycopy(aDeque, nextFirst + 1, a, 0, size - nextFirst - 1);
        System.arraycopy(aDeque, 0, a, size - nextFirst - 1, nextFirst + 1);
        aDeque = a;
        nextFirst = aDeque.length - 1;
        space = aDeque.length;
        nextLast = size;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        int i;
        if(nextFirst != aDeque.length-1) {
            for (i = nextFirst + 1; i < aDeque.length; i++) {
                if (aDeque[i] == null) {
                    break;
                } else {
                    System.out.print(aDeque[i]);
                    if (i + 1 < aDeque.length && aDeque[i + 1] != null) {
                        System.out.print(" ");
                    }
                    if (i + 1 == aDeque.length && aDeque[0] != null) {
                        System.out.print(" ");
                    }
                    if (i + 1 == aDeque.length && aDeque[0] == null){
                        System.out.print("\n");
                    }
                }
            }
        }
        for(i = 0; i<nextLast; i++){
            if(i != nextLast - 1){
                System.out.print(aDeque[i]+" ");
            }
            else if(i == nextLast - 1){
                System.out.println(aDeque[i]);
            }
        }
    }
    @Override
    public T removeFirst(){
        T returnValue;
        if(size == 0){
            returnValue = null;
        }
        else if(nextFirst == aDeque.length - 1){
            returnValue = aDeque[0];
            aDeque[0] = null;
            nextFirst = 0;
            size -= 1;
        }
        else{
            returnValue = aDeque[nextFirst + 1];
            aDeque[nextFirst + 1] = null;
            nextFirst += 1;
            size -= 1;
        }
        return returnValue;
    }

    @Override
    public T removeLast(){
        if ((size < aDeque.length / 4) && (size > 4)) {
            resize(aDeque.length / 4);
        }
        T returnValue;
        if(size == 0){
            returnValue = null;
        }
        else if (nextLast == 0){
            returnValue = aDeque[aDeque.length - 1];
            aDeque[aDeque.length - 1] = null;
            nextLast = aDeque.length - 1;
            size -= 1;
        }
        else{
            returnValue = aDeque[nextLast - 1];
            aDeque[nextLast - 1] = null;
            nextLast -= 1;
            size -= 1;
        }
        return returnValue;
    }

    @Override
    public T get(int index){
        int realIndex = nextFirst + 1 + index;
        if(realIndex < aDeque.length){
            return aDeque[realIndex];
        }
        else{
            int outIndex = realIndex - aDeque.length;
            return aDeque[outIndex];
        }
    }
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T>{
        private int nowPos;
        public ArrayDequeIterator(){
            nowPos = 0;
        }
        public boolean hasNext(){
            return nowPos < size;
        }
        public T next(){
            T returnItem = get(nowPos);
            nowPos += 1;
            return returnItem;
        }
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if (o instanceof Deque) {
            Deque other = (Deque) o;
            if (other.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
