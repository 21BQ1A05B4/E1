import java.util.*;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static void shortestPath(int [][] graph, int source) {
        int vertices = graph.length;
        boolean [] visited = new boolean[vertices];
        int [] dist = new int [vertices];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        for(int count = 0; count<vertices-1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for(int v=0; v<vertices; v++) {
                if(!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        for(int u=0; u<vertices; u++) {
            System.out.println(dist[u]);
        }
    }

    static int minDistance (int [] dist, boolean [] visited) {
        int min = INF;
        int minIndex = -1;
        int vertices = dist.length;
        for(int v=0; v<vertices; v++) {
            if(!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        shortestPath(graph, 0);
    }   
}
