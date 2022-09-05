package week2_김보라;

public class P42842_카펫 {

	static int brown = 24;	//8 이상
	static int yellow = 24;	//1 이상
	
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(5000*2000000);
		
		int[] answer= new int[2];
		int area = brown+yellow;
		//카펫의 가로길이가 더 김
		
		for(int x = 3; x<=area/x;x++) {
			if(area%x==0) {
				System.out.println(x+" "+(area/x));
				if(area-(x+(area/x))*2+4==yellow) {
					answer[0]=area/x;
					answer[1]=x;
				}
			}
		}//for 끝
		
		System.out.println(answer[0]+" "+answer[1]);
		
	}//main 끝
	
	/*
	public static void main(String[] args) {
		int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
	}*/

}
