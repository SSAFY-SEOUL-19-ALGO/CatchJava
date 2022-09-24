package week8.week8_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_킹 {

	//  중요 포인트  좌우상하 움직일때 열행 추가로 체크

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String st[]=br.readLine().split(" ");
		
		String kingLoc=st[0];
		int k_x=kingLoc.charAt(1)-48;
		int k_y=kingLoc.charAt(0)-64;
		
		String stoneLoc=st[1];
		int s_x=stoneLoc.charAt(1)-48;
		int s_y=stoneLoc.charAt(0)-64;
		
		
		int cmdNum=Integer.parseInt(st[2]);
		
		
		for(int i=0; i<cmdNum; i++) {
		
			String cmd=br.readLine();
			// 위 아래 움직일때는 반대로 생각해야돼!
			if(cmd.equals("R")) {
				
				//1. 킹이 벗어나지 않을때
				if(k_y+1<=8) {
				//2. 킹이 움직였을때 돌이랑 겹치는지 확인
					
					//2-1 옆에 있고, 이동해도 안겹치면 같이 이동
					if((k_y+1==s_y && s_y+1<=8) && k_x==s_x) {
						k_y++;
						s_y++;
					//2-2 이동했을때 돌이 위치해 있지 않으면
					}else if(k_y+1!=s_y ||k_x!=s_x) {
						k_y++;
					//2-3 이동해서 위치해있잇는데, 돌이 넘어가면 취소
					}else if((k_y+1==s_y && k_x==s_x) && s_y+1>8) {
						continue;
					}
				}else {
					continue;
				}
				

			}else if(cmd.equals("L")) {
				
				
				if(k_y-1>=1) {
					if((k_y-1==s_y && s_y-1>=1)&& k_x==s_x) {
						k_y--;
						s_y--;
				
					}else if(k_y-1!=s_y || k_x!=s_x) {
						k_y--;
				
					}else if((k_y-1==s_y && k_x==s_x) && s_y-1<1) {
						continue;
					}
				}else {
					continue;
				}
				
				
			}else if(cmd.equals("B")) {
				// 포인트는 반대로 생각해야됨
				// 내려간다는게 올라간다는거랑 같음
				if(k_x-1>=1) {
					
					if((k_x-1==s_x&& k_y==s_y) && s_x-1>=1) {
						k_x--;
						s_x--;
					}else if(k_x-1!=s_x || k_y!=s_y) {
						k_x--;
						
					}else if((k_x-1==s_x && k_y==s_y) && s_x-1<1) {
						continue;
					}
				}else {
					continue;
				}
	
			}else if(cmd.equals("T")) {
				
				if(k_x+1<=8) {
					
					if((k_x+1==s_x &&k_y==s_y) && s_x+1<=8) {
						k_x++;
						s_x++;
					}else if(k_x+1!=s_x || k_y!=s_y) {
						k_x++;
						
					}else if((k_x+1==s_x&& k_y==s_y) && s_x+1>8) {
						continue;
					}
				}else {
					continue;
				}
				
			}else if(cmd.equals("RT")) {
				
				//오른쪽 대각선 확인, 위아래는 반대로 고려 까먹지마
				if(k_x+1<=8 && k_y+1<=8) {
					
					// 킹이 대각선으로 이동한 좌표가, 돌의 좌표이면서 범위 안벗어나면
					if((k_x+1==s_x &&k_y+1==s_y)&& s_x+1<=8 && s_y+1<=8) {
						
						k_x++;
						k_y++;
						s_x++;
						s_y++;
						
					}else if(k_x+1!=s_x || k_y+1!=s_y) {
						k_x++;
						k_y++;
					}else if((k_x+1==s_x &&k_y+1==s_y)&&(s_x+1>8 || s_y+1>8)) {
						continue;
					}
					
					
				}else {
					continue;
				}
				
				
			}else if(cmd.equals("LT")) {
				
				
				//오른쪽 대각선 확인, 위아래는 반대로 고려 까먹지마
				if(k_x+1<=8 && k_y-1>=1) {
					
					// 킹이 대각선으로 이동한 좌표가, 돌의 좌표이면서 범위 안벗어나면
					if((k_x+1==s_x &&k_y-1==s_y)&& s_x+1<=8 && s_y-1>=1) {
						
						k_x++;
						k_y--;
						s_x++;
						s_y--;
						
					}else if(k_x+1!=s_x || k_y-1!=s_y) {
						k_x++;
						k_y--;
					}else if((k_x+1==s_x &&k_y-1==s_y)&&(s_x+1>8 || s_y-1<1)) {
						continue;
					}
					
				}else {
					continue;
				}
				
			}else if(cmd.equals("RB")) {
				
			
				if(k_x-1>=1 && k_y+1<=8) {
					
					// 킹이 대각선으로 이동한 좌표가, 돌의 좌표이면서 범위 안벗어나면
					if((k_x-1==s_x &&k_y+1==s_y)&& s_x-1>=1 && s_y+1<=8) {
						
						k_x--;
						k_y++;
						s_x--;
						s_y++;
						
					}else if(k_x-1!=s_x || k_y+1!=s_y) {
						k_x--;
						k_y++;
					}else if((k_x-1==s_x &&k_y+1==s_y)&&(s_x-1<1 || s_y+1>8)) {
						continue;
					}
					
				}else {
					continue;
				}
				
				
				
			}else if(cmd.equals("LB")) {
				
				
				if(k_x-1>=1 && k_y-1>=1) {
					
					// 킹이 대각선으로 이동한 좌표가, 돌의 좌표이면서 범위 안벗어나면
					if((k_x-1==s_x &&k_y-1==s_y)&& s_x-1>=1 && s_y-1>=1) {
						
						k_x--;
						k_y--;
						s_x--;
						s_y--;
						
					}else if(k_x-1!=s_x || k_y-1!=s_y) {
						k_x--;
						k_y--;
					}else if((k_x-1==s_x &&k_y-1==s_y)&&(s_x-1<1 || s_y-1<1)) {
						continue;
					}
					
				}else {
					continue;
				}
			}	
		}
		
		String answer1=(char)(k_y+64)+""+k_x;
		String answer2=(char)(s_y+64)+""+s_x;
		
		System.out.println(answer1);
		System.out.println(answer2);
		

	}

}
