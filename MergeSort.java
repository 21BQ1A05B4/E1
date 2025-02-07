import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {

    static void mergeSort (int [] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge (int [] arr, int low, int mid, int high) {
        int [] merged = new int [high - low + 1];
        int start = low;
        int end = mid + 1;
        int mergePointer = 0;
        while (start <= mid && end <= high) {
            if (arr[start] < arr[end]) {
                merged[mergePointer++] = arr[start++];
            } else {
                merged[mergePointer++] = arr[end++];
            }
        }
        while (start <= mid) {
            merged[mergePointer++] = arr[start++];
        }
        while (end <= high) {
            merged[mergePointer++] = arr[end++];
        }
        for(int i=0, p=low; i<merged.length; i++, p++) {
            arr[p] = merged[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
