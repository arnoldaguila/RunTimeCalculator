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
        int[] something = randomIntArray(x);

        sortingPrint(something);

    }//main

    public static void sortingPrint(int[] something){
        long startTime = System.nanoTime();
        selectionSort(something);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        //duration is in milliseconds
        long second = duration / 1000000000;
        long millisecond = duration / 1000000;
        System.out.println("Selection Sort's Run Time: ");
        System.out.println("Run time: " + second + " seconds");
        System.out.println("Run time: " + millisecond + " milliseconds");
        System.out.println("Run time: " + duration + " nanoseconds");


    }

    public static int[] randomIntArray(int userInput){
        // creating a random array
        int[] randomArray = new int[userInput];
        Random rd = new Random();
        for(int i = 0; i < userInput; i++){
            randomArray[i] = rd.nextInt(userInput) + 1;
        }//for

        return randomArray;
    }//randomIntArray

    public static void selectionSort(int[] something){
        // first pointer
        for(int i = 0; i < something.length; i++){
            // temp int var for switching purposes
            int temp = 0;

            //second pointer
            for(int j = i + 1; j < something.length; j++){

                // switching the ints
                if (something[j] < something[i]){
                    temp = something[i];
                    something[i] = something[j];
                    something[j] = temp;
                }//if
            }//for
        }//for
    }//selectionSort

    public static void insertionSort(int[] something){

    }

    public static void shellSort(int[] something){

    }

    public static void quickSort(int[] something){

    }

    public static void mergeSort(int[] something){

    }
}
