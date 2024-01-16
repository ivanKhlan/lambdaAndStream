package queue;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyQueue<T> {
    //add(Object value) добавляет элемент в конец
    //clear() очищает коллекцию
    //size() возвращает размер коллекции
    //peek() возвращает первый элемент в очереди (FIFO)
    //poll() возвращает первый элемент в очереди и удаляет его из коллекции

    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int index = 7;
    private int length;

    public MyQueue() {
        data = new Object[INIT_SIZE];
    }

    public void add(T value) {
        data[index] = value;
        resizeIfNeed();
        index--;
        length++;
    }

    public void clear() {
        data = new Object[INIT_SIZE];
        index = 7;
        length = 0;
    }

    public T peek() {
        return (T) data[data.length - 1];
    }

    public T poll() {
        Object element = data[data.length - 1];
        Object[] newData = new Object[data.length - 1];
        System.arraycopy(data, index - 1, newData, index - 1, length + 1);
        data = newData;
        index--;
        return (T) element;
    }


    private void resizeIfNeed() {
        if (length == data.length - 1) {
            int newSize = data.length * 2;
            System.out.println("Resize happened, index = " + index + ", new data.length = " + newSize);
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, length + 1, length + 1);
            data = newData;
            index = length + 1;
        }
    }

    public int size() {
        return length;
    }
    public T get(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("index cannot be less than 0");
        }
        if (i > length) {
            throw new ArrayIndexOutOfBoundsException("index is greater than array size");
        }

        return (T) data[data.length - i - 1];
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        for (int i = data.length - 1; i > 0; i--) {
            if (data[i] != null) {
                result.add(data[i].toString());
            }
        }
        return "[" + result + "]";
    }
}
