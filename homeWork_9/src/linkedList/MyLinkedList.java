package linkedList;

import java.util.StringJoiner;

public class MyLinkedList<T> {
    //add(Object value) добавляет элемент в конец
    //size() возвращает размер коллекции
    //get(int index) возвращает элемент под индексом
    //remove(int index) удаляет элемент под индексом
    //clear() очищает коллекцию
    private Node<T> head;
    private Node<T> tail;

    public void add(T item) {
        Node<T> node = new Node<>();
        node.setValue(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            this.tail = node;
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
            count++;
        }
        return count;
    }

    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();
            if (search == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
            }
        }
        return search.getValue();
    }

    public void clear() {
        if (head == null) {
            throw new IndexOutOfBoundsException("collection is empty");
        } else {
            head = null;
        }
    }

    public void remove(int index) {
            Node<T> search = head;
            for (int i = 0; i < index; i++) {
                search = search.getNext();
            }
            if (search.getPrevious() == null) {
                search.getNext().setPrevious(null);
                head = search.getNext();
            } else if (search.getNext() == null) {
                search.getPrevious().setNext(null);
                tail = search.getPrevious();
            } else {
                search.getPrevious().setNext(search.getNext());
                search.getNext().setPrevious(search.getPrevious());
            }
    }
}
