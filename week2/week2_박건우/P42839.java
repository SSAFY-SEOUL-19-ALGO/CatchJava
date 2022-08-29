package week2_박건우;


import java.util.HashSet;
import java.util.Set;

public class P42839 {	// 소수 찾기
	public static void main(String[] args){
		Solution_42839 sol = new Solution_42839();
	    System.out.println(sol.solution("17"));
	}   
}

class Solution_42839{
	 public int solution(String numbers) {
		 int answer = 0;
		 Set<Integer> set = new HashSet<>();
		 comb(numbers, "", set);
//		 System.out.println(set.toString());
		 for(Integer num: set) {
			 int i;
			 for(i = 2; i < num; i++) {
				 if(num % i == 0) {
					 break;
				 }
			 }
			 if (i == num) {
				 answer++;
			 }
		 }
		 return answer;
	 }
	 
	 public void comb(String numbers, String str, Set<Integer> set) {
		 int size = numbers.length();
		 if(!"".equals(str)) {
			 set.add(Integer.valueOf(str));
		 }
		 for(int i = 0; i < size; i++) {
			 comb(numbers.substring(0, i) + numbers.substring(i + 1, size), str + numbers.charAt(i), set);
		 }
	 }
}