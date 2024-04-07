import java.util.Scanner;

public class KnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity, size, temp;
        double total = 0; 
        
        // Enter the number of objects to be in knapsack
        size = sc.nextInt();
        // Enter the capacity of the knapsack in terms of weight
        capacity = sc.nextInt();
        
        int[] noOfObjects = new int[size];
        int[] profit = new int[size];
        int[] weight = new int[size];
        double[] ratio = new double[size];

        for (int i = 0; i < size; i++) {
            noOfObjects[i] = sc.nextInt();
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            ratio[i] = (double) profit[i] / weight[i]; // Calculate profit/weight ratio
        }

        // Sorting items based on profit-to-weight ratio using Bubble Sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (ratio[j] < ratio[j + 1]) {
                    // Swap ratio
                    double tempRatio = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempRatio;
                    // Swap profit
                    temp = profit[j];
                    profit[j] = profit[j + 1];
                    profit[j + 1] = temp;
                    // Swap weight
                    temp = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = temp;
                    // Swap noOfObjects
                    temp = noOfObjects[j];
                    noOfObjects[j] = noOfObjects[j + 1];
                    noOfObjects[j + 1] = temp;
                }
            }
        }

        System.out.println("Items to be included in knapsack with maximum profit:");
        
        for (int i = 0; i < size; i++) {
            if (weight[i] <= capacity) {
                total += profit[i]; // Add profit of the item
                capacity -= weight[i]; // Reduce the capacity
                System.out.println("Item " + noOfObjects[i] + " added to knapsack");
            } else {
                // Calculate the partial profit if item cannot be fully included
                total += (double) profit[i] * capacity / weight[i];
                System.out.println("Item " + noOfObjects[i] + " partially added to knapsack");
                break;
            }
        }

        System.out.println("Total profit: " + total);
    }
}
