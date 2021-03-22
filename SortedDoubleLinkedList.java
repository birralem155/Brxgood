public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    java.util.Comparator<T> comp;


    public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
        comp = comparator2;
    }


    public SortedDoubleLinkedList<T> add(T data) {
        if (data == null) {
            return this;
        }


        Node newNode = new Node(data, null, null);
        if (header == null) {
            header = tail = new Node(data, null, null);
        } else {
            if (comp.compare(data, header.item) <= 0) {
                tail.next = newNode;
                header = newNode;
            } else if (comp.compare(data, tail.item) >= 0) {
                tail.next = newNode;
                tail = newNode;
            } else {
                Node next = header.next;
                Node previous = header;
                while (comp.compare(data, next.item) > 0) {
                    previous = next;
                    next = next.next;
                }
                previous.next = newNode;
                newNode.next = next;
            }
        }
        size++;
        return this;
    }


    public java.util.ListIterator<T> iterator() {
        return new iter();
    }


    public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
        Node next = header;
        Node prev = null;
        while (next != null) {
            if (comparator.compare(next.item, data) == 0) {
                size--;
                if (prev != null) {
                    prev.next = next.next;
                } else {
                    header = next.next;
                }
                if (next == tail) {
                    tail = prev;

                }
            }
            prev = next;
            next = next.next;
        }
        return this;
    }
}
































