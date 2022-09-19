package week7.week7_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_유기농배추 {
    static int ground[][];
    static int N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            String st[]=br.readLine().split(" ");

            M=Integer.parseInt(st[0]);
            N=Integer.parseInt(st[1]);
            int K=Integer.parseInt(st[2]);

            ground= new int [N][M];
            for (int i=0; i<K; i++) {
                st=br.readLine().split(" ");
                ground[Integer.parseInt(st[1])][Integer.parseInt(st[0])]=1;
            }
            int result=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(dfs(i,j)==true) result++;
                }
            }
            System.out.println(result);
        }
    }

    static boolean dfs(int x, int y) {
        if(x<=-1 || x>=N || y<=-1 || y>=M) return false;
        if(ground[x][y]==1) {
            ground[x][y]=0;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
}