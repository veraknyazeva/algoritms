package binaryheap;

public class BinaryHeapMax {
    private int[] heap;
    private int maxSize;
    private int currentSize;

    public BinaryHeapMax(int[] array) {
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

    public BinaryHeapMax(int maxSize) {
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

    public int extractMax() {
        int maxElement = heap[0];
        int positionOfNewMax = currentSize - 1;
        heap[0] = heap[positionOfNewMax];
        heap[positionOfNewMax] = 0;
        currentSize--;
        tryDown(0);

        return maxElement;
    }

    private void tryUp(int position) {
        if (currentSize < 2) {
            return;
        } else {
            int parentPosition = (position - 1) / 2;
            if (heap[position] > heap[parentPosition]) {
                swap(position, parentPosition);
                tryUp(parentPosition);
            }
        }
    }

    private void tryDown(int i) {
        if (currentSize < 2) {
            return;
        } else {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int maxPosition = left;
            if (left < currentSize) {
                if (right < currentSize && heap[left] < heap[right]) {
                    maxPosition = right;
                }

                if (heap[i] < heap[maxPosition]) {
                    swap(i, maxPosition);
                    tryDown(maxPosition);
                }
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


}

