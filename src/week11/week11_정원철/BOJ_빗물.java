package week11.week11_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		int H=Integer.parseInt(st[0]);
		int W=Integer.parseInt(st[1]);
		int firstDepth;
		int lastDepth;
		int result=0;
		int total=0;
		int rainyMap[]=new int [W];
		st=br.readLine().split(" ");
		
		for(int i=0; i<W; i++) rainyMap[i]=Integer.parseInt(st[i]);
		
		
		

	
		// 대표인덱스 (i)를 기준으로 자신을 포함해 가장 높은 높으를 구하고 (오,왼~)
		// 정해진 왼쪽 오른쪽 높이중에서 더 작은 높이와 현재의 내높이를 빼게되면 해당 인덱스
		// 위치에서의 빗물 양임을 생각하면서 풀이
		
		
		for(int i=0; i<W; i++) {
			firstDepth=i;
			
			for(int j=i; j>=0; j--) {
				if(rainyMap[j]>rainyMap[firstDepth]) {
					firstDepth=j;
				}
			}
			
			lastDepth=i;
			
			for(int j=i; j<W; j++) {
				if(rainyMap[j]>rainyMap[lastDepth]) {
					lastDepth=j;
				}
			}
			
			
			total=Math.min(rainyMap[firstDepth], rainyMap[lastDepth])-rainyMap[i];
			if(total>0) {
				result+=total;
			}
		}
		
		System.out.println(result);

	}

}	
		
		
//		for(int i=0; i<W; i++) {
//			
//			
//			
////			if(rainyMap[i]>0) {
////				fisrtDepth=rainyMap[i];
////				lastDepth=0;
////				firstIdx=i;
////				System.out.println("첫"+fisrtDepth);
////				rainTotal=0;
////				for(int j=i+1; j<W; j++) {
////					if(rainyMap[j]>=fisrtDepth) {
////						lastDepth=rainyMap[j];
////						i=j;
////						lastIdx=j;
////						break;
////					}
////				}
////				
////				
////				// 첫 시작과 끝중에 시작이 더 작으면 시작높이 기준으로 더한다.
////				if(fisrtDepth<=lastDepth) {
////					for(int j=firstIdx+1; j<lastIdx; j++) {
////						rainTotal+=fisrtDepth-rainyMap[j];
////					}
////				}else if(fisrtDepth>=lastDepth) {
////					for(int j=firstIdx+1; j<lastIdx; j++) {
////						rainTotal+=lastDepth-rainyMap[j];
////					}
////				}
////			}
//			
//
//			
//		}
		

