package deque;

public class LinkedListDeque<T> {
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
    public void addFirst(T item){
        Node t = new Node(item, sentinel.next, sentinel);
        sentinel.next.front = t;
        sentinel.next = t;
        size += 1;
    }
    public void addLast(T item){
        Node t = new Node(item, sentinel, sentinel.front);
        sentinel.front.next = t;
        sentinel.front = t;
        size += 1;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node start = sentinel.next;
        while(start != sentinel){
            System.out.print(start.item);
            start = start.next;
            if (start!= sentinel)
            {
                System.out.print(" ");
            }
            else{
                System.out.print("\n");
                break;
            }
        }
    }
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
    public T get(int index){
        if(index>=size){
            return null;
        }
        else{
            if(size==0)
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
    /**public Iterator<T> iterator(){

    }*/
    /**public boolean equals(Object o){

    }*/

}
