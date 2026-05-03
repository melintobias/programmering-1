public final class Algorithms {
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == value)
                return i;
        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            /**
             * Istället för addition följt av division med 2, används `(high - low) >>> 1` används
             * ett osignerat bitskifte som delar differensen med 2 utan att påverkas av eventuellt
             * heltalsöverflöde i summan `low + high`.
             */
            int mid = low + ((high - low) >>> 1);
            if (array[mid] == value)
                return mid;
            else if (array[mid] < value)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int lowestPos = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[lowestPos])
                    lowestPos = j;
            if (lowestPos != i)
                swap(array, i, lowestPos);
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        while (n > 1) {
            int lastSwap = 0;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    lastSwap = i;
                }
            }
            n = lastSwap;
        }
    }

    private static void swap(int[] array, int firstPos, int secondPos) {
        int temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
    }


    public static int findMin(int[] array, int fromPos) {
        int minPos = fromPos;
        for (int i = fromPos + 1; i < array.length; i++)
            if (array[i] < array[minPos])
                minPos = i;
        return minPos;
    }
}
