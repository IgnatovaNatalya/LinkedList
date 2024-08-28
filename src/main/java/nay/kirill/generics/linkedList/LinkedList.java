package nay.kirill.generics.linkedList;

public class LinkedList<T> {

    private Node node;
    private Node head;
    private Node tail;

    private int size = 0;

    // TODO реализовать двусвязный список

    public void add(T t) { //добавление в конец списка
        node = new Node(t);
        if (tail == null)
            head = node;
        else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void remove(T t) {
        Node n = head;
        while (n.next != null) {
            if (n.value.equals(t)) {
                n.next.prev = n.prev;
                n.prev.next = n.next;
                size--;
                return; //прекращаем, если уже нашли такой элемент и удалили его
            }
            n = n.next;
        }
    }

    public int size() {
        return size;
    }

    public void addAll(LinkedList<? extends T> list) {

        for (LinkedList<? extends T>.Node node = list.head; node != null; node = node.next)
            add(node.value);

    }

    public T get(int i) {
        Node n = head;
        int j = 0;

        while (n != null) {
            if (j == i) return n.value!=null?n.value:null;
            j++;
            n = n.next;
        }
        return null;//нет элемента с таким индексом
    }

    private class  Node {
        Node prev;
        Node next;
        T value;

        Node(T value) {
            this.value = value;
        }
    }
}
