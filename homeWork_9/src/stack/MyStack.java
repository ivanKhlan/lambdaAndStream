package stack;


public class MyStack<T> {
    //push(Object value) добавляет элемент в конец
    //remove(int index) удаляет элемент под индексом
    //clear() очищает коллекцию
    //size() возвращает размер коллекции
    //peek() возвращает первый элемент в стеке (LIFO)
    //pop() возвращает первый элемент в стеке и удаляет его из коллекции
    private Node<T> head;

    public void push(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public T peek() {
        return head.getValue();
    }

    public T poop() {
        Node<T> element = head;
        head = head.getNext();
        return element.getValue();
    }

    public void remove(int index) {
        Node<T> search = head;
        for (int i = 0; i < index - 1; i++) {
            search = search.getNext();
        }
        if (search.getNext().getNext() == null) {
            search.setNext(null);
        } else {
            search.getNext().setNext(search.getNext().getNext());
        }
    }

    public void clear() {
        if (head == null) {
            throw new IndexOutOfBoundsException("collection is empty");
        } else {
            head = null;
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
}
