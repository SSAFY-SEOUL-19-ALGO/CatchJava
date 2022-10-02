package week9.week9_정원철;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_회문 {
    public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
        List<String> list = new ArrayList<>();
        String st = br.readLine();

        for (int j = 0; j < st.length(); j++)
            list.add(String.valueOf(st.charAt(j)));

        int cnt = 0;
        int idx = 0;
        for (int j = 0; j < list.size() / 2; j++) {
            if (!list.get(j).equals(list.get(list.size() - 1 - j))) {
                cnt++;
                idx = j;
                break; // 다른 구간이 나오면 바로 해당 인덱스 체크하고 나와야 검사가능
            }
        }

        if (cnt == 0) {
            System.out.println(0); // 완전 회문인경우
        } else { // 유사회문인지 확인하는 구간 =>회문:0 유사회문:1 아니면:2
            int cnt1 = 0;
            int cnt2 = 0;

            int size = list.subList(idx + 1, list.size() - idx).size();
            for (int j = 0; j < size / 2; j++) {
                List<String> list1 = list.subList(idx + 1, list.size() - idx);
                List<String> list2 = list.subList(idx, list.size() - idx - 1);
                if (!list1.get(j).equals(list1.get(size - 1 - j)))
                    cnt1++;
                if (!list2.get(j).equals(list2.get(size - 1 - j)))
                    cnt2++;
            }

            if (cnt1 == 0 || cnt2 == 0) {
                System.out.println(1);
            } else{
                System.out.println(2);
            }

        }

    }

}
}