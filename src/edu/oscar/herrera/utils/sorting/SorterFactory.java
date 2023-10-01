package edu.oscar.herrera.utils.sorting;

/**
 * clase que crea los distintos tipos de sorters
 */
public class SorterFactory {
    /**
     * crea un sorter dependiendo del elegido
     * @param method el sorter elegido
     * @return un sorter
     */
    public static Sorter getSorter(SorterMethods method){

        return switch (method){

            case BUBBLE -> new Sorter() {
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    boolean swapped = true;
                    while (swapped){
                        swapped = false;
                        for (int i = 0; i < array.length-1; i++) {
                            COMPARACIONES++;
                            if (array[i] > array[i+1]){
                                MOVIMIENTOS++;
                                swapped = true;
                                swap(array,i,i+1);
                            }
                        }
                    }
                }
            };


            case SELECTION -> new Sorter(){
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    for(int i=0;i<array.length-1;i++){
                        int minIndex=i;
                        for(int j=i+1;j<array.length;j++){
                            COMPARACIONES++;
                            if(array[minIndex]>array[j]){
                                minIndex = j;
                            }
                        }
                        if(minIndex!=i){
                            MOVIMIENTOS++;
                            swap(array,minIndex,i);
                        }
                    }
                }
            };


            case INSERTION -> new Sorter() {
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    for (int i = 1; i < array.length; i++) {
                        int currentPos = i;
                        int previousPos = i-1;
                        while (currentPos > 0){
                            if (array[currentPos] < array[previousPos]){
                                COMPARACIONES++;
                                MOVIMIENTOS++;
                                swap(array,currentPos,previousPos);
                                currentPos -= 1;
                                previousPos -= 1;
                            } else {
                                COMPARACIONES++;
                                break;
                            }
                        }
                    }
                }
            };


            case SHELL -> new Sorter() {
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    for (int jumps = array.length/2; jumps > 0; jumps /= 2){
                        for (int i = jumps; i < array.length; i+= jumps) {
                            int currentPos = i;
                            int previousPos = i-jumps;
                            while (currentPos > 0){
                                if (array[currentPos] < array[previousPos]){
                                    COMPARACIONES++;
                                    MOVIMIENTOS++;
                                    swap(array,currentPos,previousPos);
                                    currentPos -= jumps;
                                    previousPos -= jumps;
                                } else {
                                    COMPARACIONES++;
                                    break;
                                }
                            }
                        }
                    }
                }
            };


            case MERGE -> new Sorter() {
                @Override
                public void sort(int[] arr) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int n = arr.length;
                    if (n < 2) {
                        return;
                    }

                    int mid = n / 2;
                    int[] left = new int[mid];
                    int[] right = new int[n - mid];

                    // Populate left and right arrays
                    for (int i = 0; i < mid; i++) {
                        left[i] = arr[i];
                    }
                    for (int i = mid; i < n; i++) {
                        right[i - mid] = arr[i];
                    }

                    // Recursively sort the left and right subarrays
                    sort(left);
                    sort(right);

                    // Merge the sorted left and right subarrays
                    merge(arr, left, right);
                }

                public void merge(int[] arr, int[] left, int[] right) {
                    int n1 = left.length;
                    int n2 = right.length;
                    int i = 0, j = 0, k = 0;
                    int[] mergedArray = new int[n1 + n2];

                    while (i < n1 && j < n2) {
                        COMPARACIONES++;
                        if (left[i] <= right[j]) {
                            MOVIMIENTOS++;
                            mergedArray[k++] = left[i++];
                        } else {
                            MOVIMIENTOS++;
                            mergedArray[k++] = right[j++];
                        }
                    }

                    // Copy remaining elements of left and right if any
                    while (i < n1) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = left[i++];
                    }
                    while (j < n2) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = right[j++];
                    }

                    // Copy the mergedArray back to the original array
                    System.arraycopy(mergedArray, 0, arr, 0, arr.length);
                }
            };
            case QUICK -> new Sorter() {
                @Override
                public void sort(int[] arr) {

                }

                public static void quickSort(int[] arr, int low, int high) {
                    if (low < high) {
                        int partitionIndex = partition(arr, low, high);

                        // Recursively sort elements before and after partition
                        quickSort(arr, low, partitionIndex - 1);
                        quickSort(arr, partitionIndex + 1, high);
                    }
                }

                public static int partition(int[] arr, int low, int high) {
                    int pivot = arr[high]; // Choose the rightmost element as the pivot
                    int i = (low - 1); // Index of smaller element

                    for (int j = low; j < high; j++) {
                        if (arr[j] <= pivot) {
                            i++;

                            // Swap arr[i] and arr[j]
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }

                    // Swap arr[i+1] and arr[high] (pivot)
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[high];
                    arr[high] = temp;

                    return i + 1;
                }
            };
            case HEAP -> null;
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };

    }
}
