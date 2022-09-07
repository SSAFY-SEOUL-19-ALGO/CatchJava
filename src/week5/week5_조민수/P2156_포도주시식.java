package week5.week5_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P2156_포도주시식 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());//포도주 개수
		int wine[]=new int[cnt+1];//1부터 사용
		for(int i=1;i<=cnt;i++) {
			 wine[i] = Integer.parseInt(br.readLine());
		}
		int [] dp=new int [cnt+1];
		if(cnt==1) {
			System.out.println(wine[1]);
			return;
		}
		else if(cnt==2) {
			System.out.println(wine[1]+wine[2]);
			return;
		}
		dp[1]=wine[1];
		dp[2]=dp[1]+wine[2];//잔이 1개일때 2개일때는 최댓값이 고정/ 1, 1-2
		for(int i=3; i<=cnt; i++) { //3개부터 연산 
            dp[i] = Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]);
            //올수 있는 경우
            //내앞에서 한칸띄고 나한테 오기 vs 내앞앞에서 한칸띄고 내앞+나로 오기
            //ex)4일 경우 --->1 2 V 4   VS   1 V 3 4 중 큰값
            dp[i] = Math.max(dp[i-1], dp[i]);
            //!!!! 나를 안고르고 순위가 높을수도 있다 --> 4일때  2 3이 1 2 4 1 3 4보다 높을수도 있다!!
        }

        System.out.println(dp[cnt]);
	}

}
