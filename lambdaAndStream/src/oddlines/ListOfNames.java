package oddlines;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Метод принимает на вход список имен. Вернуть строку в виде:
//"1. Ivan, 3. Peter ...", с именами из списка,
// стоящими под нечетным индексом (1, 3 и т.д.).
public class ListOfNames {
    private static List<String> names = List.of("Ivan", "Peter", "Bob", "Max", "Rake");

    public static void main(String[] args) {
        System.out.println(getNamesOnOddLine(names));
    }
    private static String getNamesOnOddLine(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(index -> (index + 1) + "." + names.get(index))
                .collect(Collectors.joining(", "));
    }
}
