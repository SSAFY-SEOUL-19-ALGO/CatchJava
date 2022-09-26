package week8.week8_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 순열의순서 {
	static int cnt=0;
	static int[][]perm;
	static int factorial(int n) {
		int result=1;
		while(n!=1) {
			result=result*n;
			n--;
		}
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long [] factorial = new long[21];//20!까지 저장
        boolean [] used = new boolean[21]; //사용한 수 표시
        Arrays.fill(factorial, 1);
        
        for(int i=1; i<=20; i++) { //팩토리얼 구하기
            factorial[i] = factorial[i-1]*i;
        }
        
        int n = Integer.parseInt(br.readLine());
        String []st=br.readLine().split(" ");
        int tc=Integer.parseInt(st[0]);
        
        int [] a = new int[n];
        if(tc== 2) { //2-> 주어지는 순열이 몇번째 순열인지 구하기
            for(int i=0; i<n; i++)
                a[i] =Integer.parseInt(st[i+1]);;
            
            long ans = 1; //순열은 1 번째 부터 시작
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!used[j])
                        ans += factorial[n-i-1];
                }
                used[a[i]]=true;
            }
            System.out.println(ans);
        }
        else if(tc== 1) { //1->주어지는 숫자(k)번째 순열구하기
            long k=Long.parseLong(st[1]);//20!까지 가능하므로  long 사용
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(used[j])
                        continue;
                    if(factorial[n-i-1] < k) {
                        k -= factorial[n-i-1];
                    }
                    else {
                        a[i] = j;
                        used[j] = true;
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


