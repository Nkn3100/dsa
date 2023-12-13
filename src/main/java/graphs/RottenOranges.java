package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] array = {{0,2,1},{2,2,1},{0,1,0},{2,1,1},{0,1,1},{1,2,1}};
        int ans = solve(array);
        System.out.println("ans -> " + ans);

    }
    public static int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        Queue<Pairs> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A[i][j] == 2){
                    queue.add(new Pairs(i,j));
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int n = queue.size();
            for(int i = 0; i < n; i++){
                Pairs p = queue.poll();
                System.out.println("pair -> " + p);
                int x = p.x;
                int y = p.y;
                // (x-1, y),(x+1, y),(x, y-1),(x, y+1)
                if(x-1 >= 0 && A[x-1][y] == 1){
                    A[x-1][y] = 2;
                    queue.add(new Pairs(x-1,y));
                }
                if(x+1 < N && A[x+1][y] == 1){
                    A[x+1][y] = 2;
                    queue.add(new Pairs(x+1,y));
                }
                if(y-1 >= 0 && A[x][y-1] == 1){
                    A[x][y-1] = 2;
                    queue.add(new Pairs(x,y-1));
                }
                if(y+1 < M && A[x][y+1] == 1){
                    A[x][y+1] = 2;
                    queue.add(new Pairs(x,y+1));
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    return -1;
                }
            }
        }
        return level;
    }
}
class Pairs {
    int x;
    int y;
    Pairs(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x+", "+ y;
    }
}
