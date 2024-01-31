import java.io.*;
import java.util.Random;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int n = 100000; // Number of arrays
        int[][] arr = new int[n][];
        Random rand = new Random();

        for (int i = 1; i < n; i=i+i) {
            arr[i] = new int[i + 1]; 
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = rand.nextInt(); 
            }
            sortAlgos(arr[i]);
        }
    }

    public static void sortAlgos(int[] inputArr) {
        System.out.println("Array Size: "+ inputArr.length + "\tselectionSort: "+ selectionSort(inputArr.clone())+ "\t| insertionSort: "+ selectionSort(inputArr.clone())+ "\t| bubbleSort: "+ bubbleSort(inputArr.clone()));
    }

    
    public static long insertionSort(int[] inputArr) {
        long startTime = System.nanoTime();
        for (int ind = 1; ind < inputArr.length; ind++) {
            int i = ind - 1;
            int key = inputArr[ind];
            while (i >= 0 && inputArr[i] > key) {
                inputArr[i + 1] = inputArr[i];
                i--;
            }
            inputArr[i + 1] = key;
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static long selectionSort(int[] inputArr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < inputArr.length - 1; i++) {
            
            int temp = inputArr[i];
            int tempIndex = i;
            for(int j=i+1;j<inputArr.length;j++)
            {
                if(inputArr[j]<temp)
                {
                    temp = inputArr[j];
                    tempIndex = j;
                }
            }
            inputArr[tempIndex] = inputArr[i];
            inputArr[i] = temp;
            
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static long bubbleSort(int[] inputArr) {
        long startTime = System.nanoTime();
        for (int index = 0; index < inputArr.length; index++) {
            for (int i = 0; i < inputArr.length - index - 1; i++) {
                int firstEle = i;
                int secondEle = i + 1;
                if (inputArr[firstEle] > inputArr[secondEle]) {
                    int temp = inputArr[firstEle];
                    inputArr[firstEle] = inputArr[secondEle];
                    inputArr[secondEle] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

}