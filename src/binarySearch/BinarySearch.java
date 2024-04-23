package binarySearch;

public class BinarySearch {
    int[] array = new int[]

            {
                    1, 2, 3, 4, 5, 6, 7, 8
            };
    int left = 0;
    int right = array.length - 1;
    int x = 3;//искомый элемент

    public int array(int[] array) {
        while (left < right) { //задаем цикл, пока в интервале больше 1 элемента
            int middle = (left + right) / 2; //смотрим в середину
            if (array[middle] == x) { //если в середине искомый элемент, то прекращаем поиск
                return x;
            } else if (array[middle] > x) { //думаем слева или справа продолжать поиск
                right = middle - 1; //ищем слева
                return x;
            } else if (array[middle] < x) {
                left = middle + 1; //ищем справа
                return x;
            }
        }
        return x;
    }
}