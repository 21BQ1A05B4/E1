import java.util.Scanner;

public class BinarySerachRecur {

    static boolean search(int [] arr, int low, int high, int target) {
        if (low == high) {
            if(target == arr[low]) {
                return true;
            } else {
                return false;
            }
        } else {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                return search(arr, low, mid, target);
            } else {
                return search(arr, mid + 1, high, target);
            }
        } 
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
