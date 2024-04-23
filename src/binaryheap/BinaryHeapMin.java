package binaryheap;

public class BinaryHeapMin {
    private int[] heap;
    private int maxSize;
    private int currentSize;

    public BinaryHeapMin(int[] array) {
        this.heap = new int[array.length];
        maxSize = array.length;
        currentSize = 0;
        initializeFromArray(array);
    }

    private void initializeFromArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    public BinaryHeapMin(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.currentSize = 0;
    }

    public boolean add(int element) {
        if (currentSize == maxSize) {
            return false;
        }
        int position = currentSize;
        heap[position] = element;
        currentSize++;
        tryUp(position);
        return true;
    }

    public int extractMin() {
        int maxElement = heap[0];
        int positionOfNewMax = currentSize - 1;
        heap[0] = heap[positionOfNewMax];
        heap[positionOfNewMax] = 0;
        currentSize--;
        tryDown(0);

        return maxElement;
    }

    private void tryUp(int position) {
        int parentPosition = (position - 1) / 2;
        if (heap[position] < heap[parentPosition]) {
            swap(position, parentPosition);
            tryUp(parentPosition);
        }
    }

    private void tryDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minPosition = right;
        if (left < currentSize) {
            if (right < currentSize && heap[left] < heap[right]) {
                minPosition = left;
            }

            if (heap[i] > heap[minPosition]) {
                swap(i, minPosition);
                tryDown(minPosition);
            }
        }
    }


    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}

