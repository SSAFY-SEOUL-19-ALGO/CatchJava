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
		int cur;
		int result=0;
		int rainyMap[]=new int [W];
		st=br.readLine().split(" ");
		
		for(int i=0; i<W; i++) rainyMap[i]=Integer.parseInt(st[i]);
		
		for(int i=1; i<W-1; i++) {
			cur=rainyMap[i];
			firstDepth=cur;
			lastDepth=cur;
			
			for(int j=i-1; j>=0; j--) {
				if(rainyMap[j]>cur) {
					firstDepth=Math.max(firstDepth, rainyMap[j]);
				}
			}
			
			for(int j=i+1; j<W; j++) {
				if(rainyMap[j]>cur) {
					lastDepth=Math.max(lastDepth, rainyMap[j]);
				}
			}
			
			if(Math.min(firstDepth, lastDepth)>cur) result+=Math.min(firstDepth, lastDepth)-rainyMap[i];
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
		

