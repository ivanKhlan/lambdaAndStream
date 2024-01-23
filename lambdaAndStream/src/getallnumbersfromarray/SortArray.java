package getallnumbersfromarray;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Дан массив: ["1, 2, 0", "4, 5"]
//Получить из массива все числа,
//вернуть в отсортированном виде, разделенные запятой, то есть
//"0, 1, 2, 4, 5"
public class SortArray {

    private static String[] numbers = new String[]{"1, 2, 0", "4, 5"};

    public static void main(String[] args) {
        System.out.println(sortDigits(numbers));
    }

    private static String sortDigits(String[] numbers) {
        return Arrays.stream(numbers)
                .map(number -> number.split(", "))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .sorted()
                .map((Integer i) -> i.toString())
                .collect(Collectors.joining(", "));
    }
}
