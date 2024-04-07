import java.util.Scanner;

public class BinarySearch {

    static boolean search (int [] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(arr, 0, arr.length-1, target));
    }
}