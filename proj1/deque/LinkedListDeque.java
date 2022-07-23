package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>,Deque<T>{
    private class Node {
        public T item;
        public Node next;
        public Node front;

        public Node(T i, Node n, Node f) {
            item = i;
            next = n;
            front = f;
        }
    }

    /**
     * The first item (if it exists) is at sentinelFront.next.
     */
    public Node sentinel;
    public int size;

    public LinkedListDeque() {
        sentinel = new Node((T) "sentinel", null, null);
        sentinel.next = sentinel;
        sentinel.front = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node((T) "sentinel", null, null);
        Node t = new Node(item, sentinel, sentinel);
        sentinel.next = t;
        sentinel.front = t;
        size = 1;
    }
    @Override
    public void addFirst(T item){
        Node t = new Node(item, sentinel.next, sentinel);
        sentinel.next.front = t;
        sentinel.next = t;
        size += 1;
    }
    @Override
    public void addLast(T item){
        Node t = new Node(item, sentinel, sentinel.front);
        sentinel.front.next = t;
        sentinel.front = t;
        size += 1;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        Node start = sentinel.next;
        while(start != sentinel){
            System.out.print(start.item);
            start = start.next;
            if (start != sentinel)
            {
                System.out.print(" ");
            }
            else{
                System.out.print("\n");
                break;
            }
        }
    }
    @Override
    public T removeFirst(){
        if (sentinel.next != sentinel){
            T firstItem = sentinel.next.item;
            sentinel.next.next.front = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return firstItem;
        }
        else{
            return null;
        }
    }
    @Override
    public T removeLast(){
        if(sentinel.front != sentinel){
            T lastItem = sentinel.front.item;
            sentinel.front.front.next = sentinel;
            sentinel.front = sentinel.front.front;
            size -= 1;
            return lastItem;
        }
        else{
            return null;
        }
    }
    @Override
    public T get(int index){
        if(index >= size){
            return null;
        }
        else{
            if(size == 0)
            {
                return null;
            }
            else{
                Node start = sentinel.next;
                int i = 0;
                while(i != index){
                    start = start.next;
                    i += 1;
                }
                return start.item;
            }
        }
    }
    public T getRecursive(int index){
        if(index<0 || index >= size){
            return null;
        }
        else{
            return getRecursiveHelper(index, sentinel.next);
        }
    }
    private T getRecursiveHelper(int index, Node currentNode){
        if(index == 0){
            return currentNode.item;
        }
        else{
            return getRecursiveHelper(index-1, currentNode.next);
        }
    }
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }
    private class LinkedListDequeIterator implements Iterator<T>{
        private int nowPos;
        public LinkedListDequeIterator(){
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
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if(this.size() != other.size()){
            return false;
        }
        for(int i = 0; i< size; i++){
            if (!get(i).equals(other.get(i))){
                return false;
            }
        }
        return true;
    }

}
