package mixingstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
// который "перемешивает" элементы из стримов first и second,
// останавливается тогда, когда у одного из стримов закончатся элементы.

public class MixingStreams {

    public static void main(String[] args) {

        Stream<String> names = Stream.of("Ivan", "Rake", "John", "Peter");
        Stream<String> letter = Stream.of("i", "r", "j", "p");

        zip(names, letter)
                .forEach(System.out::print);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<String> twoList = new ArrayList<>();
        Stream<T> result;

        List<String> list1 = (List<String>) first.collect(Collectors.toList());
        List<String> list2 = (List<String>) second.collect(Collectors.toList());

        IntStream.range(0, Math.min(list1.size(), list2.size()))
                .forEach(i -> {
                    String element1 = list1.get(i);
                    String element2 = list2.get(i);
                    twoList.add(element1 + " " + element2);
                    twoList.add("\n");
                });
        result = (Stream<T>) twoList.stream();
        return result;
    }
}
