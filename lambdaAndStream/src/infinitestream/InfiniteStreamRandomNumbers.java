package infinitestream;



// Используя Stream.iterate сделайте бесконечный стрим рандомных чисел,
// но не используя Math.random(). Реализуйте свой "линейный конгруэнтный генератор".
// Для этого начните с x[0] = seed и затем каждый следующий элемент
// x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m.
// Необходимо имплементировать метод, который принимает на вход параметры
// a, c, m и seed и возвращает Stream<Long>.
// Для теста используйте данные a = 25214903917,
// c = 11 и m = 2^48 (2 в степени 48).

import java.math.BigInteger;
import java.util.stream.Stream;

public class InfiniteStreamRandomNumbers {
    public static void main(String[] args) {
        generateNumber();
    }
    public static void generateNumber() {

         Stream.iterate(0L, n -> createN(n))
                .limit(5)
                .forEach(System.out::println);;
    }
    public static long createN(long n) {
        Long a = 25214903917L;
        int c = 11;
        long m = 281474976710656L;
        n = 1 * (a * n + c) % m;
        return n;
    }
}
