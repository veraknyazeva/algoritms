package binaryheap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //BinaryHeapMax binaryHeapMax = new BinaryHeapMax(6);
//        binaryHeapMax.add(1);
//        binaryHeapMax.add(2);
//        binaryHeapMax.add(3);
//        binaryHeapMax.add(4);
//        binaryHeapMax.add(5);
//        binaryHeapMax.add(6);

        int[] array = {500, 1000, 2000, 3000, 3, 2, 1, 18, 16, 25};
        BinaryHeapMin binaryHeapMin = new BinaryHeapMin(array);
        int[] sorted = new int[array.length];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = binaryHeapMin.extractMin();
        }

        System.out.println(Arrays.toString(sorted));

        BinaryHeapMax binaryHeapMax = new BinaryHeapMax(array);

        int[] sorted1 = new int[array.length];

        for (int i = 0; i < sorted1.length; i++) {
            sorted1[i] = binaryHeapMax.extractMax();
        }

        System.out.println(Arrays.toString(sorted1));

    }
}
