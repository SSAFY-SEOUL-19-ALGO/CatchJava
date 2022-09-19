package week5_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class BOJ_폰호석만 {
	

//		long result=0;
//		
//		for(int i=0; i<s.length(); i++) {
//			long num=0;
//			
//			if('0'<=s.charAt(i) && s.charAt(i)<='9') {
//				num=s.charAt(i)-'0';
//			}else if('a'<=s.charAt(i) && s.charAt(i)<='z') {
//				num=s.charAt(i)-'a'+10;
//			}
//			
//			//진법수를 넘어가면
//			if(num>=B) return -1;
//			if((Long.MAX_VALUE-num)/B<result) return -1;
//			result=result*B+num;
//		}
//		return result;
	
	
	//11/24
	
	
	//문자열을 가능한 모든 진법에 대해서 시도! 서로 같은 숫자가 있는지 확인!
	//수가 적어서 크게 시간신경은 안써도될듯 진법변환 전부-> 문제조건에 맞게 답을 도출

	
	//주어진 두 수에 대해서 2진법 부터 36진법 까지 모든 진법이라고 가정하고 10진법으로 나타냄
	//각각의 진법에 대해서 두 수를 10진법으로 나타냈을 때 같다면, 각각 몇진법인지와 그때 10진법 수를 정답 배열에 추가~~
	
	//진법 변환을 전부 다~~ 해준뒤 전부 다~~ 비교해서 문제 조건에 맞게 출력
	//배열 사이즈에 따라 0이면 임파써블, 2개보다 크거나 같으면 멀티플, 1개로 유일하면 바로 출력
	
	// 10진법으로 변환해주는 함수 (표현된 수와 진법수 인자 ) 
	
	static long convert(String num, long k) {
		 long result = 0;
	        for (int i = 0; i < num.length(); i++) { //입력된 수의 길이 만큼
	            int c = num.charAt(i); 			// 각자리 확인
	            if ( '0' <= c && c <= '9') { // 0~9 사이
	                c -= 48;				// 각자리를 정수로 변환
	                if (c >= k) {		// 해당 진법수보다 크거나 같다면 -1리턴
	                    return -1;
	                }							
	            } if('a' <= c && c <= 'z') {  // a~z 사이
	                c -= 87;				 	// 정수로 변환
	                if (c >= k) {	// 해당 진법수보다 크거나 같다면 -1리턴
	                    return -1;
	                }
	            }
	            result+= c * Math.pow(k, num.length() - i - 1); // 10 진수화
	        }
	        return result;
	    }
	
	
	public static void main(String[] args) throws IOException {
		
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<long[]> list=new ArrayList<long[]>(); // 조건을 통과하는 값들을 담을 리스트~~
	   
	
	    String[]st = br.readLine().split(" ");
	    String a=st[0];
	    String b=st[1];
		
		
	    for (long i = 2; i <= 36; i++) { // 2~36까지 탐색
            long newA = convert(a, i); // 해당 a진법으로 표현된 수, 진법 탐색이  들어감
            if (newA== -1 || newA >= Long.MAX_VALUE) { // 컨버트 함수에서 십진수화 할수없거나, 문제에서 주어진 범위를 벗어나면 패스~
                continue;
            }
            for(long j = 2; j <= 36; j++) { // b진법도 마찬가지로 움직임
                long newB = convert(b, j);
                if (newB == -1 && newB >= Long.MAX_VALUE) {
                    continue;
                }
                if (newA == newB && i != j) { // 변환된 A와 B의 값이 같고, 표현된 진법의 수가 다를때 , 따로 선언한 배열에 추가
                    long[] arr = { newA, i, j };
                    list.add(arr);
                }
            }
        }
	  //Java의 Long 타입 변수가 가질 수 있는 값의 범위는 -2^63 이상 2^63 
	    
	 
	    
	    
	 // 배열 사이즈에 따라 0이면 임파써블, 2개보다 크거나 같으면 멀티플, 유일하게 1개면 바로 값을 출력
        if (list.size() == 0) {
            System.out.println("Impossible");
        } else if (list.size() == 1) {
        	long[] arr = list.get(0);
            System.out.println((Long.toString(arr[0]) + " " + Long.toString(arr[1]) + " " + Long.toString(arr[2])));
        } else {
           System.out.println("Multiple");
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		String st[]=br.readLine().split(" ");
//		String a,b;
//		a=st[0];
//		b=st[1];
//		
//		ArrayList<Long> A=new ArrayList();
//		ArrayList<Long> B=new ArrayList();
//		
//		for(long i=2; i<=36; i++) {
//			A.add(convert(a, i));
//			B.add(convert(b, i));
//		}
//		
//		int cnt=0;
//		long x=0;
//		
//		int aIdx=0, bIdx=0;
//		
//		for(int i=0; i<A.size(); i++) {
//			if(A.get(i)==-1) continue;
//			
//			for(int j=0; j<B.size(); j++) {
//				if(A.get(i)==B.get(j) && i!=j) {
//					cnt++;
//					x=A.get(i);
//					aIdx=i;
//					bIdx=j;
//				}
//			}
//		}
//		
//		if(cnt==0) System.out.println("Impossible");
//		else if(cnt>1) System.out.println("Multiple" );
//		else System.out.println(x+ " " + (aIdx+2)+" "+ (bIdx+2)); // 
//		

	}

}
