package week2_강수지;

import java.util.*;

public class P42839_소수찾기 {
	boolean[] visit; // 중복을 막기 위해 ..
    char[] arr; 
    Set<Integer> set = new HashSet<>(); // 자바에서 이거 처음 써본다..

    public boolean isPrime(int n) { // 소수인지 판별하는 함수
        if(n<2) return false; // 2보다 작은 소수는 없다

        for(int i = 2; i < n; i++) { // 2부터 자기자신앞까지 나누어떨어지는게 있으면 소수가 아님
            if(n%i == 0) return false;
        }
        return true;
    }

    //char형 배열의 앞에서부터 length 길이 만큼 잘라서 1부터 n까지 .. 
    public int charsToInt(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public void dfs(int depth, int length, String numbers) {
        if(depth == length) { 
            int num = charsToInt(arr, length); //char를 int로 변환하기
            if(isPrime(num)) set.add(num); // 소수라면 add
        } else {
            for(int i = 0; i < numbers.length(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[depth] = numbers.charAt(i);
                    dfs(depth+1, length, numbers);
                    visit[i] = false;
                }
            }
        }
    }

    public int solution(String numbers) {
        visit = new boolean[numbers.length()]; // 중복 ..
        arr = new char[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++) {
           dfs(0, i, numbers);
        }

        return set.size();
    }
}
