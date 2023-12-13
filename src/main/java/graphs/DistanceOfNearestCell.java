package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
    public static void main(String[] args) {
        int[][] array = {{1,1,0,1,1,0},{1,1,1,0,0,0}};
        int[][] ans = solve(array);
    }
    public static int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] distance = new int[N][M];
        Queue<Pair2> queue = new LinkedList<>();
        for (int i =0; i < N; i++){
            for (int j = 0; j<M; j++){
                if (A[i][j] == 1){
                    distance[i][j] = 0;
                    queue.add(new Pair2(i,j));
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int n = queue.size();
            for (int i = 0; i < n; i++){
                Pair2 p = queue.poll();
                System.out.println("Pair -> " + p);
                int x = p.x;
                int y = p.y;
                if (x-1 >= 0 && A[x-1][y] == 0){
                    A[x-1][y] = 1;
                    distance[x-1][y] = level;
                    queue.add(new Pair2(x-1,y));
                }
                if (y-1 >= 0 && A[x][y-1] == 0){
                    A[x][y-1] = 1;
                    distance[x][y-1] = level;
                    queue.add(new Pair2(x,y-1));
                }
                if (x+1 < N && A[x+1][y] == 0){
                    A[x+1][y] = 1;
                    distance[x+1][y] = level;
                    queue.add(new Pair2(x+1,y));
                }
                if (y+1 < M && A[x][y+1] == 0){
                    A[x][y+1] = 1;
                    distance[x][y+1] = level;
                    queue.add(new Pair2(x,y+1));
                }
            }
        }
        return distance;

    }
}
class Pair2 {
    int x;
    int y;
    Pair2(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ", " + y;

    }
}