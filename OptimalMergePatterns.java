import java.util.*;

public class OptimalMergePatterns {
    static int optimalMerge(int [] files, int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int file : files) {
            pq.add(file);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int file1 = pq.poll();
        int file2 = pq.poll();
        int mergedCost = file1 + file2;
        cost += mergedCost;
        pq.add(mergedCost);
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] files = new int [size];
        for (int i = 0; i < files.length; i++) {
            files[i] = sc.nextInt();
        }
        int minCost = optimalMerge(files, size);
        System.out.println(minCost);
    }    
}
