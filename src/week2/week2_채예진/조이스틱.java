package week2.week2_채예진;

import java.util.Scanner;

public class 조이스틱 {

    public static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
        	answer += (name.charAt(i) - 'A') <= ('Z' - name.charAt(i) + 1) ? (name.charAt(i) - 'A' ) : ('Z' - name.charAt(i) + 1); // 앞에서부터 할지, 뒤에서부터 할지 
        	
        	int idx = i + 1; // 다음 움직일 곳 
        	
        	while (idx < name.length() && name.charAt(idx) == 'A') { // A가 아닐 때까지 
        		idx++;
        	}
        	
        	move = (move <= i * 2 + (name.length() - idx) ? move : i * 2 + (name.length() - idx)); // 순서대로 가는 것 
        	move = (move <= i + (name.length() - idx) * 2 ? move : i + (name.length() - idx) * 2); // 뒤로 돌아가는 것
        }
        answer += move;
        
        return answer;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println(solution(name));
	}

}
