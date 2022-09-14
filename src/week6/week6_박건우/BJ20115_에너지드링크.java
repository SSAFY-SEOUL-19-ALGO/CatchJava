package week6.week6_박건우;

import java.io.*;
import java.util.Arrays;


public class BJ20115_에너지드링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        int N = Integer.parseInt(br.readLine());
        ipt = br.readLine().split(" ");
        float[] nums = new float[N];

        for(int i = 0; i < N; i++){
            nums[i] = Float.parseFloat(ipt[i]);
        }

        // 정렬
        Arrays.sort(nums);

        for(int i = 0; i < N-1; i++){
            nums[N-1] += nums[i] / 2;
        }

        bw.write(nums[N-1]+"\n");
        bw.flush();
    }
}
