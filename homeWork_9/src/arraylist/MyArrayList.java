package arraylist;

import java.util.StringJoiner;

public class MyArrayList<T> {
    //add(Object value) добавляет элемент в конец
    //remove(int index) удаляет элемент под индексом
    //clear() очищает коллекцию
    //size() возвращает размер коллекции
    //get(int index) возвращает элемент под индексом

    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int index;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    public void add(T value) {
        resizeIfNeed();
        data[index] = value;
        index++;
    }

    public void remove(int indexElement) throws Exception {
        if (indexElement < 0 || indexElement > index - 1) {
            throw new Exception("invalid index");
        }
        Object[] newData = new Object[data.length - 1];
        if (index == indexElement) {
            System.arraycopy(data, 0, newData, 0, indexElement - 1);
        } else {
            System.arraycopy(data, 0, newData, 0, indexElement);
            System.arraycopy(data, indexElement + 1, newData, indexElement, index - indexElement);
        }
        index--;
        data = newData;
    }

    public void clear() {
        data = new Object[INIT_SIZE];
        index = 0;
    }

    private void resizeIfNeed() {
        if (index == data.length) {
            int newSize = data.length * 2;
            System.out.println("Resize happened, index = " + index + ", new data.length = " + newSize);
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0 ,data.length);
            data = newData;
        }
    }

    public T get(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("index cannot be less than 0");
        }
        if (i > index) {
            throw new ArrayIndexOutOfBoundsException("index is greater than array size");
        }

        return (T) data[i];
    }
    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
            for (int i = 0; i < index; i++) {
                if (data[i] != null) {
                    result.add(data[i].toString());
                }
            }
        return "[" + result + "]";
    }
}
