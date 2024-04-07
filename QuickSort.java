import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {

    static void quickSort(int [] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    static int partition (int [] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while(i <= j && arr[i] <= pivot) {
                i++;
            }
            while (j >= i && arr[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
