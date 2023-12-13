package graphs;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int[] A = {1,1,1,3,3,2,2,7,6};
        System.out.println(solve(A,2,8));
    }
    public static int solve(int[] A, final int B, final int C) {
        ArrayList<Integer>[] adjacencyList = createAdjacencyList(A);
        boolean[] visited = new boolean[A.length+1];
        dfs(adjacencyList, C, visited);
        return visited[B] ? 1 : 0;

    }
    public static ArrayList<Integer> [] createAdjacencyList(int[] A){
        ArrayList<Integer> [] adjacencyList = new ArrayList[A.length+1];
        for(int i = 0; i < adjacencyList.length; i++){
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 1; i < A.length; i++){
            adjacencyList[A[i]].add(i+1);
        }
        for(ArrayList<Integer> arrayList : adjacencyList){
            System.out.println(arrayList);
        }
        return adjacencyList;

    }
    public static void dfs(ArrayList<Integer> [] adjacencyList, int S, boolean[] visited){
        int u = S;
        System.out.println("u -> " + u);
        if(visited[u]){
            return;
        }
        visited[u] = true;
        for(int v : adjacencyList[u]){
            System.out.println("v -> " + v);
            if(!visited[v]){
                dfs(adjacencyList, v, visited);
            }
        }
    }
}
