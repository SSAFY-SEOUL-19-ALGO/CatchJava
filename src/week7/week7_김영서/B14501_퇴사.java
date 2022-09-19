package week7_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B14501_퇴사 {
    static int n;
    static ArrayList<int[]> al;
    static int answer;

public static void dfs(int i, int sum) {
    //n보다 i가 크면 더 근무 못하는 환경!
    if (i >= n) {
        answer = Math.max(answer, sum);
        return;
    }
    //더 일할 수 있을지 없을지 확인
    if (i + al.get(i)[0] <= n) {
        //더 일할 수 있는 날이면 sum계산하기
        dfs(i + al.get(i)[0], sum + al.get(i)[1]);
    } else {
        dfs(i + al.get(i)[0], sum);
    }
    //다음 인덱스 번호의 dfs구하기
    dfs(i + 1, sum);
}

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    // al에 담기
    al = new ArrayList();
    for (int i = 0; i < n; i++) {
        al.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        // int[] arr=Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
    }
    // System.out.println(Arrays.toString(al.get(6)));
    dfs(0, 0);
    System.out.println(answer);
}
}