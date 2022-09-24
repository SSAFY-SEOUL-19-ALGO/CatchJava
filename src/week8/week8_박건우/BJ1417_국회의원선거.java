package week8.week8_박건우;

import java.io.*;
import java.util.Arrays;

public class BJ1417_국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        if(N > 1){
            while(true){
                Arrays.sort(nums, 1, nums.length);
                if(nums[0] > nums[N-1]) {
                    break;
                } else{
                    nums[0] += 1;
                    nums[N-1] -= 1;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
