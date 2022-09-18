package week7.week7_박건우;

import java.io.*;
import java.util.Arrays;

public class BJ13164_행복유치원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        ipt = br.readLine().split(" ");
        // n이 번호, k가 아이들 키
        int[][] nk = new int[Integer.parseInt(ipt[0])][2];
        String[] nums = br.readLine().split(" ");
        for(int i = 0; i < Integer.parseInt(ipt[0]); i++){
            nk[i][0] = i;
            nk[i][1] = Integer.parseInt(nums[i]);
        }

        int[] arr = new int[nk.length - 1];

        for(int i = 1; i < nk.length; i++){
            arr[i-1] = nk[i][1] - nk[i-1][1];
        }

        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0; i < nk.length - Integer.parseInt(ipt[1]); i++){
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
