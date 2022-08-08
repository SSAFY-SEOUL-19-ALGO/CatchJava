package week1_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 같은_숫자는_싫어 {

    // 프로그래머스용
    public ArrayList solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (Integer i: arr) {
            if (list.size() == 0 || !list.get(list.size() - 1).equals(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = in.readLine().split(",");

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || !arr[i - 1].equals(arr[i])) { // 이전값과 같지 않으면 (0은 이전값이 없기 때문에 넣기)
                list.add(Integer.parseInt(arr[i]));
            }
        }

        for (int i = 0; i < list.size() - 1; i++) { // 출력
            System.out.print(list.get(i) + ",");
        }
        System.out.println(list.get(list.size() - 1));
    }
}
