import java.util.Random;
import java.util.function.Predicate;

public class UtilitiesTester {
    public static void main (String[] args) {
        Integer[] data = new Integer[10];
        for (int i = 0; i < 10; i++) {
            data[i] = i+1;
        }
        printArr(data);
        System.out.println(Utilities.isSorted(data));
        System.out.println(Utilities.isSorted(data, 1, 2));
        Utilities.swap(data, 1, 2);
        printArr(data);
        System.out.println(Utilities.isSorted(data));
        System.out.println(Utilities.isSorted(data, 1, 2));
        for (int i = 0; i < 5; i++) {
            Utilities.shuffle(new Random(), data);
            printArr(data);
        }
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        };
        System.out.println(Utilities.partition(data, 0, data.length, p));
        printArr(data);
    }

    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }
}
