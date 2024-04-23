package sort;

public class QuickSort { //быстрая сортировка (самый эффективный алгоритм сортировки)

    public static void main(String[] args) {
        int[] testArr = new int[]{6, 3, 8, 8, 6, 9, 4, 11, 1};
        fastSort(testArr);
        for (int i : testArr) {
            System.out.println(i);
        }
    }

    public static void fastSort(int[] array) {
        recursionFastSort(array, 0, array.length - 1);
    }


    public static void recursionFastSort(int[] array, int min, int max) {
        if (array.length == 0)// условие выхода из рекурсии,  если длина массива равна 0
            return;

        if (min >= max) //выходим, так как нечего уже делить
            return;


        int middle = min + (max - min) / 2;  // выбираем середину
        int middleElement = array[middle];


        int i = min, j = max;
        while (i <= j) {  // относительно элемента middle определяемменьшие элементы слева, большие справа
            while (array[i] < middleElement) {
                i++;
            }
            while (array[j] > middleElement) {
                j--;
            }

            if (i <= j) {      //меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (min < j) // запускаем рекурсию с элементами меньшими чем middle
            recursionFastSort(array, min, j);

        if (max > i)// запускаем рекурсию с элементами большими чем middle
            recursionFastSort(array, i, max);
    }

}
