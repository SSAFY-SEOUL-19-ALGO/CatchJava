package week5.week5_정원철;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_포도주시식 {

	//3개의 경우를 고려
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N];
		int []D=new int[N];
		
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		if(N>=1)
			D[0]=arr[0];
		if(N>=2)
			D[1]=arr[1]+arr[0];
		if(N>=3)
			D[2]=Math.max(D[1],Math.max(arr[2]+arr[1],arr[2]+arr[0]));
	
		for(int i=3;i<N;i++){
			D[i]=Math.max(D[i-1],Math.max(arr[i]+arr[i-1]+D[i-3],arr[i]+D[i-2]));
		}
		System.out.println(D[N-1]);	
	}

}
