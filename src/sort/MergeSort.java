package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        //int[] testArr = new int[]{6, 3, 8, 8, 6, 9, 4, 11, 1, 11};
        int[] testArr = new int[] {1,2,3,4,5,6,7,8,9};
        testArr = sort(testArr); //3,6,8,8,6/4,9,1,11,11
        for (int i : testArr) {       //3,6,8,6,8/4,9,1,11,11
            System.out.print(i + ", ");    //3,6,6,8,8/1,4,9,11,11
        }                             //1,3,4,6,6,8,8,9,11,11
    }                                 //8,8,6,6,3|11,11,9,4,1
    //11,11,9,8,8,6,6,4,3,1

    public static int[] sort(int[] array1) {
        int[] copyArr = Arrays.copyOf(array1, array1.length);
        int[] bufferArr = new int[copyArr.length];
        //return mergeSortClassic(array1, 0, copyArr.length - 1);
        return mergeSortWithBuffer(copyArr, bufferArr, 0 , copyArr.length);
    }


    public static int[] mergeSortClassic(int[] array,
                                         int start, int end) {
        if (start == end) {
            return new int[]{array[end]};
        }

        //сортируем левую и правую часть
        int middle = start + (end - start) / 2;
        int[] left = mergeSortClassic(array, start, middle);
        int[] right = mergeSortClassic(array, middle + 1, end);
        System.out.println("left: " + Arrays.toString(left) + "     right: " + Arrays.toString(right));

        //слияние
        int indexLeft = 0;
        int indexRight = 0;
        int destIndex = 0;
        int[] resMerge = new int[left.length + right.length];

        while (indexLeft < left.length || indexRight < right.length) {
            if (indexLeft < left.length && indexRight < right.length) {
                if (left[indexLeft] > right[indexRight]) {
                    resMerge[destIndex] = left[indexLeft];
                    indexLeft++;
                    destIndex++;
                } else if (left[indexLeft] == right[indexRight]) {
                    resMerge[destIndex] = left[indexLeft];
                    destIndex++;
                    resMerge[destIndex] = right[indexRight];
                    indexLeft++;
                    indexRight++;
                    destIndex++;
                } else {
                    resMerge[destIndex] = right[indexRight];
                    indexRight++;
                    destIndex++;
                }
            } else {
                if (indexLeft >= left.length) {
                    resMerge[destIndex] = right[indexRight];
                    destIndex++;
                    indexRight++;
                } else {
                    resMerge[destIndex] = left[indexLeft];
                    destIndex++;
                    indexLeft++;
                }
            }
        }
        System.out.println(" res: " + Arrays.toString(resMerge));
        return resMerge;
    }

    public static int[] mergeSortWithBuffer(int[] copyArray, int[] bufferArray,
                                            int start, int end) {
        if (start == end - 1) {
            return copyArray;
        }

        int middle = start + (end - start) / 2;
        int[] left = mergeSortWithBuffer(copyArray, bufferArray, start, middle);
        int[] right = mergeSortWithBuffer(copyArray, bufferArray, middle, end);

        int indexForLeft = start;
        int indexForRight = middle;
        int destIndex = start;

        int[] result = left == copyArray ? bufferArray : copyArray;
        while (indexForLeft < middle && indexForRight < end) {
            if (left[indexForLeft] > right[indexForRight]) {
                result[destIndex++] = left[indexForLeft++];
            } else {
                result[destIndex++] = right[indexForRight++];
            }
        }
        while (indexForLeft < middle) {
            result[destIndex++] = left[indexForLeft++];
        }
        while (indexForRight < end) {
            result[destIndex++] = right[indexForRight++];
        }
        return result;
    }
}

