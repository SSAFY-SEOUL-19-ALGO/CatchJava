package week5_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 폰_호석만 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		ArrayList<Long> XList = new ArrayList<>();
		ArrayList<Integer> AList = new ArrayList<>();
		ArrayList<Integer> BList = new ArrayList<>();
		for (int a = 2; a <= 36; a++) { // 2진법부터 36진법 
			for (int b = 2; b <= 36; b++) { // 2진법부터 36진법
				if (a == b) continue;
				try { // 변환이 안 되면 다음 값 진행되도록 try-catch 진행 
					if(Long.parseLong(input[0], a) == Long.parseLong(input[1], b)) { // 변환된 값이 같을 경우 (X를 A진수와 B진수로 바꾼 것이기 때문) 
						XList.add(Long.parseLong(input[0], a)); // X 넣기 
						AList.add(a); // A진수 넣기 
						BList.add(b); // B진수 넣기 
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		
		if (XList.size() == 0) System.out.println("Impossible");
		else if (XList.size() >= 2) System.out.println("Multiple");
		else System.out.println(XList.get(0) + " " + AList.get(0) + " " + BList.get(0));
	}

}
