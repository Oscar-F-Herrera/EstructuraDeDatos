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


            case MERGE -> null;
            case QUICK -> null;
            case HEAP -> null;
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };

    }
}
