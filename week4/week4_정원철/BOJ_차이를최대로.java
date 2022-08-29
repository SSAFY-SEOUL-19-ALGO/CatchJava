package week4_정원철;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_차이를최대로 {

	static int test[];
	static int output[];
	static boolean visited[];
	static int n,result,max=Integer.MIN_VALUE;
	static void perm(int depth, int r) {
	    if (depth == r) {
	    	//System.out.println(Arrays.toString(output));
	    	calculator();
	        if(result>max) {
	        	max=result;
	        }
	        result=0;
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = test[i];
	            perm(depth + 1, r);       
	            visited[i] = false;;
	        }
	    }
	}
	

	  
	  static void calculator() {
		  for(int i=0; i<n-1; i++) {
			  result+=Math.abs(output[i]-output[i+1]);
		  }
	  }
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		test=new int[n];
		output=new int[n];
		visited= new boolean[n];
		
		for(int i=0; i<test.length; i++) {
			test[i]=sc.nextInt();
		}
		
		perm(0, n);
		
		System.out.println(max);
		
	}

}
