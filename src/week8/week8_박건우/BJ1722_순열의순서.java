package week8.week8_박건우;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BJ1722_순열의순서 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long [] f = new long[21];
        boolean [] c = new boolean[21];
        Arrays.fill(f, 1);

        for(int i=1; i<=20; i++) {
            f[i] = f[i-1]*i;
        }

        int n = scan.nextInt();
        int what = scan.nextInt();

        int [] a = new int[n];
        if(what == 2) {
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();

            long ans = 1;
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!c[j])
                        ans += f[n-i-1];
                }
                c[a[i]]=true;
            }
            System.out.println(ans);
        }
        else if(what == 1) {
            long k = scan.nextLong();
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(c[j])
                        continue;
                    if(f[n-i-1] < k) {
                        k -= f[n-i-1];
                    }
                    else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
