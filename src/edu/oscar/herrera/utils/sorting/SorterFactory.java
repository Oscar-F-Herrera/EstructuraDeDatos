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
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int[] aux = mergeSort(N);
                }
                public int[] mergeSort(int[] original){
                    if (original.length == 1){
                        return original;
                    }

                    int mitad = original.length/2;
                    int[] array1 = new int[mitad];
                    int[] array2 = new int[(original.length % 2) == 1 ? mitad + 1 : mitad];

                    for (int i = 0; i < mitad; i++) {
                        array1[i] = original[i];
                    }
                    for (int i = mitad; i < original.length; i++) {
                        array2[i-mitad] = original[i];
                    }

                    array1 = mergeSort(array1);
                    array2 = mergeSort(array2);

                    return merge(array1,array2);
                }
                public int[] merge(int[] n1, int[] n2){

                    int[] N =new int[n1.length+n2.length];
                    int index1=0;
                    int index2=0;

                    for(int i=0;i<N.length;i++){
                        if(index1== n1.length){
                            MOVIMIENTOS++;
                            N[i]= n2[index2]; index2++;
                        }else if(index2== n2.length){
                            MOVIMIENTOS++;
                            N[i]= n1[index1]; index1++;
                        }else if(n1[index1]< n2[index2]){
                            COMPARACIONES++;
                            MOVIMIENTOS++;
                            N[i]= n1[index1]; index1++;
                        }else{
                            COMPARACIONES++;
                            MOVIMIENTOS++;
                            N[i]= n2[index2]; index2++;
                        }
                    }
                    return N;
                }
            };


            case QUICK -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    quickSort(N,0,N.length-1);
                }
                public void quickSort(int[] array, int left, int right){
                    int partition; /* index of partition */

                    if ((right - left)>0) {
                        partition = getPartition(array, left, right);
                        quickSort(array, left,partition-1);
                        quickSort(array,partition+1, right);
                    }
                }
                public int getPartition(int[] array, int left, int right) {
                    int pivot = right;
                    int firsthigh = left;

                    for (int i = left; i < right; i++) {
                        COMPARACIONES++;
                        if (array[i] < array[pivot]) {
                            MOVIMIENTOS++;
                            swap(array, i, firsthigh);
                            firsthigh++;
                        }
                    }

                    MOVIMIENTOS++;
                    swap(array, pivot, firsthigh);
                    return (firsthigh);
                }
            };


            case HEAP -> new Sorter() {
                @Override
                public void sort(int[] array) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int n = array.length;

                    for(int i = 1; i < array.length; i++)
                    {
                        int current = i;
                        int parent = getParent(current);

                        while(current > 0 && array[current] > array[parent])
                        {
                            COMPARACIONES++;
                            swap(array, current, parent);
                            MOVIMIENTOS++;
                            current = parent;
                            parent = getParent(current);
                        }
                    }

                    for(int arrayEnd = n - 1; arrayEnd > 0; arrayEnd--){
                        int current = 0;
                        swap(array, current, arrayEnd);
                        int biggestChild = getBiggestChild(array, current, arrayEnd);

                        while(biggestChild < arrayEnd && array[current] < array[biggestChild]){
                            COMPARACIONES++;
                            swap(array, current, biggestChild);
                            MOVIMIENTOS++;
                            current = biggestChild;
                            biggestChild = getBiggestChild(array, current, arrayEnd);
                        }
                    }
                }

                public static int getParent(int index){
                    return (index + 1) / 2 - 1;
                }

                public static int getBiggestChild(int[] array, int current, int fP){
                    int leftChild = 2 * current + 1;
                    int rightChild = 2 * current + 2;

                    if (leftChild < fP){
                        if (rightChild < fP && array[rightChild] > array[leftChild]){
                            return rightChild;
                        } else {
                            return leftChild;
                        }
                    }

                    return current;
                }
            };


            default -> throw new IllegalStateException("Unexpected value: " + method);
        };
    }
}
