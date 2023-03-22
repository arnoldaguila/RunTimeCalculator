import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        // getting user input for the size of an array
        System.out.print("Enter a number: ");
        int x = userInput.nextInt();
        // calling randomIntArray static method to generate a random array.
        int[] randomIntArray = randomIntArray(x);

        sortingPrint(randomIntArray);

    }//main

    /**
     * sortingPrint()
     * This static method prints the Run time of the sorting algorithms.
     * @param array
     */
    public static void sortingPrint(int[] array){
        long startTime;
        long endTime;
        long duration;
        long second;
        long millisecond;
        long microsecond;

        // creating a new object to copy the original random array. CSCI221 knowledge lol.
        int[] selectionSortArray = new int[array.length];
        int[] insertionSortArray = new int[array.length];
        int[] shellSortArray = new int[array.length];
        int[] quickSortArray = new int[array.length];
        int[] mergeSortArray = new int[array.length];

        // copying original random array to the different arrays.
        for(int i = 0; i < array.length; i++){
            selectionSortArray[i] = array[i];
            insertionSortArray[i] = array[i];
            shellSortArray[i] = array[i];
            quickSortArray[i] = array[i];
            mergeSortArray[i] = array[i];
        }//for

        //SELECTION SORT
        startTime = System.nanoTime();
        selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        microsecond = duration / 1000;
        System.out.println("Selection Sort's Run Time: ");
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();

        //INSERTION SORT
        startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        microsecond = duration / 1000;
        System.out.println("Insertion Sort's Run Time: ");
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();

        //SHELL SORT
        startTime = System.nanoTime();
        shellSort(shellSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        microsecond = duration / 1000;
        System.out.println("Shell Sort's Run Time: ");
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();

        //QUICK SORT
        startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        microsecond = duration / 1000;
        System.out.println("Quick Sort's Run Time: ");
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();

        //MERGE SORT
        startTime = System.nanoTime();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        microsecond = duration / 1000;
        System.out.println("Merge Sort's Run Time: ");
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();


    }

    /**
     * randomIntArray()
     * This method generates a random int array.
     * @param userInput
     * @return
     */
    public static int[] randomIntArray(int userInput){
        // creating a random array
        int[] randomArray = new int[userInput];
        Random rd = new Random();
        for(int i = 0; i < userInput; i++){
            randomArray[i] = rd.nextInt(userInput) + 1;
        }//for

        return randomArray;
    }//randomIntArray

    /**
     * selectionSort()
     * This is the selection sort algorithm
     * @param array
     */
    public static void selectionSort(int[] array){
        // first pointer
        for(int i = 0; i < array.length; i++){
            // temp int var for switching purposes
            int temp = 0;
            //second pointer
            for(int j = i + 1; j < array.length; j++){
                // switching the ints
                if (array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }//if
            }//for
        }//for
    }//selectionSort

    /**
     * insertionSort()
     * This is the insertion sort algorithm
     * @param array
     */
    public static void insertionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int j = i;
            while ((j > 0) && (array[j - 1] > array[j])){
                int temp = 0;
                temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }//while
        }//for

    }//insertionSort

    /**
     * shellSort()
     * This is the shell sort algorithm
     * @param array
     */
    public static void shellSort(int[] array){
        //step
        for (int step = array.length/2; step > 0; step /= 2) {
            //first pointer
            for (int pointer1 = step; pointer1 < array.length; pointer1 += 1) {
                int temp = array[pointer1];
                //second pointer
                int pointer2;
                for (pointer2 = pointer1; pointer2 >= step && array[pointer2 - step] > temp; pointer2 -= step)
                    array[pointer2] = array[pointer2 - step];
                array[pointer2] = temp;
            }//for
        }//for

    }//shellSort()

    /**
     * quickSort()
     * This is the quick sort algorithm.
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high ){
        if (low < high) {
            int x = quickSortHelper(array, low, high);
            quickSort(array, low, x - 1);
            quickSort(array, x + 1, high);
        }//if

    }//quickSort()

    /**
     * quickSortHelper()
     * This static method is a helper for quickSort.
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int quickSortHelper(int[] array, int low, int high) {
        int temp;
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }//if
        }//for

        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);

    }//helper()

    /**
     * mergeSort()
     * This is the merge sort algorithm.
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right){
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(array, left, m);
            mergeSort(array, m + 1, right);
            mergeSortHelper(array, left, m, right);
        }//if
    }//mergeSort()

    /**
     * mergeSortHelper()
     * This static method is the helper for mergeSort
     * @param array
     * @param left
     * @param middle
     * @param right
     */
    public static void mergeSortHelper(int[] array, int left, int middle, int right){
        int pivot = middle - left + 1;
        int pivot2 = right - middle;
        int[] leftArray = new int[pivot];
        int[] rightArray = new int[pivot2];
        for (int i = 0; i < pivot; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < pivot2; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;
        while (i < pivot && j < pivot2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }//if
            else {
                array[k] = rightArray[j];
                j++;
            }//else
            k++;
        }//while
        while (i < pivot) {
            array[k] = leftArray[i];
            i++;
            k++;
        }//while
        while (j < pivot2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }//while
    }//mergeSortHelper()

}//SortingAlgorithms()
