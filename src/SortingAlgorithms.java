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

    }//main()

    /**
     * sortingPrint()
     * This static method prints the Run time of the sorting algorithms. The parameter is int[].
     * @param array int[]
     */
    public static void sortingPrint(int[] array){
        long startTime;
        long endTime;
        long duration;

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
        System.out.println("Selection Sort's Run Time: ");
        timePrint(duration);

        //INSERTION SORT
        startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion Sort's Run Time: ");
        timePrint(duration);

        //SHELL SORT
        startTime = System.nanoTime();
        shellSort(shellSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Shell Sort's Run Time: ");
        timePrint(duration);

        //QUICK SORT
        startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sort's Run Time: ");
        timePrint(duration);

        //MERGE SORT
        startTime = System.nanoTime();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge Sort's Run Time: ");
        timePrint(duration);

    }//sortingPrint()

    /**
     * timePrint()
     * This method prints out the run time in second, millisecond, microsecond, and nanosecond.
     * @param duration long
     */
    public static void timePrint(long duration){
        long second = duration / 1000000000;
        long millisecond = duration / 1000000;
        long microsecond = duration / 1000;
        System.out.println("  Run time: " + second + " seconds");
        System.out.println("  Run time: " + millisecond + " milliseconds");
        System.out.println("  Run Time: " + microsecond + " microseconds");
        System.out.println("  Run time: " + duration + " nanoseconds");
        System.out.println();
    }//timePrint()

    /**
     * randomIntArray()
     * This method generates a random int array, the parameter is int.
     * @param userInput int
     * @return int[]
     */
    public static int[] randomIntArray(int userInput){
        // creating a random array
        int[] randomArray = new int[userInput];
        Random rd = new Random();
        for(int i = 0; i < userInput; i++){
            randomArray[i] = rd.nextInt(userInput) + 1;
        }//for

        return randomArray;
    }//randomIntArray()

    /**
     * selectionSort()
     * This is the selection sort algorithm, the parameter is int[].
     * @param array int[]
     */
    public static void selectionSort(int[] array){
        // first pointer
        for(int pointer1 = 0; pointer1 < array.length; pointer1++){
            // temp int var for switching purposes
            int temp;
            //second pointer
            for(int pointer2 = pointer1 + 1; pointer2 < array.length; pointer2++){

                //searching for the smallest element in the list
                if (array[pointer2] < array[pointer1]){
                    //swapping variables
                    temp = array[pointer1];
                    array[pointer1] = array[pointer2];
                    array[pointer2] = temp;
                }//if

            }//for

        }//for

    }//selectionSort()

    /**
     * insertionSort()
     * This is the insertion sort algorithm.
     * @param array int[]
     */
    public static void insertionSort(int[] array){
        //first pointer
        for(int pointer1 = 0; pointer1 < array.length; pointer1++){
            int pointer2 = pointer1;
            while ((pointer2 > 0) && (array[pointer2 - 1] > array[pointer2])){

                //temp for swapping elements
                int temp;
                //swapping elements
                temp = array[pointer2 - 1];
                array[pointer2 - 1] = array[pointer2];
                array[pointer2] = temp;

                pointer2--;
            }//while
        }//for

    }//insertionSort()

    /**
     * shellSort()
     * This is the shell sort algorithm, the parameters is int[].
     * @param array int[]
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
     * This is the quick sort algorithm, the parameters are int[], int, int.
     * @param array int[]
     * @param low int
     * @param high int
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
     * @param array int[]
     * @param low int
     * @param high int
     * @return int
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

    }//quickSortHelper()

    /**
     * mergeSort()
     * This is the merge sort algorithm.
     * @param array int[]
     * @param left int
     * @param right int
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
     * @param array int[]
     * @param left int
     * @param middle int
     * @param right int
     */
    public static void mergeSortHelper(int[] array, int left, int middle, int right){
        int pivot = middle - left + 1;
        int pivot2 = right - middle;
        int[] leftArray = new int[pivot];
        int[] rightArray = new int[pivot2];

        for (int i = 0; i < pivot; ++i){
            leftArray[i] = array[left + i];
        }//for

        for (int j = 0; j < pivot2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }//for

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
