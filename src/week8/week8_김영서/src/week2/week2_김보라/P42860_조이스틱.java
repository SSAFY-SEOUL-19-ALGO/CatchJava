package week2.week2_김보라;

public class P42860_조이스틱 {
	
	static String name = "JAN";
	
	public static void main(String[] args) {
		int cnt = 0;
		int min = name.length()-1;
		for(int i = 0 ; i<name.length(); i++) {
			cnt+=Math.min((int)(name.charAt(i)-'A'),(int)(Math.abs(name.charAt(i)-'Z')+1));
			
			int j;
			for(j = i+1; j<name.length(); j++) {
				if(name.charAt(j)!='A')
					break;
			}
			
			min=Math.min(min, (i*2)+name.length()-j);
			min=Math.min(min, (name.length()-j)*2+i);
			
		}
		
//		int min = name.length()-1;
//		for(int i = 0; i<name.length()-1; i++) {
//			for(int j = i+1; name.charAt(j+1)!='A'; j++) {
//				A++;
//			}
//			min=Math.min(min, (i*2)+name.length()-(i-1));
//		}
//		System.out.println(cnt+min);
		System.out.println(cnt+min);

	}

}
