package week11.week11_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ14719_빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int H = Integer.parseInt(s[0]);//세로
		int W = Integer.parseInt(s[1]);//가로
		
		String st[] = br.readLine().split(" ");
		int[] block= new int[W];
		
		for(int w = 0; w<W; w++) {
			block[w]=Integer.parseInt(st[w]);
		}
		
		int answer = 0;
		for(int h = 0; h<H; h++) {
			boolean onoff = false;
			int tmp = 0;
			for(int w = 0; w<W; w++) {
				if(block[w]!=0) {
					block[w]--;
					if(!onoff) {
						onoff=true;
						tmp=0;
					}else {
						answer+=tmp;
						tmp=0;
					}
				}else {
					tmp++;
				}
			}
		}
		System.out.println(answer);
		
		
	}

}
