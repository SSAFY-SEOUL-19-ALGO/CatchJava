package week6.week6_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ12018_YonseiTOTO {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);    // 과목 수
        int m = Integer.parseInt(st[1]);    // 마일리지

        int[][] arr = new int[n][3];    // 과목별 신청정보를 담는 배열, 0: 신청인원, 1: 수강정원, 2: 수강 턱걸이 마일리지
        int count = 0;

        for(int i=0; i<n; i++) {
            st = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(st[0]);    // 신청인원
            arr[i][1] = Integer.parseInt(st[1]);    // 수강정원

            // 수강신청한 사람들의 마일리지 오름차순 정렬
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            if(arr[i][0] < arr[i][1]) {   // 아직 자리가 남은 경우
                if(m != 0) {    // 마일리지가 남아 있다면
                    m--;    // 마일리지 1감소
                    count++;    // 수강과목 개수 증가
                }
            } else {    // 정원이 초과된경우
                arr[i][2] = tmp[tmp.length - arr[i][1]]; // 그 과목의 턱걸이 마일리지를 기록
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[2]));   // 턱걸이 마일리지 기준 오름차순 정렬

        for (int[] a :
                arr) {
            if(m != 0 && a[0] >= a[1]) {    // 마일리지가 남아있고 정원이 초과된 과목일 경우
                if(m >= a[2]) { // 턱걸이 마일리지만큼이 남아있으면
                    m -= a[2];  // 그만큼의 마일리지를 차감하고
                    count++;    // 수강과목 개수 증가
                }
            }
        }

        System.out.println(count);  // 수강과목 개수 출력
    }
}
