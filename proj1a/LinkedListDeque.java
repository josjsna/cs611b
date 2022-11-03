public class LinkedListDeque <T>{
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(LinkedListDeque<T>.Node prev, T item, LinkedListDeque<T>.Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }private Node sentinel;
        private int size;

        public LinkedListDeque(){
       sentinel=new Node(null,(T)new Object(),null);
       sentinel.prev=sentinel;
       sentinel.next=sentinel;

        }public void addfirst(T item){
        Node NewNode=new Node(sentinel,item,sentinel.next);
        sentinel.next.prev=NewNode;
        sentinel.next=NewNode;
        size++;
        }public void addlast(T item){
        Node NewNode=new Node(sentinel.prev,item,sentinel);
        sentinel.prev.next=NewNode;
        sentinel.prev=NewNode;
        size++;
        }
        public boolean isEmpty(){
            return size==0;
        }public int size(){
            return size;
    }
        public void printDeque() {
            for (Node i = sentinel.next; i != sentinel; i = i.next) {
                if (i.next == sentinel) {
                    System.out.println(i.item);
                    break;
                }
                System.out.println(i.item);
            }
        }public T removelast(){
            if(isEmpty()){
                return null;
            } T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return res;
    }public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return res;
    }public T get(int index) {
        if (size < index) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }public T getRecursive(int index) {
        if (size < index) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(LinkedListDeque<T>.Node node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursive(node.next, i - 1);
    }
}







