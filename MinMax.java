import java.util.Scanner;
import java.util.Arrays;

public class MinMax {

    static int[] minMax(int[] arr, int low, int high) {
        int[] res = new int[2];
        if (low == high) {
            res[0] = res[1] = arr[low]; // Corrected this line
        } else if (low == high - 1) {
            if (arr[low] < arr[high]) {
                res[0] = arr[low];
                res[1] = arr[high];
            } else {
                res[0] = arr[high];
                res[1] = arr[low];
            }
        } else {
            int mid = low + (high - low) / 2;
            int[] leftResult = minMax(arr, low, mid);
            int[] rightResult = minMax(arr, mid + 1, high);
            int min1 = leftResult[0];
            int max1 = leftResult[1];
            int min2 = rightResult[0];
            int max2 = rightResult[1];

            res[0] = Math.min(min1, min2);
            res[1] = Math.max(max1, max2);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = minMax(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(res));
    }
}
