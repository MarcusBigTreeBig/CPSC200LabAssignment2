import java.util.Random;

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
    }

    public static <E> void printArr (E[] arr) {
        for (E e: arr) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }
}
