package graphs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] B = new int[19][2];

        B[0][0] = 1;
        B[0][1] = 4;
        B[1][0] = 2;
        B[1][1] = 1;
        B[2][0] = 4;
        B[2][1] = 3;
        B[3][0] = 4;
        B[3][1] = 5;
        B[4][0] = 2;
        B[4][1] = 3;
        B[5][0] = 2;
        B[5][1] = 4;
        B[6][0] = 1;
        B[6][1] = 5;
        B[7][0] = 5;
        B[7][1] = 3;
        B[8][0] = 2;
        B[8][1] = 5;
        B[9][0] = 5;
        B[9][1] = 1;
        B[10][0] = 4;
        B[10][1] = 2;
        B[11][0] = 3;
        B[11][1] = 1;
        B[12][0] = 5;
        B[12][1] = 4;
        B[13][0] = 3;
        B[13][1] = 4;
        B[14][0] = 1;
        B[14][1] = 3;
        B[15][0] = 4;
        B[15][1] = 1;
        B[16][0] = 3;
        B[16][1] = 5;
        B[17][0] = 3;
        B[17][1] = 2;
        B[18][0] = 5;
        B[18][1] = 2;
        solve(5,B);

    }
    public static int solve(int A, int[][] B) {
        ArrayList<Integer> [] adjacencyList = createAdjacencyList(A,B);
        boolean[] isVisited = new boolean[A+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;
        while (!q.isEmpty()){
            int index = q.poll();
            System.out.println("index -> " + index);
            ArrayList<Integer> arrayList = adjacencyList[index];
            System.out.println("Array List -> " + arrayList);
            for(Integer i : arrayList){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println(Arrays.toString(isVisited));
        System.out.println(isVisited[A] ? 1 : 0);
        return isVisited[A] ? 1 : 0;

    }
    public static ArrayList<Integer> [] createAdjacencyList(int A, int[][] B){
        //directed graph
        ArrayList<Integer> [] adjacencyList = new ArrayList[A+1];
        for(int i = 0; i < adjacencyList.length; i++){
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] ints : B) {
            int index = ints[0];
            adjacencyList[index].add(ints[1]);
        }
        for (ArrayList<Integer> integers : adjacencyList) {
            System.out.println(integers);
        }
        return adjacencyList;
    }
}
