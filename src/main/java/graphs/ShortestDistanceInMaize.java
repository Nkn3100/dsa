package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInMaize {
    public static void main(String[] args) {
        int[][] maize = {{1,1,0,1},{0,0,0,1},{1,0,0,1},{0,0,1,0}};

        int[] B = {1,1};
        int[] C = {2,1};
        System.out.println("ans -> " + solve(maize, B, C));
    }
    public static int solve(int[][] A, int[] B, int[] C) {
        int N = A.length;
        int M = A[0].length;
        Pair s = new Pair(B[0], B[1]);
        System.out.println("source -> " + s);
        Pair d = new Pair(C[0], C[1]);
        System.out.println("destination -> " + d);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(s);
        int level = 0;
        while (!queue.isEmpty()){
            System.out.println("level -> " + level);
            level++;
            int n = queue.size();
            System.out.println("size -> " + n);
            for (int i = 0; i < n; i++){
                Pair p = queue.poll();
                System.out.println("Pair -> " + p);
                if (p.x == d.x && p.y == d.y){
                    return level;
                }
                int x = p.x;
                int y = p.y;
                if (y+1 < M && A[x][y+1] == 1){
                    level++;
                }
                if (y+1 < M && A[x][y+1] == 0){
                    A[x][y+1] = 2;
                    queue.add(new Pair(x,y+1));
                }
                if (y-1 >= 0 && A[x][y-1] == 1){
                    level++;
                }
                if (y-1 >= 0 && A[x][y-1] == 0){
                    A[x][y-1] = 2;
                    queue.add(new Pair(x,y-1));
                }
                if (x-1 >= 0 && A[x-1][y] == 0){
                    level++;
                }
                if (x-1 >= 0 && A[x-1][y] == 0){
                    A[x-1][y] = 2;
                    queue.add(new Pair(x-1,y));
                }
                if (x+1 < N && A[x+1][y] == 0){
                    level++;
                }

                if (x+1 < N && A[x+1][y] == 0){
                    A[x+1][y] = 2;
                    queue.add(new Pair(x+1,y));
                }

            }

        }
        return -1;
    }
}
class Pair{
    int x ;
    int y ;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x +", " + y;
    }
}
