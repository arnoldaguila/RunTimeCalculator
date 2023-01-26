import java.util.Arrays;
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

        System.out.println(Arrays.toString(randomIntArray));
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

        //SELECTION SORT
//        startTime = System.nanoTime();
//        selectionSort(array);
//        endTime = System.nanoTime();
//        duration = endTime - startTime;
//        second = duration / 1000000000;
//        millisecond = duration / 1000000;
//        System.out.println("Insertion Sort's Run Time: ");
//        System.out.println("Run time: " + second + " seconds");
//        System.out.println("Run time: " + millisecond + " milliseconds");
//        System.out.println("Run time: " + duration + " nanoseconds");

        //INSERTION SORT
        startTime = System.nanoTime();
        insertionSort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        second = duration / 1000000000;
        millisecond = duration / 1000000;
        System.out.println(Arrays.toString(array));
        System.out.println("Insertion Insertion's Run Time: ");
        System.out.println("Run time: " + second + " seconds");
        System.out.println("Run time: " + millisecond + " milliseconds");
        System.out.println("Run time: " + duration + " nanoseconds");


        //duration is in milliseconds

//        System.out.println("Selection Sort's Run Time: ");


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

    }//shellSort

    /**
     * quickSort()
     * This is the quicksort algorithms
     * @param array
     */
    public static void quickSort(int[] array){

    }//quickSort

    /**
     * mergeSort()
     * This is the merge sort algorithm.
     * @param array
     */
    public static void mergeSort(int[] array){

    }//mergeSort
}
