package sortdescending;

import java.util.List;

//Метод принимает на вход список из строк (можно список из Задания 1).
// Возвращает список этих строк в верхнем регистре
// и отсортированные по убыванию (от Z до А).

public class SortOfDescending {
    private static List<String> names = List.of("Ivan", "Peter", "Bob", "Max", "Rake");


    public static void main(String[] args) {
        System.out.println(sortArray(names));
    }

    private static List<String> sortArray(List<String> names) {
        return names.stream()
                .map(name -> name.toUpperCase())
                .sorted((name1, name2) -> name2.compareTo(name1)).toList();
    }
}
