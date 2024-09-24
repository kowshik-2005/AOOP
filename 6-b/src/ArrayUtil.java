public class ArrayUtil<T extends Comparable<T>> implements ComparableArray<T> {

    @Override
    public T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null; // Handle empty or null array
        }

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    @Override
    public T findMin(T[] array) {
        if (array == null || array.length == 0) {
            return null; // Handle empty or null array
        }

        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}
