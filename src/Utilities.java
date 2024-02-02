import java.util.function.Predicate;
import java.util.Comparator;
import java.util.Random;
public class Utilities {

    /**
     * Swaps the first and second given indexes in the given array
     * Modifies the array given
     *
     * @param data The array that is swapping data
     * @param i The first index
     * @param j The second index
     * @param <E> The type of the array that is swapping data
     */
    public static <E> void swap (E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * Checks if an array is sorted
     * Elements of the array must extend comparable
     *
     * @param data the array to check if it sorted
     * @return true if the data is sorted
     * @param <E> the type of the data in the array
     */
    public static <E extends Comparable<? super E>> boolean isSorted (E[] data) {
        for (int i = 0; i < data.length-1; i++) {
            if (data[i].compareTo(data[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if 2 indices of an array are sorted
     * elements of the array must extend comparable
     *
     * @param data the array to check if indices are sorted
     * @param i the first index
     * @param j the second index
     * @return true if the first and second given indices are in the right order
     * @param <E> the type of the data in the array
     */
    public static <E extends Comparable<? super E>> boolean isSorted (E[] data, int i, int j) {
        return data[Math.min(i, j)].compareTo(data[Math.max(i, j)]) <= 0;
    }

    /**
     * Uses a Comparator to check if an array is sorted
     *
     * @param data the array to check if it's sorted
     * @param c the Comparator for the type of the data
     * @return true if the array is sorted
     * @param <E> the type of the data in the array
     */
    public static <E> boolean isSorted (E[] data, Comparator<? super E> c) {
        for (int i = 0; i < data.length-1; i++) {
            if (c.compare(data[i], data[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Partitions an array based on a pivot
     *
     * @param data the array being partitioned
     * @param ell the start index of the part of the array being partitioned (inclusive)
     * @param arr the start index of the part of the array being partitioned (exclusive)
     * @param p Predicate containing a test method, that returns false if the element should be before the pivot, true
     * @return
     * @param <E>
     */
    public static <E> int partition (E[] data, int ell, int arr, Predicate<E> p) {
        arr--;
        for (int i = 0; i < data.length-2; i++) {
            if (!p.test(data[ell])) {
                ell++;
            }else if (p.test(data[arr])) {
                arr--;
            }else{
                swap(data, ell, arr);
                i--;
            }
        }
    }

    /**
     * Randomly arranges an array
     *
     * @param rand a random object used for random number generation
     * @param data the array to be randomized
     * @param <E> the type of data in the array
     */
    public static <E> void shuffle (Random rand, E[] data) {
        for (int i = data.length; i > 1; --i) {
            swap (data, i-1, rand.nextInt(i));
        }
    }
}
