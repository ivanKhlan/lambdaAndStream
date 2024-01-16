package hashmap;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;


public class MyHashMap<T, V> {
    //put(Object key, Object value) добавляет пару ключ + значение
    //remove(Object key) удаляет пару по ключу
    //clear() очищает коллекцию
    //size() возвращает размер коллекции
    //get(Object key) возвращает значение(Object value) по ключу

    public static final int INITIAL_CAPACITY = 5;
    private int countElement;
    private List<Entry<T, V>>[] buckets;
    private int size;
    private int countBucket = 5;

    public MyHashMap() {
        buckets = new List[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void put(T key, V value) {
        Entry<T, V> entry = new Entry<>(key);
        entry.setValue(value);
        int whichBucket = key.hashCode() % countBucket;
        if (whichBucket < 0) {
            whichBucket = whichBucket * -1;
        }
        buckets[whichBucket].add(entry);

        countElement++;
        resize();
    }

    public boolean contains(T key) {


        return false;
    }

    public void remove(T key) {
        int whichBucket = key.hashCode() % countBucket;
        if (whichBucket < 0) {
            whichBucket = whichBucket * -1;
        }
        List<Entry<T, V>> element = buckets[whichBucket];

        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getKey().equals(key)) {
                element.remove(i);
            }
        }
    }

    public void clear() {
        buckets = new List[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        countBucket = 5;
        countElement = 0;
    }

    public int size() {
        return countElement;
    }

    public Entry<T, V> get(T key) {
        int whichBucket = key.hashCode() % countBucket;
        if (whichBucket < 0) {
            whichBucket = whichBucket * -1;
        }
        List<Entry<T, V>> element = buckets[whichBucket];

        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getKey().equals(key)) {
                return element.get(i);
            }
        }
        return null;
    }


    private void resize() {
        if (countElement == buckets.length) {
            countBucket = buckets.length * 2;
            List<Entry<T, V>>[] newBuckets = new List[countBucket];

            for (int i = 0; i < countBucket; i++) {
                newBuckets[i] = new LinkedList<>();
            }

            for (List<Entry<T, V>> bucket : buckets) {
                for (Entry<T, V> entry : bucket) {
                    int newIndex = entry.getKey().hashCode() % countBucket;
                    if (newIndex < 0) {
                        newIndex = newIndex * -1;
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
            buckets = newBuckets;
        }
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        for (int i = 0; i < buckets.length; i++) {
            List<Entry<T, V>> element = buckets[i];
            result.add(element.toString());
        }
        return "[" + result + "]";
    }
}
