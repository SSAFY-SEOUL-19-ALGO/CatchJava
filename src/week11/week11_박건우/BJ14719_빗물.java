package week11.week11_박건우;

import java.io.*;

public class BJ14719_빗물 {
    static int H, W;
    static int[] block;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        ipt = br.readLine().split(" "); // input to get H, W
        H = Integer.parseInt(ipt[0]);   // get H
        W = Integer.parseInt(ipt[1]);   // get W
        StringBuilder sb = new StringBuilder();
        block = new int[W]; // assign block, size fit in W

        ipt = br.readLine().split(" "); // input for block heights
        for(int i = 0; i < W; i++){ // for iter
            block[i] = Integer.parseInt(ipt[i]);    // get block value
        }   // fori end

        int ans = 0;    // answer value


        for(int i = 1; i < W-1; i++){
            int l = -1, r = -1;   // two pointer ;. r
            for(int j = 0; j < i; j++){
               if(l < block[j]){
                   l = block[j];
               }
           }

           for (int j = i+1; j < W; j++) {
               if(r < block[j]){
                   r = block[j];
               }
           }

           int minVal = Math.min(l, r);

           if(block[i] < minVal){
                ans += minVal - block[i];
           }
       }

        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
