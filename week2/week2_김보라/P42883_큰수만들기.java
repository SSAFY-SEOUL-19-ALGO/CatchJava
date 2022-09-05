package week2_김보라;

public class P42883_큰수만들기 {

	static String number="4321";
	static int k = 1;
	
	public static void main(String[] args) {
		
		String answer ="";
		int start = 0;
		int end = k+1;
		while(k>0) {
			if(end>number.length())	//이 경우 조심
				break;
			
			int max = start;
			
			for(int i = start; i<end; i++) {
				if(number.charAt(max)-'0'<number.charAt(i)-'0') {
					max=i;
				}
			}
			answer+=number.substring(max,max+1);
			k-=max-start;
			
			start=max+1;
			end=start+k+1;
		}
		answer+=number.substring(start,number.length());
		if(k>0) {
			answer=answer.substring(0,answer.length()-k);
		}
		System.out.println(answer);
		
	}//main 종료

}
