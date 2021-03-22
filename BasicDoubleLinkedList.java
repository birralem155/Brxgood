import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements java.lang.Iterable {


    public int getSize() {
        return size;
    }

    public class Node {
        public T item;
        public Node next, previous;

        public Node(T item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;

        }
    }

    public int size;
    public Node header, tail;


    public BasicDoubleLinkedList() {
        size = 0;
        header = tail = null;
    }


    public BasicDoubleLinkedList<T> addToEnd(T data) {
        Node tmp = new Node(data, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (header == null) {
            header = tmp;
        }
        size++;
        return this;
    }


    public BasicDoubleLinkedList<T> addToFront(T data) {
        Node tmp = new Node(data, header, null);
        if (header != null) {
            header.previous = tmp;
        }
        header = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        return this;
    }


    public T getFirst() {
        return header.item;
    }


    public T getLast() {
        return tail.item;
    }


    public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
        Node previous = null, current = header;
        while (current != null) {
            if (!(comparator.compare(current.item, targetData) == 0)) {
                previous = current;
                current = current.next;
            } else {
                if (header == current) {
                    header = header.next;
                    current = header;
                } else if (current == tail) {
                    current = null;
                    tail = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    current = current.next;
                }
                size--;
            }
        }
        return this;
    }


    public T retrieveFirstElement() {
        if (size == 0) {
            throw new NoSuchElementException("Linked list is empty");
        }
        Node tmp = header;
        header = header.next;
        header.previous = null;
        size--;
        return tmp.item;
    }


    public T retrieveLastElement() {
        if (header == null) {
            throw new NoSuchElementException("Linked list is empty");
        }
        Node currentNode = header;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.equals(tail)) {
                tail = previousNode;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        size--;
        assert currentNode != null;
        return currentNode.item;
    }


    public java.util.ArrayList<T> toArrayList() {
        ArrayList<T> temp = new ArrayList<>();
        ListIterator<T> iterator1 = new iter();

        while (iterator1.hasNext()) {
            temp.add(iterator1.next());
        }
        return temp;
    }

    public class iter implements ListIterator<T> {
        private Node current;
        private Node last;

        public iter() {
            current = header;
            last = null;
        }

        public T next() {
            if (current != null) {
                T returnData = current.item;
                last = current;
                current = current.next;
                if (current != null) {
                    current.previous = last;
                }
                return returnData;
            } else
                throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return current != null;
        }

        public T previous() {
            if (last != null) {
                current = last;
                last = current.previous;
                T returnData = current.item;
                return returnData;
            } else
                throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return last != null;
        }

        public void set(T elem) {
            current.item = elem;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();

        }
    }

    public ListIterator<T> iterator() {
        return new iter();
    }
}










