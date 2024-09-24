public class Main {
    public static void main(String[] args) {
        // Integer array
        Integer[] intArray = {10, 20, 5, 30, 15};
        ArrayUtil<Integer> intUtil = new ArrayUtil<>();
        System.out.println("Max Integer: " + intUtil.findMax(intArray));
        System.out.println("Min Integer: " + intUtil.findMin(intArray));

        // String array
        String[] strArray = {"apple", "banana", "orange", "grape"};
        ArrayUtil<String> strUtil = new ArrayUtil<>();
        System.out.println("Max String: " + strUtil.findMax(strArray));
        System.out.println("Min String: " + strUtil.findMin(strArray));

        // Character array
        Character[] charArray = {'d', 'a', 'c', 'b'};
        ArrayUtil<Character> charUtil = new ArrayUtil<>();
        System.out.println("Max Character: " + charUtil.findMax(charArray));
        System.out.println("Min Character: " + charUtil.findMin(charArray));

        // Float array
        Float[] floatArray = {1.5f, 2.5f, 0.5f, 3.5f};
        ArrayUtil<Float> floatUtil = new ArrayUtil<>();
        System.out.println("Max Float: " + floatUtil.findMax(floatArray));
        System.out.println("Min Float: " + floatUtil.findMin(floatArray));
    }
}
